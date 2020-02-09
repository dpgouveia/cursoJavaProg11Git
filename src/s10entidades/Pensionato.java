package s10entidades;

public class Pensionato {

	private Quarto[] quartos;
	private static final int numeroQuartos = 10;

	// construtores
	public Pensionato() {
		this.quartos = new Quarto[numeroQuartos];
	}

	// getters e setters
	public void setQuarto(int numeroQuarto, Quarto quarto) {
		if (this.quartoDisponivel(numeroQuarto)) {
			this.quartos[numeroQuarto] = quarto;
		}
	}

	public Quarto getQuarto(int numeroQuarto) {
		if (numeroQuarto >= 0 && numeroQuarto <= this.quartos.length) {
			return this.quartos[numeroQuarto];
		}
		return null;
	}

	// métodos específicos da classe
	public boolean quartoDisponivel(int numeroQuarto) {
		if (numeroQuarto >= 0 && numeroQuarto <= this.quartos.length) {
			if (this.quartos[numeroQuarto] == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public String toString() {
		String stringOutput = "";
		for (int i = 0; i < this.quartos.length; i++) {
			if (!this.quartoDisponivel(i)) {
				stringOutput += i+ ": " + this.getQuarto(i).getNome() + ", " + this.getQuarto(i).getEmail() + "\n";
			}
		}	
		return stringOutput;
	}

}
