package com.project.exception;

public class EmployeeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public EmployeeNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "Exception message =>"+message;
	}

}
