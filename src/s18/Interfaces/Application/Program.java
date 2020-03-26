package s18.Interfaces.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s18.Interfaces.Entidades.ContratoLocacao;
import s18.Interfaces.Entidades.Locadora;
import s18.Interfaces.Entidades.Veiculo;
import s18.Interfaces.model.devices.MyComboDevice;
import s18.Interfaces.model.devices.MyPrinter;
import s18.Interfaces.model.devices.MyScanner;
import s18.Interfaces.model.entities.AbstractShape;
import s18.Interfaces.model.entities.CarRental;
import s18.Interfaces.model.entities.Circle;
import s18.Interfaces.model.entities.Color;
import s18.Interfaces.model.entities.Contract;
import s18.Interfaces.model.entities.Funcionario;
import s18.Interfaces.model.entities.Funcionario2;
import s18.Interfaces.model.entities.Rectangle;
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
//		aula189_exercicio1("AULA 189 - EXERCICIO 01", input);
//		aula190_exemplo1("AULA 190 - EXEMPLO 01", input);
//		aula191_exemplo1("AULA 191 - EXEMPLO 01", input);
//		aula192_exemplo2("AULA 192 - EXEMPLO 02", input);
		aula192_exemplo3("AULA 192 - EXEMPLO 03", input);

		input.close();

	}

	public static void aula192_exemplo3(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

		String inputFile = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a192_ex01\\in2.txt";

		// lendo registros do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

			// criando lista de nomes
			ArrayList<Funcionario2> listaFuncionarios = new ArrayList<Funcionario2>();
			String line = br.readLine();
			while (line != null) {
				String campos[] = line.split(",");
				if (campos.length >= 2) {
					Funcionario2 funcionario = new Funcionario2(campos[0], Double.parseDouble(campos[1]));
					listaFuncionarios.add(funcionario);
				}
				line = br.readLine();
			}
			System.out.println();
			System.out.println("==============================");
			System.out.println("LISTA DE NOMES:");
			for (Funcionario2 funcionario : listaFuncionarios) {
				System.out.println(funcionario);
			}

			// ordenando a lista
//			listaFuncionarios.sort(Comparator.naturalOrder()); // meu jeito
			Collections.sort(listaFuncionarios);   // exemplo do professor

			// imprimindo a lista ordenada
			System.out.println();
			System.out.println("==============================");
			System.out.println("LISTA DE NOMES (ORDENADA)");
			for (Funcionario2 funcionario : listaFuncionarios) {
				System.out.println(funcionario);
			}

		} catch (NullPointerException | IOException e) {
			System.out.println();
			System.out.println("==============================");
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println();
			System.out.println("==============================");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("==============================");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("==============================");
			System.out.println();
		}

	}

	public static void aula192_exemplo2(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

		String inputFile = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a192_ex01\\in2.txt";

		// lendo registros do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

			// criando lista de nomes
			ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
			String line = br.readLine();
			while (line != null) {
				String campos[] = line.split(",");
				if (campos.length >= 2) {
					Funcionario funcionario = new Funcionario(campos[0], Double.parseDouble(campos[1]));
					listaFuncionarios.add(funcionario);
				}
				line = br.readLine();
			}
			System.out.println();
			System.out.println("==============================");
			System.out.println("LISTA DE NOMES:");
			for (Funcionario funcionario : listaFuncionarios) {
				System.out.println(funcionario);
			}

			// ordenando a lista
			listaFuncionarios.sort(Comparator.naturalOrder()); // meu jeito
//			Collections.sort(listaFuncionarios);   // exemplo do professor

			// imprimindo a lista ordenada
			System.out.println();
			System.out.println("==============================");
			System.out.println("LISTA DE NOMES (ORDENADA)");
			for (Funcionario funcionario : listaFuncionarios) {
				System.out.println(funcionario);
			}

		} catch (NullPointerException | IOException e) {
			System.out.println();
			System.out.println("==============================");
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println();
			System.out.println("==============================");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("==============================");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("==============================");
			System.out.println();
		}

	}

	public static void aula192_exemplo1(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

		String inputFile = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a192_ex01\\in.txt";

		// lendo registros do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

			// criando lista de nomes
			ArrayList<String> listaNomes = new ArrayList<String>();
			String line = br.readLine();
			while (line != null) {
				listaNomes.add(line);
				line = br.readLine();
			}
			System.out.println();
			System.out.println("==============================");
			System.out.println("LISTA DE NOMES:");
			for (String nome : listaNomes) {
				System.out.println(nome);
			}

			// ordenando a lista
			listaNomes.sort(Comparator.naturalOrder()); // meu jeito
//			Collections.sort(listaNomes);                  // exemplo do professor

			// imprimindo a lista ordenada
			System.out.println();
			System.out.println("==============================");
			System.out.println("LISTA DE NOMES (ORDENADA)");
			for (String nome : listaNomes) {
				System.out.println(nome);
			}

		} catch (NullPointerException | IOException e) {
			System.out.println();
			System.out.println("==============================");
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println();
			System.out.println("==============================");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("==============================");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("==============================");
			System.out.println();
		}

	}

	public static void aula191_exemplo1(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

		System.out.println();
		System.out.println("==============================");
		MyPrinter p = new MyPrinter("1080");
		p.processDoc("My letter");
		p.print("My letter");

		System.out.println();
		System.out.println("==============================");
		MyScanner s = new MyScanner("2003");
		s.processDoc("My Email");
		System.out.println("Scan result: " + s.scan());

		System.out.println();
		System.out.println("==============================");
		MyComboDevice cd = new MyComboDevice("2081");
		cd.processDoc("My dissertation");
		cd.print("My dissertation!");
		System.out.println("Scan result: " + cd.scan());

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

	}

	public static void aula190_exemplo1(String prog, Scanner input) {

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

//		Shape s1 = new Circle(Color.BLUE, 2.0);
//		Shape s2 = new Rectangle(Color.GREEN, 3.0, 4.0);
		AbstractShape s1 = new Circle(Color.BLUE, 2.0);
		AbstractShape s2 = new Rectangle(Color.GREEN, 3.0, 4.0);

		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));

		System.out.println();
		System.out.println("==============================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("==============================");
		System.out.println();

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
