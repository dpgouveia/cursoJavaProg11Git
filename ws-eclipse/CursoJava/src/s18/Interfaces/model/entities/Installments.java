package s18.Interfaces.model.entities;

import java.util.Date;

public class Installments {

	private Date dueDate;
	private Double amount;

	public Installments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Installments(Date dueDate, Double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
