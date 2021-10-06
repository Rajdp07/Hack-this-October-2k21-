package com.nayan.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nayan.model.ResponseMessage;

import lombok.NoArgsConstructor;

/**
 * @author nayan
 *
 */
@RestControllerAdvice
@NoArgsConstructor
public class ExceptionHandler {

	/**
	 * @param e1
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(final InvalidProfileException exception) {
		final ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param e2
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(final NullPointerException exception) {
		final ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param e3
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler
	public  ResponseEntity<ResponseMessage> handleException(final ProfileNotFoundException exception) {
		return new ResponseEntity<>(
					new ResponseMessage(HttpStatus.NOT_FOUND, exception.getMessage()),
					HttpStatus.NOT_FOUND
				);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public  ResponseEntity<ResponseMessage> handleException(final OrderNotFoundException exception) {
		return new ResponseEntity<>(
					new ResponseMessage(HttpStatus.NOT_FOUND, exception.getMessage()),
					HttpStatus.NOT_FOUND
				);
	}
	/**
	 * handleMethodArgumentNotValid
	 * @param ex
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception) {

        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND);

        //Get all errors
        final List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("message", errors);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

}