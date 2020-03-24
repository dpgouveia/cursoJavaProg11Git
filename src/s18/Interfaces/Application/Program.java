package s18.Interfaces.Application;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s18.Interfaces.Entidades.ContratoLocacao;
import s18.Interfaces.Entidades.Locadora;
import s18.Interfaces.Entidades.Veiculo;
import s18.Interfaces.model.entities.CarRental;
import s18.Interfaces.model.entities.Contract;
import s18.Interfaces.model.entities.Vehicle;
import s18.Interfaces.model.services.BrazilTaxService;
import s18.Interfaces.model.services.InstallmentService;
import s18.Interfaces.model.services.PayPal;
import s18.Interfaces.model.services.RentalService;

public class Program {

	// metodos estaticos
	// main function
	public static void main(String args[]) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

//		aula184_exemplo01("AULA 184 - EXEMPLO 01", input);
//		aula186_exemplo1("AULA 186 - EXEMPLO 01", input);
		aula189_exercicio1("AULA 189 - EXERCICIO 01", input);

		input.close();

	}

	public static void aula189_exercicio1(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

		System.out.println();
		System.out.println("==============================");
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = MyUtils.readInteger(input);

		System.out.print("Date (dd/MM/yyyy): ");
		Date startDate = MyUtils.readDate(input);

		System.out.print("Contract value: ");
		double value = MyUtils.readDouble(input);

		System.out.print("Enter number of installments: ");
		int installments = MyUtils.readInt(input);

		Contract contract = new Contract(number, startDate, value);
		InstallmentService is = new InstallmentService(installments, new PayPal());
		is.processInstallment(contract);

		System.out.println();
		System.out.println("==============================");
		System.out.println("Installments: ");
		System.out.println(contract);

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

	}

	public static void aula186_exemplo1(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

		System.out.println();
		System.out.println("==============================");
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String model = MyUtils.readString(input);

		System.out.print("Pickup (dd/MM/yyyy HH:mm:ss): ");
		Date pickupDate = MyUtils.readTimeStamp(input);
		System.out.print("Return (dd/MM/yyyy HH:mm:ss): ");
		Date returnDate = MyUtils.readTimeStamp(input);
		System.out.print("Enter price per hour: ");
		Double pricePerHour = MyUtils.readDouble(input);
		System.out.print("Enter price per day: ");
		Double pricePerDay = MyUtils.readDouble(input);

		CarRental carRental = new CarRental(pickupDate, returnDate, new Vehicle(model));
		RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rs.processInvoice(carRental);

		System.out.println();
		System.out.println("INVOICE:");
		System.out.println("Basic payment: $" + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: $" + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total Payment: $" + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();
	}

	public static void aula184_exemplo01(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

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
