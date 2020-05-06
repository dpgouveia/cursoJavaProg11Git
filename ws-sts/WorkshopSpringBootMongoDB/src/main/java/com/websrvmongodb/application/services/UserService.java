package com.websrvmongodb.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websrvmongodb.application.domain.User;
import com.websrvmongodb.application.repositories.UserRepository;

@Service public class UserService {

	@Autowired private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
}
