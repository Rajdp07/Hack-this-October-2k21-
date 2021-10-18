package com.project.exception;

public class NameNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	public NameNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "Exception :="+message;
	}
}
