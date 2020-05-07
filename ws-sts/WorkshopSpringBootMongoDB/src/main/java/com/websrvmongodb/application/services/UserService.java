package com.websrvmongodb.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.websrvmongodb.application.domain.User;
import com.websrvmongodb.application.dto.UserDTO;
import com.websrvmongodb.application.repositories.UserRepository;
import com.websrvmongodb.application.services.exceptions.ResourceException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {

		if (id == null) {
			throw new ResourceException("Object ID IS NULL!", HttpStatus.NO_CONTENT);
		}

		return repository.findById(id)
				.orElseThrow(() -> new ResourceException("Object ID NOT IN DATABASE", HttpStatus.NOT_FOUND));
	}

	public User insert(User user) {

		if (user == null) {
			throw new ResourceException("User Object IS NULL!", HttpStatus.NO_CONTENT);
		}

		if (user.getId() != null) {
			throw new ResourceException("User Object ID EXISTS IN DATABASE!", HttpStatus.FOUND);
		}

		if (user.getName() == null || user.getName().trim().isBlank() || user.getName().trim().isEmpty()) {
			throw new ResourceException("User name in Object IS NULL OR EMPTY!", HttpStatus.NO_CONTENT);
		}

		if (user.getEmail() == null || user.getEmail().trim().isBlank() || user.getEmail().trim().isEmpty()) {
			throw new ResourceException("User Email in Object IS NULL OR EMPTY!", HttpStatus.NO_CONTENT);
		}

		try {
			return repository.save(user);
		} catch (RuntimeException e) {
			throw new ResourceException("Error caused by: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO);
	}

}
