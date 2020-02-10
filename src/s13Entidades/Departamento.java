package s13Entidades;

public class Departamento {
	
	private String nome;
	
	// construtores
	public Departamento() {
	}
	
	public Departamento(String nome) {
		this.setNome(nome);
	}
	
	// getters e setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	// métodos específicos da classe
	public String toString() {
		return "nome: [" + this.getNome() + "]\n";
	}
	

}
