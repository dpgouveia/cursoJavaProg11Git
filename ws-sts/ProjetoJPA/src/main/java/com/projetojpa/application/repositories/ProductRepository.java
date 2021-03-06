package com.projetojpa.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.application.entities.Product;

@Repository public interface ProductRepository extends JpaRepository<Product, Integer>{

}
