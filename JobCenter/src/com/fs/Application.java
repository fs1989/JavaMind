package com.fs;

public class Application {

	String appName;
	String appGroup;
	String appType;

	public Application(String appName, String appGroup) {
		super();
		this.appName = appName;
		this.appGroup = appGroup;
		// System.out.println(appName + " " +appGroup);
	}

	void update_user_list() throws InterruptedException {

		Thread_dsquery t1 = new Thread_dsquery(appName, appGroup);
		Thread_processtxt t2 = new Thread_processtxt(appName, appGroup);

		t1.start();
		t2.start();

	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppGroup() {
		return appGroup;
	}

	public void setAppGroup(String appGroup) {
		this.appGroup = appGroup;
	}

}