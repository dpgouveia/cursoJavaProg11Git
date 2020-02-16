package s14Entidades;

public class SavingsAccount extends Account {

	// atributos base
	private Double interestRate;

	// construtores
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	// getters e setters
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	// metodos
	@Override
	public void withdraw(Double amount) {
		if (this.balance > amount) {
			this.balance -= amount;
		}
	}

	public void updateBalance() {
		this.balance *= (1 + this.interestRate);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Account [number=" + this.getNumber() + ", holder=" + this.getHolder() + ", balance="
				+ String.format("%.2f", this.balance) + "]\n");
		sb.append("SavingsAccount [interestRate=" + String.format("%.2f", this.interestRate) + "]\n");
		return sb.toString();
	}

}
