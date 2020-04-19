package s22.javafx.application;

import java.io.IOException;
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import s22.javafx.exceptions.MainException;

public class Main extends Application {

	public static void main(String args[]) {

		Locale ptBrLocale = new Locale("pt", "BR");
		Locale.setDefault(ptBrLocale);

		launch(args);
	}

	@Override
	public void start(Stage stage) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO DO PROGRAMA.");

		try {

//			iniciarAula("aula254_exemplo01", stage);
//			iniciarAula("aula255_exemplo01", stage);
//			iniciarAula("aula256_exemplo01", stage);
//			iniciarAula("aula257_exemplo01", stage);
//			iniciarAula("aula258_exemplo01", stage);
			iniciarAula("aula259_exemplo01", stage);

		} catch (MainException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO NÃO TRATADO PELO PROGRAMA: " + e.getMessage());
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
			System.out.println("FIM DO PROGRAMA.");
		}

	}

	private void iniciarAula(String aula, Stage stage) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO AULA: " + aula);
		System.out.println();

		switch (aula) {

		case "aula254_exemplo01": {

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

			break;
		}

		case "aula255_exemplo01": {

			try {
				Parent parent = FXMLLoader.load(getClass().getResource("../gui/View255.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				throw new MainException(e.getMessage());
			}

			break;
		}

		case "aula256_exemplo01": {

			try {
				Parent parent = FXMLLoader.load(getClass().getResource("../gui/View256.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				throw new MainException(e.getMessage());
			}

			break;
		}

		case "aula257_exemplo01": {

			try {
				Parent parent = FXMLLoader.load(getClass().getResource("../gui/View257.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				throw new MainException(e.getMessage());
			}

			break;
		}

		case "aula258_exemplo01": {

			try {
				Parent parent = FXMLLoader.load(getClass().getResource("../gui/View258.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				throw new MainException(e.getMessage());
			}

			break;
		}

		case "aula259_exemplo01": {

			try {
				Parent parent = FXMLLoader.load(getClass().getResource("../gui/View259.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				throw new MainException(e.getMessage());
			}

			break;
		}

		default:
			throw new MainException("Aula inexistente");

		}

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("FIM AULA: " + aula);

	}

}