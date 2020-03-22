package s17.ManipulandoArquivos.Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s17.ManipulandoArquivos.Entidades.Produto;

public class Program {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

//		aula175_exemplo01("AULA 175 - EXEMPLO 01");
//		aula176_exemplo01("AULA 176 - EXEMPLO 01");
//		aula177_exemplo01("AULA 177 - EXEMPLO 01");
//		aula178_exemplo01("AULA 178 - EXEMPLO 01");
//		aula178_exemplo02("AULA 178 - EXEMPLO 02");
//		aula179_exemplo01("AULA 179 - EXEMPLO 01", input);
//		aula180_exemplo01("AULA 180 - EXEMPLO 01", input);
		aula181_exercicio01("AULA 180 - EXEMPLO 01", input);

		input.close();

	}

	public static void aula181_exercicio01(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		// String path =
		// "C:\\Users\\Familia\\Documents\\Daniel\\eclipse\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a181_ex01\\in.txt";
		String path = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a181_ex01\\in.txt";

		// lendo os registros do arquivos e montando a lista de produtos
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String camposProduto[] = line.split(",");

				// se o registro tiver menos de 3 campos, ignora o registro carregado e parte para o proximo
				if (camposProduto.length >= 3) {
					Produto registroArquivo = new Produto(camposProduto[0].trim(), Double.parseDouble(camposProduto[1].trim()),
							Integer.parseInt(camposProduto[2].trim()));

					if (listaProdutos.isEmpty()) {
						listaProdutos.add(registroArquivo);
					} else {
						boolean produtoEncontrado = false;
						for (Produto produto : listaProdutos) {
							if (produto.getNome().equals(registroArquivo.getNome())
									&& produto.getPrecoUnitario() == registroArquivo.getPrecoUnitario()) {
								produto.incrementarQuantidade(registroArquivo.getQuantidade());
								produtoEncontrado = true;
							}
						}

						if (!produtoEncontrado) {
							listaProdutos.add(registroArquivo);
						}

					}
				} else {
					System.out.println("Registro com dados incompletos: ");
					for(String str : camposProduto) {
						System.out.print("[" + str + "] | ");
					}
					System.out.println();
				}

				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		// criando diretorio e o arquivo de output
		File inputFile = new File(path);
		File outputDir = new File(inputFile.getParent() + "\\out");
		File outputFile = new File(outputDir.getPath() + "\\summary.csv");
		try {

			if (!outputDir.exists()) {
				if (outputDir.mkdir()) {
					outputFile.createNewFile();
				} else {
					throw new IOException("Nao é possível criar a pasta \"out\"!");
				}

			} else if (outputDir.canWrite() && !outputFile.canWrite()) {
				throw new IOException("Nao é possível escrever no arquivo existente da pasta output!");
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		// imprimindo o valor total de cada produto cadastro na lista
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			for (Produto produto : listaProdutos) {
				String line = "[" + produto.getNome() + "],[$" + String.format("%.2f", produto.valorTotal()) + "]";
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("================================");

	}

	public static void aula180_exemplo01(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		System.out.print("Enter a file path: ");
		String strPath = MyUtils.readString(input);
		File path = new File(strPath);

		// C:\\app\\NG_PRD\\NegociacaoImportaFeira\\batch-negociacao-1.0.0.jar
		// filename
		System.out.println("getName: " + path.getName());

		// parent
		System.out.println("getParent: " + path.getParent());

		// path
		System.out.println("getPath: " + path.getPath());

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("================================");

	}

	public static void aula179_exemplo01(String prog, Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		System.out.println();
		System.out.println("================================");
		System.out.print("Enter a folder path: ");
		String strPath = MyUtils.readString(input);

		File path = new File(strPath);

		// C:\app\NG_PRD\NegociacaoImportaFeira
		// C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\
		// pegar todos as pastas a partir do caminho informado
		File folders[] = path.listFiles(File::isDirectory);
		System.out.println("Folders: ");
		for (File folder : folders) {
			System.out.println(folder);
		}

		// pegar todos os arquivos a partir do caminho informado
		System.out.println();
		System.out.println("================================");
		File files[] = path.listFiles(File::isFile);
		System.out.println("Files: ");
		for (File file : files) {
			System.out.println(file);
		}

		// criar uma subpasta a partir do caminho informado
		System.out.println();
		System.out.println("================================");
		boolean success = new File(strPath + "\\newSubdir").mkdir();
		System.out.println("newSubdir created successfully? " + success);

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("================================");

	}

	public static void aula178_exemplo02(String prog) {

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		String lines[] = new String[] { "Good morning", "Good afternoon", "Good night" };
		String path = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a178_ex02_out_ovr.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

			System.out.println();
			System.out.println("================================");
			e.printStackTrace();
			System.out.println("================================");
		}

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("================================");

	}

	public static void aula178_exemplo01(String prog) {

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		String lines[] = new String[] { "Good morning", "Good afternoon", "Good night" };
		String path = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\a178_ex01_out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

			System.out.println();
			System.out.println("================================");
			e.printStackTrace();
			System.out.println("================================");
		}

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("================================");

	}

	public static void aula177_exemplo01(String prog) {

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		String path = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

			System.out.println();
			System.out.println("================================");
			e.printStackTrace();
			System.out.println("================================");
		}

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - FIM DO PROGRAMA");
		System.out.println("================================");

	}

	public static void aula176_exemplo01(String prog) {

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		String path = "C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\in.txt";
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

			System.out.println();
			System.out.println("================================");
			e.printStackTrace();
			System.out.println("================================");
		} finally {

			try {
				if (br != null) {
					br.close();
				}

				if (fr != null) {
					fr.close();
				}

			} catch (IOException e) {
				System.out.println();
				System.out.println("================================");
				e.printStackTrace();
				System.out.println("================================");
			}

			System.out.println();
			System.out.println("================================");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("================================");
		}
	}

	public static void aula175_exemplo01(String prog) {

		System.out.println();
		System.out.println("================================");
		System.out.println(prog + " - INICIO DO PROGRAMA");
		System.out.println("================================");

		File file = new File("C:\\Users\\BRDPG1\\Documents\\eclipse-workspace\\cursoJavaProg11Git\\temp\\in.txt");
		Scanner fileScanner = null;

		try {
			fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {
				System.out.println(fileScanner.nextLine());

			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

			System.out.println();
			System.out.println("================================");
			e.printStackTrace();
			System.out.println("================================");
		} finally {
			if (fileScanner != null) {
				fileScanner.close();
			}
			System.out.println();
			System.out.println("================================");
			System.out.println(prog + " - FIM DO PROGRAMA");
			System.out.println("================================");
		}

	}

}
