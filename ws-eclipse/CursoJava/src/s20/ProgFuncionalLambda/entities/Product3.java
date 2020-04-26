package s20.ProgFuncionalLambda.entities;

public class Product3 {

	// atributos
	private String name;
	private Double price;

	// construtores
	public Product3(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	// getters e setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// metodos
	@Override
	public String toString() {
		return "name=[" + name + "], price=[$ " + String.format("%.2f", price) + "]";
	}

}
