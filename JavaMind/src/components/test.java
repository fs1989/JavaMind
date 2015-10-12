package components;

import components.Method.MethodParameters;

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

		
		// 添加一个方法
		String methodModifier = "private"; 
		String methodReturnType = "void"; 
		String methodName = "Application"; 
		
		application.createMethod(application.getClassName(), methodModifier, methodReturnType, methodName);
		Method method = new Method(application.getClassName(), methodModifier, methodReturnType, methodName);
		method.setMethodClassName(application.getClassName());
		
		method.addMethodParameter("String", "appName");
		method.addMethodParameter("String", "appGroup");
		
		
		System.out.println(application.getCode());
		
		
	}

} 
