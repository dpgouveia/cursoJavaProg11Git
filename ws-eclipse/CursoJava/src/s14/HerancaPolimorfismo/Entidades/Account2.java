package s14.HerancaPolimorfismo.Entidades;

public abstract class Account2 {

	// atributos estaticos
	private static final double ACCOUNT_VAT = 5.0;

	// atributos base
	private Integer number;
	private String holder;
	protected Double balance;

	// constutores
	public Account2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account2(Integer number, String holder, Double balance) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	// getters e setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	// metodos
	public void withdraw(Double amount) {
		if (this.balance > amount) {
			this.balance -= amount + Account2.ACCOUNT_VAT;
		}
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Account [number=" + this.number + ", holder=" + this.holder + ", balance=" + String.format("%.2f", this.balance) + "]\n");
		return sb.toString();
	}

}
