package s15TratamentoExcecoes;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import myUtils.MyUtils;
import s15model.entities.Account;
import s15model.entities.Reserva;
import s15model.entities.ReservaComException;
import s15model.entities.ReservaComRuntimeException;
import s15model.exceptions.AccountException;
import s15model.exceptions.BusinessException;
import s15model.exceptions.BusinessRuntimeException;

public class Program {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

//		aula134_exemplo01(input);
//		aula134_exemplo02(input);

//		aula135_exemplo01_method02(input);
//		aula135_exemplo01(input);

//		aula136_exemplo01();

//		aula138_exemplo01_MuitoRuim(input);

//		aula139_exemplo01_Ruim(input);

//		aula140_exemplo01_Boa(input);
//		aula140_exemplo02_Boa(input);

		aula141_exercicio01(input);

		input.close();
	}

	public static void aula141_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 141 - EXERCÍCIO 01");
		System.out.println("-----------------------------------\n");

		try {

//			debug code
//			System.out.println();
//			System.out.println("--------------------");
//			Account conta = new Account(1001, "Alex", 0.0, 200.00);
//			Account conta = new Account(-1001, "Alex", 0.0, 200.00);
//			Account conta = new Account(1001, "", 0.0, 200.00);
//			Account conta = new Account(1001, null, 0.0, 200.00);
//			Account conta = new Account(1001, "Alex", -100.00, 200.00);
//			Account conta = new Account(1001, "Alex", 0.00, 0.0);
//			Account conta = new Account(1001, "Alex", 0.00, -100.0);
//			System.out.println(conta);
//
//			System.out.println();
//			System.out.println("--------------------");
//			conta.deposit(500.0);
//			System.out.println(conta);
//
//			System.out.println();
//			System.out.println("--------------------");
//			conta.withdraw(200.0);
//			System.out.println(conta);
//			
//			System.out.println();
//			System.out.println("--------------------");
//			conta.withdraw(200.0);
//			System.out.println(conta);
//			
//			System.out.println();
//			System.out.println("--------------------");
//			conta.withdraw(200.0);
//			System.out.println(conta);
//
//			System.out.println();
//			System.out.println("--------------------");
//			conta.withdraw(300.0);
//			System.out.println(conta);

			// cadastrando os dados da conta bancária
			System.out.println();
			System.out.println("-----------------------------------");
			System.out.println("Digite os dados da conta bancária");
			System.out.print("Numero da conta: ");
			Integer number = MyUtils.readInteger(input);
			System.out.print("Nome do proprietário da conta: ");
			String holder = MyUtils.readString(input);
			System.out.print("Saldo inicial da conta: ");
			Double balance = MyUtils.readDouble(input);
			System.out.print("Limite máximo para saque da conta: ");
			Double withdrawLimit = MyUtils.readDouble(input);
			Account conta = new Account(number, holder, balance, withdrawLimit);
			
			// realizando saque da conta
			System.out.println();
			System.out.println("-----------------------------------");
			System.out.print("Digite o valor de saque da conta: ");
			Double amount = MyUtils.readDouble(input);
			conta.withdraw(amount);
			System.out.println("Novo saldo da conta: " + conta.getBalance());

		} catch (AccountException e) {
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void aula140_exemplo02_Boa(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 140 - EXEMPLO 01 --- (BOA)");
		System.out.println("-----------------------------------\n");

		// cadastrando a reserva
		Integer numeroQuarto;
		do {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite o numero do quarto: ");
			numeroQuarto = MyUtils.readInteger(input);
		} while (numeroQuarto < 0);

		try {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			Date checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			Date checkOut = MyUtils.readDate(input);

			ReservaComRuntimeException reserva = new ReservaComRuntimeException(numeroQuarto, checkIn, checkOut);
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("RESERVA: " + reserva);

			// atualizando a reserva
			System.out.println("Digite os dados para atualizar a reserva");

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			checkOut = MyUtils.readDate(input);

			reserva.atualizarReserva(checkIn, checkOut);
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("RESERVA: " + reserva);

			// fim do programa
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("FIM DO PROGRAMA");
			System.out.println("---------------------------------------");
		} catch (BusinessRuntimeException e) {
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println(e);
		}

	}

	public static void aula140_exemplo01_Boa(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 140 - EXEMPLO 01 --- (BOA)");
		System.out.println("-----------------------------------\n");

		// cadastrando a reserva
		Integer numeroQuarto;
		do {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite o numero do quarto: ");
			numeroQuarto = MyUtils.readInteger(input);
		} while (numeroQuarto < 0);

		try {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			Date checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			Date checkOut = MyUtils.readDate(input);

			ReservaComException reserva = new ReservaComException(numeroQuarto, checkIn, checkOut);
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("RESERVA: " + reserva);

			// atualizando a reserva
			System.out.println("Digite os dados para atualizar a reserva");

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			checkOut = MyUtils.readDate(input);

			reserva.atualizarReserva(checkIn, checkOut);
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println("RESERVA: " + reserva);

		} catch (BusinessException e) {
			System.out.println(e);
		}

		// fim do programa
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("FIM DO PROGRAMA");
		System.out.println("---------------------------------------");
	}

	public static boolean aula139_validaReserva(Reserva reserva, Date checkIn, Date checkOut) {
//		boolean output = (	(reserva == null && checkIn.getTime() < checkOut.getTime()) ||
//							(checkIn.getTime() < checkOut.getTime() && checkIn.getTime() > reserva.getCheckIn().getTime() && checkOut.getTime() > reserva.getCheckOut().getTime())) 
//							? true : false;

		LocalDate ldCheckIn = checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ldCheckOut = checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int diffInput = (int) ChronoUnit.DAYS.between(ldCheckIn, ldCheckOut);

		boolean output = false;
		if (reserva == null) {
			if (diffInput > 0) {
				output = true;
			} else {
				output = false;
				System.out.println("A data de CHECK-OUT deve ser FUTURA a data de CHECK-IN");
			}
		} else {
			if (diffInput > 0) {

				LocalDate ldReservaCheckIn = reserva.getCheckIn().toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				LocalDate ldReservaCheckOut = reserva.getCheckOut().toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				int diffCheckin = (int) ChronoUnit.DAYS.between(ldReservaCheckIn, ldCheckIn);
				int diffCheckOut = (int) ChronoUnit.DAYS.between(ldReservaCheckOut, ldCheckOut);

				if (diffCheckin > 0) {
					if (diffCheckOut > 0) {
						output = true;
					} else {
						output = false;
						System.out.println("A data CHECK-OUT deve ser futura a data de CHECK-OUT da reserva");
					}
				} else {
					output = false;
					System.out.println("A data CHECK-IN deve ser futura a data de CHECK-IN da reserva");
				}
			} else {
				output = false;
				System.out.println("A data de CHECK-OUT deve ser FUTURA a data de CHECK-IN");
			}
		}

		return output;
	}

	public static void aula139_exemplo01_Ruim(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 139 - EXEMPLO 01 --- (RUIM)");
		System.out.println("-----------------------------------\n");

		// cadastrando a reserva
		Integer numeroQuarto;
		do {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite o numero do quarto: ");
			numeroQuarto = MyUtils.readInteger(input);
		} while (numeroQuarto < 0);
		Date checkIn = null, checkOut = null;
		do {

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			checkOut = MyUtils.readDate(input);

		} while (!aula139_validaReserva(null, checkIn, checkOut));

		Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("RESERVA: " + reserva);

		// atualizando a reserva
		System.out.println("Digite os dados para atualizar a reserva");
		do {

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			checkOut = MyUtils.readDate(input);

		} while (!aula139_validaReserva(reserva, checkIn, checkOut));
		reserva.atualizarReserva(checkIn, checkOut);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("RESERVA: " + reserva);

		// fim do programa
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("FIM DO PROGRAMA");
		System.out.println("---------------------------------------");
	}

	public static void aula138_exemplo01_MuitoRuim(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 138 - EXEMPLO 01 --- (MUITO RUIM)");
		System.out.println("-----------------------------------\n");

		// cadastrando a reserva
		Integer numeroQuarto;
		do {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite o numero do quarto: ");
			numeroQuarto = MyUtils.readInteger(input);
		} while (numeroQuarto < 0);

		boolean reservaInvalida;
		Date checkIn = null, checkOut = null;
		do {

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			checkOut = MyUtils.readDate(input);

			reservaInvalida = true;
			if (checkOut.before(checkIn)) {
				System.out.println("A data de CHECK-OUT deve ser futura a data de CHECK-IN");
			} else {
				reservaInvalida = false;
			}

		} while (reservaInvalida);

		Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("RESERVA: " + reserva);

		// atualizando a reserva
		System.out.println("Digite os dados para atualizar a reserva");
		do {
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-IN (dd/MM/yyyy): ");
			checkIn = MyUtils.readDate(input);

			System.out.println();
			System.out.println("---------------------------------------");
			System.out.print("Digite a data de CHECK-OUT (dd/MM/yyyy): ");
			checkOut = MyUtils.readDate(input);

			reservaInvalida = true;
			if (checkOut.before(checkIn)) {
				System.out.println("A data de CHECK-OUT deve ser futura a data de CHECK-IN");
			} else if (checkIn.before(reserva.getCheckIn())) {
				System.out.println("A data de CHECK-IN deve ser futura a data de CHECK-IN da reserva");
			} else if (checkOut.before(reserva.getCheckOut())) {
				System.out.println("A data de CHECK-OUT deve ser futura a data de CHECK-OUT da reserva");
			} else {
				reservaInvalida = false;
			}

		} while (reservaInvalida);
		reserva.atualizarReserva(checkIn, checkOut);
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("RESERVA: " + reserva);

		// fim do programa
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("FIM DO PROGRAMA");
		System.out.println("---------------------------------------");
	}

	public static void aula136_exemplo01() {

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 136 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		File file = new File(
				"C:\\Users\\Familia\\Documents\\Daniel\\eclipse\\eclipse-workspace\\cursoJavaProg11Git\\temp\\in.txt");
		Scanner input = null;

		try {
			input = new Scanner(file);
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("Imprimindo o texto do arquivo:");
			System.out.println("------------------------------\n");
			System.out.println();
			while (input.hasNextLine()) {
				System.out.println(input.nextLine());
			}
		} catch (Exception e) {
			System.out.println("ERRO AO ABRIR O ARQUIVO: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("BLOCO FINALLY EXECUTADO");
			System.out.println("------------------------------\n");
			System.out.println();
		}
	}

	public static void aula135_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 135 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		aula135_exemplo01_method01(input);

		System.out.println("Fim do programa!");

	}

	public static void aula135_exemplo01_method01(Scanner input) {
		System.out.println("*** METHOD01 START***");
		aula135_exemplo01_method02(input);
		System.out.println("*** METHOD01 END***");
	}

	public static void aula135_exemplo01_method02(Scanner input) {
		System.out.println("*** METHOD02 START***");
		Locale.setDefault(Locale.US);
		input.reset();

		String vect[] = input.nextLine().split(" ");
		try {
			int position = input.nextInt();
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição informada é INVÁLIDA ou INEXISTENTE no texto informado!!!");
			e.printStackTrace();
			input.next();
		} catch (InputMismatchException e) {
			System.out.println("Posição informada deve ser UM NÚMERO INTEIRO POSITIVO!!!");
		}
		System.out.println("*** METHOD02 END***");
	}

	public static void aula134_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 134 - EXEMPLO 02");
		System.out.println("-----------------------------------\n");

		System.out.println();
		System.out.println("----------------------------");
		System.out.print("Digite uma string com espaços: ");
		String vect[] = input.nextLine().split(" ");

		try {
			System.out.print("Informe a posição que deseja imprimir em tela: ");
			int position = input.nextInt();
			System.out.println(vect[position]);
		}
//		catch (Exception e) {
//			System.out.println("\n----------------------------");
//			System.out.println(e);
//			System.out.println("----------------------------\n");
//		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição informada é INVÁLIDA ou INEXISTENTE no texto informado!!!");
		} catch (InputMismatchException e) {
			System.out.println("Posição informada deve ser UM NÚMERO INTEIRO POSITIVO!!!");
		}

		System.out.println();
		System.out.println("----------------------------");
		System.out.println("Fim do programa!!!");

	}

	public static void aula134_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 134 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		System.out.println();
		System.out.println("----------------------------");
		System.out.print("Digite uma string com espaços: ");
		String vect[] = input.nextLine().split(" ");

		System.out.print("Informe a posição que deseja imprimir em tela: ");
		int position = input.nextInt();
		System.out.println(vect[position]);

		System.out.println("Fim do programa!!!");

		// Inputar os valroes abaixo
		// Alex Maria Bob
		// 1

		// Alex Maria Bob
		// a

		// Alex Maria Bob
		// 5

	}

}
