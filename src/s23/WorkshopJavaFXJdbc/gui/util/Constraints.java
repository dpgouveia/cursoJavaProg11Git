package s23.WorkshopJavaFXJdbc.gui.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class Constraints {

	public static void setTextFieldInteger(TextField txt) {
		System.out.println();
		System.out.println(Constraints.class + " ==== showAlert()");
				
		// Implementing functional interfaces:
		// ChangeListener
		ChangeListener<String> listener = new ChangeListener<String>() {

			@Override public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
				if (newValue != null && !(newValue.isBlank() || newValue.isEmpty()) && !newValue.equals("-")) {
					try {
						Integer.parseInt(newValue);
					} catch (NumberFormatException e) {
						txt.setText(oldValue);
					}
				}
			}
			
		};
		
		// mainCode --- setTextFieldInteger() 
		txt.textProperty().addListener(listener );
		
	}

	public static void setTextFieldMaxLength(TextField txt, int max) {
		System.out.println();
		System.out.println(Constraints.class + " ==== setTextFieldMaxLength()");
		
		// Implementing functional interfaces:
		// ChangeListener 
		ChangeListener<String> listener = new ChangeListener<String>() {

			@Override public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
				if (newValue != null && newValue.length() > max) {
					txt.setText(oldValue);
				}	
			}
			
		};
		
		// mainCode --- setTextFieldMaxLength() 
		txt.textProperty().addListener(listener);
				
	}

	public static void setTextFieldDouble(TextField txt) {
		System.out.println();
		System.out.println(Constraints.class + " ==== setTextFieldDouble()");
		
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			newValue = newValue.replace(',', '.');
			if (newValue != null && !(newValue.isBlank() || newValue.isEmpty()) && !newValue.equals("-")) {
				try {
					Double.parseDouble(newValue);
				} catch (NumberFormatException e) {
					txt.setText(oldValue);
				}
			}

		});
	}
}
