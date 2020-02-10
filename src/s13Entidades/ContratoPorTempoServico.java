package s13Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContratoPorTempoServico {

	private Date dataInicio;
	private Double valorHora;
	private Integer horasTrabalhadas;

	// construtores
	public ContratoPorTempoServico() {

	}

	public ContratoPorTempoServico(Date dataInicio, Double valorHora, Integer horasTrabalhadas) {

	}

	// getters e setters
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public Double getValorHora() {
		return this.valorHora;
	}

	public Integer getHorasTrabalhadas() {
		return this.horasTrabalhadas;
	}

	// métodos específicos da classe
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "dataInicio: [" + sdf.format(this.getDataInicio()) + "], valorHora: ["
				+ String.format("%.2f", this.getValorHora()) + "], horasTrabalhadas: [" + this.getHorasTrabalhadas()
				+ "]\n";
	}

}
