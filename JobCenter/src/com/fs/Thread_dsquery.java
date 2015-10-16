package com.fs;

public class Thread_dsquery extends Thread {
	
	Process p1 = null;
	Process p2 = null;
	
	public Thread_dsquery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Thread_dsquery(String appName, String appGroup) {
		
		
		String cmd_scepco_users = "csvde -f C:/APPS/UserList/SCEPCO_User_List.CSV -r \"(ou=SCEPCO)\" -l cn,sAMAccountName,mail,displayName,l,location,whenCreated,employeeType,lastLogon";
		String cmd_app_dsquery = "cmd /c dsquery group -samid \"" + appGroup + "\" | dsget group -members > C:\\apps\\UserList\\" + appName + ".csv";
//		System.out.println(cmdStr);
		try {
			p1 = Runtime.getRuntime().exec(cmd_scepco_users);
			p2 = Runtime.getRuntime().exec(cmd_app_dsquery);
			p1.waitFor();
			p2.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(appName + " done - dsquery");
		}
		
	}

}

