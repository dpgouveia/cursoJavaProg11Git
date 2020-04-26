package s18.Interfaces.model.entities;

//public class Circle extends Shape {
public class Circle extends AbstractShape {

	// atributos
	private Double radius;

	// construtores
	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	// metodos
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

}
