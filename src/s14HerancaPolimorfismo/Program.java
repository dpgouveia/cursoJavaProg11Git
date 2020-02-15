package s14HerancaPolimorfismo;

import java.util.Locale;
import java.util.Scanner;

import s14Entidades.ContaFisica;
import s14Entidades.ContaJuridica;

public class Program {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		aula121_exemplo01(input);

		input.close();
	}

	public static void aula121_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 121 - EXEMPLO 01");
		System.out.println("-------------------------\n");

		ContaFisica cf = new ContaFisica(283452, "DANIEL GOUVEIA", 200.00);
		System.out.println();
		System.out.println(cf);

		ContaJuridica cj = new ContaJuridica(15180, "KÉLIA CHAGAS", 400.00);
		System.out.println();
		System.out.println(cj);

	}

}
