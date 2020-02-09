package s04EstruturaSequencial;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input;
		input = new Scanner(System.in);

//		aula22(input);
//		aula23(input);
//		aula24();
//		aula25();
//		aula26();

//		Ex01(input);
//		Ex02(input);
//		Ex03(input);
//		Ex04(input);
//		Ex05(input);
		Ex06(input);

		input.close();

	}

//	 Faça um programa para ler dois valores inteiros, e depois mostrar na
//	 tela a soma desses números com uma mensagem explicativa, conforme exemplos
	private static void Ex01(Scanner input) {

		System.out.println("\n EX01 --------------------------------------------");
		int x, y, soma;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("Entrada (X,Y): ");
		x = Integer.parseInt(input.nextLine());
		y = Integer.parseInt(input.nextLine());
		soma = x + y;

		System.out.println("SOMA = " + soma);
	}

//	Faça um programa para ler o valor do raio de um círculo e depois mostrar o valor da área deste 
//	círculo com quatro casas decimais conforme exemplos.
//	Fórmula da área: area = PI . raio2
//	Considere o valor de PI = 3.14159
	private static void Ex02(Scanner input) {

		System.out.println("\n EX02 --------------------------------------------");
		double area, raio;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("Entrada (raio): ");
		raio = Double.parseDouble(input.nextLine());
		area = 3.14159 * Math.pow(raio, 2.0);

		System.out.printf("A = %.4f\n", area);
	}

//	Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença 
//	do produto de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D).
	private static void Ex03(Scanner input) {

		System.out.println("\n EX03 --------------------------------------------");
		int a, b, c, d, diferenca;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("Entrada (A,B,C,D): ");
		a = Integer.parseInt(input.nextLine());
		b = Integer.parseInt(input.nextLine());
		c = Integer.parseInt(input.nextLine());
		d = Integer.parseInt(input.nextLine());
		diferenca = a * b - c * d;

		System.out.println("DIFERENÇA = " + diferenca);
	}

//	Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que
//	recebe por hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário 
//	do funcionário, com duas casas decimais.
	private static void Ex04(Scanner input) {

		System.out.println("\n EX04 --------------------------------------------");
		int numeroFuncionario, horasTrabalhadas;
		double valorHora, salario;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("Entrada (NUMERO DO FUNCIONARO, HORAS TRABALHADAS, VALOR HORA): ");
		numeroFuncionario = Integer.parseInt(input.nextLine());
		horasTrabalhadas = Integer.parseInt(input.nextLine());
		valorHora = Double.parseDouble(input.nextLine());
		salario = horasTrabalhadas * valorHora;

		System.out.println("NUMBER = " + numeroFuncionario);
		System.out.printf("SALARY = U$ %.2f\n", salario);
	}

//	Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, 
//	o código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o
//	valor a ser pago.
	private static void Ex05(Scanner input) {

		System.out.println("\n EX05 --------------------------------------------");
		int codigoPeca1, quantidadePeca1, codigoPeca2, quantidadePeca2;
		double valorPeca1, valorPeca2, valorTotal;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("Entrada (CODIGO PECA 1, QUANTIDADE PEÇA 1, VALOR UNITARIO PECA 1): ");
		codigoPeca1 = input.nextInt();
		quantidadePeca1 = input.nextInt();
		valorPeca1 = input.nextDouble();

		System.out.println("Entrada (CODIGO PECA 2, QUANTIDADE PEÇA 2, VALOR UNITARIO PECA 2): ");
		codigoPeca2 = input.nextInt();
		quantidadePeca2 = input.nextInt();
		valorPeca2 = input.nextDouble();

		valorTotal = quantidadePeca1 * valorPeca1 + quantidadePeca2 * valorPeca2;
		System.out.printf("VALOR A PAGAR: R$ %.2f\n", valorTotal);
	}

//	Fazer um programa que leia três valores com ponto flutuante de dupla precisão: A, B e C. Em seguida, 
//	calcule e mostre:
//	a) a área do triângulo retângulo que tem A por base e C por altura.
//	b) a área do círculo de raio C. (pi = 3.14159)
//	c) a área do trapézio que tem A e B por bases e C por altura.
//	d) a área do quadrado que tem lado B.
//	e) a área do retângulo que tem lados A e B.
	private static void Ex06(Scanner input) {

		System.out.println("\n EX06 --------------------------------------------");
		double A, B, C;
		double areaTriangulo, areaCirculo, areaTrapezeio, areaQuadrado, areaRetangulo;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("Entrada (A, B, C): ");
		A = input.nextDouble();
		B = input.nextDouble();
		C = input.nextDouble();

		areaTriangulo = A * C / 2.0;
		areaCirculo = 3.14159 * Math.pow(C, 2.0);
		areaTrapezeio = (A + B) * C / 2.0;
		areaQuadrado = Math.pow(B, 2.0);
		areaRetangulo = A * B;

		System.out.printf("TRIANGULO = %.3f\n", areaTriangulo);
		System.out.printf("CIRCULO = %.3f\n", areaCirculo);
		System.out.printf("TRAPEZIO = %.3f\n", areaTrapezeio);
		System.out.printf("QUADRADO = %.3f\n", areaQuadrado);
		System.out.printf("RETANGULO = %.3f\n", areaRetangulo);
	}

	private static void aula26() {
		double A, B, C, x, y, z, x1, x2;
		double a, b, c, d;
		Scanner input;

//		ex1 -- formulas da classe Math
		System.out.println("\n-----------------------------------");
		x = 3.0;
		y = 4.0;
		z = -5.0;
		A = Math.sqrt(x);
		B = Math.sqrt(y);
		C = Math.sqrt(25.0);
		System.out.println("Raiz quadrada de " + x + " = " + A);
		System.out.println("Raiz quadrada de " + y + " = " + B);
		System.out.println("Raiz quadrada de 25 = " + C);

		A = Math.pow(x, y);
		B = Math.pow(x, 2.0);
		C = Math.pow(5.0, 2.0);
		System.out.println(x + " elevado a " + y + " = " + A);
		System.out.println(x + " elevado ao quadrado = " + B);
		System.out.println("cinco elevado ao quadrado = " + C);

		A = Math.abs(y);
		B = Math.abs(z);
		System.out.println("Valor absoluto de " + y + " = " + A);
		System.out.println("Valor absoluto de " + z + " = " + B);

//		ex2 -- formula de bascara
		System.out.println("\n-----------------------------------");
		input = new Scanner(System.in);
		System.out.println("DIGITE A,B,C:");
		a = Double.parseDouble(input.nextLine());
		b = Double.parseDouble(input.nextLine());
		c = Double.parseDouble(input.nextLine());
		d = Math.pow(b, 2) - 4 * a * c;
		x1 = (-b + Math.sqrt(d)) / 2 * a;
		x2 = (-b - Math.sqrt(d)) / 2 * a;

		System.out.println("Delta = " + d);
		System.out.println("Bascara x1 = " + x1);
		System.out.println("Bascara x1 = " + x2);

		input.close();
	}

	private static void aula25() {
		Scanner input = new Scanner(System.in);
		String s1, s2, s3;
		int x;

//		ex1: lendo strings ate a quebra da linha
		System.out.println("\n-------------------------");
		System.out.println("Digite 3 strings:");
		s1 = input.nextLine();
		s2 = input.nextLine();
		s3 = input.nextLine();

		System.out.println("DADOS DIGITADOS");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

//		ex2: quebra de linha pendente --- da problema na leitura da string1
		System.out.println("\n-------------------------");
		System.out.println("Digite um int e 3 strings:");
		x = input.nextInt();
		s1 = input.nextLine();
		s2 = input.nextLine();
		s3 = input.nextLine();

		System.out.println("DADOS DIGITADOS");
		System.out.println(x);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

//		ex2: quebra de linha pendente --- resolve o problema jogando fora a quebra de linha apos a leitura do numero
		System.out.println("\n-------------------------");
		System.out.println("Digite um int e 3 strings:");
		x = input.nextInt();
		input.nextLine();
//		x = Integer.parseInt( input.nextLine() );   ---- ou .... ler tudo sempre como string e converter para int com a class Integer
		s1 = input.nextLine();
		s2 = input.nextLine();
		s3 = input.nextLine();

		System.out.println("DADOS DIGITADOS");
		System.out.println(x);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		input.close();
	}

	private static void aula24() {
		String x;
		int xx;
		double xxx;
		char xxxx;
		Locale ptBrLocale = new Locale("pt", "BR"); // restaurando a localizacao brasil pra formatar os numeros
													// corretamente na tela
		Scanner input = new Scanner(System.in);

		// INPUT CORRETO: you 2 4,5 4.5 FUCK YOU 2 3,16
		// INPUT ERRADO: you 2 4,5 4,5 FUCK YOU 2 3,16

		// exercicio 1 -- lendo strings (ignora a partir do momento que colocar espaco)
		Locale.setDefault(ptBrLocale);
		input.reset();
		System.out.println("\n------------------------------");
		System.out.printf("DIGITE: ");
		x = input.next();
		System.out.println("Voce digitou (string): " + x);

		// exercicio 2 -- lendo numero inteiros
		Locale.setDefault(ptBrLocale);
		input.reset();
		System.out.println("\n------------------------------");
		xx = input.nextInt();
		System.out.println("Voce digitou (int): " + xx);

		// exercicio 3 -- lendo numeros flutuantes com duas localidades: BR e US
		System.out.println("\n------------------------------");
		xxx = input.nextDouble();
		System.out.printf("Voce digitou (double BR): %.2f%n", xxx);
		Locale.setDefault(Locale.US);
		input.reset();
		System.out.println("\n------------------------------");
		xxx = input.nextDouble();
		System.out.printf("Voce digitou (double US): %.2f%n", xxx);

		// exercicio 4 -- lendo numeros um caractere
		Locale.setDefault(ptBrLocale);
		input.reset();
		System.out.println("\n------------------------------");
		xxxx = input.next().charAt(0);
		System.out.printf("Voce digitou (char): %c%n", xxxx);

		// exercicio 5 -- lendo varios dados (ja e o padrao deste programa, mas so pra
		// ter o exemplo do professor registrado aqui
		Locale.setDefault(ptBrLocale);
		input.reset();
		System.out.println("\n------------------------------");
		x = input.next();
		xx = input.nextInt();
		xxx = input.nextDouble();
		System.out.printf("Voce digitou: %s | %d | %.2f", x, xx, xxx);

//		ao final do programa (tanto em caso de sucesso quanto no erro) devemos encerrar o recurso de entrada com funcao close()
		System.out.println("\n------------------------------");
		input.close();
		System.out.println("FIM DO PROGRAMA");
	}

	private static void aula23(Scanner input) {
		// processamento de dados
		System.out.println("\n------------------------------");
		int x, y;
		x = 5;
		y = 2 * x;
		System.out.println(x);
		System.out.println(y);

		// processamento de dados (y agora e double -- entao virou yy)
		System.out.println("\n------------------------------");
		double yy;
		yy = 2 * x;
		System.out.println(x);
		System.out.println(yy);

		// exemplo 3 -- com double coloca .0 (frescuraaaaaaaaa)
		System.out.println("\n------------------------------");
		double b, B, h, area;
		b = 6.0;
		B = 8.0;
		h = 5.0;
		area = (b + B) / 2 * h;
		System.out.println("Area = " + area);

		// exemplo 3 -- com float coloca .f (frescuraaaaaaaaaa)
		System.out.println("\n------------------------------");
		float bb, BB, hh, area2;
		bb = 6f;
		BB = 8f;
		hh = 5f;
		area2 = (bb + BB) / 2f * hh;
		System.out.println("Area2 = " + area2);

		// exemplo 4
		System.out.println("\n------------------------------");
		int a, bbb;
		double resultado;
		a = 5;
		bbb = 2;
		resultado = a / bbb;
		System.out.println("RESULTADO = " + resultado);
		resultado = (double) a / bbb;
		System.out.println("RESULTADO com casting double = " + resultado);

		// exemplo 5
		System.out.println("\n------------------------------");
		double aa;
		aa = 5.123;
//				bbb = aa;     errado, pois bbb esta tentando receber um double sendo que ele e int.... tem que aplicar casting neste caso (com perda de informacao no caso)
		bbb = (int) aa;
		System.out.println("bbb = " + bbb);
	}

	private static void aula22(Scanner input) {

		System.out.println("\n------------------------------");
		// saida SEM e COM quebra de linha
		System.out.println("Ola Mundo!");
		System.out.print("Bom dia!");
		System.out.println("Bom dia!");

		// imprimindo variaveis (int)
		System.out.println("\n------------------------------");
		int y = 32;
		System.out.println(y);

		// imprimindo variaveis (double) -- arredonda no final
		System.out.println("\n------------------------------");
		double x = 10.35784;
		System.out.println("Brasil Locale");
		System.out.println(x);
		System.out.printf(" | %.4f%n", x);
		System.out.println("Fim BR");
		Locale.setDefault(Locale.US);
		System.out.println(Locale.US);
		System.out.println(x);
		System.out.printf(" | %.4f%n", x);
		System.out.println("Fim" + " " + Locale.US + "");

		// concatenando na saida
		System.out.println("\n------------------------------");
		double metros = 1.6812837;
		System.out.println("DANIEL TEM " + metros + "M DE ALTURA!");
		System.out.printf("DANIEL TEM %.2fM DE ALTURA!%n", metros);

		// concatenando na saida com diversos tipos primitivos
		System.out.println("\n------------------------------");
		String nome = "Maria";
		int idadeMaria = 35;
		double salario = 4095.74812321;
		System.out.printf("%s tem %d anos e tem uma renda de R$ %.2f%n", nome, idadeMaria, salario);

//	**********************
//	exercicio de fixacao
//	**********************
		System.out.println("\n------------------------------");
		System.out.println("EXERCICIOS DE FIXACAO DA SECAO");
		System.out.println("------------------------------\n");
		String product1 = "Computer";
		String product2 = "Office Desk";
		int age = 30;
		int code = 5960;
		char gender = 'F';
		double price1 = 2100.0;
		double price2 = 650.0;
		double measure = 53.234567;
		Locale ptBrLocale = new Locale("pt", "BR"); // restaurando a localizacao brasil pra formatar os numeros
													// corretamente na tela
		Locale.setDefault(ptBrLocale);

		System.out.printf("%nProducts:%n%s, which price is %.2f%n%s, which price is %.2f%n", product1, price1, product2,
				price2);

		System.out.printf("%nRecord: %d years old, code %d and gender: %c%n", age, code, gender);

		System.out.printf("%nMeasure with eight decimal places: %.8f%nRounded (three decimal places): %.3f%n", measure,
				measure);

		Locale.setDefault(Locale.US);
		System.out.printf("Measure with eight decimal places: %.3f%n", measure);
	}

}
