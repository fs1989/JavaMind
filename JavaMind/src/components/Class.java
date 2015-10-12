package components;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

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
	private static StringBuffer allMethods = new StringBuffer();

	ArrayList Methods = new ArrayList();

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

	public String getAllMethods() {
		Iterator t = Methods.iterator();
		while (t.hasNext()) {
			allMethods.append(t.next() + "\r\n");
		}
		return Methods.toString();
	}

	public void updateClass() {

		String cPackagePart = "package " + classPackage + ";" + "\r\n" + "\r\n";
		String cImportsPart = "import " + classImport + ";\r\n" + "\r\n";

		String cName = "public class " + className;
		String cExtens = " extens " + classExtends;
		String cImplements = " implements " + classImplements;

		String cVariables = allVariables.toString();
		String cMethods = allMethods.toString();

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

	public void createMethod(String className, String methodModifier, String methodReturnType, String methodName) {
		Method method = new Method(int i, getClassName(), methodModifier, methodReturnType, methodName);
		Methods.add(method.getMethod());
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

	public static String getClassName() {
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
