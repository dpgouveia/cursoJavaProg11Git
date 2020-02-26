package s13.Enumeracoes.Entidades;

import java.util.Date;

public class Contrato {

	private Date dataInicio;
	private Double valorHora;
	private Integer horasTrabalhadas;

	// construtores
	public Contrato(Date dataInicio, Double valorHora, Integer horasTrabalhadas) {
		this.setDataInicio(dataInicio);
		this.setValorHora(valorHora);
		this.setHorasTrabalhadas(horasTrabalhadas);
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
	public Double valorTotal() {
		return this.getHorasTrabalhadas() * this.getValorHora();
	}

}
