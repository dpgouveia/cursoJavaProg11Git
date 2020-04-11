package s20.ProgFuncionalLambda.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;

import s20.ProgFuncionalLambda.entities.Product;
import s20.ProgFuncionalLambda.entities.Product2;
import s20.ProgFuncionalLambda.exception.ProgramException;
import s20.ProgFuncionalLambda.util.ProductPredicate;

public class Program {

	public static int globalValue = 3;

	public static void main(String args[]) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
//		iniciarAula("212_exemplo_01", input);
//		iniciarAula("212_exemplo_02", input);
//		iniciarAula("212_exemplo_03", input);
//		iniciarAula("212_exemplo_04", input);
//		iniciarAula("212_exemplo_05", input);
//		iniciarAula("212_exemplo_06", input);

//		iniciarAula("213_exemplo_01", input);
//		iniciarAula("213_exemplo_02", input);
//		iniciarAula("213_exemplo_03", input);

//		iniciarAula("215_exemplo_01", input);
//		iniciarAula("215_exemplo_02", input);
//		iniciarAula("215_exemplo_03", input);
//		iniciarAula("215_exemplo_04", input);
//		iniciarAula("215_exemplo_05", input);
//		iniciarAula("215_exemplo_06", input);
		iniciarAula("215_exemplo_07", input);

		input.close();

	}

	public static int compareProducts(Product p1, Product p2) {
		return p1.getPrice().compareTo(p2.getPrice());
	}

	public static void changeOdValues(int numbers[]) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 != 0) {
				numbers[i] += globalValue;
			}
		}
	}

	public static void iniciarAula(String aula, Scanner input) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO DO PROGRAMA. AULA: " + aula);
		System.out.println();

		try {

			switch (aula) {

			case "212_exemplo_01": {
				List<Product> list = new ArrayList<Product>();
				list.add(new Product("TV", 900.00));
				list.add(new Product("Notebook", 1200.00));
				list.add(new Product("Tablet", 450.00));

				Collections.sort(list);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "212_exemplo_02": {
				List<Product2> list = new ArrayList<Product2>();
				list.add(new Product2("TV", 900.00));
				list.add(new Product2("Notebook", 1200.00));
				list.add(new Product2("Tablet", 450.00));

				list.sort(new MyComparator());

				for (Product2 p : list) {
					System.out.println(p);
				}

				break;
			}

			case "212_exemplo_03": {
				List<Product2> list = new ArrayList<Product2>();
				list.add(new Product2("TV", 900.00));
				list.add(new Product2("Notebook", 1200.00));
				list.add(new Product2("Tablet", 450.00));

				// classe anonima dentro do programa principal
				Comparator<Product2> comp = new Comparator<Product2>() {
					@Override
					public int compare(Product2 o1, Product2 o2) {
						return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
					}
				};
				list.sort(comp);

				for (Product2 p : list) {
					System.out.println(p);
				}

				break;
			}

			case "212_exemplo_04": {
				List<Product2> list = new ArrayList<Product2>();
				list.add(new Product2("TV", 900.00));
				list.add(new Product2("Notebook", 1200.00));
				list.add(new Product2("Tablet", 450.00));

				// classe anonima dentro do programa principal
				// tambem conhecida como "arrow function" (por causa da setinha)
				Comparator<Product2> comp = (o1, o2) -> {
					return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
				};

				list.sort(comp);

				for (Product2 p : list) {
					System.out.println(p);
				}

				break;
			}

			case "212_exemplo_05": {
				List<Product2> list = new ArrayList<Product2>();
				list.add(new Product2("TV", 900.00));
				list.add(new Product2("Notebook", 1200.00));
				list.add(new Product2("Tablet", 450.00));

				// classe anonima dentro do programa principal
				// tambem conhecida como "arrow function" (por causa da setinha)
				// versao mais simplificada (pois conseguimos resolver tudo em uma unica
				// instrucao
				Comparator<Product2> comp = (o1, o2) -> o1.getName().toUpperCase()
						.compareTo(o2.getName().toUpperCase());

				list.sort(comp);

				for (Product2 p : list) {
					System.out.println(p);
				}

				break;
			}

			case "212_exemplo_06": {
				List<Product2> list = new ArrayList<Product2>();
				list.add(new Product2("TV", 900.00));
				list.add(new Product2("Notebook", 1200.00));
				list.add(new Product2("Tablet", 450.00));

				// classe anonima dentro do programa principal
				// tambem conhecida como "arrow function" (por causa da setinha)
				// versao mais simplificada (pois conseguimos resolver tudo em uma unica
				// instrucao
				// versao ultra simplificada (declarando a funcao anonima como parametro do sort
				list.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));

				for (Product2 p : list) {
					System.out.println(p);
				}

				break;
			}

			case "213_exemplo_01": {

				int vect[] = new int[] { 3, 4, 5 };
				changeOdValues(vect);
				System.out.println(Arrays.toString(vect));

				break;
			}

			case "213_exemplo_02": {

				List<Product> list = new ArrayList<Product>();
				list.add(new Product("TV", 900.00));
				list.add(new Product("Notebook", 1200.00));
				list.add(new Product("Tablet", 450.00));

				list.sort(Program::compareProducts);

				list.forEach(System.out::println);

				break;
			}

			case "213_exemplo_03": {

				List<Integer> list = Arrays.asList(3, 4, 5);

				Integer sum = 0;
				for (Integer x : list) {
					sum += x;
				}
				System.out.println("Sum: " + sum);

				Integer sum2 = list.stream().reduce(0, Integer::sum);
				System.out.println("Sum2: " + sum2);

				break;
			}

			case "215_exemplo_01": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				list.removeIf(p -> p.getPrice() >= 100);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "215_exemplo_02": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

//				list.removeIf(new ProductPredicate());
				list.removeIf(new ProductPredicate(100.00));

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "215_exemplo_03": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				list.removeIf(Product::staticProductPredicate);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "215_exemplo_04": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				list.removeIf(Product::nonStaticProductPredicate);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "215_exemplo_05": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				Predicate<Product> pred = new Predicate<Product>() {
					@Override
					public boolean test(Product p) {
						return p.getPrice() >= 100;
					}
				};
				list.removeIf(pred);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "215_exemplo_06": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				double min = 100.0;
				Predicate<Product> pred = p -> p.getPrice() >= min;
				list.removeIf(pred);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			case "215_exemplo_07": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				double min = 100.0;
				list.removeIf(p -> p.getPrice() >= min);

				for (Product p : list) {
					System.out.println(p);
				}

				break;
			}

			default: {
				System.out.println("Não existe a aula selecionada");
				break;
			}

			}

		} catch (ProgramException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("Erro: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO INESPERADO durante a execução do programa!");
			System.out.println("Encerrando a aplicação....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO FATAL NA MAQUINA VIRTUAL JAVA durante a execução do programa!");
			System.out.println("Encerrando a aplicação....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("FIM DO PROGRAMA. AULA: " + aula);
		}

	}

}
