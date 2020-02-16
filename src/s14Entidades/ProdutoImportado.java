package s14Entidades;

public class ProdutoImportado extends Produto {

	// atributos base
	private Double taxaAlfandega;

	// construtores
	public ProdutoImportado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	// getters e setters
	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	// métodos
	@Override
	public String toString() {
		return this.etiquetaPreco();
	}

	@Override
	public String etiquetaPreco() {
		StringBuffer sb = new StringBuffer();
		sb.append("Produto: " + this.getNome() + " | Preço: $ "
				+ String.format("%.2f", this.getPreco() + this.taxaAlfandega) + " (Taxa de Alfandega: $ "
				+ String.format("%.2f", this.taxaAlfandega) + ") |\n");
		return sb.toString();
	}

}
