package com.projetojpa.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojpa.application.entities.OrderItem;
import com.projetojpa.application.entities.pk.OrderItemPK;

@Repository public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
