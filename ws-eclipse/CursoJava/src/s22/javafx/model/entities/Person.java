package s22.javafx.model.entities;

import java.io.Serializable;

public class Person implements Serializable {

	// atributos estáticos
	private static final long serialVersionUID = 1L;

	// atributos
	private Integer Id;
	private String name;
	private String email;

	// construtores
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Integer id, String name, String email) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
	}

	// getters e setters
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// métodos
	@Override
	public String toString() {
		return "Person [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	}

}
