package s05.EstruturaCondicional;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input;
		input = new Scanner(System.in);

//		aula33_exemplo1(input);
//		aula33_exemplo2(input);
//		aula33_exemplo3(input);
//		aula33_exemplo4(input);

//		aula35_exercicio01(input);
//		aula35_exercicio02(input);
//		aula35_exercicio03(input);
//		aula35_exercicio04(input);
//		aula35_exercicio05(input);
//		aula35_exercicio06(input);
//		aula35_exercicio07(input);
//		aula35_exercicio08(input);

//		aula36_exemplo01(input);

//		aula37_exemplo01(input);

//		aula38_exemplo01(input);
//		aula38_exemplo02_aluno(input);

		aula39_exemplo01(input);

		input.close();

	}

	public static void aula39_exemplo01(Scanner input) {
		
		System.out.println("\n---------------------------");
		System.out.println("AULA 39 - EXEMPLO 01 - ALUNO");
		
		double price = 400.00;
		if(price < 200.00) {
			double discount = price * 0.25;
		}
		double discount = 9999.00;
		
		System.out.println(discount);
		
		
	}

	public static void aula38_exemplo02_aluno(Scanner input) {
		int tipo = 0;
		int gasolina = 0, alcool = 0, diesel = 0;

		System.out.println("\n---------------------------");
		System.out.println("AULA 38 - EXEMPLO 01 - ALUNO");
		System.out.println("Alcool    | Gasolina | Diesel   ");
		while (tipo != 4) {
			tipo = input.nextInt();
			alcool += (tipo == 1) ? 1 : 0;
			gasolina += (tipo == 2) ? 1 : 0;
			diesel += (tipo == 3) ? 1 : 0;

			System.out.printf(" %d        | %d           | %d        \n", alcool, gasolina, diesel);
		}

		System.out.println("Fim do programa");
	}

	public static void aula38_exemplo01(Scanner input) {

		double preco, descontoIf, descontoTernario;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 38 - EXEMPLO 01");

		System.out.println("Digite um preço: ");
		preco = input.nextDouble();

		if (preco < 20) {
			descontoIf = preco * 0.1;
		} else {
			descontoIf = preco * 0.05;
		}
		descontoTernario = (preco < 20) ? preco * 0.1 : preco * 0.05;

		System.out.printf("Valor do desconto (IF): %.2f\n", descontoIf);
		System.out.printf("Valor do desconto (TERNÁRIO): %.2f\n", descontoTernario);

	}

	public static void aula37_exemplo01(Scanner input) {

		int numDiaSemana;
		String diaSemana;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 37 - EXEMPLO 01");

		System.out.println("Digite um numero referente ao dia da semana: ");
		numDiaSemana = input.nextInt();

		switch (numDiaSemana) {
		case 1: {
			diaSemana = "Domingo";
			break;
		}
		case 2: {
			diaSemana = "Segunda";
			break;
		}
		case 3: {
			diaSemana = "Terça";
			break;
		}
		case 4: {
			diaSemana = "Quarta";
			break;
		}
		case 5: {
			diaSemana = "Quinta";
			break;
		}
		case 6: {
			diaSemana = "Sexta";
			break;
		}
		case 7: {
			diaSemana = "Sábado";
			break;
		}
		default: {
			diaSemana = "Valor inválido";
			break;
		}

		}

		System.out.println("Dia da semana: " + diaSemana);

	}

	public static void aula36_exemplo01(Scanner input) {

		int minutos;
		double valorPagar = 50.00;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 36 - EXEMPLO 01");

		System.out.printf("Digite a quantidade de minutos consumidos: ");
		minutos = input.nextInt();

		if (minutos > 100) {
//			valorPagar = valorPagar + (minutos - 100) * 2.00;
			valorPagar += (minutos - 100) * 2.00;
		} else {

		}

		System.out.printf("Valor a pagar: R$ %.2f\n", valorPagar);

	}

//	Em um país imaginário denominado Lisarb, todos os habitantes ficam felizes em pagar seus impostos, pois sabem
//	que nele não existem políticos corruptos e os recursos arrecadados são utilizados em benefício da população, sem
//	qualquer desvio. A moeda deste país é o Rombus, cujo símbolo é o R$.
//	Leia um valor com duas casas decimais, equivalente ao salário de uma pessoa de Lisarb. Em seguida, calcule e
//	mostre o valor que esta pessoa deve pagar de Imposto de Renda, segundo a tabela abaixo.
//	
//	Renda.................................................Imposto de Renda
//	de R$ 0.00 até R$ 2000................................Isento
//	de R$ 2000.01 a até R$ 3000.00........................8%
//	de R$ 3000.01 até R$ 4500.00..........................18%
//	acima de R$ 4500.01...................................28%
//	
//	Lembre que, se o salário for R$ 3002.00, a taxa que incide é de 8% apenas sobre R$ 1000.00, pois a faixa de
//	salário que fica de R$ 0.00 até R$ 2000.00 é isenta de Imposto de Renda. No exemplo fornecido (abaixo), a taxa é
//	de 8% sobre R$ 1000.00 + 18% sobre R$ 2.00, o que resulta em R$ 80.36 no total. O valor deve ser impresso com
//	duas casas decimais.
	public static void aula35_exercicio08(Scanner input) {

		double renda, rendaFaixa, proximaRendaFaixa, imposto;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 08");

		System.out.printf("Digite o valor da renda: ");
		renda = input.nextDouble();

		// calculo para a faixa 8%
		rendaFaixa = renda - 2000.00;
		proximaRendaFaixa = rendaFaixa - 1000.00;
		if (rendaFaixa <= 0) {
			imposto = 0;
		} else if (proximaRendaFaixa <= 0) {
			imposto = rendaFaixa * 0.08;
		} else {
			imposto = (rendaFaixa - proximaRendaFaixa) * 0.08;
		}

		// calculo para a faixa 18%
		rendaFaixa = proximaRendaFaixa;
		proximaRendaFaixa = rendaFaixa - 1500.00;
		if (rendaFaixa <= 0) {
			imposto = imposto + 0;
		} else if (proximaRendaFaixa <= 0) {
			imposto = imposto + (rendaFaixa * 0.18);
		} else {
			imposto = imposto + ((rendaFaixa - proximaRendaFaixa) * 0.18);
		}

		// calculo para a faixa 28%
		rendaFaixa = proximaRendaFaixa;
		if (rendaFaixa <= 0) {
			imposto = imposto + 0;
		} else {
			imposto = imposto + (rendaFaixa * 0.28);
		}

		System.out.printf("R$ %.2f\n", imposto);

	}

//	Leia 2 valores com uma casa decimal (x e y), que devem representar as coordenadas
//	de um ponto em um plano. A seguir, determine qual o quadrante ao qual pertence o
//	ponto, ou se está sobre um dos eixos cartesianos ou na origem (x = y = 0).
//	Se o ponto estiver na origem, escreva a mensagem “Origem”.
//	Se o ponto estiver sobre um dos eixos escreva “Eixo X” ou “Eixo Y”, conforme for a
//	situação.
	public static void aula35_exercicio07(Scanner input) {

		double x, y;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 07");

		System.out.printf("Digite as coordenadas X e Y: ");
		x = input.nextDouble();
		y = input.nextDouble();

		if (x > 0 && y > 0) {
			System.out.println("Q1");
		} else if (x < 0 && y > 0) {
			System.out.println("Q2");
		} else if (x < 0 && y < 0) {
			System.out.println("Q3");
		} else if (x > 0 && y < 0) {
			System.out.println("Q4");
		} else if (x == 0 && y != 0) {
			System.out.println("Y");
		} else if (x != 0 && y == 0) {
			System.out.println("X");
		} else {
			System.out.println("Origem");
		}

	}

//	Você deve fazer um programa que leia um valor qualquer e apresente uma mensagem dizendo em qual dos
//	seguintes intervalos ([0,25], (25,50], (50,75], (75,100]) este valor se encontra. Obviamente se o valor não 
//	estiver em nenhum destes intervalos, deverá ser impressa a mensagem “Fora de intervalo”.
	public static void aula35_exercicio06(Scanner input) {

		double valorQualquer;
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 06");

		System.out.printf("Digite um valor qualquer: ");
		valorQualquer = input.nextDouble();

		if (valorQualquer < 0 || valorQualquer > 100) {
			System.out.println("Fora de intervalo");
		} else if (valorQualquer >= 0 && valorQualquer <= 25) {
			System.out.println("Intervalo [0,25]");
		} else if (valorQualquer > 25 && valorQualquer <= 50) {
			System.out.println("Intervalo (25,50]");
		} else if (valorQualquer > 50 && valorQualquer <= 75) {
			System.out.println("Intervalo (50,75]");
		} else {
			System.out.println("Intervalo (75,100]");
		}

	}

//	aula35 -- exercicio 05
//	Com base na tabela abaixo, escreva um programa que leia o código de um item e a quantidade deste item. A
//	seguir, calcule e mostre o valor da conta a pagar.
//	
//	1 | cachorro quente | R$ 4.00
//	2 | X Salada        | R$ 4.50
//	3 | X Bacon         | R$ 5.00
//	4 | Torrada Simples | R$ 2.00
//	5 | Refrigerante    | R$ 1.50
	public static void aula35_exercicio05(Scanner input) {

		int codigoProduto, quantidadePedido;
		double valorProduto, valorConta;

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 05");

		System.out.printf("Digite o produto e quantidade desejada: ");
		codigoProduto = input.nextInt();
		quantidadePedido = input.nextInt();

		if (codigoProduto == 1) {
			valorProduto = 4.0;
		} else if (codigoProduto == 2) {
			valorProduto = 4.50;
		} else if (codigoProduto == 3) {
			valorProduto = 5.0;
		} else if (codigoProduto == 4) {
			valorProduto = 2.0;
		} else if (codigoProduto == 5) {
			valorProduto = 1.50;
		} else {
			valorProduto = 0;
		}
		valorConta = valorProduto * quantidadePedido;

		if (valorProduto != 0) {
			System.out.printf("Total: R$ %.2f\n", valorConta);
		} else {
			System.out.println("NAO E POSSIVEL CALCULAR O VALOR DO PEDIDO COM PRODUTO INEXISTENTE");
		}

	}

//	aula35 -- exercicio 04
//	Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo pode
//	começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24 horas.
	public static void aula35_exercicio04(Scanner input) {

		int horaInicial, horaFinal, duracao;

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 04");

		System.out.printf("Digite o horario de inicio e fim de jogo: ");
		horaInicial = input.nextInt();
		horaFinal = input.nextInt();

		if (horaInicial > horaFinal) {
			horaFinal += 24;
		} else if (horaInicial < horaFinal) {
			horaInicial += 24;
			horaFinal += 24;
		} else if (horaInicial == horaFinal) {
			horaFinal = 24;
			horaInicial = 0;
		}
		duracao = Math.abs(horaFinal - horaInicial);

		System.out.printf("O JOGO DUROU %d HORA(S)\n", duracao);

	}

//	aula35 -- exercicio 03
//	Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem "Sao Multiplos" ou "Nao sao
//	Multiplos", indicando se os valores lidos são múltiplos entre si. Atenção: os números devem poder ser digitados em
//	ordem crescente ou decrescente.
	public static void aula35_exercicio03(Scanner input) {

		int A, B;

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 03");

		System.out.printf("Digite dois numeros inteiros: ");
		A = input.nextInt();
		B = input.nextInt();

		if (A % B == 0 || B % A == 0) {
			System.out.println("Sao Multiplos");
		} else {
			System.out.println("Nao sao Mutiplos");
		}

	}

//	aula35 -- exercicio 02
//	Fazer um programa para ler um número inteiro e dizer se este número é par ou ímpar.
	public static void aula35_exercicio02(Scanner input) {

		int numero;

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 02");

		System.out.printf("Digite um numero inteiro: ");
		numero = input.nextInt();

		if (numero % 2.0 == 0) {
			System.out.println("PAR");
		} else {
			System.out.println("IMPAR");
		}

	}

//	aula35 -- exercicio 01
//	Fazer um programa para ler um número inteiro, e depois dizer se este número é negativo ou não
	public static void aula35_exercicio01(Scanner input) {

		int numero;

		System.out.println("\n---------------------------");
		System.out.println("AULA 35 - EXERCICÍO 01");

		System.out.printf("Digite um numero inteiro: ");
		numero = input.nextInt();

		if (numero < 0) {
			System.out.println("NEGATIVO");
		} else {
			System.out.println("NÃO NEGATIVO");
		}

	}

//	aula33 -- exemplo4
	public static void aula33_exemplo4(Scanner input) {

		int hora;

		System.out.println("\n---------------------------");
		System.out.println("AULA 33 - EXEMPLO 04");

		System.out.println("Que horas são?");
		hora = input.nextInt();

		if (hora < 12) {
			System.out.println("Bom dia");
		} else if (hora < 18) {
			System.out.println("Boa tarde");
		} else {
			System.out.println("Boa noite");
		}

	}

//	aula33 -- exemplo3
	public static void aula33_exemplo3(Scanner input) {

		int hora;

		System.out.println("\n---------------------------");
		System.out.println("AULA 33 - EXEMPLO 03");

		System.out.println("Que horas são?");
		hora = input.nextInt();

		if (hora < 12) {
			System.out.println("Bom dia");
		} else {
			System.out.println("Boa tarde");
		}
	}

//	aula33 -- exemplo2
	public static void aula33_exemplo2(Scanner input) {

		int x = 5;

		System.out.println("\n---------------------------");
		System.out.println("AULA 33 - EXEMPLO 02");
		System.out.println("Bom dia");

		if (x < 0) {
			System.out.println("Boa tarde");
		}

		System.out.println("Boa noite");
	}

//	aula33 -- exemplo1
	public static void aula33_exemplo1(Scanner input) {

		int x = 5;

		System.out.println("\n---------------------------");
		System.out.println("AULA 33 - EXEMPLO 01");
		System.out.println("Bom dia");

		if (x > 0) {
			System.out.println("Boa tarde");
		}

		System.out.println("Boa noite");
	}

}
