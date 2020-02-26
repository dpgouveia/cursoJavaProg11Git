package s10.MemoriaArrayListas.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import common.myUtils.MyUtils;
import s10.MemoriaArrayListas.Entidades.CadastroFuncionarios;
import s10.MemoriaArrayListas.Entidades.Funcionario;
import s10.MemoriaArrayListas.Entidades.Pensionato;
import s10.MemoriaArrayListas.Entidades.Produto;
import s10.MemoriaArrayListas.Entidades.Quarto;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

//		aula85_exemplo01(input);
//
//		aula87_exemplo01(input);
//
//		aula88_exemplo01(input);
//		aula88_exemplo02(input);
//
//		aula89_exercicio01(input);
//		
//		aula90_exemplo01(input);
//
//		aula91_exemplo01(input);
//
//		aula92_exemplo01(input);
//
//		aula93_exemplo01(input);
//
//		aula94_exercicio01(input);
//
//		aula96_exercicio01(input);

		aula97_exercicio01(input);

		input.close();

	}

	public static void aula97_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 97 - EXERCICIO 01");
		System.out.println("--------------------------\n");

		// lendo o numero de linhas e colunas da metriz
		int mLinhas, nColunas;
		do {
			System.out.printf("Digite o número de linhas da matriz: ");
			mLinhas = MyUtils.readInt(input);
			System.out.printf("Digite o número de colunas da matriz: ");
			nColunas = MyUtils.readInt(input);
			if (mLinhas <= 0 && nColunas <= 0) {
				System.out.println("O número de linhas e colunas DEVE SER MAIOR QUE ZERO!");
			}
		} while (mLinhas <= 0 && nColunas <= 0);

		// montando a matriz e inserindo números nela
		System.out.println();
		System.out.println("Inserindo numeros na matriz: ");

		int matriz[][] = new int[mLinhas][nColunas];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("Matriz[%d][%d]: ", i + 1, j + 1);
				matriz[i][j] = MyUtils.readInt(input);
			}
			System.out.println();
		}

		// buscando um elemento X na matriz e apresentando seu vizinhos
		// repete a busca o usuário informar NÂO
		do {

			// imprimindo a matriz montada
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.printf("%d ", matriz[i][j]);
				}
				System.out.println();
			}

			System.out.println();
			System.out.printf("Buscar o elemento a seguir na matriz: ");
			int elementoX = MyUtils.readInt(input);
			String output = "";
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (elementoX == matriz[i][j]) {
						output += "Posicao: " + (i + 1) + "," + (j + 1) + "\n";
						output += ((j - 1) >= 0) ? "Esquerda: " + matriz[i][j - 1] + "\n" : "";
						output += ((i - 1) >= 0) ? "Acima: " + matriz[i - 1][j] + "\n" : "";
						output += ((j + 1) < matriz[i].length) ? "Direita: " + matriz[i][j + 1] + "\n" : "";
						output += ((i + 1) < matriz.length) ? "Abaixo: " + matriz[i + 1][j] + "\n" : "";
						output += "\n";
					}
				}
			}

			// caso não encontra o elemento, ajusta o output informando que não encontrou o
			// elemento
			if (output.isBlank() || output.isEmpty()) {
				output = "Elemento não encontrado na matriz!";
			}

			System.out.println(output);

			System.out.println();
			System.out.printf("Deseja repetir a busca (y/n)? ");

		} while (MyUtils.readChar(input, "^y|^Y|^n|^N").toLowerCase().charAt(0) == 'y');

		// fim do programa
		System.out.println("FIM DO PROGRAMA!!");

	}

	public static void aula96_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 96 - EXERCICIO 01");
		System.out.println("--------------------------\n");

		int tamanhoMatriz = 0;
		do {
			System.out.printf("Digite o tamanho da matriz: ");
			tamanhoMatriz = MyUtils.readInt(input);
			if (tamanhoMatriz <= 0) {
				System.out.println("O tamanho da matriz DEVE SER MAIOR QUE ZERO: ");
			}
		} while (tamanhoMatriz <= 0);

//		inserindo numeros na matriz
		System.out.println("");
		System.out.println("Inserindo números na matriz: ");
		Integer matriz[][] = new Integer[tamanhoMatriz][tamanhoMatriz];
		int quantidadeNumeroNegativos = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("MATRIZ[%d][%d]: ", i + 1, j + 1);
				matriz[i][j] = MyUtils.readInteger(input);
				if (matriz[i][j] < 0) {
					quantidadeNumeroNegativos++;
				}
			}
		}

//		Imprimindo a matriz
		System.out.println();
		System.out.println("Imprimindo matriz na tela!");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf(" %d ", matriz[i][j]);
			}
			System.out.println();
		}

//		Elementos na diagonal da matriz
		System.out.println("");
		System.out.printf("Diagonal princial da metriz: ");
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf(" %d ", matriz[i][i]);
		}

//		Imprimindo a quantidade de negativos da matriz
		System.out.println();
		System.out.println("Quantidade números negativos na matriz: " + quantidadeNumeroNegativos);

	}

	public static void aula94_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 94 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		System.out.printf("Digite a quantidade de funcionários que deseja cadastrar: ");
		int numeroFuncionarios = MyUtils.readInt(input);
		if (numeroFuncionarios > 0) {

			CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
			System.out.println("Cadastrando os dados dos funcionários ....");
			for (int i = 1; i <= numeroFuncionarios; i++) {

				System.out.println("\n");
				System.out.println("Cadastrando o funcionario " + i);
				String id;
				Funcionario funcionario;
				do {
					System.out.printf("Digite o novo ID do funcionário: ");
					id = MyUtils.readString(input).trim();
					funcionario = cadastroFuncionarios.getFuncionario(id);
					if (funcionario != null) {
						System.out.println("Já existe um funcionário com este ID!");
					}
				} while (funcionario != null);

				System.out.printf("Digite o NOME do funcionário: ");
				String nome = MyUtils.readString(input).trim();
				System.out.printf("Digite o SALÁRIO do funcionário: ");
				Double salario = MyUtils.readDouble(input);

				cadastroFuncionarios.setFuncionario(new Funcionario(id, nome, salario));
			}

			System.out.println("\n");
			System.out.println("Lista de funcionários cadastrados: ");
			System.out.println(cadastroFuncionarios);

			System.out.printf("Digite o ID do funcionário para aumentar o salário: ");
			Funcionario funcionario = cadastroFuncionarios.getFuncionario(MyUtils.readString(input).trim());
			Double incrementoPercentual;
			if (funcionario != null) {
				do {
					System.out.printf("Digite o incremento percentual do salário: ");
					incrementoPercentual = MyUtils.readDouble(input);
					if (incrementoPercentual <= 0) {
						System.out.println("O incremento percentual deve ser MAIOR QUE ZERO!!!");
					}
				} while (incrementoPercentual <= 0);
				cadastroFuncionarios.aumentarSalario(funcionario, incrementoPercentual);
			} else {
				System.out.println("Não encontramos o ID digitado na base de cadastro de funcionários!");
			}

			System.out.println("\n");
			System.out.println("Lista atualizada de funcionários cadastrados: ");
			System.out.println(cadastroFuncionarios);

		} else {
			System.out.println("O número de funcionários deve ser MAIOR QUE ZERO!!!");
		}

	}

	public static void aula93_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 93 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		List<String> listaString = new ArrayList<>(); // nao e preciso definir o tipo nas versoes mais novas no java
		List<String> resultList = new ArrayList<String>();

		listaString.add("Maria");
		listaString.add("Alex");
		listaString.add("Bob");
		listaString.add("Ana");
		listaString.add("Aurelio");
		listaString.add("Juliana");
		listaString.add("Cesar");
		listaString.add("Victor");
		listaString.add("Melina");
		listaString.add(2, "Marco");

		System.out.println("====================");
		System.out.println("TAMANHO DA LISTA = " + listaString.size());
		for (String name : listaString) {
			System.out.println("NOME = " + name);
		}
		System.out.println("Index of Bob = " + listaString.indexOf("Bob"));
		System.out.println("Index of Daniel = " + listaString.indexOf("Daniel"));

		System.out.println("====================");
		resultList = listaString.stream().filter(x -> x.toLowerCase().charAt(0) == 'a').collect(Collectors.toList());
		System.out.println("Printing resultList: ");
		for (String name : resultList) {
			System.out.println("NOME = " + name);
		}

		System.out.println("====================");
		String strFindFirst = resultList.stream().filter(x -> x.toLowerCase().charAt(0) == 'a').findAny().orElse(null);
		System.out.println("Find First Element with A = " + strFindFirst);
		strFindFirst = resultList.stream().filter(x -> x.toLowerCase().charAt(0) == 'B').findAny().orElse(null);
		System.out.println("Find First Element with B = " + strFindFirst);

		System.out.println("\n====================");
		System.out.println("TAMANHO DA LISTA = " + listaString.size());
		listaString.removeIf(x -> x.charAt(0) == 'M'); // funcao lambda (tambem conhecida como predicado)
		for (String name : listaString) {
			System.out.println("NOME = " + name);
		}

		listaString.remove("Ana");
		listaString.remove(1);
		System.out.println("\n====================");
		System.out.println("TAMANHO DA LISTA = " + listaString.size());
		for (String name : listaString) {
			System.out.println("NOME = " + name);
		}

	}

	public static void aula92_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 92 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		System.out.println("List x  = new List(); // não pode ser instanciado, pois List é uma interface");

	}

	public static void aula91_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 91 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		String vect[] = new String[] { "Maria", "Bob", "Alex" };

		System.out.println("Printing names now (for padrão) ...");
		for (int i = 0; i < vect.length; i++) {
			System.out.println(vect[i]);
		}

		System.out.println("=============");
		System.out.println("Printing names now (for each) ...");
		for (String name : vect) {
			System.out.println(name);
		}

	}

	public static void aula90_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n-----------------------------------");
		System.out.println("AULA 90 - EXEMPLO 01");
		System.out.println("-----------------------------------\n");

		int x = 20;
		Object obj = x; // boxing
		int y = (int) obj; // unboxing
		Integer obj2 = x; // wrapper class
		int w = obj2 * 2; // utilizando a wrapper class nao precisa fazer casting

		System.out.println(obj);
		System.out.println(y);
		System.out.println(obj2);
		System.out.println(w);

	}

	public static void aula89_exercicio01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 89 - EXERCICIO 01");
		System.out.println("--------------------------\n");

		System.out.printf("Quantos quartos deseja alocar: ");
		int numeroQuartos = MyUtils.readInt(input);

		if (numeroQuartos > 0) {
			Pensionato pensao = new Pensionato();

			for (int i = 0; i < numeroQuartos; i++) {
				System.out.println("Locatário " + (i + 1) + ": ");
				System.out.printf("Nome: ");
				String nomeLocatario = MyUtils.readString(input);
				System.out.printf("Email: ");
				String emailLocatario = MyUtils.readString(input);
				int numeroQuarto;
				do {
					System.out.printf("Numero do quarto [0-9]: ");
					numeroQuarto = MyUtils.readInt(input);
				} while (!pensao.quartoDisponivel(numeroQuarto));
				pensao.setQuarto(numeroQuarto, new Quarto(nomeLocatario, emailLocatario));
			}

			System.out.println("");
			System.out.println("QUARTOS ALOCADOS NA PENSÃO ATÉ O MOMENTO: ");
			System.out.println(pensao);

		} else {
			System.out.println("O número de alocação deve ser MAIOR QUE ZERO!");
		}
	}

	public static void aula88_exemplo02(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 88 - EXEMPLO 02");
		System.out.println("--------------------------\n");

		System.out.printf("Digite o numero de produtos a serem digitados: ");
		int numeroProdutos = MyUtils.readInt(input);

		if (numeroProdutos > 0) {
			double somaPrecoProdutos = 0.0;
			Produto[] listaProdutos = new Produto[numeroProdutos];
			for (int i = 0; i < listaProdutos.length; i++) {
				System.out.printf("Digite o nome do produto %d: ", i + 1);
				String nome = MyUtils.readString(input);
				System.out.printf("Digite o preço do produto %d: ", i + 1);
				double preco = MyUtils.readDouble(input);
				listaProdutos[i] = new Produto(nome, preco);
				somaPrecoProdutos += listaProdutos[i].getPreco();
			}
			System.out.println("Preço médio de todos os produtos digitados: "
					+ String.format("%.2f", somaPrecoProdutos / listaProdutos.length));
		} else {
			System.out.println("O nunmero de produtos deve ser MAIOR QUE ZERO.");
		}

	}

	public static void aula88_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 88 - EXEMPLO 01");
		System.out.println("--------------------------\n");

		System.out.printf("Digite o numero de produtos a serem digitados: ");
		int numeroProdutos = MyUtils.readInt(input);

		if (numeroProdutos > 0) {
			double somaPrecoProdutos = 0.0;
			Produto[] listaProdutos = new Produto[numeroProdutos];
			for (int i = 0; i < numeroProdutos; i++) {
				System.out.printf("Digite o nome do produto %d: ", i + 1);
				String nome = MyUtils.readString(input);
				System.out.printf("Digite o preço do produto %d: ", i + 1);
				double preco = MyUtils.readDouble(input);
				listaProdutos[i] = new Produto(nome, preco);
				somaPrecoProdutos += listaProdutos[i].getPreco();
			}
			System.out.println("Preço médio de todos os produtos digitados: "
					+ String.format("%.2f", somaPrecoProdutos / numeroProdutos));
		} else {
			System.out.println("O nunmero de produtos deve ser MAIOR QUE ZERO.");
		}

	}

	public static void aula87_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 87 - EXEMPLO 01");
		System.out.println("--------------------------\n");

		System.out.printf("Digite o número de pessoas que serão registradas: ");
		int numeroPessoas = MyUtils.readInt(input);
		if (numeroPessoas > 0) {
			double somaAltura = 0;
			double[] vetorAlturaPessoas = new double[numeroPessoas];
			for (int i = 0; i < numeroPessoas; i++) {
				System.out.printf("Digite a altura da pessoa %d: ", i + 1);
				vetorAlturaPessoas[i] = MyUtils.readDouble(input);
				somaAltura += vetorAlturaPessoas[i];
			}
			System.out.println("Altura média = " + String.format("%.2f", somaAltura / numeroPessoas));
		} else {
			System.out.println("O número de pessoas deve ser MAIOR QUE ZERO");
		}

	}

	public static void aula85_exemplo01(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println("\n--------------------------");
		System.out.println("AULA 85 - EXEMPLO 01");
		System.out.println("--------------------------\n");

		int x;
//		System.out.println(x);

		x = 10;
		System.out.println(x);

	}

}
