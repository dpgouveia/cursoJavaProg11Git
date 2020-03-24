package s18.Interfaces.model.services;

public class PayPal implements PaymentService {

	@Override
	public double tax(double amount, int numberInstallments, int installmentNumber) {
		double quota = amount / numberInstallments;
		return (quota * installmentNumber * 0.01 + quota) * 1.02;
	}

}
