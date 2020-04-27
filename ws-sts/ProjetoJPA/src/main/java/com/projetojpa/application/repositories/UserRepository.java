package com.projetojpa.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.application.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
