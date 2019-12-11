package com.belatrix.test.exceptions;

public class BelatrixException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BelatrixException(String message) {
        super(message);
    }
	
	public BelatrixException(String message, Throwable cause) {
        super(message, cause);
    }

}
