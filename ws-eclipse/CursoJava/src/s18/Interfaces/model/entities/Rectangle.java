package s18.Interfaces.model.entities;

//public class Rectangle extends Shape {
public class Rectangle extends AbstractShape {

	// atributos
	private Double width;
	private Double height;

	// construtores
	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	// metodos
	@Override
	public double area() {
		return width * height;
	}

}
