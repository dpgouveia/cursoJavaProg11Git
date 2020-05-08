package com.websrvmongodb.application.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.websrvmongodb.application.domain.Post;
import com.websrvmongodb.application.domain.User;
import com.websrvmongodb.application.dto.AuthorDTO;
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

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User bob = new User(null, "Bob Brown", "bob@gmail.com");
		User alex = new User(null, "Alex Brown", "alex@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, bob, alex));

		Post p1 = new Post(null, Instant.parse("2018-03-21T00:00:00.00Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post p2 = new Post(null, Instant.parse("2018-03-23T00:00:00.00Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		maria.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(maria);
		

	}

}
