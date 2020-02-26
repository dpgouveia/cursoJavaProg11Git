package s09.ConstrutoresSobrecargaEncapsulamento.Application;

import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s09.ConstrutoresSobrecargaEncapsulamento.Entidades.ContaBancaria;
import s09.ConstrutoresSobrecargaEncapsulamento.Entidades.Product;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

//		aula74_exemplo01(input);
//		aula74_exemplo02(input);
//		aula74_exemplo03(input);

//		aula76_exemplo01(input);

//		aula77_exemplo01(input);
//		aula77_exemplo02(input);
//		aula77_exemplo02(input);
//		aula77_exemplo03(input);

		aula80_exercicio01(input);

		input.close();
	}

	public static void aula80_exercicio01(Scanner input) {

		System.out.println("\n---------------------------");
		System.out.println("AULA 80 - EXERCICÍO 01");
		System.out.println("---------------------------\n");

		ContaBancaria contaBancaria;
		System.out.printf("Digite o NUMERO DA CONTA: ");
		int numeroConta = MyUtils.readInt(input);
		System.out.printf("Digite o NOME DO PROPRIETÁRIO DA CONTA: ");
		String name = MyUtils.readString(input);

		System.out.printf("Deseja depositar um valor inicial na conta (y/n)? ");
		String depositoInicial = MyUtils.readChar(input, "^y|^Y|^n|^N");
		if (depositoInicial.toLowerCase().charAt(0) == 'y') {
			System.out.printf("Digite o valor a ser depositado na conta: ");
			double deposito = MyUtils.readDouble(input);
			contaBancaria = new ContaBancaria(name, numeroConta, deposito);
		} else {
			contaBancaria = new ContaBancaria(name, numeroConta);
		}

		System.out.println("");
		System.out.println("Dados da conta");
		System.out.println(contaBancaria);

		System.out.println("");
		System.out.printf("Digite o valor a ser DEPOSITADO na sua conta: ");
		contaBancaria.depositar(MyUtils.readDouble(input));
		System.out.println("Nova posição da conta");
		System.out.println(contaBancaria);

		System.out.println("");
		System.out.printf("Digite o valor a ser SACADO da sua conta: ");
		if (contaBancaria.getSaldoConta() == contaBancaria.sacar(MyUtils.readDouble(input)).getSaldoConta()) {
			System.out.println("Não foi possível realizar o saque de sua conta por falta de saldo!!!");
			System.out.println("Dados da conta");
		} else {
			System.out.println("Nova posição da conta");
		}
		System.out.println(contaBancaria);
	}

	public static void aula77_exemplo03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 77 - EXEMPLO 03");
		System.out.println("---------------------------\n");

		System.out.println("Enter product data");
		System.out.printf("Name: ");
		String productName = input.nextLine();
		System.out.printf("Price: ");
		double productPrice = input.nextDouble();
		Product produto = new Product(productName, productPrice);

		produto.setName("Computer");
		System.out.println("Updated product name = " + produto.getName() + "\n");
		produto.setPrice(100.00);
		System.out.println("Updated product price = " + String.format("%.2f", produto.getPrice()) + "\n");

		System.out.println("Product data: " + produto + "\n");

		System.out.printf("Enter the number of products to add in stock: ");
		produto.addProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

		System.out.printf("Enter the number of products to be removed from stock: ");
		produto.removeProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

	}

	public static void aula77_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 77 - EXEMPLO 02");
		System.out.println("---------------------------\n");

		System.out.println("Enter product data");
		System.out.printf("Name: ");
		String productName = input.nextLine();
		System.out.printf("Price: ");
		double productPrice = input.nextDouble();
		Product produto = new Product(productName, productPrice);

		produto.setName("Computer");
		System.out.println("Updated product name = " + produto.getName() + "\n");
		System.out.println("Product data: " + produto + "\n");

		System.out.printf("Enter the number of products to add in stock: ");
		produto.addProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

		System.out.printf("Enter the number of products to be removed from stock: ");
		produto.removeProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

	}

	public static void aula77_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 77 - EXEMPLO 01");
		System.out.println("---------------------------\n");

		System.out.println("Enter product data");
		System.out.printf("Name: ");
		String productName = input.nextLine();
		System.out.printf("Price: ");
		double productPrice = input.nextDouble();
		Product produto = new Product(productName, productPrice);

		produto.setName("Computer");
		System.out.println("Product data: " + produto + "\n");

		System.out.printf("Enter the number of products to add in stock: ");
		produto.addProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

		System.out.printf("Enter the number of products to be removed from stock: ");
		produto.removeProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

	}

	public static void aula76_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 76 - EXEMPLO 01");
		System.out.println("---------------------------\n");

		System.out.println("Enter product data");
		System.out.printf("Name: ");
		String productName = input.nextLine();
		System.out.printf("Price: ");
		double productPrice = input.nextDouble();
		Product produto = new Product(productName, productPrice);

		System.out.println("Product data: " + produto + "\n");

		System.out.printf("Enter the number of products to add in stock: ");
		produto.addProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

		System.out.printf("Enter the number of products to be removed from stock: ");
		produto.removeProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

	}

	public static void aula74_exemplo03(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 74 - EXEMPLO 03");
		System.out.println("---------------------------\n");

		System.out.println("Enter product data");
		System.out.printf("Name: ");
		String productName = input.nextLine();
		System.out.printf("Price: ");
		double productPrice = input.nextDouble();
		System.out.printf("Quantity: ");
		int productQuantity = input.nextInt();
		Product produto = new Product(productName, productPrice, productQuantity);

		System.out.println("Product data: " + produto + "\n");

		System.out.printf("Enter the number of products to add in stock: ");
		produto.addProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

		System.out.printf("Enter the number of products to be removed from stock: ");
		produto.removeProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

	}

	public static void aula74_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 74 - EXEMPLO 02");
		System.out.println("---------------------------\n");

		Product produto = new Product();
		System.out.println("Product data: " + produto + "\n");

	}

	public static void aula74_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n---------------------------");
		System.out.println("AULA 74 - EXEMPLO 01");
		System.out.println("---------------------------\n");

		System.out.println("Enter product data:");
		Product produto = new Product();

		System.out.printf("Name: ");
		produto.setName(input.nextLine());
		System.out.printf("Price: ");
		produto.setPrice(input.nextDouble());

		System.out.println("Product data: " + produto + "\n");

		System.out.printf("Enter the number of products to add in stock: ");
		produto.addProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

		System.out.printf("Enter the number of products to be removed from stock: ");
		produto.removeProducts(input.nextInt());
		System.out.println("Updated data: " + produto + "\n");

	}

}
