package s23.WorkshopJavaFXJdbc.application;

import java.util.Locale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import s23.WorkshopJavaFXJdbc.exception.MainException;

public class Main extends Application {

	public static void main(String args[]) {

		Locale.setDefault(Locale.US);

		launch(args);
	}

	@Override
	public void start(Stage stage) {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO DO PROGRAMA.");

		try {

			iniciarAula("aula264_exemplo01", stage);

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

		case "aula264_exemplo01": {

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
//			scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

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