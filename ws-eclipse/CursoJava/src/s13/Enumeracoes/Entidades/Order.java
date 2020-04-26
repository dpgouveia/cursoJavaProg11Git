package s13.Enumeracoes.Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import s13.Enumeracoes.Enum.OrderStatus;

public class Order {

	// atributos estaticos
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	// atributos base
	private Date moment;
	private OrderStatus status;

	// atributos de composicao
	private Client client;
	private List<OrderItem> orderList;

	// construtores
	public Order() {
		super();

	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.setMoment(moment);
		this.setStatus(status);
		this.setClient(client);
		this.orderList = new ArrayList<OrderItem>();
	}

	// getters e setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}

	// metodos especificos
	public void addItem(OrderItem item) {
		this.getOrderList().add(item);
	}

	public void removeItem(OrderItem item) {
		this.getOrderList().remove(item);
	}

	public Double total() {
		Double sum = 0.0;
		for (OrderItem orderItem : this.getOrderList()) {
			sum += orderItem.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order summary: " + sdf.format(this.getMoment()) + "\n");
		sb.append("Order status: " + this.getStatus() + "\n");
		sb.append("Client: " + this.getClient().getName() + " (" + sdf.format(this.getClient().getBirthDate()) + ") - "
				+ this.getClient().getEmail() + "\n");
		sb.append("Order items:\n");
		for (OrderItem orderItem : this.getOrderList()) {
			sb.append(orderItem.getProduct().getName() + ", $"
					+ String.format("%.2f", orderItem.getProduct().getPrice()) + ", Quantity: "
					+ orderItem.getQuantity() + ", Subtotal: $" + String.format("%.2f", orderItem.subTotal()) + "\n");
		}
		sb.append("Total price: $" + this.total() + "\n");
		return sb.toString();
	}

}
