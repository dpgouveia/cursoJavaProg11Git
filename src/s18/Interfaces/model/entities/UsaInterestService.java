package s18.Interfaces.model.entities;

public class UsaInterestService implements InterestService {

	// atributos
	private Double interestRate;

	// construtores
	public UsaInterestService() {
		super();
		interestRate = 1.0;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
