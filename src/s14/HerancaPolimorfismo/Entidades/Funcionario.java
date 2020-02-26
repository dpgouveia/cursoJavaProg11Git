package s14.HerancaPolimorfismo.Entidades;

public class Funcionario {

	// atributos base
	private String nome;
	private Integer quantidadeHoras;
	private Double valorHora;

	// construtores
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, Integer quantidadeHoras, Double valorHora) {
		super();
		this.nome = nome;
		this.quantidadeHoras = quantidadeHoras;
		this.valorHora = valorHora;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Funcionario [nome=" + nome + ", quantidadeHoras=" + quantidadeHoras + ", valorHora=" + valorHora
				+ "]\n");
		return sb.toString();
	}

	public Double pagamento() {
		return this.quantidadeHoras * this.valorHora;
	}

}
