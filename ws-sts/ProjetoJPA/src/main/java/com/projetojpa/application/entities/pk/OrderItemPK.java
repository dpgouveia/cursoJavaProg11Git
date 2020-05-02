package com.projetojpa.application.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.projetojpa.application.entities.Product;
import com.projetojpa.application.entities.PurchaseOrder;

@Embeddable public class OrderItemPK implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;
	
	// atributos
	@ManyToOne @JoinColumn(name = "purchaseorder_id") private PurchaseOrder order;
	@ManyToOne @JoinColumn(name = "product_id") private Product product;

	// getters e setters
	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	// métodos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
