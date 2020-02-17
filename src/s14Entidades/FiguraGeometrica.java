package s14Entidades;

import s14Entidades.Enum.Cor;

public abstract class FiguraGeometrica {

	// atributo base
	private Cor cor;

	// construtores
	public FiguraGeometrica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FiguraGeometrica(Cor cor) {
		super();
		this.cor = cor;
	}

	// getters e setters
	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	// metodos
	public abstract Double area();

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("FiguraGeometrica [cor=" + this.cor + "]\n");
		return sb.toString();
	}

}
