package s14HerancaPolimorfismo;

import java.util.Locale;
import java.util.Scanner;

import s14Entidades.Account;
import s14Entidades.BusinessAcount;
import s14Entidades.SavingsAccount;

public class Program {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

//		aula121_exemplo01(input);

//		aula122_exemplo01(input);

		aula123_exemplo01(input);

		input.close();
	}

	public static void aula123_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-------------------------");
		System.out.println("AULA 123 - EXEMPLO 01");
		System.out.println("-------------------------\n");

//		Account acc = new Account(1001, "Alex", 0.00);
//		System.out.println(acc);
//		acc.deposit(100.00);
//		System.out.println(acc);
//		acc.withdraw(15.0);
//		System.out.println(acc);
//
//		System.out.println();
//		SavingsAccount sacc = new SavingsAccount(1002, "Maria", 100.0, 0.1);
//		System.out.println(sacc);
//		sacc.withdraw(15.0);
//		System.out.println(sacc);
//		sacc.updateBalance();
//		System.out.println(sacc);

//		System.out.println();
//		BusinessAcount bacc = new BusinessAcount(1003, "Bob", 0.0, 500.00);
//		System.out.println(bacc);
//		bacc.deposit(100.0);
//		System.out.println(bacc);
//		bacc.withdraw(15.00);
//		System.out.println(bacc);
//		bacc.loan(50.00);
//		System.out.println(bacc);

		Account acc1 = new Account(1001, "Alex", 1000.00);
		acc1.withdraw(200.0);
		System.out.println(acc1);

		Account acc2 = new SavingsAccount(1002, "Maria", 1000.00, 0.01);
		acc2.withdraw(200.0);
		System.out.println(acc2);

		Account acc3 = new BusinessAcount(1003, "Bob", 1000.0, 500.0);
		acc3.withdraw(200.0);
		System.out.println(acc3);

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
