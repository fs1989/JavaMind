package components;

public class Method {

	private String methodString;
	private String methodClassName;

	private String methodType = "";
	private String methodModifier = "";
	private String methodReturnType = "";
	private String methodName = "";
	private StringBuffer methodParameters = new StringBuffer("");
	private String methodContent = "";

	static class MethodParameters extends Variable {

		public MethodParameters(String variableType, String variableName) {
			super(variableType, variableName);
			if (variableString != "") {
				variableString = variableString.substring(0, variableString.length() - 1);
				// variable = "(" + variable + ")";
			} else {
				variableString = " (" + variableString + ")";
			}

		}
	}

	public Method() {
		updateMethod();
	}

	void addMethodParameter(String parameterType, String parameterName) {
		MethodParameters parameters = new MethodParameters(parameterType, parameterName);

		if (methodParameters.toString().equals("")) {
			methodParameters.append(parameters.getVariableString());
		} else {
			methodParameters.append(", ");
			methodParameters.append(parameters.getVariableString());
		}
		updateMethod();
	}

	void updateMethod() {

		if (methodModifier != "" && !methodModifier.contains(" ")) {
			setMethodModifier(methodModifier + " ");
		}

		if (methodReturnType != "" && !methodReturnType.contains(" ")) {
			setMethodReturnType(methodReturnType + " ");
		}

		methodString = "\r\n" + methodModifier + methodReturnType + methodName + "(" + methodParameters.toString() + ")"
				+ " {\r\n" + methodContent + "\r\n}";

	}

	// Setters and Getters
	public String getMethodString() {
		return methodString;
	}

	public void setMethod(String methodString) {
		this.methodString = methodString;
	}

	public String getMethodModifier() {
		return methodModifier;
	}

	public void setMethodModifier(String methodModifier) {
		this.methodModifier = methodModifier;
	}

	public String getMethodReturnType() {
		return methodReturnType;
	}

	public void setMethodReturnType(String methodReturnType) {
		this.methodReturnType = methodReturnType;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodParameters() {
		return methodParameters.toString();
	}

	public String getMethodContent() {
		return methodContent;
	}

	public void setMethodContent(String methodContent) {
		this.methodContent = methodContent;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getMethodClassName() {
		return methodClassName;
	}

	public void setMethodClassName(String className) {
		this.methodClassName = className;
	}

}
