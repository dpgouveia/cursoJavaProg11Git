package s13.Enumeracoes.Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import s13.Enumeracoes.Enum.StatusPedido;

public class Pedido {

	private Integer id;
	private Date moment;
	private StatusPedido status;

	// construtores
	public Pedido() {
	}

	public Pedido(Integer id, Date moment, StatusPedido status) {
		this.setId(id);
		this.setMoment(moment);
		this.setStatus(status);
	}

	// getters e setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public Date getMoment() {
		return this.moment;
	}

	public StatusPedido getStatus() {
		return this.status;
	}

	// métodos específicos da classe
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "ID: [" + this.getId() + "], Moment: [" + sdf.format(this.getMoment()) + "], Status: [" + this.getStatus() + "]\n";
	}

}
