package s18.Interfaces.model.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import s18.Interfaces.model.entities.Contract;
import s18.Interfaces.model.entities.Installments;

public class InstallmentService {

	private Integer numberInstallments;
	private PaymentService paymentService;

	public InstallmentService(Integer numberInstallments, PaymentService paymentService) {
		super();
		this.numberInstallments = numberInstallments;
		this.paymentService = paymentService;

	}

	public void processInstallment(Contract contract) {
		LocalDate startDate = contract.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		for (int i = 1; i <= numberInstallments; i++) {
			LocalDate dueDate = startDate.plusMonths(i);
			contract.setInstallments(
					new Installments(Date.from(dueDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
							paymentService.tax(contract.getValue(), numberInstallments, i)));
		}

	}

}
