package components;

public class Variable {

	String variableString;

	String variableType;
	String variableName;
	String variableValue;

	public Variable(String variableType, String variableName) {
		this.variableType = variableType;
		this.variableName = variableName;
		
		if (variableType != "" & variableName != "") {
			variableString = variableType + " " + variableName + ";";
		} else {
			variableString = "";
		}
		
	}

	public Variable(String variableType, String variableName, String variableValue) {
		this.variableType = variableType;
		this.variableName = variableName;
		this.variableValue = variableValue;
		variableString = variableType + " " + variableName + " = " + variableValue + ";";
	}

	public Variable() {
		// TODO Auto-generated constructor stub
	}

	public String getVariableString() {
		return variableString;
	}

	public void setVariable(String variableString) {
		this.variableString = variableString;
	}

	public String getVariableType() {
		return variableType;
	}

	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getVariableValue() {
		return variableValue;
	}

	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}


}
