package com.projetojpa.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.application.entities.PurchaseOrderProduct;
import com.projetojpa.application.entities.pk.PurchaseOrderProductPK;

@Repository public interface PurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct, PurchaseOrderProductPK>{

}
