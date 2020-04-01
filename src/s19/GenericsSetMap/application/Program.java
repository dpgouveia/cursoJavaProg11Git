package s19.GenericsSetMap.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s19.GenericsSetMap.entities.CalculationService;
import s19.GenericsSetMap.entities.Circulo;
import s19.GenericsSetMap.entities.PrintService;
import s19.GenericsSetMap.entities.PrintServiceInteger;
import s19.GenericsSetMap.entities.PrintServiceObject;
import s19.GenericsSetMap.entities.PrintServiceString;
import s19.GenericsSetMap.entities.Produto;
import s19.GenericsSetMap.entities.Retangulo;
import s19.GenericsSetMap.entities.Shape;

public class Program {

	public static void main(String args[]) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

//		aula198_exemplo01("AULA 198 - EXEMPLO 01", input);
//		aula198_exemplo02("AULA 198 - EXEMPLO 02", input);
//		aula198_exemplo03("AULA 198 - EXEMPLO 03", input);
//		aula198_exemplo04("AULA 198 - EXEMPLO 04", input);
//		aula198_exemplo05("AULA 198 - EXEMPLO 05", input);
//		aula199_exemplo01("AULA 199 - EXEMPLO 01", input);
//		aula200_exemplo01("AULA 200 - EXEMPLO 01", input);
//		aula201_exemplo01("AULA 201 - EXEMPLO 01", input);
		aula201_exemplo02("AULA 201 - EXEMPLO 02", input);

		input.close();

	}

	private static void copyList(List<? extends Number> source, List<? super Number> target) {
		for (Number num : source) {
			target.add(num);
		}
	}

	public static void aula201_exemplo02(String prog, Scanner input) {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {

			List<Integer> intList = Arrays.asList(1, 2, 3, 4);

			// covariancia
			List<? extends Number> list1 = intList; // lista de sub tipo de numbers (que estendem de number)
			Number num = list1.get(0);
//			list1.add(300);     /// nao da, pois pode ser que o alor a ser inserido nao seja de um compativel com a lista em tempo de compilacao

			// contravariancia
			List<Object> list2 = new ArrayList<Object>();
			list2.add("Maria");
			list2.add("Daniel");
			List<? super Number> list3 = list2; /// lista de super tipos de Number (no caso Object)
			list3.add(30);
			list3.add(40);
//			Number x = list3.get(0);              // nao da, pois pode ser que um dos elementos da lista seja um super tipo de number (no caso Object que pode ser uma string) que pode ser incompatível com Number
			Object x = list3.get(0);

			List<Double> doubleList = Arrays.asList(3.14, 6.28);
			List<Object> genList = new ArrayList<Object>();

			System.out.println();
			Program.copyList(intList, genList);
			Program.printList(genList);

			System.out.println();
			Program.copyList(doubleList, genList);
			Program.printList(genList);

		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	private static double somaDasAreas1(List<Shape> shapes) {
		double areas = 0.0;
		for (Shape shape : shapes) {
			areas += shape.area();
		}
		return areas;
	}

	private static double somaDasAreas2(List<? extends Shape> shapes) {
		double areas = 0.0;
		for (Shape shape : shapes) {
			areas += shape.area();
		}
		return areas;
	}

	public static void aula201_exemplo01(String prog, Scanner input) {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {

			System.out.println();
			List<Shape> shapes = new ArrayList<Shape>();
			shapes.add(new Retangulo(3.0, 2.0));
			shapes.add(new Circulo(2.0));
			System.out.println("Total das areas = " + String.format("%.2f", Program.somaDasAreas1(shapes)));

			System.out.println();
			List<Circulo> circulos = new ArrayList<Circulo>();
			circulos.add(new Circulo(2.0));
			circulos.add(new Circulo(3.0));
			System.out.println("Total das areas = " + String.format("%.2f", Program.somaDasAreas2(circulos)));

		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	private static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	public static void aula200_exemplo01(String prog, Scanner input) {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {

			ArrayList<Object> myObjs = new ArrayList<Object>();
			ArrayList<Integer> myNumbers = new ArrayList<Integer>();
			ArrayList<?> myObjs2 = new ArrayList<Object>();
//			myObjs = myNumbers;      // nao pode, pois lista de objetos nao e um super tipo de lista de integer
			myObjs2 = myNumbers;

			System.out.println();
			Program.printList(Arrays.asList(5, 2, 10));

			System.out.println();
			Program.printList(Arrays.asList("Daniel", "Joao", "Kelia"));

			List<?> intList = new ArrayList<Integer>();
//			intList.add(3);     /// nao pode, pois o compilador nao sabe dizer o tipo de dados que a lista suporta

		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	public static void aula199_exemplo01(String prog, Scanner input) {

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

//		File path = new File("C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a199_ex01\\in.txt");
		File path = new File(
				"C:\\Users\\Familia\\Documents\\Daniel\\eclipse\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a199_ex01\\in.txt");
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//			System.out.println(cs.max(listaProdutos));
			String line = br.readLine();
			while (line != null) {
//				System.out.println(line);
				String campos[] = line.split(",");
				listaProdutos.add(new Produto(campos[0], Double.parseDouble(campos[1])));
				line = br.readLine();
			}

			System.out.print("Produto mais caro: ");
			System.out.println(CalculationService.max(listaProdutos));

		} catch (IllegalStateException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	public static void aula198_exemplo05(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {
			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Digite a quantidade de registros a serem inseridos na lista: ");
			int qtdNumeros = MyUtils.readInt(input);

			if (qtdNumeros <= 0)
				throw new InvalidParameterException("A quantidade numeros a serem digitados deve ser MAIOR QUE ZERO!");

			PrintService<String> ps = new PrintService<String>();
//			PrintService ps = null;

			while (qtdNumeros > 0) {
				System.out.print("Digite o valor do registro: ");
				ps.addValue(MyUtils.readString(input));
				qtdNumeros--;
			}

			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Numeros digitados foram: ");
			ps.print();
			String first = ps.first();
			System.out.println("Primeiro registro digitado na lista: " + first);

		} catch (InvalidParameterException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	public static void aula198_exemplo04(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {
			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Digite a quantidade de registros a serem inseridos na lista: ");
			int qtdNumeros = MyUtils.readInt(input);

			if (qtdNumeros <= 0)
				throw new InvalidParameterException("A quantidade numeros a serem digitados deve ser MAIOR QUE ZERO!");

			PrintService<Integer> ps = new PrintService<Integer>();
//			PrintService ps = null;

			while (qtdNumeros > 0) {
				System.out.print("Digite o valor do registro: ");
				ps.addValue(MyUtils.readInteger(input));
				qtdNumeros--;
			}

			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Numeros digitados foram: ");
			ps.print();
			Integer first = ps.first();
			System.out.println("Primeiro registro digitado na lista: " + first);

		} catch (InvalidParameterException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	public static void aula198_exemplo03(String prog, Scanner input) {
		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {
			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Digite a quantidade de registros a serem inseridos na lista: ");
			int qtdNumeros = MyUtils.readInt(input);

			if (qtdNumeros <= 0)
				throw new InvalidParameterException("A quantidade numeros a serem digitados deve ser MAIOR QUE ZERO!");

			PrintServiceObject ps = new PrintServiceObject();
//			PrintService ps = null;

			ps.addValue("Maria");

			while (qtdNumeros > 0) {
				System.out.print("Digite o valor do registro: ");
				ps.addValue(MyUtils.readInteger(input));
				qtdNumeros--;
			}

			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Numeros digitados foram: ");
			ps.print();
			Integer x = (Integer) ps.first();
			System.out.println("Primeiro registro digitado na lista: " + x);

		} catch (InvalidParameterException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	public static void aula198_exemplo02(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {
			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Digite a quantidade de registros a serem inseridos na lista: ");
			int qtdNumeros = MyUtils.readInt(input);

			if (qtdNumeros <= 0)
				throw new InvalidParameterException(
						"A quantidade de registros a serem digitados deve ser MAIOR QUE ZERO!");

			PrintServiceString ps = new PrintServiceString();
//			PrintService ps = null;
			while (qtdNumeros > 0) {
				System.out.print("Digite o valor do registro: ");
				ps.addValue(MyUtils.readString(input));
				qtdNumeros--;
			}

			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Numeros digitados foram: ");
			ps.print();
			System.out.println("Primeiro registro digitado na lista: " + ps.first());

		} catch (InvalidParameterException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

	public static void aula198_exemplo01(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("----------------------------");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("----------------------------");

		try {
			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Digite a quantidade de registros a serem inseridos na lista: ");
			int qtdNumeros = MyUtils.readInt(input);

			if (qtdNumeros <= 0)
				throw new InvalidParameterException(
						"A quantidade de registros a serem digitados deve ser MAIOR QUE ZERO!");

			PrintServiceInteger ps = new PrintServiceInteger();
//			PrintService ps = null;
			while (qtdNumeros > 0) {
				System.out.print("Digite um numero: ");
				ps.addValue(MyUtils.readInteger(input));
				qtdNumeros--;
			}

			System.out.println();
			System.out.println("----------------------------");
			System.out.print("Numeros digitados foram: ");
			ps.print();
			System.out.println("Primeiro registro digitado na lista: " + ps.first());

		} catch (InvalidParameterException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(
					"Erro: objetos necessários para execução do programa nao foram instanciados corretamente!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("Erro fatal inesperado durante a execução do programa!");
			System.out.println("Encerrando aplicação ....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("----------------------------");
		}

	}

}
