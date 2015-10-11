package components;

public class Method {

	private String method;
	
	private String methodType;
	private String methodModifier;
	private String methodMReturnType;
	private String methodName;
	private MethodParameters methodParameters;
	private String methodContent;

	static class MethodParameters {
		
		String methodParameters;
		static String type;
		static String name;
		
		public MethodParameters(String type, String name){
			if (methodParameters != null) {
				methodParameters.append(", " + type + name);
			} else {
				methodParameters.append("(" + type + " " + name + ")");
			}
			
			
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}
	
	public Method(String methodType, String methodModifier, String methodMReturnType, String methodName, MethodParameters methodParameters, String methodContent) {
		super();
		this.methodType = methodType;
		this.methodModifier = methodModifier;
		this.methodMReturnType = methodMReturnType;
		this.methodName = methodName;
		this.methodParameters = new MethodParameters(MethodParameters.type, MethodParameters.name);
		this.methodContent = methodContent;
		
		switch (methodType) {
		case "constructor":
			methodModifier = "public ";
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

		if (methodParameters.toString() != "") {
		} else {
			methodParameters = null;
		}

		method = methodModifier + methodMReturnType + methodName + methodParameters + methodContent;
	}
	
	void addMethodParameters(String type, String name){

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

	public void setMethodParameters(String methodParameters) {
		this.methodParameters = new StringBuffer(methodParameters);
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
