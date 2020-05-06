package com.websrvmongodb.application.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.websrvmongodb.application.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
