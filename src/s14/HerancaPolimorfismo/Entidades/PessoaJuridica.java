package s14.HerancaPolimorfismo.Entidades;

public class PessoaJuridica extends Contribuinte {

	// atributos base
	private Integer numeroFuncionarios;

	// construtores
	public PessoaJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	// getters e setters
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	// metodos
	@Override
	public Double calcularImposto() {
		Double impostoArrecadado = rendaAnual * 0.16;
		if (numeroFuncionarios > 10) {
			impostoArrecadado = rendaAnual * 0.14;
		}
		return impostoArrecadado;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("PessoaJuridica [numeroFuncionarios=" + numeroFuncionarios + "]\n");
		return sb.toString();
	}

}
