package s14HerancaPolimorfismo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import myUtils.MyUtils;
import s14Entidades.Account;
import s14Entidades.BusinessAcount;
import s14Entidades.Funcionario;
import s14Entidades.FuncionarioTercerizado;
import s14Entidades.Produto;
import s14Entidades.ProdutoImportado;
import s14Entidades.ProdutoUsado;
import s14Entidades.SavingsAccount;

public class Program {

	public static void main(String args[]) throws ParseException {

		Scanner input = new Scanner(System.in);

//		aula121_exemplo01(input);

//		aula122_exemplo01(input);

//		aula123_exemplo01(input);

//		aula124_exemplo01(input);

//		aula125_exemplo01(input);

//		aula126_exercicio01(input);

		aula127_exercicio01(input);

		input.close();
	}

	public static void aula127_exercicio01(Scanner input) throws ParseException {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 127 - EXERCÍCIO 01");
		System.out.println("-------------------------\n");

//		Codigo de teste antes de iniciar a codificacao do exercicio
//		Produto prod1 = new Produto("Impressora BrazuCanion", 699.00);
//		System.out.println(prod1);
//		
//		Produto prod2 = new ProdutoImportado("Impressora Chenox", 299.00, 69.00);
//		System.out.println(prod2);
//		
//		Produto prod3 = new ProdutoUsado("Impressora Agape", 499.00, ProdutoUsado.sdf.parse("16/02/2018"));
//		System.out.println(prod3);

		System.out.println("-----------------------------------------------------");
		Integer quantidadeProdutos;
		do {
			System.out.print("Digite a quantidade de produtos a serem cadastrados: ");
			quantidadeProdutos = MyUtils.readInteger(input);
			if (quantidadeProdutos <= 0) {
				System.out.println("Quantidade de produtos deve ser MAIOR QUE ZERO!!!");
			}
		} while (quantidadeProdutos <= 0);
		List<Produto> listaProdutos = new ArrayList<Produto>();

		for (int i = 1; i <= quantidadeProdutos; i++) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("Tipo de produto a ser cadastrado: ");
			System.out.println("1) Novo Nacional");
			System.out.println("2) Importado");
			System.out.println("3) Usado");
			System.out.print("Escolha o tipo de produto a ser cadastrado: ");
			Integer tipoProduto;
			do {
				tipoProduto = MyUtils.readInteger(input);
			} while (tipoProduto != 1 && tipoProduto != 2 && tipoProduto != 3);

			System.out.println();
			System.out.print("Nome: ");
			String nome = MyUtils.readString(input);
			System.out.print("Preço: ");
			Double preco;
			do {
				preco = MyUtils.readDouble(input);
			} while (preco <= 0);

			if (tipoProduto == 1) {
				listaProdutos.add(new Produto(nome, preco));
			} else if (tipoProduto == 2) {
				System.out.print("Taxa de Alfandega: ");
				Double taxaAlfandega;
				do {
					taxaAlfandega = MyUtils.readDouble(input);
				} while (taxaAlfandega < 0);
				listaProdutos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
			} else {
				System.out.print("Data de fabricação: ");
				Date dataFabricacao = ProdutoUsado.sdf.parse(MyUtils.readString(input));
				listaProdutos.add(new ProdutoUsado(nome, preco, dataFabricacao));
			}
		}

		StringBuffer sb = new StringBuffer();
		for (Produto prod : listaProdutos) {
			sb.append(prod.toString());
		}
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("Lista de produtos cadastrados: ");
		System.out.println(sb.toString());

	}

	public static void aula126_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 126 - EXERCÍCIO 01");
		System.out.println("-------------------------\n");

//		Testando metodos antes de comecar a codificar o exercicio de fato
//		Funcionario func1 = new Funcionario("Alex", 40, 30.0);
//		System.out.println(func1);
//		System.out.println(func1.pagamento());
//
//		Funcionario func2 = new FuncionarioTercerizado("Maria", 40, 30.0, 3.0);
//		System.out.println(func2);
//		System.out.println(func2.pagamento());

		System.out.print("------------------------------");
		Integer numeroFuncionarios;
		do {
			System.out.println();
			System.out.printf("Digite quantos funcionários deseja cadastrar: ");
			numeroFuncionarios = MyUtils.readInteger(input);
			if (numeroFuncionarios <= 0) {
				System.out.println("O número de funcionários deve ser MAIOR QUE ZERO!!!");
			}
		} while (numeroFuncionarios <= 0);
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

		for (int i = 1; i <= numeroFuncionarios; i++) {

			Integer tipoFuncionario;
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("1) Funcionário");
			System.out.println("2) Terceiro");
			System.out.print("Que tipo de funcionário será cadastrado: ");
			do {
				tipoFuncionario = MyUtils.readInteger(input);
			} while (tipoFuncionario != 1 && tipoFuncionario != 2);
			System.out.println();
			System.out.println("------------------------------");
			String nome;
			Integer quantidadeHoras;
			Double valorHora;
			System.out.printf("Digite o nome do funcionário: ");
			nome = MyUtils.readString(input);
			System.out.printf("Digite a carga horário total do funcionário: ");
			do {
				quantidadeHoras = MyUtils.readInteger(input);
			} while (quantidadeHoras <= 0);
			System.out.printf("Digite o valor hora do funcionário: ");
			do {
				valorHora = MyUtils.readDouble(input);
			} while (valorHora <= 0);
			if (tipoFuncionario == 1) {
				listaFuncionarios.add(new Funcionario(nome, quantidadeHoras, valorHora));
			} else {
				System.out.printf("Digite a despesa adicional do funcionário: ");
				Double despesaAdicional;
				do {
					despesaAdicional = MyUtils.readDouble(input);
				} while (despesaAdicional < 0);
				listaFuncionarios.add(new FuncionarioTercerizado(nome, quantidadeHoras, valorHora, despesaAdicional));
			}
		}

		StringBuffer sb = new StringBuffer();
		for (Funcionario func : listaFuncionarios) {
			sb.append(func.getNome() + ": $ " + String.format("%.2f", func.pagamento()) + "\n");
		}
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("Lista de pagamento de funcionários: ");
		System.out.println(sb.toString());

	}

	public static void aula125_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 125 - EXEMPLO 01");
		System.out.println("-------------------------\n");

		Account x = new Account(1200, "Alex", 1000.00);
		Account y = new SavingsAccount(1203, "Maria", 1000.00, 0.01);

		x.withdraw(50.0);
		y.withdraw(50.0);

		System.out.println(x);
		System.out.println(y);
	}

	public static void aula124_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 124 - EXEMPLO 01");
		System.out.println("-------------------------\n");

		System.out.println(
				"Descomentar as linhas de código da classe \"SavingsAccount\" e verificar impactos via Eclipse na classe \"SavingsAccountPlus\"");

//		public final void withdraw(Double amount) {
//		public void withdraw(Double amount) {

//		public final class SavingsAccount extends Account {
//		public class SavingsAccount extends Account {

	}

	public static void aula123_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 123 - EXEMPLO 01");
		System.out.println("-------------------------\n");

		Account acc = new Account(1001, "Alex", 0.00);
		System.out.println(acc);
		acc.deposit(100.00);
		System.out.println(acc);
		acc.withdraw(15.0);
		System.out.println(acc);

		System.out.println();
		SavingsAccount sacc = new SavingsAccount(1002, "Maria", 100.0, 0.1);
		System.out.println(sacc);
		sacc.withdraw(15.0);
		System.out.println(sacc);
		sacc.updateBalance();
		System.out.println(sacc);

		System.out.println();
		BusinessAcount bacc = new BusinessAcount(1003, "Bob", 0.0, 500.00);
		System.out.println(bacc);
		bacc.deposit(100.0);
		System.out.println(bacc);
		bacc.withdraw(15.00);
		System.out.println(bacc);
		bacc.loan(50.00);
		System.out.println(bacc);

//		Account acc1 = new Account(1001, "Alex", 1000.00);
//		acc1.withdraw(200.0);
//		System.out.println(acc1);
//
//		Account acc2 = new SavingsAccount(1002, "Maria", 1000.00, 0.01);
//		acc2.withdraw(200.0);
//		System.out.println(acc2);
//
//		Account acc3 = new BusinessAcount(1003, "Bob", 1000.0, 500.0);
//		acc3.withdraw(200.0);
//		System.out.println(acc3);

	}

	public static void aula122_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 122 - EXEMPLO 01");
		System.out.println("-------------------------\n");

		// UPCASTING
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAcount bacc = new BusinessAcount(1002, "Maria", 0.0, 500.00);
		Account acc1 = bacc;
		Account acc2 = new BusinessAcount(1003, "Bob", 0.0, 200.00);
		Account acc3 = new SavingsAccount(1004, "Ana", 100.00, 0.1);

		// DOWNCASTING
		BusinessAcount bacc1 = (BusinessAcount) acc2;
		bacc1.loan(100.0);

		// BusinessAcount bacc2 = (BusinessAcount) acc3; // possivel, mas e errado pois
		// acc3 e BusinessAccount (vai dar ClassCastException na hora de executar)
		if (acc3 instanceof BusinessAcount) {
			BusinessAcount bacc2 = (BusinessAcount) acc3;
			bacc2.loan(200.00);
			System.out.println(bacc2.getBalance());
		} else if (acc3 instanceof SavingsAccount) {
			SavingsAccount sacc = (SavingsAccount) acc3;
			sacc.updateBalance();
			System.out.println(sacc.getBalance());
		}

	}

	public static void aula121_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 121 - EXEMPLO 01");
		System.out.println("-------------------------\n");

		Account cf = new Account(283452, "DANIEL GOUVEIA", 200.00);
		System.out.println();
		System.out.println(cf);

		BusinessAcount cj = new BusinessAcount(15180, "KÉLIA CHAGAS", 100.00, 600.00);
		System.out.println();
		System.out.println(cj);

	}

}
