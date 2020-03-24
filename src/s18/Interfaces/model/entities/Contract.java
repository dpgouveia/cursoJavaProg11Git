package s18.Interfaces.model.entities;

import java.util.ArrayList;
import java.util.Date;

import common.myUtils.MyUtils;

public class Contract {

	// atributos
	private Integer number;
	private Date startDate;
	private Double value;
	private ArrayList<Installments> installments;

	// construtores
	public Contract(Integer number, Date startDate, Double value) {
		super();
		this.number = number;
		this.startDate = startDate;
		this.value = value;
		this.installments = new ArrayList<Installments>();
	}

	// getters e setters
	public Date getStartDate() {
		return startDate;
	}

	public Double getValue() {
		return value;
	}

	// metodos
	public void setInstallments(Installments installment) {
		installments.add(installment);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Installments inst : installments) {
			System.out.println(
					MyUtils.stringToDate.format(inst.getDueDate()) + " - $ " + String.format("%.2f", inst.getAmount()));
		}
		return sb.toString();
	}

}
