package com.fs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Thread_processtxt extends Thread {

	private String appName;
	public static StringBuffer result = new StringBuffer();

	public Thread_processtxt(String appName, String appGroup) {

		getUserID(appName);
		getSCEPCOUsers(appName);

	}

	private void getUserID(String appName) {
		this.appName = appName;
		String fileToBeReaded = "C:/APPS/UserList/" + appName + ".csv";
		String fileToBeCreated = "C:/APPS/UserList/result-" + appName + ".csv";
		readFile(fileToBeReaded, fileToBeCreated);
		System.out.println(appName + " done - getUserID");
		deleteFile(fileToBeReaded);
	}

	// private void getAll() throws IOException {
	// String path = "C:/APPS/UserList/scepco-" + appName + ".csv";;
	// readFileToString(appName, path);
	//
	// }
	//
	// private String readFileToString(String appName, String path) throws
	// IOException {
	// String line_App = "";
	// String fileToBeReaded = "C:/APPS/UserList/scepco-" + appName + ".csv";
	// BufferedReader brUserList_APP = null;
	// StringBuffer sbAppUserList = new StringBuffer();
	//
	// brUserList_APP = new BufferedReader(new FileReader(fileToBeReaded));
	// int line = 0;
	//
	// while ((line_App = brUserList_APP.readLine()) != null) {
	// sbAppUserList.append(line_App + "\r\n");
	// }
	//
	// return sbAppUserList.toString();
	// }

	private void getSCEPCOUsers(String appName) {

		String fileAllUserList = "C:/Apps/UserList/SCEPCO_User_List.csv";
		String fileAppUserList = "C:/Apps/UserList/result-" + appName + ".csv";
		String fileToBeCreated = "C:/APPS/UserList/scepco-" + appName + ".csv";

		String line_App = "";
		String line_UserList = "";
		BufferedReader brUserList_APP = null;
		BufferedReader brUserList_SCEPCO = null;
		StringBuffer sbAppUserList = new StringBuffer();
		StringBuffer sbAllUserList = new StringBuffer();
		StringBuffer res = new StringBuffer();

		try {
			brUserList_APP = new BufferedReader(new FileReader(fileAppUserList));
			brUserList_SCEPCO = new BufferedReader(new FileReader(fileAllUserList));
			int line = 1;

			while ((line_UserList = brUserList_SCEPCO.readLine()) != null) {
				if (line > 1) {
					String[] a = line_UserList.split(",");
					String[] b = a[0].split("=");
					sbAllUserList.append(b[1] + "\r\n");
				}
				line++;
			}

			while ((line_App = brUserList_APP.readLine()) != null) {
				if (sbAllUserList.toString().contains(line_App)) {
					sbAppUserList.append(line_App + "," + appName + "\r\n");
				}
			}
			

			brUserList_APP.close();
			brUserList_SCEPCO.close();

			// 写入result
			result.append(sbAppUserList.toString());
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (brUserList_APP != null | brUserList_SCEPCO != null) {
				try {
					System.out.println(appName + " done - getSCEPCOUsers" + "\r\n");
					deleteFile(fileAppUserList);
					brUserList_APP.close();
					brUserList_SCEPCO.close();
				} catch (IOException e1) {
				}
			}
		}

	}

	public boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	private String readFile(String fileToBeReaded, String fileToBeCreated) {
		String tempString = "";
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();

		try {
			br = new BufferedReader(new FileReader(fileToBeReaded));
			int line = 1;

			while ((tempString = br.readLine()) != null) {

				boolean condition0 = !tempString.toString().contains("\\");
				boolean condition1 = tempString.toString().contains("User Accounts");
				boolean condition2 = !tempString.toString().contains(".");
				boolean condition3 = !tempString.toString().contains("\\");

				if (condition0 & condition1 & condition2 & condition3) {
					String[] a = tempString.split(",");
					String[] b = a[0].split("=");
					sb.append(b[1] + "\r\n");
				}
				line++;
			}

			br.close();

			// 写入新文件
			FileWriter fw = new FileWriter(fileToBeCreated);
			fw.write(sb.toString());
			fw.close();

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
				}
			}
		}

		return sb.toString();
	}
}
