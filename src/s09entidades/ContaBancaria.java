package s09entidades;

public class ContaBancaria {

	private String name;
	private int numeroConta;
	private double saldoEmConta;

	private static final double taxaSaque = 5.00;

	// construtores (sobrecarga)
	public ContaBancaria() {
	}

	public ContaBancaria(String name, int numeroConta) {
		this.setName(name);
		this.setNumeroConta(numeroConta);
	}

	public ContaBancaria(String name, int numeroConta, double deposito) {
		this.setName(name);
		this.setNumeroConta(numeroConta);
		this.depositar(deposito);
	}

	// getters e setters
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldoConta() {
		return saldoEmConta;
	}

	// métodos da classe
	public void depositar(double deposito) {
		this.saldoEmConta += deposito;
	}

	public ContaBancaria sacar(double valorSaque) {
		if (valorSaque <= saldoEmConta) {
			this.saldoEmConta -= valorSaque + taxaSaque;
		}
		return this;
	}

	public String toString() {
		return "CONTA: " + numeroConta + ", PROPRIETÁRIO: " + name + ", SALDO: $ "
				+ String.format("%.2f", saldoEmConta);
	}

}
