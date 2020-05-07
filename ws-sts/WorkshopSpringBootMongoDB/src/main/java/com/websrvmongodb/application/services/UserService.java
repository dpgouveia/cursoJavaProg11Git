package com.websrvmongodb.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.websrvmongodb.application.domain.User;
import com.websrvmongodb.application.dto.UserDTO;
import com.websrvmongodb.application.repositories.UserRepository;
import com.websrvmongodb.application.services.exceptions.UserServiceException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {

		if (id == null) {
			throw new UserServiceException("Object ID IS NULL!", HttpStatus.NO_CONTENT);
		}

		return repository.findById(id)
				.orElseThrow(() -> new UserServiceException("Object ID NOT FOUND IN DATABASE", HttpStatus.NOT_FOUND));
	}

	public User insert(User user) {

		if (user == null) {
			throw new UserServiceException("User Object IS NULL!", HttpStatus.NO_CONTENT);
		}

		if (user.getId() != null) {
			throw new UserServiceException("User Object ID IS NOT NULL!", HttpStatus.NO_CONTENT);
		}

		if (user.getName() == null || user.getName().trim().isBlank() || user.getName().trim().isEmpty()) {
			throw new UserServiceException("User name in Object IS NULL OR EMPTY!", HttpStatus.NO_CONTENT);
		}

		if (user.getEmail() == null || user.getEmail().trim().isBlank() || user.getEmail().trim().isEmpty()) {
			throw new UserServiceException("User Email in Object IS NULL OR EMPTY!", HttpStatus.NO_CONTENT);
		}

		return repository.save(user);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO);
	}

}
