package s08entidades;

public class Funcionario {

	private String nomeFuncionario;
	private double salarioBruto;
	private double impostos;

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public void setImpostos(double impostos) {
		this.impostos = impostos;
	}

	public double salarioLiquido() {
		return (salarioBruto - impostos);
	}

	public void aumentarSalario(double percentual) {
		this.salarioBruto *= (1 + percentual);
	}

	public String toString() {
		return nomeFuncionario + ", $ " + String.format("%.2f", salarioLiquido());
	}

}
