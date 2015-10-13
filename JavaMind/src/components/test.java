package components;

import components.Method.MethodParameters;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// 创建一个类
		Class application = new Class("Application");

		application.setClassPackage("components");
		application.setClassName("Application");
		application.setClassExtends("");
		application.setClassImplements("");

		String variableType = "String";
		String variableName = "appName";
		createVariable(application, variableType, variableName);

		// System.out.println(application.getCode());
		String methodModifier = "private";
		String methodReturnType = "void";
		String methodName = "Application";

		createMethod(application, methodModifier, methodReturnType, methodName);

	}

	// 创建一个变量, 把变量的"字符串"传递给application类
	public static void createVariable(Class className, String appType, String appName) {
		Variable variable = new Variable(appType, appName);
		className.addClassVariable(variable.getVariableName(), variable.getVariableString());
	}

	// 创建一个方法, 把方法的"字符串"传递给application类
	public static void createMethod(Class className, String methodModifier, String methodReturnType, String methodName) {

		Method method = new Method();
		method.setMethodModifier(methodModifier);
		method.setMethodReturnType(methodReturnType);
		method.setMethodName(methodName);

		if (methodName == className.getClassName()) {
			method.setMethodType("constructor");
			method.setMethodModifier("public");
			method.setMethodReturnType("");
		}

		method.addMethodParameter("String", "appName");
		method.addMethodParameter("String", "appGroup");

		System.out.println(method.getMethodString());

		className.addClassMethod(method.getMethodName(), method.getMethodString());
	}

}
