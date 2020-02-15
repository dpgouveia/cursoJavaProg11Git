package s14Entidades;

public class ContaJuridica extends ContaFisica {

	// atributos base
	private Double creditoConta;

	// construtores
	public ContaJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaJuridica(Integer numeroConta, String nomeTitular, Double saldoConta) {
		super(numeroConta, nomeTitular, saldoConta);
		// TODO Auto-generated constructor stub
	}

	public ContaJuridica(Double creditoConta) {
		super();
		this.setCreditoConta(creditoConta);
	}

	// getters e setters
	public Double getCreditoConta() {
		return creditoConta;
	}

	public void setCreditoConta(Double creditoConta) {
		this.creditoConta = creditoConta;
	}

	// metodos
	public void sacarCredito(Double valorSaque) {
		if (this.getCreditoConta() > valorSaque) {
			this.setCreditoConta(this.getCreditoConta() - valorSaque);
		}
	}

	@Override
	public String toString() {
		String output = "ContaFisica [numeroConta=" + this.getNumeroConta() + ", nomeTitular=" + this.getNomeTitular()
				+ ", saldoConta=" + this.getSaldoConta() + "]\n";
		return output + "ContaJuridica [creditoConta=" + creditoConta + "]";
	}

}
