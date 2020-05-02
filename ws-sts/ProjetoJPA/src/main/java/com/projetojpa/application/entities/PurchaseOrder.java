package com.projetojpa.application.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetojpa.application.entities.enums.PurchaseOrderStatus;

@Entity public class PurchaseOrder implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;

	// atributos
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") private Instant moment;
	private Integer purchaseOrderStatus;
	@ManyToOne @JoinColumn(name = "client_id") private User client;
	@OneToMany(mappedBy = "id.purchaseOrder") private Set<OrderItem> items = new HashSet<OrderItem>();

	// construtores
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrder(Integer id, Instant moment, PurchaseOrderStatus status, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setStatus(status);
		this.client = client;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public PurchaseOrderStatus getStatus() {
		return PurchaseOrderStatus.valueof(purchaseOrderStatus);
	}

	public void setStatus(PurchaseOrderStatus status) {
		if(status != null) {
			this.purchaseOrderStatus = status.getCode();	
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}

	// métodos
	@Override public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrder other = (PurchaseOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", client=" + client + "]";
	}

}
