package s13Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import s13Entidades.Enum.NivelTrabalhador;

public class Funcionario {

	// atributos simples da classe
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;

	// atributos compostos
	private Departamento departamento;
	private List<Contrato> contratos;

	// construtores
	public Funcionario(String nome, String nivel, Double salarioBase, Departamento departamento) {
		this.setNome(nome);
		this.setNivelTrabalhador(nivel);
		this.setSalarioBase(salarioBase);
		this.setDepartamento(departamento);
		this.contratos = new ArrayList<Contrato>();
	}

	// getters e setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNivelTrabalhador(String nivel) {
		this.nivel = NivelTrabalhador.valueOf(nivel);
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return this.nome;
	}

	public NivelTrabalhador getNivelTrabalhador() {
		return this.nivel;
	}

	public Double getSalarioBase() {
		return this.salarioBase;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	// métodos específicos da classe
	public void adicionarContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}

	public void removerContrato(Contrato contrato) {
		this.contratos.remove(contrato);
	}

	public Double faturamento(Integer mesFiscal, Integer anoFiscal) {
		Double faturamento = this.getSalarioBase();
		for (Contrato contrato : this.contratos) {
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(contrato.getDataInicio());
			if (calendario.get(Calendar.MONTH) == mesFiscal && calendario.get(Calendar.YEAR) == anoFiscal) {
				faturamento += contrato.valorTotal();
			}
		}
		return faturamento;
	}

	public String toString() {
		return "Nome: [" + this.getNome() + "]\nDepartamento: [" + this.getDepartamento().getNome() + "]\n";
	}

}
