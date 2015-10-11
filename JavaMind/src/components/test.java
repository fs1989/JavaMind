package components;

public class test  {
		
	public test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Class application = new Class();
		
		application.setClassName("Application");
		application.setClassExtends("");
		application.setClassImplements("");
		
		application.addClassVariable("String", "appName");
		application.addClassVariable("String", "appGroup");
		application.addClassVariable("String", "appType");
		
		application.setClassContent("");
		
		System.out.println(application.getCode());
		
		
	}

}
