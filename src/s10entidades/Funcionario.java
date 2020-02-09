package s10entidades;

public class Funcionario {

	private String id;
	private String nome;
	private Double salario;

	// construtores
	public Funcionario(String id, String nome, Double salario) {
		this.setId(id);
		this.setNome(nome);
		this.salario = salario;
	}

	// getters e setters
	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getSalario() {
		return salario;
	}

	// métodos específicos da classe
	protected void aumentarSalario(Double incrementoPercentual) {
		this.salario = this.salario * ((100 + incrementoPercentual) / 100);
	}
}
