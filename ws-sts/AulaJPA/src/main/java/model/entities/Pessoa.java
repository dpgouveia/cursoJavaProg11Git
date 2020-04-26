package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity public class Pessoa implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;

	// atributos
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
	@Column(name="nome") private String nomeCompleto;
	private String email;

	// construtores
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nomeCompleto = nome;
		this.email = email;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nomeCompleto;
	}

	public void setNome(String nome) {
		this.nomeCompleto = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// métodos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nomeCompleto + ", email=" + email + "]";
	}

}
