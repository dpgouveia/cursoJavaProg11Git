package com.websrvmongodb.application.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.websrvmongodb.application.domain.Post;
import com.websrvmongodb.application.repositories.PostRepository;
import com.websrvmongodb.application.services.exceptions.PostServiceException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {

		if (id == null || id.trim().isBlank() || id.trim().isEmpty()) {
			throw new PostServiceException("Object ID IS NULL!", HttpStatus.NO_CONTENT);
		}

		return repository.findById(id)
				.orElseThrow(() -> new PostServiceException("Object NOT FOUND in database", HttpStatus.NOT_FOUND));
	}

	public List<Post> findByTitle(String titleSearch) {
//		return repository.findByTitleContainingIgnoreCase(titleSearch);
		return repository.searchTitle(titleSearch);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
		return repository.fullSearch(text, minDate, maxDate);
	}

}
