package com.websrvmongodb.application.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.websrvmongodb.application.services.exceptions.ResourceException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceException.class)
	public ResponseEntity<StandardError> resource(ResourceException e, HttpServletRequest request) {
		String error = e.getClass().toString();
		HttpStatus status = e.getStatus();
		String path = request.getRequestURI();
		StandardError err = new StandardError(Instant.now(), status, error, e.getMessage(), path);
		return ResponseEntity.status(status).body(err);
	}

}
