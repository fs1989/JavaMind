package components;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dan.D.Zhang
 *
 */
public class Class {

	private String classPackage = "";
	private String className = "";
	private String classExtends = "";
	private String classImplements = "";
	private String allClassString = "";

	private Map<String, String> variables = new HashMap<String, String>();
	private Map<String, String> methods = new HashMap<String, String>();

	
	private StringBuffer allVariables = new StringBuffer();
	private StringBuffer allMethods = new StringBuffer();

	public Class(String className) {
		this.setClassPackage(getClassPackage());
		updateClass();
	}

	public void updateClass() {
		String cPackagePart = "package " + classPackage + ";" + "\r\n" + "\r\n";

		String cName = "public class " + className;
		String cExtens = " extens " + classExtends;
		String cImplements = " implements " + classImplements;

		String cVariables = allVariables.toString();
		String cMethods = allMethods.toString();

		if (classExtends == "") {
			cExtens = "";
		}
		if (classImplements == "") {
			cImplements = "";
		}
		if (allVariables.toString() == "") {
			cVariables = "";
		}
		if (allMethods.toString() == "") {
			cMethods = "";
		}

		String cContent = " {\r\n" + "\r\n" + cVariables + cMethods + "\r\n}";
		String cHeaderPart = cName + cExtens + cImplements + cContent;
		allClassString = cPackagePart + cHeaderPart;
	}

	
	void addClassVariable(String variableName, String variable) {
		variables.put(variableName, variable);
	}
	
	void addClassMethod(String methodName, String method) {
		methods.put(methodName, method);
	}
	
	public String getCode() {
		updateClass();
		return allClassString;
	}
	

	// Setters and Getters
	public String getClassPackage() {
		return classPackage;
	}

	public void setClassPackage(String classPackage) {
		this.classPackage = classPackage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassExtends() {
		return classExtends;
	}

	public void setClassExtends(String classExtends) {
		this.classExtends = classExtends;
	}

	public String getClassImplements() {
		return classImplements;
	}

	public void setClassImplements(String classImplements) {
		this.classImplements = classImplements;
	}

	public String getAllClassString() {
		return allClassString;
	}

	public void setAllClassString(String allClassString) {
		this.allClassString = allClassString;
	}

	public StringBuffer getAllVariables() {
		return allVariables;
	}

	public void setAllVariables(StringBuffer allVariables) {
		this.allVariables = allVariables;
	}

	public StringBuffer getAllMethods() {
		return allMethods;
	}

	public void setAllMethods(StringBuffer allMethods) {
		this.allMethods = allMethods;
	}
	
	

}
