package s23.WorkshopJavaFXJdbc.gui.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alerts {

	public static void showAlert(String title, String header, String content, AlertType type) {
		System.out.println();
		System.out.println("==== showAlert()");
		
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

	public static Optional<ButtonType> showConfirmation(String title, String content) {
		System.out.println();
		System.out.println("==== showConfirmation()");
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		return alert.showAndWait();

	}

}