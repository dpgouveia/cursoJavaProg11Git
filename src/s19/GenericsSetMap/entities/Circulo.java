package s19.GenericsSetMap.entities;

public class Circulo implements Shape {

	// atributos
	private double raio;

	// construtores
	public Circulo(double raio) {
		super();
		this.raio = raio;
	}

	// metodos
	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2.0);
	}

}
