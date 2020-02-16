package s14Entidades;

public class SavingsAccountPlus extends SavingsAccount {

	// atributos estaticos
	private static Double VAT = 1.0;

	// metodos
	@Override
	public void withdraw(Double amount) {
		if (this.balance > amount) {
			this.balance -= amount + SavingsAccountPlus.VAT;
		}
	}

}
