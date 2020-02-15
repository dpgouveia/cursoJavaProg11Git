package s14Entidades;

public class ContaFisica {

	// atributos base
	private Integer numeroConta;
	private String nomeTitular;
	private Double saldoConta;

	// constutores
	public ContaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaFisica(Integer numeroConta, String nomeTitular, Double saldoConta) {
		super();
		this.setNumeroConta(numeroConta);
		this.setNomeTitular(nomeTitular);
		this.setSaldoConta(saldoConta);
	}

	// getters e setters
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	private void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}

	// metodos
	public void sacar(Double valorSaque) {
		if (this.getSaldoConta() > valorSaque) {
			this.setSaldoConta(this.getSaldoConta() - valorSaque);
		}
	}

	public void depositar(Double valorDeposito) {
		this.setSaldoConta(this.getSaldoConta() + valorDeposito);
	}

	@Override
	public String toString() {
		return "ContaFisica [numeroConta=" + this.getNumeroConta() + ", nomeTitular=" + this.getNomeTitular()
				+ ", saldoConta=" + this.getSaldoConta() + "]";
	}

}
