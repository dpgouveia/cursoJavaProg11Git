package s18.Interfaces.Entidades;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import common.myUtils.MyUtils;

public class ContratoLocacao {

	// atributos
	private String locatario;
	private Veiculo veiculo;
	private Locadora locadora;
	private Date horaInicioLocacao;
	private Date horaFimLocacao;
	private double valorHoraLocacao;
	private double valorDiarioLocacao;

	// Construtores
	public ContratoLocacao(String locatario, Veiculo veiculo, Locadora locadora, Date horaInicioLocacao,
			Date horaFimLocacao, double valorHoraLocacao, double valorDiarioLocacao) {
		super();
		this.locatario = locatario;
		this.veiculo = veiculo;
		this.locadora = locadora;
		this.horaInicioLocacao = horaInicioLocacao;
		this.horaFimLocacao = horaFimLocacao;
		this.valorHoraLocacao = valorHoraLocacao;
		this.valorDiarioLocacao = valorDiarioLocacao;
	}

	// metodos
	public String gerarNotaPagamento() {

		double qtdHorasLocacao = Math.ceil(MyUtils.dateDiff(horaInicioLocacao, horaFimLocacao, TimeUnit.MINUTES) / 60.0);				
		double valorLocacao = qtdHorasLocacao <= 12 ? qtdHorasLocacao * valorHoraLocacao : valorDiarioLocacao * (Math.ceil(qtdHorasLocacao / 24.0)) ;
		double valorImposto = valorLocacao <= 100 ? valorLocacao * 0.2 : valorLocacao * 0.15;
		double valorTotalPagamento = valorLocacao + valorImposto;

		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("=================\n");
		sb.append("NOTA DE PAGAMENTO\n");
		sb.append("LOCATARIO: " + locatario + "\n");
		sb.append("LOCADORA: " + locadora.getNome() + "\n");
		sb.append("VEICULO: " + veiculo.getModelo() + "\n");
		sb.append("VALOR DA LOCACAO: $ " + String.format("%.2f", valorLocacao) + "\n");
		sb.append("VALOR DO IMPOSTO: $ " + String.format("%.2f", valorImposto) + "\n");
		sb.append("VALOR TOTAL DO PAGAMENTO: $ " + String.format("%.2f", valorTotalPagamento) + "\n");
		sb.append("=================\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		return gerarNotaPagamento();
	}

}
