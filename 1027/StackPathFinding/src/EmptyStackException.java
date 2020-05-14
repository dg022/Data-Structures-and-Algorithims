
public class EmptyStackException extends Exception {
	
	/**
	   * Sets up this exception with an appropriate message.
	   * @param collection String representing the name of the stack
	   */

	public EmptyStackException(String stack) {
		super("The " + stack + " is empty");
	}

}
