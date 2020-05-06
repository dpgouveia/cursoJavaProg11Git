package com.websrvmongodb.application.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websrvmongodb.application.dto.UserDTO;
import com.websrvmongodb.application.services.UserService;

@RestController
@RequestMapping(value = "users/")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok()
				.body(service.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList()));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(new UserDTO(service.findById(id)));
	}

}
