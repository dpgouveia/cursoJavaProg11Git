package s14Entidades;

public class FuncionarioTercerizado extends Funcionario {

	// atributos base
	private Double adicional;

	// construtores
	public FuncionarioTercerizado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuncionarioTercerizado(String nome, Integer quantidadeHoras, Double valorHora, Double adicional) {
		super(nome, quantidadeHoras, valorHora);
		this.adicional = adicional;
	}

	// getters e setters
	public Double getAdicional() {
		return adicional;
	}

	public void setAdicional(Double adicional) {
		this.adicional = adicional;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("FuncionarioTercerizado [adicional=" + adicional + "]\n");
		return sb.toString();
	}

}
