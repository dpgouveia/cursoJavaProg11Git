package s10entidades;

public class Quarto {

	private String nomeLocatario;
	private String emailLocatario;

	// construtores
	public Quarto(String nomeLocatario, String emailLocatario) {
		this.setNome(nomeLocatario);
		this.setEmail(emailLocatario);
	}

	// getters e setters
	public void setNome(String nomeLocatario) {
		this.nomeLocatario = nomeLocatario;
	}

	public String getNome() {
		return nomeLocatario;
	}

	public void setEmail(String emailLocatario) {
		this.emailLocatario = emailLocatario;
	}

	public String getEmail() {
		return emailLocatario;
	}

}
