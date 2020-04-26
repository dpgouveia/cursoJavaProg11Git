package s19.GenericsSetMap.entities;

public class Retangulo implements Shape {

	// atributos
	private double largura;
	private double altura;
	
	// construtores
	public Retangulo(double largura, double altura) {
		super();
		this.largura = largura;
		this.altura = altura;
	}
	
	// metodos
	@Override
	public double area() {
		return largura * altura;
	}
		
}
