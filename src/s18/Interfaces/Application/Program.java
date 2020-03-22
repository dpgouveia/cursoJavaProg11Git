package s18.Interfaces.Application;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s18.Interfaces.Entidades.ContratoLocacao;
import s18.Interfaces.Entidades.Locadora;
import s18.Interfaces.Entidades.Veiculo;

public class Program {

	// metodos estaticos
	// main function
	public static void main(String args[]) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		aula181_exemplo01("AULA 181 - EXEMPLO 01", input);

		input.close();

	}

	public static void aula181_exemplo01(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

//		codigo de teste da impresso da nota de pagamento
//		Veiculo veiculo = new Veiculo("Fiesta 2014");
//		Locadora locadora = new Locadora("Localiza");
//		ContratoLocacao cl;
//		try {
//			cl = new ContratoLocacao("Daniel", veiculo, locadora, MyUtils.timestampToDate.parse("22/03/2020 10:00:00"),
//					MyUtils.timestampToDate.parse("23/03/2020 11:00:00"), 80.0, 400.00);
//			System.out.println(cl);
//		} catch (ParseException e) {
//			System.out.println("Erro: " + e.getMessage());
//
//			System.out.println();
//			System.out.println("==================");
//			e.printStackTrace();
//			System.out.println("==================");
//		}

		System.out.println();
		System.out.println("==============================");
		System.out.print("Entre com o nome da locadora: ");
		String nomeLocadora = MyUtils.readString(input);
		Locadora locadora = new Locadora(nomeLocadora);

		int qtdLocacoes;
		do {
			System.out.println();
			System.out.println("==============================");
			System.out.print("Entre com a quantidade de locações a serem registradas: ");
			qtdLocacoes = MyUtils.readInt(input);
			if (qtdLocacoes <= 0) {
				System.out.println("A quantidade de locações DEVE SER MAIOR QUE ZERO!");
			}
		} while (qtdLocacoes <= 0);

		while (qtdLocacoes > 0) {
			System.out.println();
			System.out.println("==============================");
			System.out.print("Entre com o nome do locatario da locação: ");
			String locatario = MyUtils.readString(input);

			System.out.print("Entre com o modelo do veículo: ");
			String modelo = MyUtils.readString(input);

			System.out.print("Entre com a data de início da locação (dd/MM/yyyy HH:mm:ss): ");
			Date inicioLocacao = MyUtils.readTimeStamp(input);

			System.out.print("Entre com a data de fim da locação (dd/MM/yyyy HH:mm:ss): ");
			Date fimLocacao = MyUtils.readTimeStamp(input);

			double valorHora;
			do {
				System.out.print("Entre com o valor hora da locação: ");
				valorHora = MyUtils.readDouble(input);
				if (valorHora < 0) {
					System.out.println("O valor hora DEVE SER MAIOR QUE ZERO!");
				}
			} while (valorHora < 0);

			double valorDiaria;
			do {
				System.out.print("Entre com o valor diário da locação: ");
				valorDiaria = MyUtils.readDouble(input);
				if (valorDiaria < 0) {
					System.out.println("O valor hora DEVE SER MAIOR QUE ZERO!");
				}
			} while (valorDiaria < 0);

			locadora.inserirNovoContrato(new ContratoLocacao(locatario, new Veiculo(modelo), locadora, inicioLocacao,
					fimLocacao, valorHora, valorDiaria));
			
			qtdLocacoes--;
		}
		
		// imprimindo todas as notas de pagamento da locadora
		System.out.println();
		System.out.println("==============================");
		System.out.println("NOTAS DE PAGAMENTO");
		System.out.println(locadora);
		
		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

	}

}
