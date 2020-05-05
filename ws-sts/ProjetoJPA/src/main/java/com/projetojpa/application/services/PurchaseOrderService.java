package com.projetojpa.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.application.entities.PurchaseOrder;
import com.projetojpa.application.repositories.PurchaseOrderRepository;

@Service public class PurchaseOrderService {
	
	@Autowired private PurchaseOrderRepository repository;
	
	public List<PurchaseOrder> findAll() {
		return repository.findAll();
	}
	
	public PurchaseOrder findById(Integer id) {
		return repository.findById(id).get();
	}

}
