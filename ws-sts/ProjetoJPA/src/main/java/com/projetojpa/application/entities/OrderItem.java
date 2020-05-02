package com.projetojpa.application.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.projetojpa.application.entities.pk.OrderItemPK;

@Entity public class OrderItem implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;
	
	// atributos
	@EmbeddedId private OrderItemPK id;
	private Integer quantity;
	private Double price;

	// construtores
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Product product, PurchaseOrder purchaseOrder, Integer quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
		id.setProduct(product);
		id.setOrder(purchaseOrder);
	}

	// getters e setters
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public PurchaseOrder getPurchaseOrder() {
		return id.getOrder();
	}
	
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		id.setOrder(purchaseOrder);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	// métodos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
