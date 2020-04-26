package s10.MemoriaArrayListas.Entidades;

public class Produto {

	private String nome;
	private double preco;

	// contrutores
	public Produto() {
	}
	
	public Produto(String nome, double preco) {
		this.setNome(nome);
		this.setPreco(preco);
	}

	// getters and setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

}
