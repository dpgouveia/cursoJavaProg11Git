package s22.javafx.gui.util;

import javafx.scene.control.TextField;

public class Constraints {

	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {

			if (newValue != null 
					&& !(newValue.isBlank() || newValue.isEmpty()) 
					&& !newValue.equals("-")) {
				try {
					Integer.parseInt(newValue);
				} catch (NumberFormatException e) {
					txt.setText(oldValue);
				}
			}

		});
	}

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {

			newValue = newValue.replace(',', '.');
			if (newValue != null 
					&& !(newValue.isBlank() || newValue.isEmpty()) 
					&& !newValue.equals("-")) {
				try {
					Double.parseDouble(newValue);
				} catch (NumberFormatException e) {
					txt.setText(oldValue);
				}
			}

		});
	}
}
