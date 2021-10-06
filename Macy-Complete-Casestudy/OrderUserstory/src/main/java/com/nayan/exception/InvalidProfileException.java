package com.nayan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author nayan
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidProfileException extends Exception {

	/**
	 * 
	 */
	public InvalidProfileException() {
		super("Invalid Profile Detail");
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidProfileException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}