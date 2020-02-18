package s15TratamentoExcecoes;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

//		aula134_exemplo01(input);
//		aula134_exemplo02(input);

//		aula135_exemplo01_method02(input);
//		aula135_exemplo01(input);

		aula136_exemplo01();

		input.close();
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
