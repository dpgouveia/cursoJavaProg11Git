package s14Entidades;

public abstract class Contribuinte {

	// atributos base
	private String nome;
	protected Double rendaAnual;

	// construtores
	public Contribuinte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contribuinte(String nome, Double rendaAnual) {
		super();
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Contribuinte [nome=" + nome + ", rendaAnual=" + String.format("%.2f", rendaAnual) + "]\n");
		return sb.toString();
	}
	
	// metodos abstratos
	public abstract Double calcularImposto();

}
