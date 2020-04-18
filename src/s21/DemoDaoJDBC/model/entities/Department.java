package s21.DemoDaoJDBC.model.entities;

import java.io.Serializable;

// Serializable: interface para permitir que os objetos da classe possam ser convertidos em bytes
// Isso permite que o objeto possa ser gravado em arquivos, banco de dados e trafegar na rede
public class Department implements Serializable {

	// atributoe estáticos
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// atibutos
	private Integer id;
	private String name;

	// construtores
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// getter e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// métodos
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

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
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
