package s19.GenericsSetMap.entities;

public class Aluno {

	// atributos
	private int CodigoAluno;

	// construtores
	public Aluno(int codigoAluno) {
		super();
		CodigoAluno = codigoAluno;
	}

	// getters e setters
	public int getCodigoAluno() {
		return CodigoAluno;
	}

	public void setCodigoAluno(int codigoAluno) {
		CodigoAluno = codigoAluno;
	}

	// metodos
	@Override
	public String toString() {
		return "Aluno [CodigoAluno=" + CodigoAluno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CodigoAluno;
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
		Aluno other = (Aluno) obj;
		if (CodigoAluno != other.CodigoAluno)
			return false;
		return true;
	}

}
