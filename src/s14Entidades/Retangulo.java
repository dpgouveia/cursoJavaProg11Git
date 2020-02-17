package s14Entidades;

import s14Entidades.Enum.Cor;

public class Retangulo extends FiguraGeometrica {

	// atributos base
	private Double largura;
	private Double altura;

	// construtores
	public Retangulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retangulo(Cor cor, Double largura, Double altura) {
		super(cor);
		this.largura = largura;
		this.altura = altura;
	}

	// getters e setters
	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("Retangulo [largura=" + String.format("%.2f", this.largura) + ", altura="
				+ String.format("%.2f", this.altura) + "]\n");
		return sb.toString();
	}

	@Override
	public Double area() {
		return this.altura * this.largura;
	}

}
