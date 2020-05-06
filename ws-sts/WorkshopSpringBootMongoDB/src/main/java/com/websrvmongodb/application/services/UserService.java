package com.websrvmongodb.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websrvmongodb.application.domain.User;
import com.websrvmongodb.application.repositories.UserRepository;
import com.websrvmongodb.application.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {

		if (id == null) {
			throw new NullPointerException(getClass() + ": Object ID IS NULL!");
		}

		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(getClass() + ": Object ID NOT FOUND ON MONGODB"));
	}

}
