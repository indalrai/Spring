package com.hotelmanagement.exception;

public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public ResourceNotFoundException() {
		super();

	}

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

}
