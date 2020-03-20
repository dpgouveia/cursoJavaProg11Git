package s17.ManipulandoArquivos.Entidades;

public class Produto {

	// atributos
	private String nome;
	private double precoUnitario;
	private int quantidade;

	// construtores
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, double precoUnitario, int quantidade) {
		super();
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	// metodos
	public void incrementarQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}

	public double valorTotal() {
		return quantidade * precoUnitario;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Produto = [" + nome + "], Valor Total = $ " + String.format("%.2f", valorTotal()));
		return sb.toString();
	}

}
