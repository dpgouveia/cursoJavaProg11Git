package s19.GenericsSetMap.entities;

import java.util.Date;

public class LoggedUser {
	
	// atributos
	private String nome;
	private Date loggedIn;

	// construtores
	public LoggedUser(String nome, Date loggedIn) {
		super();
		this.nome = nome;
		this.loggedIn = loggedIn;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Date loggedIn) {
		this.loggedIn = loggedIn;
	}

	// metodos
	@Override
	public String toString() {
		return "LoggedUser [nome=" + nome + ", loggedIn=" + loggedIn + "]";
	}

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
		LoggedUser other = (LoggedUser) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
