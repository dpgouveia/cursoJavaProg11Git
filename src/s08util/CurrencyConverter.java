package s08util;

public class CurrencyConverter {

	public static double IOF = 0.06;

	public static double usToBRL(double dollarRate, double dollar) {
		return dollar * dollarRate * (1 + IOF);
	}

}
