package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.User;
import com.projetojpa.application.repositories.UserRepository;
import com.projetojpa.application.services.exceptions.DatabaseException;
import com.projetojpa.application.services.exceptions.ResourceNotFoundException;


@Service public class UserService {

	// atributos
	@Autowired private UserRepository repository;
	
	// métodos
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);	
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
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
