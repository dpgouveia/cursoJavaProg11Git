package s20.ProgFuncionalLambda.entities;

public class Product implements Comparable<Product> {

	private String name;
	private Double price;

	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

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

	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100;
	}

	public boolean nonStaticProductPredicate() {
		return price >= 100;
	}

	public static void staticProductConsumer(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}

	public void nonStaticProductConsumer() {
		price *= 1.1;
	}

	public static Product staticProductFunction(Product source) {
		return new Product(source.getName().toUpperCase(), source.getPrice());
	}

	public Product nonStaticProductFunction() {
		return new Product(this.name.toUpperCase(), price);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + String.format("%.2f", price) + "]";
	}

	@Override
	public int compareTo(Product o) {
		return name.toUpperCase().compareTo(o.name.toUpperCase());
	}

}
