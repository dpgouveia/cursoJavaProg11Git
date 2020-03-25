package s18.Interfaces.model.entities;

public abstract class AbstractShape implements InterfaceShape {

	// atributos
	private Color color;

	// construtores
	public AbstractShape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractShape(Color color) {
		super();
		this.color = color;
	}

	// metodos
	public Color getColor() {
		return color;
	}

}
