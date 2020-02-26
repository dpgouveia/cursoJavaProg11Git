package s06.EstruturaRepetitiva;

import java.lang.annotation.Repeatable;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input;
		input = new Scanner(System.in);

//		aula42_exemplo01(input);

//		aula43_exemplo01(input);

//		aula45_exercicio01(input);
//		aula45_exercicio02(input);
//		aula45_exercicio03(input);
//		aula45_exercicio04(input);
//		aula45_exercicio05(input);
//		aula45_exercicio06(input);

//		aula47_exercicio01(input);
//		aula47_exercicio02(input);
//		aula47_exercicio03(input);

//		aula48_exemplo01(input);
//		aula48_exemplo02(input);
//		aula48_exemplo03(input);

//		aula50_exercicio01(input);
//		aula50_exercicio02(input);
//		aula50_exercicio03(input);
//		aula50_exercicio04(input);
//		aula50_exercicio05(input);
//		aula50_exercicio06(input);

//		aula52_exercicio01(input);
//		aula52_exercicio02(input);
//		aula52_exercicio03(input);
//		aula52_exercicio04(input);
//		aula52_exercicio05(input);
//		aula52_exercicio06(input);
//		aula52_exercicio07(input);

		aula53_exemplo01(input);

		input.close();

	}

	private static void aula53_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 53 - EXEMPLO 01 --- TRATAMENTO TOTAL DAS ENTRADAS");

		String celsiusString;
		String repetirPrograma;
		do {
			
			do {
				System.out.printf("Digite a temperatura em Celsius): ");
				celsiusString = input.nextLine();
			} while (celsiusString.isEmpty() || (!celsiusString.matches("[0-9]+") && !celsiusString.matches("[0-9]+.[0-9]+") && !celsiusString.matches("[0-9]+.") && !celsiusString.matches(".[0-9]+")));

			System.out.printf("Equivalente em Fahrenheit: %.1f\n", 9.0 * Double.parseDouble(celsiusString) / 5.0 + 32.0);

			do {
				System.out.printf("Deseja repetir (s/n): ");
				repetirPrograma = input.nextLine();
			} while (repetirPrograma.isEmpty() || (repetirPrograma.toLowerCase().charAt(0) != 's' && repetirPrograma.toLowerCase().charAt(0) != 'n'));
		} while (repetirPrograma.toLowerCase().charAt(0) == 's');

	}

//	Fazer um programa para ler um número inteiro positivo N. O programa deve então mostrar na tela N linhas,
//	começando de 1 até N. Para cada linha, mostrar o número da linha, depois o quadrado e o cubo do valor, conforme
//	exemplo.
	private static void aula52_exercicio07(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 07");

		System.out.println("Quantos linhas deseja visualizar: ");
		int quantidadeLinhas = input.nextInt();

		if (quantidadeLinhas <= 0) {
			System.out.println("Número de linhas deve ser maior que zero.");
		} else {
			for (int i = 1; i <= quantidadeLinhas; i++) {
				System.out.printf("%.0f %.0f %.0f\n", Math.pow(i, 1), Math.pow(i, 2), Math.pow(i, 3));
			}
		}

	}

//	Ler um número inteiro N e calcular todos os seus divisores.
	private static void aula52_exercicio06(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 06");

		System.out.println("Digite um número inteiro: ");
		int numeroDigitado = input.nextInt();

		if (numeroDigitado == 0) {
			System.out.println("O número zero é divisível por todos os números inteiros!");
		} else {
			int numeroDigitadoAbsoluto = Math.abs(numeroDigitado);
			System.out.println("O número " + numeroDigitadoAbsoluto + " é divisível por: ");
			for (int i = 1; i <= numeroDigitadoAbsoluto; i++) {
				if (numeroDigitadoAbsoluto % i == 0) {
					System.out.println(i);
					System.out.println(i * -1);
				}
			}
		}

	}

//	Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial de N = N * (N-1) * (N-2) * (N-3) * ... * 1.
//	Lembrando que, por definição, fatorial de 0 é 1.
	private static void aula52_exercicio05(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 05");

		System.out.printf("Qual número fatorial deseja saber: ");
		int fatorial = input.nextInt();
		int fatorialTotal;

		if (fatorial < 0) {
			System.out.println("Impossível calcular fatorial de números negativos");
		} else if (fatorial == 0) {
			System.out.println(1);
		} else {
			fatorialTotal = fatorial;
			for (int i = 1; i < fatorial; i++) {
				fatorialTotal *= fatorial - i;
			}
			System.out.println(fatorialTotal);
		}

	}

//	Fazer um programa para ler um número N. Depois leia N pares de números e mostre a divisão do primeiro pelo
//	segundo. Se o denominador for igual a zero, mostrar a mensagem "divisao impossivel".
	private static void aula52_exercicio04(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 04");

		System.out.printf("Quantos pares de número deseja digitar: ");
		int quantidadeParesDigitados = input.nextInt();

		String saida = "";
		for (int i = 1; i <= quantidadeParesDigitados; i++) {
			System.out.printf("Digite um par de números inteiros: ");
			int numero1 = input.nextInt();
			int numero2 = input.nextInt();
			if (numero2 == 0) {
				saida += "Divisão Impossível\n";
			} else {
				saida += (numero1 * 1.0 / numero2 * 1.0) + "\n";
			}
		}
		System.out.println(saida);

	}

//	Leia 1 valor inteiro N, que representa o número de casos de teste que vem a seguir. Cada caso de teste consiste
//	de 3 valores reais, cada um deles com uma casa decimal. Apresente a média ponderada para cada um destes
//	conjuntos de 3 valores, sendo que o primeiro valor tem peso 2, o segundo valor tem peso 3 e o terceiro valor tem
//	peso 5.
	private static void aula52_exercicio03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 03");

		int numeroCasos;
		double mediaPonderada = 0;
		System.out.print("Quantos casos de teste deseja digitar: ");
		numeroCasos = input.nextInt();

		for (int i = 1; i <= numeroCasos; i++) {
			double valorPeso1, valorPeso2, valorPeso3;
			System.out.printf("Digite 3 valores decimais: ");
			valorPeso1 = input.nextDouble();
			valorPeso2 = input.nextDouble();
			valorPeso3 = input.nextDouble();
			mediaPonderada = (valorPeso1 * 2.0 + valorPeso2 * 3.0 + valorPeso3 * 5.0) / 10;
			System.out.printf("Média ponderada do caso de teste %d: %.1f\n", i, mediaPonderada);
		}

	}

//	Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X que serão lidos em seguida.
//	Mostre quantos destes valores X estão dentro do intervalo [10,20] e quantos estão fora do intervalo, mostrando
//	essas informações conforme exemplo (use a palavra "in" para dentro do intervalo, e "out" para fora do intervalo).
	private static void aula52_exercicio02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 02");

		int quantidadeNumerosDigitados, numeroDigitado, dentroIntervalo = 0, foraIntervalo = 0;
		System.out.print("Quantos números inteiros deseja digitar: ");
		quantidadeNumerosDigitados = input.nextInt();

		for (int i = 1; i <= quantidadeNumerosDigitados; i++) {
			System.out.printf("Digite um número inteiro: ");
			numeroDigitado = input.nextInt();

			if (numeroDigitado >= 10 && numeroDigitado <= 20) {
				dentroIntervalo++;
			} else {
				foraIntervalo++;
			}

		}
		System.out.println(dentroIntervalo + " in");
		System.out.println(foraIntervalo + " out");
	}

//	Leia um valor inteiro X (1 <= X <= 1000). Em seguida mostre os ímpares de 1 até X, um valor por linha, inclusive o
//	X, se for o caso.
	private static void aula52_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 52 - EXERCICIO 01");

		int numeroDigitado;

		System.out.print("Digite um número inteiro: ");
		numeroDigitado = input.nextInt();

		if (numeroDigitado >= 1 && numeroDigitado <= 1000) {
			System.out.println("Numeros ímpares de 1 até " + numeroDigitado + " são: ");
			for (int i = 1; i <= numeroDigitado; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
				}
			}
		} else {
			System.out.println("Número digitado é inválido para este programa");
		}

	}

	private static void aula50_exercicio06(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 50 - EXERCICIO 06");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 8;
		int y = 3;
		int i;
		for (i = 0; y < x; i++) {
			x = x - 2;
			y = y + 1;
			System.out.println(i);
		}

	}

	private static void aula50_exercicio05(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 50 - EXERCICIO 05");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 4;
		int y = 0;
		int i;
		for (i = 0; i < x; i++) {
			y = y + i;
		}
		System.out.println(y);

	}

	private static void aula50_exercicio04(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 50 - EXERCICIO 04");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 4;
		int y = 0;
		int i;
		for (i = 0; i < x; i++) {
			System.out.print(i);
			System.out.println(x);
			y = y + 10;
		}

	}

	private static void aula50_exercicio03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 50 - EXERCICIO 03");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int y = 10;
		int i;
		for (i = 0; i < 4; i++) {
			System.out.print(i);
			y = y + i;
			System.out.println(y);
		}

	}

	private static void aula50_exercicio02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 50 - EXERCICIO 02");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int i;
		for (i = 1; i < 5; i++) {
			int y = i - 1;
			int x = i * 10;
			System.out.print(i);
		}

	}

	private static void aula50_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 50 - EXERCICIO 01");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 4;
		int y = x + 2;
		int i;
		for (i = 0; i < x; i++) {
			System.out.printf(x + " " + y);
			y = y + i;
		}

	}

	private static void aula48_exemplo03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 48 - EXEMPLO 03");

		for (int i = 4; i >= 0; i--) {
			System.out.println("Valor de i: " + i);

		}

	}

	private static void aula48_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 48 - EXEMPLO 02");

		for (int i = 0; i < 5; i++) {
			System.out.println("Valor de i: " + i);

		}

	}

	private static void aula48_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 48 - EXEMPLO 01");

		int quantidadeEntradas, somaTotalEntradas = 0;

		System.out.printf("Digite a quantidade de entradas: ");
		quantidadeEntradas = input.nextInt();

		for (int i = 0; i < quantidadeEntradas; i++) {
			System.out.printf("Digite um número inteiro: ");
			somaTotalEntradas += input.nextInt();
		}
		System.out.println("Soma total dos números digitados: " + somaTotalEntradas);

	}

//	Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva
//	um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina 3.Diesel
//	4.Fim). Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até
//	que seja válido). O programa será encerrado quando o código informado for o número 4. Deve ser escrito a
//	mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de combustível, conforme
//	exemplo.
	private static void aula47_exercicio03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 47 - EXERCICIO 03");

		int codigoCombustivel, qtdClientesAlcool = 0, qtdClientesGasolina = 0, qtdClientesDiesel = 0;

		System.out.println("1. Álcool | 2. Gasolina | 3. Diesel | 4. Fim");
		System.out.println("Digite o tipo de combustível para abastercer: ");
		codigoCombustivel = input.nextInt();
		while (codigoCombustivel != 4) {

			if (codigoCombustivel == 1) {
				qtdClientesAlcool += 1;
			} else if (codigoCombustivel == 2) {
				qtdClientesGasolina += 1;
			} else if (codigoCombustivel == 3) {
				qtdClientesDiesel += 1;
			}
			System.out.println("Digite o tipo de combustível para abastercer: ");
			codigoCombustivel = input.nextInt();
		}
		System.out.println("MUITO OBRIGADO");
		System.out.printf("ÁLCOOL: %d\n", qtdClientesAlcool);
		System.out.printf("GASOLINA: %d\n", qtdClientesGasolina);
		System.out.printf("DIESEL: %d\n", qtdClientesDiesel);

	}

//	Escreva um programa para ler as coordenadas (X,Y) de uma quantidade indeterminada de pontos no sistema
//	cartesiano. Para cada ponto escrever o quadrante a que ele pertence. O algoritmo será encerrado quando pelo
//	menos uma de duas coordenadas for NULA (nesta situação sem escrever mensagem alguma).
	private static void aula47_exercicio02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 47 - EXERCICIO 02");

		int x, y;

		System.out.printf("Digite as coordenadas X e Y: ");
		x = input.nextInt();
		y = input.nextInt();
		while (x != 0 && y != 0) {
			if (x > 0 && y > 0) {
				System.out.println("primeiro");
			} else if (x < 0 && y > 0) {
				System.out.println("segundo");
			} else if (x < 0 && y < 0) {
				System.out.println("terceiro");
			} else if (x > 0 && y < 0) {
				System.out.println("quarto");
			}
			System.out.printf("Digite as coordenadas X e Y: ");
			x = input.nextInt();
			y = input.nextInt();

		}

	}

//	Escreva um programa que repita a leitura de uma senha até que ela seja válida. Para cada leitura de senha
//	incorreta informada, escrever a mensagem "Senha Invalida". Quando a senha for informada corretamente deve ser
//	impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que a senha correta é o valor 2002.
	private static void aula47_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 47 - EXERCICIO 01");

		int senha = 0;

		System.out.printf("Digite a senha (somente 4 digitos numéricos): ");
		senha = input.nextInt();
		while (senha != 2002) {
			System.out.println("Senha Invalida");
			System.out.printf("Digite a senha (somente 4 digitos numéricos): ");
			senha = input.nextInt();
		}
		System.out.println("Acesso Permitido");

	}

	private static void aula45_exercicio06(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 45 - EXERCICIO 06");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 4;
		int y = 0;
		int i = 0;

		while (i < x) {
			i = i + 1;
			y = y + i;
			System.out.print(i);
			System.out.println(y);
		}

	}

	private static void aula45_exercicio05(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 45 - EXERCICIO 05");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 2;
		int y = 10;

		System.out.println("Ola");
		while (x < y) {
			System.out.println(x + " - " + y);
			x = x * 2;
			y = y + 1;
		}

	}

	private static void aula45_exercicio04(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 45 - EXERCICIO 04");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 0;
		int y;

		while (x < 5) {
			y = x * 3;
			System.out.println(y);
			x = x + 1;
		}
		System.out.println("Fim");

	}

	private static void aula45_exercicio03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 45 - EXERCICIO 03");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		double x = 100.00;
		int y = 100;

		while (x != y) {
			System.out.println("Olha");
			x = Math.sqrt(y);
		}

	}

	private static void aula45_exercicio02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 45 - EXERCICIO 02");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 2;
		int y = 0;

		while (x < 60) {
			System.out.println(x);
			x = x * 2;
			y = y + 10;
		}

	}

	private static void aula45_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 45 - EXERCICIO 01");
		System.out.println("EXECUTAR EM MODO DEBUG -- APLICAR BREAKPOINT AQUI");

		int x = 5;
		int y = 0;

		while (x > 2) {
			System.out.println(x);
			y = y + x;
			x = x - 1;
		}

	}

	private static void aula43_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 43 - EXEMPLO 01");

		int numero = 1, somaNumero = 0;

		while (numero != 0) {
			System.out.printf("Digite um numero qualquer (zero para finalizar): ");
			numero = input.nextInt();
			somaNumero += numero;
		}

		System.out.println(somaNumero);

	}

	private static void aula42_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 42 - EXEMPLO 01");

		System.out.println("Digite a LARGURA, COMPRIMENTO e METRO QUADRADO: ");

		double largura = input.nextDouble();
		double comprimento = input.nextDouble();
		double metroQuadrado = input.nextDouble();

		double area = largura * comprimento;
		double preco = area * metroQuadrado;

		System.out.printf("AREA = %.2f\n", area);
		System.out.printf("PRECO = %.2f\n", preco);

	}

}
