package s19.GenericsSetMap.entities;

public class Candidato implements Comparable<Candidato> {

	// atributos
	private String nome;
	private Integer qtdVotos;

	// construtores
	public Candidato(String nome) {
		super();
		this.nome = nome;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(Integer qtdVotos) {
		this.qtdVotos = qtdVotos;
	}

	// metodos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome + ": " + qtdVotos;
	}

	@Override
	public int compareTo(Candidato o) {
		return -1 * qtdVotos.compareTo(o.qtdVotos);
	}

}