package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.Product;
import com.projetojpa.application.repositories.ProductRepository;

@Service public class ProductService {
	
	// atributos
	@Autowired private ProductRepository repository;
	
	// métodos
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Integer id) {
		return repository.findById(id).get();
	}
	
}
