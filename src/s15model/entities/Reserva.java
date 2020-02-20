package s15model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Reserva {

	// atributos estaticos
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// atributos base
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	// construtores
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// getters e setters
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Reserva [numeroQuarto=" + numeroQuarto + ", checkIn=" + sdf.format(checkIn) + ", checkOut="
				+ sdf.format(checkOut) + "]\n");
		return sb.toString();
	}

	public Integer duracao() {
		LocalDate checkIn = this.checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate checkOut = this.checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
	}

	public void atualizarReserva(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

}
