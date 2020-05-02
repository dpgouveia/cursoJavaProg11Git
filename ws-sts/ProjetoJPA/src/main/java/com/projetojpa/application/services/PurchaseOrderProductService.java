package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.PurchaseOrderProduct;
import com.projetojpa.application.repositories.PurchaseOrderProductRepository;

@Service public class PurchaseOrderProductService {
	
	// atributos
	@Autowired private PurchaseOrderProductRepository repository;
	
	// métodos
	public List<PurchaseOrderProduct> findAll() {
		return repository.findAll();
		
	}
	
}
