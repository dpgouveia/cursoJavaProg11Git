package s15model.entities;

import s15model.exceptions.AccountException;

public class Account {

	// atributos base
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	// construtores
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws AccountException {
		super();

		if (number < 0) {
			throw new AccountException("O número da conta deve ser um valor positivo maior que zero");
		}

		if (holder == null || holder.isBlank() || holder.isEmpty()) {
			throw new AccountException("Não é possível criar uma conta com o nome do proprietário vazio ou nulo");
		}

		if (balance < 0) {
			throw new AccountException("Não é possível iniciar uma conta com saldo negativo");
		}

		if (withdrawLimit <= 0) {
			throw new AccountException("Valor máximo para saque deve ser maior que zero");
		}

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	// getters e setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) throws AccountException {

		if (number < 0) {
			throw new AccountException("O número da conta deve ser um valor positivo maior que zero");
		}

		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) throws AccountException {

		if (holder == null | holder.isBlank() || holder.isEmpty()) {
			throw new AccountException("Não é possível criar uma conta com o nome do proprietário vazio ou nulo");
		}

		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) throws AccountException {

		if (withdrawLimit <= 0) {
			throw new AccountException("Valor máximo para saque deve ser maior que zero");
		}

		this.withdrawLimit = withdrawLimit;
	}

	// metodos
	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) throws AccountException {

		if (amount > this.withdrawLimit) {
			throw new AccountException("Valor a ser sacado é SUPERIOR ao limite permitido na conta");
		}

		if (amount > this.balance) {
			throw new AccountException("Não há saldo suficiente na conta para realizar o saque");
		}

		this.balance -= amount;
	}

}
