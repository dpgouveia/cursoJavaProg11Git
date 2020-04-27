package com.projetojpa.application.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.application.entities.User;

@RestController @RequestMapping(value="/users") public class UserResource {
	
	@GetMapping public ResponseEntity<User> findAll() {
		
		User user = new User(1, "Maria", "maria@gmail.om", "9999-9999", "qwerty123");
		
		return ResponseEntity.ok().body(user);
		
	}
	
}
