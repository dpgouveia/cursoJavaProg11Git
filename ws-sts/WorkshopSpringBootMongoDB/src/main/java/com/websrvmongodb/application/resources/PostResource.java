package com.websrvmongodb.application.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websrvmongodb.application.domain.Post;
import com.websrvmongodb.application.resources.util.URL;
import com.websrvmongodb.application.services.PostService;

@RestController
@RequestMapping(value = "posts/")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findPostsByTitle(
			@RequestParam(value = "text", defaultValue = "") String titleSearch) {
		return ResponseEntity.ok().body(service.findByTitle(URL.decodeParam(titleSearch)));
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String rawText,
			@RequestParam(value = "mindate", defaultValue = "") String strMinDate,
			@RequestParam(value = "maxdate", defaultValue = "") String strMaxDate) {
		
		String decodedText = URL.decodeParam(rawText);
		Instant minDate = URL.convertDate(strMinDate, Instant.parse("2000-01-01T00:00:00.00Z"));
		Instant maxDate = URL.convertDate(strMaxDate, Instant.now());
		
//		System.out.println("strMinDate: " + minDate);
//		System.out.println("strMaxDate: " + maxDate);
		
		return ResponseEntity.ok().body(service.fullSearch(decodedText, minDate, maxDate));
	}
	

}
