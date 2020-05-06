package com.websrvmongodb.application.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websrvmongodb.application.domain.User;

@RestController
@RequestMapping(value = "users/")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> list = new ArrayList<User>();
		list.add(new User(1, "Daniel", "daniel@gmail.com"));
		list.add(new User(2, "Kélia", "kelia@gmail.com"));
		list.add(new User(3, "João", "joao@gmail.com"));
		list.add(new User(4, "Kelia", "keila@gmail.com"));
		list.add(new User(5, "Zeus", "zeus@gmail.com"));
		list.add(new User(6, "Sapeca", "sapeca@gmail.com"));
		list.add(new User(7, "Diana", "diana@gmail.com"));

		return ResponseEntity.ok().body(list);
	}

}
