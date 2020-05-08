package com.websrvmongodb.application.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.websrvmongodb.application.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
