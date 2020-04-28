package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.Category;
import com.projetojpa.application.repositories.CategoryRepository;

@Service public class CategoryService {
	
	// atributos
	@Autowired private CategoryRepository repository;
	
	// métodos
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Integer id) {
		return repository.findById(id).get();
	}
	
}
