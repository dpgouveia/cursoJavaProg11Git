package com.projetojpa.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.application.entities.PurchaseOrderProduct;
import com.projetojpa.application.services.PurchaseOrderProductService;

@RestController @RequestMapping(value = "/purchaseorderproducts/") public class PurchaseOrderProductResource {

	// atributos
	@Autowired private PurchaseOrderProductService service;
	
	// métodos
	@GetMapping public ResponseEntity<List<PurchaseOrderProduct>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
