package s23.WorkshopJavaFXJdbc.application;

import java.io.IOException;
import java.util.Locale;

import common.utils.db.DBException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import s23.WorkshopJavaFXJdbc.exceptions.MainException;

public class Main extends Application {
	
	// atributos estáticos da classe
	private static Scene mainScene;
	
	// getters e setters
	public static Scene getMainScene() {
		return mainScene;
	}

	// main function
	public static void main(String args[]) {
		
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("INICIO DO PROGRAMA.");
		
		Locale.setDefault(Locale.US);
		launch(args);
		
	}

	// métodos
	@Override
	public void start(Stage stage) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			mainScene = new Scene(scrollPane);
			stage.setScene(mainScene);
			stage.setTitle("Workshop JavaFX JDBC - DEMO");
			stage.show();

		} catch (DBException | IOException | MainException e) {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("ERRO DURANTE A EXECUÇÃO DO PROGRAMA!");
			System.out.println("CAUSA: " + e.getMessage());
			System.out.println("Encerrando programa....");
		} finally {
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("FIM DO PROGRAMA.");
		}

	}

}