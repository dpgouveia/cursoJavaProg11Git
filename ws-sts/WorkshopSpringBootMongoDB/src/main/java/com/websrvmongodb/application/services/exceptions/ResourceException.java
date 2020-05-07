package com.websrvmongodb.application.services.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;

	public ResourceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

}
