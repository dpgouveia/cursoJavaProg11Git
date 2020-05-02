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
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public User update(Integer id, User user) {
		User entity = repository.getOne(id);
		updateDate(entity, user);
		return repository.save(entity);
	}

	private void updateDate(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());	
	}
	
}
