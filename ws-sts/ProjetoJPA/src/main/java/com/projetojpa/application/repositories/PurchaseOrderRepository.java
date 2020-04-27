package com.projetojpa.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.application.entities.PurchaseOrder;

@Repository public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

}
