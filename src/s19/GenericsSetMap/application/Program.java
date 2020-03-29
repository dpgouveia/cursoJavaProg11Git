package s19.GenericsSetMap.application;

import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;

public class Program {

	public static void main(String args[]) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		aula198_exemplo01("AULA 195 - EXEMPLO 01", input);

		input.close();

	}

	public static void aula198_exemplo01(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {
			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Digite a quantidade de numeros: ");
			int qtdNumeros = MyUtils.readInt(input);

			if (qtdNumeros <= 0)
				throw new InvalidParameterException("A quantidade numeros a serem digitados deve ser MAIOR QUE ZERO!");

		} catch (InvalidParameterException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

}
