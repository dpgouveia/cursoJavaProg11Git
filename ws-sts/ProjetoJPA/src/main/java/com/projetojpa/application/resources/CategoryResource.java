package com.projetojpa.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.application.entities.Category;
import com.projetojpa.application.services.CategoryService;

@RestController @RequestMapping(value = "/categories") public class CategoryResource {
	
	// atributos
	@Autowired private CategoryService service;
	
	// métodos
	@GetMapping public ResponseEntity<List<Category>> findall() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}") public ResponseEntity<Category> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
}
