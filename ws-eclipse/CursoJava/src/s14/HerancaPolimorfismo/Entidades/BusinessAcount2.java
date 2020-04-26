package s14.HerancaPolimorfismo.Entidades;

public class BusinessAcount2 extends Account2 {

	// atributos estaticos
	private static final double VAT = 2.0;

	// atributos base
	private Double loanLimit;

	// construtores
	public BusinessAcount2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessAcount2(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	// getters e setters
	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	// metodos
	public void loan(Double amount) {
		if (amount < this.loanLimit) {
			this.deposit(amount);
		}
	}
	
	@Override
	public void withdraw(Double amount) {
		if (this.balance > amount) {
			super.withdraw(amount);
			this.balance -= BusinessAcount2.VAT;
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("BusinessAcount [loanLimit=" + String.format("%.2f", this.loanLimit) + "]\n");
		return sb.toString();
	}

}
