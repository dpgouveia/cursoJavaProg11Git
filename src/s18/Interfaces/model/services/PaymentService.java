package s18.Interfaces.model.services;

public interface PaymentService {

	double tax(double amount, int numberInstallments, int installmentNumber);
	
}
