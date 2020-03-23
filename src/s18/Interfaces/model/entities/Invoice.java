package s18.Interfaces.model.entities;

public class Invoice {

	// atributos
	private Double basicPayment;
	private Double tax;

	// construtores
	public Invoice() {
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	// getters e setters
	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	// metodos
	public Double getTotalPayment() {
		return basicPayment + tax;
	}

}
