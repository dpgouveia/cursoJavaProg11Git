package com.projetojpa.application.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetojpa.application.entities.pk.PurchaseOrderProductPK;

@Entity public class PurchaseOrderProduct implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;
	
	// atributos
	@EmbeddedId private PurchaseOrderProductPK id = new PurchaseOrderProductPK();
	private Integer quantity;
	private Double price;

	// construtores
	public PurchaseOrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderProduct(Product product, PurchaseOrder purchaseOrder, Integer quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
		id.setProduct(product);
		id.setPurchaseOrder(purchaseOrder);
	}

	// getters e setters
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@JsonIgnore public PurchaseOrder getPurchaseOrder() {
		return id.getPurchaseOrder();
	}
	
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		id.setPurchaseOrder(purchaseOrder);
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
		PurchaseOrderProduct other = (PurchaseOrderProduct) obj;
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
