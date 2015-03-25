package ro.academic.exception;

public class LoginException extends Exception {
	
	/**
	 * Generated serial version
	 */
	private static final long serialVersionUID = 5374987679848356766L;

	/**
	 * Default constructor
	 */
	public LoginException() {
		super();
	}

	/**
	 * Constructor with message
	 * @param message
	 */
	public LoginException(String message) {
		super(message);
	}

	/**
	 * Constructor with message and exception
	 * @param message
	 * @param cause
	 */
	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with exception
	 * @param cause
	 */
	public LoginException(Throwable cause) {
		super(cause);
	}
}
