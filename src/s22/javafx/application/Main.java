package s22.javafx.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import s22.javafx.exceptions.MainException;

public class Main extends Application {

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO DO PROGRAMA.");

		try {

			iniciarAula("aula254_exemplo01", primaryStage);

		} catch (MainException e) {
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
			System.out.println("FIM DO PROGRAMA.");
		}

	}

	private void iniciarAula(String aula, Stage primaryStage) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO AULA: " + aula);
		System.out.println();

		switch (aula) {

		case "aula254_exemplo01": {

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
//			scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

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