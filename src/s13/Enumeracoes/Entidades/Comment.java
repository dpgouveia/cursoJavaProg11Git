package s13.Enumeracoes.Entidades;

public class Comment {

	private String text;

	// construtores
	public Comment() {
	}

	public Comment(String text) {
		this.setText(text);
	}

	// getters e setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
