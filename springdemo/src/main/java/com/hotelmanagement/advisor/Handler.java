package com.hotelmanagement.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelmanagement.exception.ResourceNotFoundException;

@RestControllerAdvice
public class Handler

//with controller we pass the exception
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> message(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

	//when we are using wrong method
	
	@ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> message2(HttpRequestMethodNotSupportedException exception) {
		if (exception instanceof HttpRequestMethodNotSupportedException) {
			ResourceNotFoundException resource = new ResourceNotFoundException();
			resource.setMessage("METHOD NOT FOUND");

			return new ResponseEntity<>(resource.getMessage(), HttpStatus.NOT_FOUND);

		} else {
			return ResponseEntity.ok(HttpStatus.OK);
		}
	}
}