package s07OutrosTopicosBasicosJava;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input;
		input = new Scanner(System.in);

//		aula56_exemplo01(input);
//		aula56_exemplo02(input);

//		aula57_exemplo01(input);
//		aula57_exemplo02(input);

//		aula59_exemplo01(input);
		aula59_exemplo02(input);

		input.close();

	}

	public static void aula59_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 59 - EXEMPLO 02");

		System.out.printf("Digite três números inteirois: ");
		int numero1 = input.nextInt();
		int numero2 = input.nextInt();
		int numero3 = input.nextInt();

		showResult(maiorNumero(numero1, numero2, numero3));

	}

	public static int maiorNumero(int number1, int number2, int number3) {

		if (number1 >= number2 && number1 >= number3) {
			return number1;
		} else if (number2 >= number1 && number2 >= number3) {
			return number2;
		} else {
			return number3;
		}
	}

	public static void showResult(int value) {
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("Maior numero digitado é o " + value);
		System.out.println("------------------------------");
	}

	public static void aula59_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 59 - EXEMPLO 01");

		double x = Math.sqrt(25.0);
		System.out.println("X = " + x);

		double y = 25.0;
		double z = Math.sqrt(y);
		System.out.println("Z = " + z);

	}

	public static void aula57_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 57 - EXEMPLO 02");

		String stringExemplo = "batata maça limão laranja";
		String[] vetor = stringExemplo.split(" ");

		System.out.println("     stringExemplo = " + "|" + stringExemplo + "|");
		System.out.println(
				"Elementos do vetor = " + "|" + vetor[0] + "|" + vetor[1] + "|" + vetor[2] + "|" + vetor[3] + "|");

	}

	public static void aula57_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 57 - EXEMPLO 01");

		String original = "     abcde FGHIJ ABC abc DEFG     ";

		System.out.println("");
		System.out.println("           ORIGINAL = " + "|" + original + "|");
		System.out.println("        toLowerCase = " + "|" + original.toLowerCase() + "|");
		System.out.println("        toUpperCase = " + "|" + original.toUpperCase() + "|");
		System.out.println("               trim = " + "|" + original.trim() + "|");
		System.out.println("       substring(7) = " + "|" + original.substring(7) + "|");
		System.out.println("    substring(7,15) = " + "|" + original.substring(7, 14) + "|");
		System.out.println("   replace('a','x') = " + "|" + original.replace('a', 'x') + "|");
		System.out.println("replace(\"abc\",\"xy\") = " + "|" + original.replace("abc", "xy") + "|");
		System.out.println("      indexOf(\"bc\") = " + "|" + original.indexOf("bc") + "|");
		System.out.println("  lastIndexOf(\"bc\") = " + "|" + original.lastIndexOf("bc") + "|");

	}

	public static void aula56_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 56 - EXEMPLO 02");

		int mascara1 = 32;
		int mascara2 = 0b100000;
		int numeroDigitado = 0;

		System.out.print("Digite um numero inteiro: ");
		numeroDigitado = input.nextInt();

		System.out.println("\nMascara numero inteiro");
		if ((numeroDigitado & mascara1) != 0) {
			System.out.println("Sexto BIT é TRUE");
		} else {
			System.out.println("Sexto BIT é FALSE");
		}

		System.out.println("\nMascara numero binario");
		if ((numeroDigitado & mascara2) != 0) {
			System.out.println("Sexto BIT é TRUE");
		} else {
			System.out.println("Sexto BIT é FALSE");
		}

	}

	public static void aula56_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 56 - EXEMPLO 01");

		int n1 = 89;
		int n2 = 60;
		int n3 = (n1 & n2);
		int n4 = (n1 | n2);
		int n5 = (n1 ^ n2);

		System.out.println("\nN1 =      " + String.format("%10s", Integer.toBinaryString(n1)).replaceAll(" ", "0")
				+ " (" + n1 + ")");
		System.out.println("N2 =      " + String.format("%10s", Integer.toBinaryString(n2)).replaceAll(" ", "0") + " ("
				+ n2 + ")");
		System.out.println("N1 & N2 = " + String.format("%10s", Integer.toBinaryString(n3)).replaceAll(" ", "0") + " ("
				+ n3 + ")");

		System.out.println("\nN1 =      " + String.format("%10s", Integer.toBinaryString(n1)).replaceAll(" ", "0")
				+ " (" + n1 + ")");
		System.out.println("N2 =      " + String.format("%10s", Integer.toBinaryString(n2)).replaceAll(" ", "0") + " ("
				+ n2 + ")");
		System.out.println("N1 | N2 = " + String.format("%10s", Integer.toBinaryString(n4)).replaceAll(" ", "0") + " ("
				+ n4 + ")");

		System.out.println("\nN1 =      " + String.format("%10s", Integer.toBinaryString(n1)).replaceAll(" ", "0")
				+ " (" + n1 + ")");
		System.out.println("N2 =      " + String.format("%10s", Integer.toBinaryString(n2)).replaceAll(" ", "0") + " ("
				+ n2 + ")");
		System.out.println("N1 ^ N2 = " + String.format("%10s", Integer.toBinaryString(n5)).replaceAll(" ", "0") + " ("
				+ n5 + ")");

	}

}
