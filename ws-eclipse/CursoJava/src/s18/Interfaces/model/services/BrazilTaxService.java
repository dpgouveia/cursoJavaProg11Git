package s18.Interfaces.model.services;

public class BrazilTaxService implements TaxService {

	// metodos
	public double tax(double amount) {
		return amount <= 100.0 ? amount * 0.2 : amount * 0.15;
	}

}
