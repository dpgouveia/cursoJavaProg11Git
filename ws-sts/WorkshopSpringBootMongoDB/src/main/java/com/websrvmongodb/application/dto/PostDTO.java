package com.websrvmongodb.application.dto;

import java.io.Serializable;
import java.time.Instant;

import com.websrvmongodb.application.domain.User;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Instant date;
	private String title;
	private String body;

	private User author;

	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(String id, Instant date, String title, String body, User author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
