package com.projetojpa.application.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.User;
import com.projetojpa.application.repositories.UserRepository;
import com.projetojpa.application.services.exceptions.DatabaseException;
import com.projetojpa.application.services.exceptions.DataValidationException;
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
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public User update(Integer id, User user) {
		try {
			User entity = repository.getOne(id);
			updateDate(entity, user);
			user = repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataValidationException e) {
			throw new DataValidationException(e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return user;
	}

	private void updateDate(User entity, User user) {
				
		if(user.getName() == null || user.getName().trim().isBlank() || user.getName().trim().isEmpty()) {
			throw new DataValidationException("User name is NULL or EMPTY");
		}
		
		if(user.getEmail() == null || user.getEmail().trim().isBlank() || user.getEmail().trim().isEmpty()) {
			throw new DataValidationException("User email is NULL or EMPTY");
		}
		
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

}
