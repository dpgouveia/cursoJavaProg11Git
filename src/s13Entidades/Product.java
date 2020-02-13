package s13Entidades;

public class Product {

	// atributos base
	private String name;
	private Double price;

	// construtores
	public Product() {
		super();
	}

	public Product(String name, Double price) {
		super();
		this.setName(name);
		this.setPrice(price);
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

}
