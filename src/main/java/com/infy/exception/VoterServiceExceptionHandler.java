package com.infy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VoterServiceExceptionHandler {

	@ExceptionHandler(value = InvalidVoterException.class)
	public void handleInvalidVoterException() {
		System.out.println("Invalid voter exception Occurred..!!");
		
	}
}
