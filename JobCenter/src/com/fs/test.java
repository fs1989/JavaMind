package com.fs;

public class test {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		Application petrel = new Application("petrel", "FGG-GLOBAL-ZZ-SCHL-Shell_Petrel-GS");
		Application techlog = new Application("techlog", "FGG-EP-GLOBAL-ZZ-THSA-Techlog-AllVersions-GS");
		Application arcgis = new Application("arcgis", "FGG-GLOBAL-ZZ-ARCGIS-GS");
		Application fme = new Application("fme", "FGR-SCEPCO-BEJ-ZZ-SAFE-FME-2013_SP3-GS");
		Application ofm = new Application("ofm", "FGG-GLOBAL-ZZ-SCHL-OFM-GS");
		Application edm = new Application("edm", "FGO-SUKEP-ABE-ZZ-EDM R5000 SCEPCO-GS");
		Application ecrin = new Application("ecrin", "FGG-EP-GLOBAL-ZZ-KAEN-Ecrin-GS");

		Thread_processtxt t1 = new Thread_processtxt("ofm", "FGG-EP-GLOBAL-ZZ-THSA-Techlog-AllVersions-GS");
		t1.start();
		
//		petrel.update_user_list();
//		techlog.update_user_list();
//		arcgis.update_user_list();
//		fme.update_user_list();
//		ofm.update_user_list();
//		edm.update_user_list();
//		ecrin.update_user_list();
		
//		System.out.println(petrel.getAppName().toString());
//		System.out.println(techlog.getAppName().toString());
//		System.out.println(arcgis.getAppName().toString());
//		System.out.println(fme.getAppName().toString());
//		System.out.println(ofm.getAppName().toString());
//		System.out.println(edm.getAppName().toString());
//		System.out.println(ecrin.getAppName().toString());
	}
	
}
