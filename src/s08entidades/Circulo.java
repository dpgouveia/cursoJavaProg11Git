package s08entidades;

public class Circulo {

	public static final double PI = 3.14159;
	private double raio;

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double circunferencia() {
		return 2 * PI * raio;
	}

	public double volume() {
		return 4 * PI * Math.pow(raio, 3.0) / 3;
	}

}
