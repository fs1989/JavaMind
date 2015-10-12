package components;

public class Method {

	private String method;

	private String methodType;
	private String methodModifier;
	private String methodMReturnType;
	private String methodName;
	private MethodParameters methodParameters;
	private String methodContent;

	static class MethodParameters extends Variable {

		public MethodParameters(String variableType, String variableName) {
			super(variableType, variableName);

			if (variable != "") {
				variable = variable.substring(0, variable.length() - 1);
				variable = "(" + variable + ")";
			} else {
				variable = " (" + variable + ")";
			}
		}

	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Method(String methodType, String methodModifier, String methodMReturnType, String methodName,
			String methodVariable, String methodContent) {
		super();
		this.methodType = methodType;
		this.methodModifier = methodModifier;
		this.methodMReturnType = methodMReturnType;
		this.methodName = methodName;
		this.methodContent = methodContent;

		switch (methodType) {
		case "constructor":
			methodModifier = "\r\npublic ";
			methodMReturnType = "";
			methodContent = "{\r\nsuper();\r\n" + methodContent + "\r\n}";
			break;
		case "main":

			break;
		default:
			methodModifier = methodModifier + " ";
			methodMReturnType = methodMReturnType + " ";
			methodContent = "{\r\n" + methodContent + "\r\n}";
			break;
		}

		if (methodModifier != "") {

		} else {
			methodModifier = "";
		}

		if (methodMReturnType != " ") {
		} else {
			methodMReturnType = "void";
		}

		if (methodVariable.toString() != "") {
			methodVariable.toString();
		} else {
			methodVariable = null;
		}

		method = methodModifier + methodMReturnType + methodName + methodVariable + methodContent;
	}

	void addMethodParameters(String type, String name) {

	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethodModifier() {
		return methodModifier;
	}

	public void setMethodModifier(String methodModifier) {
		this.methodModifier = methodModifier;
	}

	public String getMethodMReturnType() {
		return methodMReturnType;
	}

	public void setMethodMReturnType(String methodMReturnType) {
		this.methodMReturnType = methodMReturnType;
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

}
