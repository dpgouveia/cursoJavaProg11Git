package s12Git;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		aula107_exemplo01(input);

		aula109_exemplo01(input);

		input.close();

	}

	public static void aula109_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n----------------------------");
		System.out.println("AULA 109 - EXEMPLOE 01");
		System.out.println("----------------------------\n");

		System.out.println("Bom dia!!!!");
		System.out.println("Boa tarde!!!");
		System.out.println("Boa noite!!!");

	}

	public static void aula107_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n----------------------------");
		System.out.println("AULA 107 - EXEMPLOE 01");
		System.out.println("----------------------------\n");

		System.out.println("Bom dia!!!!");

	}

}
