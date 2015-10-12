package components;

public class Method {

	private String method;

	private String methodClassName;

	private String methodType;
	private String methodModifier;
	private String methodReturnType;
	private String methodName;
	private StringBuffer methodParameters = new StringBuffer("");
	private String methodContent = "";

	static class MethodParameters extends Variable {

		public MethodParameters(String variableType, String variableName) {
			super(variableType, variableName);

			if (variable != "") {
				variable = variable.substring(0, variable.length() - 1);
				// variable = "(" + variable + ")";
			} else {
				variable = " (" + variable + ")";
			}
		}

	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Method(String methodClassName, String methodModifier, String methodReturnType, String methodName) {
		super();
		this.methodClassName = methodClassName;
		this.methodModifier = methodModifier;
		this.methodReturnType = methodReturnType;
		this.methodName = methodName;

		if (methodModifier != "") {
			this.methodModifier = methodModifier + " ";
		}

		if (methodReturnType != "") {
			setMethodReturnType(methodReturnType + " ");
		}

		if (methodName == Class.getClassName()) {
			setMethodType("constructor");
			setMethodModifier("public ");
			setMethodReturnType("");
		}

		method = "\r\n" + this.methodModifier + this.methodReturnType + this.methodName + "(" + methodParameters + ")"
				+ " {\r\n" + methodContent + "\r\n}";
	}

	void addMethodParameter(String parameterType, String parameterName) {
		MethodParameters parameters = new MethodParameters(parameterType, parameterName);

		if (methodParameters.toString().equals("")) {
			methodParameters.append(parameters.getVariable());
		} else {
			methodParameters.append(", ");
			methodParameters.append(parameters.getVariable());
		}
	}

	void updateMethod() {
		method = "\r\n" + this.methodModifier + this.methodReturnType + this.methodName + "("
				+ methodParameters.toString() + ")" + " {\r\n" + methodContent + "\r\n}";
		System.out.println(method);
		Class.updateAllMethod();
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
