package s10.MemoriaArrayListas.Entidades;

import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarios {

	private List<Funcionario> listaFuncionarios;

	// construtores
	public CadastroFuncionarios() {
		listaFuncionarios = new ArrayList<Funcionario>();
	}

	// getters e setters
	public void setFuncionario(Funcionario funcionario) {
		if (this.getFuncionario(funcionario.getId()) == null) {
			listaFuncionarios.add(funcionario);
		}
	}

	public Funcionario getFuncionario(String id) {
		return listaFuncionarios.stream().filter(funcionario -> funcionario.getId().equals(id)).findAny().orElse(null);
	}
	
	// métodos específicos da classe
	
	public void aumentarSalario(Funcionario funcionario, Double incrementoPercentual) {
		if(funcionario != null) {
			funcionario.aumentarSalario(incrementoPercentual);
		}
	}
	
	public String toString() {
		String output = "";
		for (Funcionario funcionario : listaFuncionarios) {
			output += "ID: " + funcionario.getId() + ", NOME: " + funcionario.getNome() + ", SALÁRIO: $ "
					+ String.format("%.2f", funcionario.getSalario()) + "\n";
		}
		return output;
	}

}
