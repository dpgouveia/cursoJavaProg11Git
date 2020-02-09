package s08IntroducaoOO;

import java.util.Locale;
import java.util.Scanner;

import s08entidades.Circulo;
import s08util.Calculator;
import s08util.CurrencyConverter;

public class Program {

	private static final double PI = 3.14159;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

//		aula69_exemplo01(input);
//		aula69_exemplo02(input);
//		aula69_exemplo03(input);

		aula71_exercicio01(input);

		input.close();
	}

	public static void aula71_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();
		System.out.println("\n--------------------------------------");
		System.out.println("AULA 71 - EXERCICIO 01");
		System.out.println("---------------------------------------\n");

		System.out.printf("Input dollar rate: ");
		double dollarRate = input.nextDouble();
		System.out.printf("How many dollars will be bought: ");
		double dollar = input.nextDouble();

		System.out.println("Amount to be paid in reais (BRL): "
				+ String.format("%.2f", CurrencyConverter.usToBRL(dollarRate, dollar)));

	}

	public static void aula69_exemplo03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();
		System.out.println("\n--------------------------------------");
		System.out.println("AULA 69 - EXEMPLO 03");
		System.out.println("---------------------------------------\n");

		System.out.printf("Digite o raio da esfera: ");
		double raio = input.nextDouble();

		System.out.println("CIRCUNFERENCIA da esfera: " + String.format("%.2f", Calculator.circunferencia(raio)));
		System.out.println("VOLUME da esfera: " + String.format("%.2f", Calculator.volume(raio)));
		System.out.println("Valor de PI: " + String.format("%.2f", Calculator.PI));

	}

	public static void aula69_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();
		System.out.println("\n--------------------------------------");
		System.out.println("AULA 69 - EXEMPLO 02");
		System.out.println("---------------------------------------\n");

		System.out.printf("Digite o raio da esfera: ");
		Circulo circle = new Circulo();
		circle.setRaio(input.nextDouble());

		System.out.println("CIRCUNFERENCIA da esfera: " + circle.circunferencia());
		System.out.println("VOLUME da esfera: " + circle.volume());
		System.out.println("Valor de PI: " + Circulo.PI);

	}

	public static void aula69_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();
		System.out.println("\n--------------------------------------");
		System.out.println("AULA 69 - EXEMPLO 01");
		System.out.println("---------------------------------------\n");

		System.out.printf("Digite o raio da esfera: ");
		double raio = input.nextDouble();

		System.out.println("CIRCUNFERENCIA da esfera: " + Program.circunferencia(raio));
		System.out.println("VOLUME da esfera: " + Program.volume(raio));
		System.out.println("Valor de PI: " + Program.PI);

	}

	public static double circunferencia(double raio) {
		return 2 * PI * raio;
	}

	public static double volume(double raio) {
		return 4 * PI * Math.pow(raio, 3.0) / 3;
	}

}
