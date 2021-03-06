package com.projetojpa.application.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetojpa.application.entities.enums.PurchaseOrderStatus;

@Entity @Table(name = "tbl_purchaseorder") public class PurchaseOrder implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;

	// atributos
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") private Instant moment;
	private Integer purchaseOrderStatus;
	@ManyToOne @JoinColumn(name = "client_id") private User client;
	@OneToMany(mappedBy = "id.purchaseOrder") private Set<PurchaseOrderProduct> items = new HashSet<PurchaseOrderProduct>();
	@OneToOne(mappedBy = "purchaseOrder", cascade = CascadeType.ALL) private Payment payment;

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
	
	public Set<PurchaseOrderProduct> getItems() {
		return items;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
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
	
	public Double getTotal() {
		return items.stream().map(pop -> pop.getSubTotal()).reduce(0.0 , (total, parcial) -> total + parcial);
	}
	
}
