package components;

import components.Method.MethodParameters;

/**
 * @author Dan.D.Zhang
 *
 */
public class Class {

	private static String classPackage = "";
	private static String classImport = "";
	private static String className = "";
	private static String classExtends = "";
	private static String classImplements = "";
	
	private static StringBuffer allVariables = new StringBuffer();
	private static StringBuffer allMethod = new StringBuffer();

	public static String allClassString = "";
	
	public Class() {
		this.setClassPackage(getPakageName());

	}

	private String getPakageName() {
		// TODO Auto-generated method stub
		return "";
	}

	public String getCode() {
		updateClass();
		return allClassString;
	}

	public void addClassVariable(String variableType, String variableName) {
		Variable variable = new Variable(variableType, variableName);
		allVariables.append(variable.getVariable() + "\r\n");
	}

	public void addClassVariable(String variableType, String variableName, String variableValue) {
		Variable variable = new Variable(variableType, variableName, variableValue);
		allVariables.append(variable.getVariable() + "\r\n");
	}
	
	public void addClassMethod(String methodType, String methodModifier, String methodReturnType, String methodName, String methodVariable, String methodContent) {
		Method method = new Method(methodType, methodModifier, methodReturnType, methodName, methodVariable, methodContent);
		allMethod.append(method.getMethod() + "\r\n");
		
	}

	public void updateClass() {

		String cPackagePart = "package " + classPackage + ";" + "\r\n" + "\r\n";
		String cImportsPart = "import " + classImport + ";\r\n" + "\r\n";

		String cName = "public class " + className;
		String cExtens = " extens " + classExtends;
		String cImplements = " implements " + classImplements;

		String cVariables = allVariables.toString();
		String cMethods = allMethod.toString();

		if (classImport != "") {
		} else {
			cImportsPart = "";
		}

		if (classExtends != "") {
		} else {
			cExtens = "";
		}

		if (classImplements != "") {
		} else {
			cImplements = "";
		}

		if (allVariables != null) {
		} else {
			cVariables = "";
		}

		String cContent = " {\r\n" + "\r\n" + cVariables + cMethods + "\r\n}";
		
		String cHeaderPart = cName + cExtens + cImplements + cContent;
		allClassString = cPackagePart + cImportsPart + cHeaderPart;
	}

	// setter and getter
	public void setClassVariables(StringBuffer allVariables) {
		Class.allVariables = allVariables;
	}

	public void setClassPackage(String classPackage) {
		Class.classPackage = classPackage;
	}

	public void setClassImport(String classImport) {
		Class.classImport = classImport;
	}

	public void setClassName(String className) {
		Class.className = className;
	}

	public void setClassExtends(String classExtends) {
		Class.classExtends = classExtends;
	}

	public void setClassImplements(String classImplements) {
		Class.classImplements = classImplements;
	}

	public String getClassPackage() {
		return classPackage;
	}

	public String getClassImport() {
		return classImport;
	}

	public String getClassName() {
		return className;
	}

	public String getClassExtends() {
		return classExtends;
	}

	public String getClassImplements() {
		return classImplements;
	}

	public String getAllClass() {
		return allClassString;
	}

	public StringBuffer getClassVariables() {
		return allVariables;
	}

}
