package s14Entidades;

public class PessoaFisica extends Contribuinte {

	// atributos base
	private Double gastosSaude;

	// construtores
	public PessoaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	// getters e setters
	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	// metodos
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("PessoaFisica [gastosSaude=" + String.format("%.2f", gastosSaude) + "]\n");
		return sb.toString();
	}

	@Override
	public Double calcularImposto() {
		Double impostoArrecadado  = rendaAnual * 0.15 - gastosSaude * 0.5;
		if(rendaAnual >= 20000.0) {
			impostoArrecadado = rendaAnual * 0.25 - gastosSaude * 0.5;
		} 
		return impostoArrecadado;
	}

}
