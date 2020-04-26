package s08.IntroducaoOO.Application;

import java.util.Locale;
import java.util.Scanner;

import s08.IntroducaoOO.Entidades.Aluno;
import s08.IntroducaoOO.Entidades.Calculator;
import s08.IntroducaoOO.Entidades.Circulo;
import s08.IntroducaoOO.Entidades.CurrencyConverter;
import s08.IntroducaoOO.Entidades.Funcionario;
import s08.IntroducaoOO.Entidades.Product;
import s08.IntroducaoOO.Entidades.Retangulo;
import s08.IntroducaoOO.Entidades.Triangulo;

public class Program {

	private static final double PI = 3.14159;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

//		aula64_exemplo01(input);
//
//		aula65_exemplo01(input);
//
//		aula66_exemplo01(input);
//
//		aula67_exemplo01(input);
//
//		aula68_exercicio01(input);
//		aula68_exercicio02(input);
//		aula68_exercicio03(input);
//		
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
	
	public static void aula68_exercicio03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 68 - EXERCICIO 03\n");

		Aluno novoAluno = new Aluno();
		System.out.println("Digite os dados do aluno a seguir: ");
		System.out.printf("Nome do aluno: ");
		novoAluno.setNomeAluno(input.nextLine());
		System.out.printf("Nota do primeiro trimestre: ");
		novoAluno.setNotaTrimestre1(input.nextDouble());
		System.out.printf("Nota do segundo trimestre: ");
		novoAluno.setNotaTrimestre2(input.nextDouble());
		System.out.printf("Nota do terceiro trimestre: ");
		novoAluno.setNotaTrimestre3(input.nextDouble());

		System.out.println(novoAluno);

	}

	public static void aula68_exercicio02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 68 - EXERCICIO 02\n");

		Funcionario novoFuncionario = new Funcionario();
		System.out.println("Digite os dados do funcionário a seguir: ");
		System.out.printf("Nome: ");
		novoFuncionario.setNomeFuncionario(input.nextLine());
		System.out.printf("Salário Bruto: ");
		novoFuncionario.setSalarioBruto(input.nextDouble());
		System.out.printf("Impostos: ");
		novoFuncionario.setImpostos(input.nextDouble());

		System.out.println("\nFuncionário: " + novoFuncionario);

		System.out.printf("\nQual o percentual de aumento de salário para o funcionário? ");
		novoFuncionario.aumentarSalario(input.nextDouble() / 100);
		System.out.println("Dados do funcionário atualizados com sucesso: " + novoFuncionario);

	}

	public static void aula68_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 68 - EXERCICIO 01\n");

		System.out.printf("Digite a ALTURA e LARGURA do retângulo: ");
		Retangulo novoRetangulo = new Retangulo();
		novoRetangulo.setAltura(input.nextDouble());
		novoRetangulo.setLargura(input.nextDouble());

		System.out.println("AREA = " + novoRetangulo.area());
		System.out.println("PERÍMETRO = " + novoRetangulo.perimetro());
		System.out.println("DIAGONAL = " + novoRetangulo.diagonal());

	}

	public static void aula67_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 67 - EXEMPLO 01\n");

		Product novoProduto = new Product();
		System.out.println("Enter product data: ");
		System.out.printf("    name: ");
		novoProduto.name = input.nextLine();
		System.out.printf("   price: ");
		novoProduto.price = input.nextDouble();
		System.out.printf("quantity: ");
		novoProduto.quantity = input.nextInt();

		System.out.println("\nProduct data: " + novoProduto);

		System.out.printf("Enter the number of products to be added in stock: ");
		novoProduto.addProducts(input.nextInt());
		System.out.println("Updated product: " + novoProduto);

		System.out.printf("Enter the number of products to be removed from stock: ");
		novoProduto.removeProducts(input.nextInt());
		System.out.println("Updated product: " + novoProduto);

	}

	public static void aula66_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 66 - EXEMPLO 01\n");

		Product novoProduto = new Product();
		System.out.println("Enter product data: ");
		System.out.printf("    name: ");
		novoProduto.name = input.nextLine();
		System.out.printf("   price: ");
		novoProduto.price = input.nextDouble();
		System.out.printf("quantity: ");
		novoProduto.quantity = input.nextInt();

		System.out.println(novoProduto);

	}

	public static void aula65_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 65 - EXEMPLO 01\n");

		Product novoProduto = new Product();
		System.out.println("Enter product data: ");
		System.out.printf("    name: ");
		novoProduto.name = input.nextLine();
		System.out.printf("   price: ");
		novoProduto.price = input.nextDouble();
		System.out.printf("quantity: ");
		novoProduto.quantity = input.nextInt();

		System.out.println(novoProduto.name + ", " + novoProduto.price + ", " + novoProduto.quantity);

	}

	public static void aula64_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 64 - EXEMPLO 01");

		Triangulo x = new Triangulo();
		System.out.printf("Digite os valores de A,B e C do triângulo X: ");
		x.a = input.nextDouble();
		x.b = input.nextDouble();
		x.c = input.nextDouble();

		Triangulo y = new Triangulo();
		System.out.printf("Digite os valores de A,B e C do triângulo X: ");
		y.a = input.nextDouble();
		y.b = input.nextDouble();
		y.c = input.nextDouble();

		System.out.printf("Área do triângulo X = %.4f\n", x.calcularArea());
		System.out.printf("Área do triângulo Y = %.4f\n", y.calcularArea());

		System.out.print("Triângulo com maior é: ");
		if (x.calcularArea() >= y.calcularArea()) {
			System.out.printf("X");
		} else {
			System.out.printf("Y");
		}

	}

}
