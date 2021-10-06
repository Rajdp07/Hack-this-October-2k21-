package com.nayan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.nayan.model.ResponseMessage;

class ResponseMessageTest {

	@Test
	void testGetterSetterConstructors() {
		ResponseMessage exceptionResponse1 = new ResponseMessage(HttpStatus.NOT_FOUND,
				"Could not find the Order Id 127");
		ResponseMessage exceptionResponse2 = new ResponseMessage();
		exceptionResponse2.setTimestamp(LocalDateTime.of(2020, 12, 31, 19, 30, 40));
		exceptionResponse2.setMessage("Could not find the Order Id 127");
		exceptionResponse2.setStatus((HttpStatus.NOT_FOUND));
        assertEquals(LocalDateTime.of(2020, 12, 31, 19, 30, 40), exceptionResponse2.getTimestamp());
		assertEquals("Could not find the Order Id 127", exceptionResponse2.getMessage());
		assertEquals(HttpStatus.NOT_FOUND, exceptionResponse1.getStatus());
	}

}
