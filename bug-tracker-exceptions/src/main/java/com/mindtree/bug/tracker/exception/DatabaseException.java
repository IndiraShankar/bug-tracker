package com.mindtree.bug.tracker.exception;

/**
 * @author M1035940
 *
 */
public class DatabaseException extends Exception {

	/**
	 * Generated serialization id
	 */
	private static final long serialVersionUID = 8450612638017339817L;

	/**
	 * constructs the new DatabaseException
	 */
	public DatabaseException() {
		super();
	}

	/**
	 * Constructor that generates the exception with the given message and cause
	 * 
	 * @param message
	 *            the message for the exception
	 * @param cause
	 *            the cause for the exception
	 */
	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs the exception with the given message
	 * 
	 * @param message
	 *            the message for the exception
	 */
	public DatabaseException(String message) {
		super(message);
	}

	/**
	 * constructs the exception for the given cause
	 * 
	 * @param cause
	 *            the cause for the exception
	 */
	public DatabaseException(Throwable cause) {
		super(cause);
	}

}
