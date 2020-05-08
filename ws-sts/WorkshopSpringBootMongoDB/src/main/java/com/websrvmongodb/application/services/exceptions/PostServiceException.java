package com.websrvmongodb.application.services.exceptions;

import org.springframework.http.HttpStatus;

public class PostServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;

	public PostServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
