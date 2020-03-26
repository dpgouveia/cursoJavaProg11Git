package s18.Interfaces.model.entities;

public class Funcionario implements Comparable<Funcionario> {

	// atributos
	private String nome;
	private Double salario;

	// construtores
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, Double salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + "], salario=[$ " + String.format("%.2f", salario) + "]";
	}

	@Override
	public int compareTo(Funcionario o) {
		return nome.compareTo(o.nome);
	}
	
}
