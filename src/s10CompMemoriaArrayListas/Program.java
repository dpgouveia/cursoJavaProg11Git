package s10CompMemoriaArrayListas;

import java.util.Locale;
import java.util.Scanner;

import myUtils.MyUtils;
import s10entidades.Pensionato;
import s10entidades.Produto;
import s10entidades.Quarto;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

//		aula85_exemplo01(input);

//		aula87_exemplo01(input);

//		aula88_exemplo01(input);
//		aula88_exemplo02(input);

//		aula89_exercicio01(input);

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
			System.out.printf("Digite o n�mero de linhas da matriz: ");
			mLinhas = MyUtils.readInt(input);
			System.out.printf("Digite o n�mero de colunas da matriz: ");
			nColunas = MyUtils.readInt(input);
			if (mLinhas <= 0 && nColunas <= 0) {
				System.out.println("O n�mero de linhas e colunas DEVE SER MAIOR QUE ZERO!");
			}
		} while (mLinhas <= 0 && nColunas <= 0);

		// montando a matriz e inserindo n�meros nela
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
		// repete a busca o usu�rio informar N�O
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
			
			// caso n�o encontra o elemento, ajusta o output informando que n�o encontrou o elemento
			if(output.isBlank() || output.isEmpty()) {
				output = "Elemento n�o encontrado na matriz!";
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
		System.out.println("Inserindo n�meros na matriz: ");
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
		System.out.println("Quantidade n�meros negativos na matriz: " + quantidadeNumeroNegativos);

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
				System.out.println("Locat�rio " + (i + 1) + ": ");
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
			System.out.println("QUARTOS ALOCADOS NA PENS�O AT� O MOMENTO: ");
			System.out.println(pensao);

		} else {
			System.out.println("O n�mero de aloca��o deve ser MAIOR QUE ZERO!");
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
				System.out.printf("Digite o pre�o do produto %d: ", i + 1);
				double preco = MyUtils.readDouble(input);
				listaProdutos[i] = new Produto(nome, preco);
				somaPrecoProdutos += listaProdutos[i].getPreco();
			}
			System.out.println("Pre�o m�dio de todos os produtos digitados: "
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
				System.out.printf("Digite o pre�o do produto %d: ", i + 1);
				double preco = MyUtils.readDouble(input);
				listaProdutos[i] = new Produto(nome, preco);
				somaPrecoProdutos += listaProdutos[i].getPreco();
			}
			System.out.println("Pre�o m�dio de todos os produtos digitados: "
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

		System.out.printf("Digite o n�mero de pessoas que ser�o registradas: ");
		int numeroPessoas = MyUtils.readInt(input);
		if (numeroPessoas > 0) {
			double somaAltura = 0;
			double[] vetorAlturaPessoas = new double[numeroPessoas];
			for (int i = 0; i < numeroPessoas; i++) {
				System.out.printf("Digite a altura da pessoa %d: ", i + 1);
				vetorAlturaPessoas[i] = MyUtils.readDouble(input);
				somaAltura += vetorAlturaPessoas[i];
			}
			System.out.println("Altura m�dia = " + String.format("%.2f", somaAltura / numeroPessoas));
		} else {
			System.out.println("O n�mero de pessoas deve ser MAIOR QUE ZERO");
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
