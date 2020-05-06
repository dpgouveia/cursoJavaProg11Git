package com.websrvmongodb.application.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.websrvmongodb.application.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		String error = "ObjectNotFoundException";
		HttpStatus status = HttpStatus.NOT_FOUND;
		String path = request.getRequestURI();
		StandardError err = new StandardError(Instant.now(), status, error, e.getMessage(), path);
		return ResponseEntity.status(status).body(err);
	}

}
