package s14Entidades;

import s14Entidades.Enum.Cor;

public class Circulo extends FiguraGeometrica {

	// atributos base
	private Double raio;

	public Circulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circulo(Cor cor, Double raio) {
		super(cor);
		this.raio = raio;
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("Circulo [raio=" + String.format("%.2f", raio) + "]\n");
		return sb.toString();
	}

	@Override
	public Double area() {
		return Math.PI * Math.pow(raio,  2.0);
	}

}
