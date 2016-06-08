package com.mindtree.bug.tracker.exception;

/**
 * @author M1035940
 *
 */
public class ServiceException extends Exception {

	/**
	 * default serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructs the ServiceException
	 */
	public ServiceException() {
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
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs the exception with the given message
	 * 
	 * @param message
	 *            the message for the exception
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * constructs the exception for the given cause
	 * 
	 * @param cause
	 *            the cause for the exception
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

}
