package com.websrvmongodb.application.dto;

import java.io.Serializable;

import com.websrvmongodb.application.domain.User;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public AuthorDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}