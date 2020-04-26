package s18.Interfaces.model.entities;

public abstract class Shape {

	// atributos
	private Color color;

	// construtores
	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shape(Color color) {
		super();
		this.color = color;
	}

	// metodos
	public Color getColor() {
		return color;
	}
	
	public abstract double area();

}
