package com.projetojpa.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.application.entities.PurchaseOrder;
import com.projetojpa.application.services.PurchaseOrderService;

@RestController @RequestMapping(value = "/purchaseorders") public class PurchaseOrderResource {
	
	// atributos
	@Autowired private PurchaseOrderService service;
	
	// métodos
	@GetMapping public ResponseEntity<List<PurchaseOrder>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}") public ResponseEntity<PurchaseOrder> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

}
