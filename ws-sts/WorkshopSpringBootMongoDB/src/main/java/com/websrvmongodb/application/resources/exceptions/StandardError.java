package com.websrvmongodb.application.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = Shape.STRING, timezone = "Brazil/East", pattern = "dd-MM-YYYY'T'hh:mm:ss'Z'") private Instant timestamp;
	private HttpStatus status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Instant timestamp, HttpStatus status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
