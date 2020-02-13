package s13Entidades;

public class OrderItem {

	// atributos base
	private Integer quantity;

	// atributos de composicao
	private Product product;

	// construtores
	public OrderItem() {
		super();
	}

	public OrderItem(Product product, Integer quantity) {
		super();
		this.setQuantity(quantity);
		this.setProduct(product);
	}

	// getters e setters
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// metodos especificos
	public Double subTotal() {
		return this.getProduct().getPrice() * this.getQuantity();
	}

}
