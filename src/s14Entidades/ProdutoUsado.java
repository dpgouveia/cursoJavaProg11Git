package s14Entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProdutoUsado extends Produto {

	// atributos estaticos
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// atributos base
	private Date dataFabricacao;

	// construtores
	public ProdutoUsado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	// getters e setters
	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	// m�todos
	@Override
	public String toString() {
		return this.etiquetaPreco();
	}

	@Override
	public String etiquetaPreco() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Usado) Produto: " + this.getNome() + " | Pre�o: $ " + String.format("%.2f", this.getPreco())
				+ " | Data de Fabrica��o: " + ProdutoUsado.sdf.format(dataFabricacao) + " |\n");
		return sb.toString();
	}

}
