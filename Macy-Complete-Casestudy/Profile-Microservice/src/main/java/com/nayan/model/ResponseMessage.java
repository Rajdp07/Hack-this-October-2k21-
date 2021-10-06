package com.nayan.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * responseMessageClass
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
	
	/**
	 * date&time
	 */
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime timestamp;
	/**
	 * status
	 */
	private HttpStatus status;
	/**
	 * message
	 */
	private String message;
	
	/**
	 * 
	 * @param status
	 * @param message
	 */
	public ResponseMessage(final HttpStatus status,final String message) {
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}

}