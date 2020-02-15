package s14Entidades;

public class ContaJuridica extends ContaFisica {

	// atributos base
	private Double limiteEmprestimo;

	// construtores
	public ContaJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaJuridica(Integer numeroConta, String nomeTitular, Double saldoConta, Double limiteEmprestimo) {
		super(numeroConta, nomeTitular, saldoConta);
		this.setLimiteEmprestimo(limiteEmprestimo);
	}

	// getters e setters
	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}

	// metodos
	public void emprestimo(Double valorEmprestimo) {
		if (valorEmprestimo < this.getLimiteEmprestimo()) {
			this.depositar(limiteEmprestimo);
		}
	}

	@Override
	public String toString() {
		String output = "ContaFisica [numeroConta=" + this.getNumeroConta() + ", nomeTitular=" + this.getNomeTitular()
				+ ", saldoConta=" + this.getSaldoConta() + "]\n";
		return output + "ContaJuridica [limiteEmprestimo=" + this.getLimiteEmprestimo() + "]";
	}

}
