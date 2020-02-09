package s08entidades;

public class Triangulo {

	public double a;
	public double b;
	public double c;

	public double calcularArea() {

		double pTriangulo = (a + b + c) / 2;
		return (Math.sqrt(pTriangulo * (pTriangulo - a) * (pTriangulo - b) * (pTriangulo - c)));

	}

}
