package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.OrderItem;
import com.projetojpa.application.repositories.OrderItemRepository;

@Service public class OrderItemService {
	
	// atributos
	@Autowired private OrderItemRepository repository;
	
	// métodos
	public List<OrderItem> findAll() {
		return repository.findAll();
		
	}
	
}
