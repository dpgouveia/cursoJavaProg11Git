package s18.Interfaces.Entidades;

import java.util.ArrayList;

public class Locadora {

	// atributos
	private String nome;
	private ArrayList<ContratoLocacao> listaContratos;

	// construtores
	public Locadora(String nome) {
		this.nome = nome;
		listaContratos = new ArrayList<ContratoLocacao>();
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	// metodos
	public void inserirNovoContrato(ContratoLocacao novoContrato) {
		listaContratos.add(novoContrato);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (ContratoLocacao contrato : listaContratos) {
			sb.append(contrato);
		}
		return sb.toString();
	}

}

/*
 * Veiculo <---------> ContratoLocacao <-----------> Locadora 1 <---------> 1..N
 * <-----------> 1..N
 * 
 * Veiculo modelo
 * 
 * ContratoLocacao locatario Veiculo Locadora horaInicioLocacao horaFimLocacao
 * valorHoraLocacao valorDiarioLocacao
 * 
 * Locadora nome
 * 
 */
