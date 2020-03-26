package s18.Interfaces.model.entities;

public class Funcionario2 implements Comparable<Funcionario2> {

	// atributos
	private String nome;
	private Double salario;

	// construtores
	public Funcionario2() {
		super();
	}

	public Funcionario2(String nome, Double salario) {
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
	public int compareTo(Funcionario2 o) {
//		return salario.compareTo(o.salario);        // ascendente
		return -1 * salario.compareTo(o.salario);   // ascendente
	}
	
}
