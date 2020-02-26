package s08.IntroducaoOO.Entidades;

public class Product {

	public String name;
	public double price;
	public int quantity;

	public double totalValueStock() {
		return (price * quantity);
	}

	public void addProducts(int quantity) {
		this.quantity += quantity;
	}

	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}

	public String toString() {
		return (name + ", $ " + String.format("%.2f", price) + ", " + quantity + ", Total: $ "
				+ String.format("%.2f", totalValueStock()) + "\n\n");
	}

}
