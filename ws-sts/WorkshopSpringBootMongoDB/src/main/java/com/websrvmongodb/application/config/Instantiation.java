package com.websrvmongodb.application.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.websrvmongodb.application.domain.Post;
import com.websrvmongodb.application.domain.User;
import com.websrvmongodb.application.repositories.PostRepository;
import com.websrvmongodb.application.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println(getClass() + " =====run()");

		User maria = new User(null, "Maria Brown", "maria@gmail.com");

		userRepository.deleteAll();
		userRepository.save(maria);

		postRepository.deleteAll();
		postRepository.save(new Post(null, Instant.parse("2018-03-21T00:00:00.00Z"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", maria));
		postRepository.save(
				new Post(null, Instant.parse("2018-03-23T00:00:00.00Z"), "Bom dia", "Acordei feliz hoje!", maria));

	}

}
