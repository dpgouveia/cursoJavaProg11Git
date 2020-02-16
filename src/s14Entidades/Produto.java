package s14Entidades;

public class Produto {

	// atributos base
	private String nome;
	private Double preco;

	// construtores
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	// metodos
	@Override
	public String toString() {
		return this.etiquetaPreco();
	}

	public String etiquetaPreco() {
		StringBuffer sb = new StringBuffer();
		sb.append("Produto: " + nome + " | Preço: $ " + String.format("%.2f", preco) + " |\n");
		return sb.toString();
	}

}
