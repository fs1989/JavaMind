package com.fs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Thread_processtxt extends Thread {

	public Thread_processtxt(String appName, String appGroup) {
		
//		getUserID(appName, appGroup);
		getSCEPCOUsers(appName);
		
	}

	
	private void getSCEPCOUsers(String appName) {
		
		String fileAllUserList = "C:/Apps/UserList/SCEPCO_User_List.csv";
		String fileAppUserList = "C:/Apps/UserList/00result-" + appName +".csv";
		String fileToBeCreated = "C:/APPS/UserList//000result-" + appName + ".csv";
		
		String line_App = "";
		String line_UserList = "";
		BufferedReader brApp = null;
		BufferedReader brUserList = null;
		StringBuffer sbAppUserList = new StringBuffer();
		StringBuffer sbAllUserList = new StringBuffer();
		
		try {
			brApp = new BufferedReader(new FileReader(fileAppUserList));
			brUserList = new BufferedReader(new FileReader(fileAllUserList));
			int line = 1;
			
			while ((line_UserList = brUserList.readLine()) != null) {
				String[] a = line_UserList.split(",");
				String[] b = a[0].split("=");
				sbAllUserList.append(b[1] + "\r\n");
				line++;
			}
			while ((line_App = brApp.readLine()) != null) {
				if (sbAllUserList.toString().contains(line_App)) {
					sbAppUserList.append(line_App + "\r\n");
				}
			}
			
			brApp.close();
			brUserList.close();
			
			// 写入新文件
			FileWriter fw = new FileWriter(fileToBeCreated);
			fw.write(sbAppUserList.toString());
			fw.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (brApp != null | brUserList != null) {
				try {
					System.out.println(appName + " done - getSCEPCOUsers" + "\r\n");
					brApp.close();
					brUserList.close();
				} catch (IOException e1) {
				}
			}
		}
		
	}

	private void getUserID(String appName) {
		String tempString = "";
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();

		String fileToBeReaded = "C:/APPS/UserList//" + appName + ".txt";
		String fileToBeCreated = "C:/APPS/UserList//00result-" + appName + ".txt";

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
					System.out.println(appName + " done - getUserID" + "\r\n");
					br.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
}
