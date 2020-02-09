package s08IntroducaoOO;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input;
		input = new Scanner(System.in);

		aula62_exemplo01(input);

		input.close();

	}

	public static void aula62_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 62 - EXEMPLO 01");

		System.out.printf("Digite os valores de A,B e C do triângulo X: ");
		double aTrianguloX = input.nextDouble();
		double bTrianguloX = input.nextDouble();
		double cTrianguloX = input.nextDouble();
		double pTrianguloX = (aTrianguloX + bTrianguloX + cTrianguloX) / 2;
		double areaTrianguloX = Math.sqrt(
				pTrianguloX * (pTrianguloX - aTrianguloX) * (pTrianguloX - bTrianguloX) * (pTrianguloX - cTrianguloX));

		System.out.printf("Digite os valores de A,B e C do triângulo X: ");
		double aTrianguloY = input.nextDouble();
		double bTrianguloY = input.nextDouble();
		double cTrianguloY = input.nextDouble();
		double pTrianguloY = (aTrianguloY + bTrianguloY + cTrianguloY) / 2;
		double areaTrianguloY = Math.sqrt(
				pTrianguloY * (pTrianguloY - aTrianguloY) * (pTrianguloY - bTrianguloY) * (pTrianguloY - cTrianguloY));

		System.out.printf("Área do triângulo X = %.4f\n", areaTrianguloX);
		System.out.printf("Área do triângulo Y = %.4f\n", areaTrianguloY);

		System.out.print("Triângulo com maior é: ");
		if (areaTrianguloX >= areaTrianguloY) {
			System.out.printf("X");
		} else {
			System.out.printf("Y");
		}

	}

}
