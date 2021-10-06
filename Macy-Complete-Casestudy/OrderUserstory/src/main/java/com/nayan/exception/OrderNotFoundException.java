package com.nayan.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

//super(){
//	
//}
	public OrderNotFoundException(Long orderId) {
		super("Could not find the Order Id " + orderId);
	}

}