package s19.GenericsSetMap.entities;

public class Produto implements Comparable<Produto> {

	// atributos
	private String nome;
	private Double preco;

	// construtores
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
	public int compareTo(Produto o) {
		return -1 * preco.compareTo(o.getPreco());
	}

	@Override
	public String toString() {
		return nome + ", " + "Preço: " + String.format("%.2f", preco) + "\n";
	}

}
