package s18.Interfaces.model.entities;

public class BrazilInterestService implements InterestService {

	// atributos
	private Double interestRate;

	// construtores
	public BrazilInterestService() {
		super();
		interestRate = 2.0;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
