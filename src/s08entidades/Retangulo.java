package s08entidades;

public class Retangulo {

	private double largura;
	private double altura;

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double area() {
		return (altura * largura);
	}

	public double perimetro() {
		return (2 * (altura + largura));
	}

	public double diagonal() {
		return (Math.sqrt(Math.pow(altura, 2.0) + Math.pow(largura, 2.0)));
	}

}
