package com.nayan.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProfileNotFoundException extends RuntimeException {

//super(){
//	
//}
	public ProfileNotFoundException(Long profileId) {
		super("Could not find the Profile with Profile Id " + profileId);
	}

}