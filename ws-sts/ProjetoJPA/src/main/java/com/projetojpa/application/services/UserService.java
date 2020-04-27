package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.User;
import com.projetojpa.application.repositories.UserRepository;


@Service public class UserService {

	// atributos
	@Autowired private UserRepository repository;
	
	// métodos
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		return repository.findById(id).get();
	}
	
}
