package s20.ProgFuncionalLambda.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.utils.MyUtils;
import s20.ProgFuncionalLambda.entities.Funcionario;
import s20.ProgFuncionalLambda.entities.Product;
import s20.ProgFuncionalLambda.entities.Product2;
import s20.ProgFuncionalLambda.entities.Product3;
import s20.ProgFuncionalLambda.entities.ProductService;
import s20.ProgFuncionalLambda.exception.ProgramException;
import s20.ProgFuncionalLambda.util.ProductConsumer;
import s20.ProgFuncionalLambda.util.ProductFunction;
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
//		iniciarAula("215_exemplo_07", input);

//		iniciarAula("216_exemplo_01", input);
//		iniciarAula("216_exemplo_02", input);
//		iniciarAula("216_exemplo_03", input);
//		iniciarAula("216_exemplo_04", input);
//		iniciarAula("216_exemplo_05", input);
//		iniciarAula("216_exemplo_06", input);

//		iniciarAula("217_exemplo_01", input);
//		iniciarAula("217_exemplo_02", input);
//		iniciarAula("217_exemplo_03", input);
//		iniciarAula("217_exemplo_04", input);
//		iniciarAula("217_exemplo_05", input);
//		iniciarAula("217_exemplo_06", input);

//		iniciarAula("218_exemplo_01", input);

//		iniciarAula("219_exemplo_01", input);
//		iniciarAula("219_exemplo_02", input);

//		iniciarAula("220_exemplo_01", input);

//		iniciarAula("221_exercicio_01", input);

		iniciarAula("222_exercicio_01", input);

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

			case "216_exemplo_01": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				list.forEach(new ProductConsumer());

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				break;
			}

			case "216_exemplo_02": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				list.forEach(Product::staticProductConsumer);

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				break;
			}

			case "216_exemplo_03": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				list.forEach(Product::nonStaticProductConsumer);

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				break;
			}

			case "216_exemplo_04": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				Consumer<Product> consumer = new Consumer<Product>() {
					@Override
					public void accept(Product p) {
						p.setPrice(p.getPrice() * 1.1);
					}
				};
				list.forEach(consumer);

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				break;
			}

			case "216_exemplo_05": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				double increment = 1.1;
				Consumer<Product> consumer = p -> {
					p.setPrice(p.getPrice() * increment);
				};
				list.forEach(consumer);

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				break;
			}

			case "216_exemplo_06": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				double increment = 1.1;
				list.forEach(p -> p.setPrice(p.getPrice() * increment));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				break;
			}

			case "217_exemplo_01": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				List<Product> newList = new ArrayList<Product>();
				newList = list.stream().map(new ProductFunction()).collect(Collectors.toList());

				System.out.println();
				System.out.println("------------------------------------------");
				newList.forEach(System.out::println);

				break;
			}

			case "217_exemplo_02": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				List<Product> newList = new ArrayList<Product>();
				newList = list.stream().map(Product::staticProductFunction).collect(Collectors.toList());

				System.out.println();
				System.out.println("------------------------------------------");
				newList.forEach(System.out::println);

				break;
			}

			case "217_exemplo_03": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				List<Product> newList = new ArrayList<Product>();
				newList = list.stream().map(Product::nonStaticProductFunction).collect(Collectors.toList());

				System.out.println();
				System.out.println("------------------------------------------");
				newList.forEach(System.out::println);

				break;
			}

			case "217_exemplo_04": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				List<Product> newList = new ArrayList<Product>();
				Function<Product, Product> func = new Function<Product, Product>() {
					@Override
					public Product apply(Product source) {
						return new Product(source.getName().toUpperCase(), source.getPrice());
					};
				};
				newList = list.stream().map(func).collect(Collectors.toList());

				System.out.println();
				System.out.println("------------------------------------------");
				newList.forEach(System.out::println);

				break;
			}

			case "217_exemplo_05": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				List<Product> newList = new ArrayList<Product>();
				Function<Product, Product> func = source -> {
					return new Product(source.getName().toUpperCase(), source.getPrice());
				};
				newList = list.stream().map(func).collect(Collectors.toList());

				System.out.println();
				System.out.println("------------------------------------------");
				newList.forEach(System.out::println);

				break;
			}

			case "217_exemplo_06": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				List<Product> newList = new ArrayList<Product>();
				newList = list.stream().map(source -> new Product(source.getName().toUpperCase(), source.getPrice()))
						.collect(Collectors.toList());

				System.out.println();
				System.out.println("------------------------------------------");
				newList.forEach(System.out::println);

				break;
			}

			case "218_exemplo_01": {

				List<Product> list = new ArrayList<Product>();

				list.add(new Product("Tv", 900.00));
				list.add(new Product("Mouse", 50.00));
				list.add(new Product("Tablet", 350.50));
				list.add(new Product("HD Case", 80.90));

				System.out.println();
				System.out.println("------------------------------------------");
				list.forEach(System.out::println);

				System.out.println();
				System.out.println("------------------------------------------");
				System.out
						.println("(Comeca com T | Modo Antigo) Soma dos preços: " + ProductService.somaFiltrada(list));
				System.out.println("(Comeca com T) Soma dos preços: "
						+ ProductService.somaFiltradaPredicate(list, x -> x.getName().toUpperCase().charAt(0) == 'T'));
				System.out.println("(Comeca com M) Soma dos preços: "
						+ ProductService.somaFiltradaPredicate(list, x -> x.getName().toUpperCase().charAt(0) == 'M'));
				System.out.println("(Preco < 100) Soma dos preços: "
						+ ProductService.somaFiltradaPredicate(list, x -> x.getPrice() < 100));

				break;
			}

			case "219_exemplo_01": {

				List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
				Stream<Integer> st1 = list.stream();
				System.out.println(Arrays.toString(st1.toArray()));

				Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
				System.out.println(Arrays.toString(st2.toArray()));

				// as streams abaixo tem tamanho indefinido em decorrencia da sua criacao estar
				// utilizando a funcao iterate
				Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
				System.out.println(Arrays.toString(st3.limit(10).toArray()));

				Stream<Long> st4 = Stream.iterate(new long[] { 0L, 1L }, p -> new long[] { p[1], p[0] + p[1] })
						.map(p -> p[0]);
				System.out.println(Arrays.toString(st4.limit(10).toArray()));

				break;
			}

			case "219_exemplo_02": {

				List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
				Stream<Integer> st1 = list.stream().map(x -> x * 10);
				System.out.println(Arrays.toString(st1.toArray()));

				Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
				System.out.println(Arrays.toString(st2.toArray()));

				// as streams abaixo tem tamanho indefinido em decorrencia da sua criacao estar
				// utilizando a funcao iterate
				Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
				System.out.println(Arrays.toString(st3.limit(10).toArray()));

				Stream<Long> st4 = Stream.iterate(new Long[] { 0L, 1L }, p -> new Long[] { p[1], p[0] + p[1] })
						.map(p -> p[0]);
				System.out.println(Arrays.toString(st4.limit(20).toArray()));

				break;
			}

			case "220_exemplo_01": {

				List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
				Stream<Integer> st1 = list.stream().map(x -> x * 10);
				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println(Arrays.toString(st1.toArray()));

				int sum = list.stream().reduce(0, (x, y) -> x + y);
				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Somatorio da stream: " + sum);

				List<Integer> newList = list.stream().filter(x -> x % 2 == 0).map(x -> x * 10)
						.collect(Collectors.toList());
				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Somatorio dos numeros pares da lista multiplicados por 10: "
						+ Arrays.toString(newList.toArray()));

				break;
			}

			case "221_exercicio_01": {

				List<Product3> listaProdutos = new ArrayList<Product3>();
				String inputFilePath = "C:\\Users\\Familia\\Documents\\Daniel\\eclipse\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a221_exer01\\in.txt";
				try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

					String line = br.readLine();
					while (line != null) {

						String fields[] = line.split(",");
						if (fields.length != 2) {
							throw new ProgramException(aula
									+ ": registro defeituoso encontrado no arquivo (não contém a quantidade de campos necessários para a execução do programa)");
						}

						listaProdutos.add(new Product3(fields[0], Double.parseDouble(fields[1])));

						line = br.readLine();
					}

				} catch (NullPointerException | NumberFormatException | IOException e) {
					throw new ProgramException(e.getMessage());
				}

				if (listaProdutos.size() <= 0) {
					throw new ProgramException(aula + ": a lista de produtos esta vazia!");
				}

				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Produtos registrados");
				listaProdutos.forEach(System.out::println);

				double precoMedioTotal = listaProdutos.stream().map(x -> x.getPrice()).reduce(0.0, Double::sum)
						/ listaProdutos.size();
//				double precoMedioTotal = listaProdutos.stream().
//						map(x -> x.getPrice()).
//						reduce(0.0, (x, y) -> x + y) / listaProdutos.size();
				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Preço médio dos produtos: " + String.format("%.2f", precoMedioTotal));
				System.out.println("Imprimindo os produtos abaixo do preço médio total: ");
				for (Product3 p : listaProdutos.stream().filter(x -> x.getPrice() < precoMedioTotal)
						.sorted((p1, p2) -> -1 * p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()))
						.collect(Collectors.toList())) {
					System.out.println(p);
				}

				break;
			}

			case "222_exercicio_01": {

				System.out.println();
				System.out.println("------------------------------------------");
				System.out.print("Digite o salário: ");
				double salario = MyUtils.readDouble(input);

				if (salario <= 0) {
					throw new ProgramException(aula + ": o valor de salário DEVE SER MAIOR QUE ZERO");
				}

				List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
				String inputFilePath = "C:\\Users\\Familia\\Documents\\Daniel\\eclipse\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a222_exer01\\in.txt";
				try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

					String linha = br.readLine();
					while (linha != null) {

						String campos[] = linha.split(",");
						if (campos.length != 3) {
							throw new ProgramException(aula + ": REGISTRO DEFEITUOSO ENCONTRADO NO ARQUIVO na linha [" + linha + "]");
						}

						if(campos[0].isEmpty() || campos[0].isBlank()) {
							throw new ProgramException(aula + ": o campo NOME FUNCIONÁRIO na linha [" + linha + "] ESTA VAZIO OU EM BRANCO");
						}
						
						if(campos[1].isEmpty() || campos[1].isBlank()) {
							throw new ProgramException(aula + ": o campo EMAIL FUNCIONÁRIO na linha [" + linha + "] ESTA VAZIO OU EM BRANCO");
						}
						
						if(campos[2].isEmpty() || campos[2].isBlank()) {
							throw new ProgramException(aula + ": o campo SALÁRIO FUNCIONÁRIO na linha [" + linha + "] ESTA VAZIO OU EM BRANCO");
						}
						
						try {
							Double.parseDouble(campos[2].trim());
						} catch (NullPointerException | NumberFormatException e) {
							throw new ProgramException(
									aula + ": o campo SALÁRIO FUNCIONÁRIO na linha [" + linha + "] NAÕ É UM VALOR DECIMAL VÁLIDO");
						}

						listaFuncionarios.add(new Funcionario(campos[0], campos[1], Double.parseDouble(campos[2])));
						linha = br.readLine();
					}

				} catch (IOException e) {
					throw new ProgramException(aula + ": Arquivo não foi encontrado na máquina [" + inputFilePath + "]");
				}

				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Lista de funcionários carregados no programa: ");
				listaFuncionarios.forEach(System.out::println);

				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Email dos funcionarios com o salário maior que $ " + String.format("%.2f", salario) + ": ");
				
				List<String> listaNomeFuncionarios = listaFuncionarios.stream()
						.filter(func -> func.getSalario() >= salario).map(func -> func.getEmail())
						.collect(Collectors.toList());
				for (String nomeFuncionario : listaNomeFuncionarios) {
					System.out.println(nomeFuncionario);
				}

				System.out.println();
				System.out.println("------------------------------------------");
				double somaSalarios = listaFuncionarios.stream()
						.filter(func -> func.getNome().toUpperCase().charAt(0) == 'M')
						.map(func -> func.getSalario())
						.reduce(0.0, Double::sum);
				System.out.print("A soma dos sálarios dos funcionários que iniciam com a letra 'M' é: " + somaSalarios);
				break;
			}

			default: {
				throw new ProgramException("Aula inexistente");
			}

			}

		} catch (ProgramException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO NO PROGRAMA: " + e.getMessage());
			System.out.println("Encerrando programa....");
		} catch (RuntimeException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO INESPERADO durante a execução do programa!");
			System.out.println("Encerrando programa....");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO FATAL NA MAQUINA VIRTUAL JAVA durante a execução do programa!");
			System.out.println("Encerrando programa....");
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("FIM DO PROGRAMA. AULA: " + aula);
		}

	}

}
