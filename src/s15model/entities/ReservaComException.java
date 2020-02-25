package s15model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import s15model.exceptions.BusinessException;

public class ReservaComException {

	// atributos estaticos
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// atributos base
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	// construtores
	public ReservaComException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservaComException(Integer numeroQuarto, Date checkIn, Date checkOut) throws BusinessException {
		super();
		
		if(checkOut.before(checkIn)) {
			throw new BusinessException("A data de CHECK-OUT deve ser futura a data de CHECK-IN");
		}
		
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
		sb.append("Quarto: " + this.numeroQuarto + ", Check-In: " + sdf.format(this.checkIn) + ", Check-Out: "
				+ sdf.format(this.checkOut) + ", " + this.duracao() + " noite(s)\n");
		return sb.toString();
	}

	public Integer duracao() {
		LocalDate checkIn = this.checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate checkOut = this.checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
	}

	public void atualizarReserva(Date checkIn, Date checkOut) throws BusinessException {
		
		if(checkOut.before(checkIn)) {
			throw new BusinessException("A data de CHECK-OUT deve ser futura a data de CHECK-IN");
		}
		
		if(checkIn.before(this.getCheckIn())) {
			throw new BusinessException("A data de CHECK-IN deve ser futura a data de CHECK-IN da reserva");
		}
		
		if(checkOut.before(this.getCheckOut())) {
			throw new BusinessException("A data de CHECK-OUT deve ser futura a data de CHECK-OUT da reserva");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

}
