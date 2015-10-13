/**
 * 
 */
package components;

/**
 * @author Dan.D.Zhang
 *
 */
public interface InterMethod {
	
	
	default void addMethodParameters() {
		
	}
	
	void addMethod(String methodModifier, String methodReturnType, String methodName);
	
	public void setMethodType(String string);

	public void setMethodModifier(String string);

	public void setMethodReturnType(String string);
	
	public void setMethod(String method);
	
	public String getMethod();

	
}
