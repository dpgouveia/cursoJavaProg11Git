package s14.HerancaPolimorfismo.Entidades;

public class FuncionarioTercerizado extends Funcionario {

	// atributos estaticos
	public static Double DESPESA_ADICIONAL = 1.1;

	// atributos base
	private Double valorAdicional;

	// construtores
	public FuncionarioTercerizado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuncionarioTercerizado(String nome, Integer quantidadeHoras, Double valorHora, Double adicional) {
		super(nome, quantidadeHoras, valorHora);
		this.valorAdicional = adicional;
	}

	// getters e setters
	public Double getAdicional() {
		return valorAdicional;
	}

	public void setAdicional(Double adicional) {
		this.valorAdicional = adicional;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("FuncionarioTercerizado [adicional=" + valorAdicional + "]\n");
		return sb.toString();
	}

	@Override
	public Double pagamento() {
		return super.pagamento() + this.valorAdicional * FuncionarioTercerizado.DESPESA_ADICIONAL;
	}

}
