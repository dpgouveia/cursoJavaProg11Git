package com.projetojpa.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.application.entities.OrderItem;
import com.projetojpa.application.services.OrderItemService;

@RestController @RequestMapping(value = "/orderitems") public class OrderItemResource {

	// atributos
	@Autowired private OrderItemService service;
	
	// métodos
	@GetMapping public ResponseEntity<List<OrderItem>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
