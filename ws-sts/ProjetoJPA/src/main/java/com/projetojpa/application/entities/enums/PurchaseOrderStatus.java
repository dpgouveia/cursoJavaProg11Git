package com.projetojpa.application.entities.enums;

public enum PurchaseOrderStatus {
	
	// enums
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	// atributos
	private int code;	

	// construtores
	PurchaseOrderStatus(int code) {
		this.code = code;
	}
	
	// getters e setters
	public int getCode() {
		return code;
	}
	
	// métodos
	public static PurchaseOrderStatus valueof(int code) {
		for(PurchaseOrderStatus value : PurchaseOrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid PurchaseOrderStatus code!");
		
	}
	

}
