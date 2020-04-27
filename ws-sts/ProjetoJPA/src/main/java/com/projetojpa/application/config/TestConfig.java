package com.projetojpa.application.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetojpa.application.entities.User;
import com.projetojpa.application.repositories.UserRepository;

@Configuration @Profile("test") public class TestConfig implements CommandLineRunner {
	
	// atributos
	@Autowired private UserRepository userRepository;

	// métodos
	@Override public void run(String... args) throws Exception {

		User user1 = new User(null, "Daniel", "daniel@gmail.com", "(51) 99999-9999", "1234567");
		User user2 = new User(null, "Kélia", "kelia@gmail.com", "(61) 98888-8888", "1234567");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}
	
	
	
}
