package com.websrvmongodb.application.services.exceptions;

import org.springframework.http.HttpStatus;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;

	public UserServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

}
