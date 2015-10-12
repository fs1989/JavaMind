package components;

public class Variable {

	String variable;

	String variableType;
	String variableName;
	String variableValue;

	public Variable(String variableType, String variableName) {
		this.variableType = variableType;
		this.variableName = variableName;
		
		if (variableType != "" & variableName != "") {
			variable = variableType + " " + variableName + ";";
		} else {
			variable = "";
		}
		
	}

	public Variable(String variableType, String variableName, String variableValue) {
		this.variableType = variableType;
		this.variableName = variableName;
		this.variableValue = variableValue;
		variable = variableType + " " + variableName + " = " + variableValue + ";";
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
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
