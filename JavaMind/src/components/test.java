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

		// 为方法添加一个参数
		
		
		String parameterType = "String";
		String parameterName = "appName";
		MethodParameters parameter = new MethodParameters(parameterType, parameterName);
		StringBuffer parameters = new StringBuffer();
		parameters.append(parameter.getVariable());
		String methodParameter = parameters.toString();
		
		// 添加一个方法
		String methodType = "constructor";
		String methodModifier = "public"; 
		String methodMReturnType = ""; 
		String methodName = "Application"; 
		String methodVariable = methodParameter; 
		String methodContent = "";
		
		application.addClassMethod(methodType, methodModifier, methodMReturnType, methodName, methodVariable, methodContent);
		
		System.out.println(application.getCode());
		
		
	}

}
