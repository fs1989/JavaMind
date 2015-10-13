package components;

public class GetCode {
	
	String code;

	public GetCode() {
		super();
		Class c = new Class();
		Method m = new Method(methodClassName, methodModifier, methodReturnType, methodName);
		Variable v = new Variable();
		
		code = c.getCode() + v.getCode() + m.getCode(); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
