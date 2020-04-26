package s18.Interfaces.model.entities;

import java.security.InvalidParameterException;

public interface InterestService {

	double getInterestRate();

	default double payment(double amount, int months) {
		
		if(amount <= 0) {
			throw new InvalidParameterException("Amount must be GREATER THAN ZERO!");
		}
		
		if (months < 1) {
			throw new InvalidParameterException("Months must be GREATER THAN ZERO!");
		}
		
		return amount * Math.pow((100 + getInterestRate()) / 100, months);
	}

}
