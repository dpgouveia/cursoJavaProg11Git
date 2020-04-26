package s22.javafx.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import s22.javafx.gui.util.Alerts;

public class ViewController {

	// atributos
	@FXML
	private Button btTeste;

	@FXML
	private Button btInformation;

	@FXML
	private Button btError;

	@FXML
	private Button btErrorNoHeader;

	@FXML
	private TextField txtNumber1;

	@FXML
	private TextField txtNumber2;

	@FXML
	private Label lblResult;

	@FXML
	private Button btCalcSum;

	// métodos
	@FXML
	public void onBtTesteAction() {
		System.out.println("Click");
	}

	@FXML
	public void onBtInformationAction() {
		Alerts.showAlert("Alert title", "Alert header", "Information message", AlertType.INFORMATION);
	}

	@FXML
	public void onBtErrorAction() {
		Alerts.showAlert("Alert title", "Alert header", "Error message", AlertType.ERROR);
	}

	@FXML
	public void onBtErrorNoHeaderAction() {
		Alerts.showAlert("Alert title", null, "Error message", AlertType.ERROR);
	}

	@FXML
	public void onBtCalcSumAction() {

		try {
			
			String number1Txt = txtNumber1.getText().toLowerCase().trim().replace(",", ".");
			String number2Txt = txtNumber2.getText().toLowerCase().trim().replace(",", ".");
			
			if(number1Txt == null || number1Txt.isBlank() || number1Txt.isEmpty()) {
				throw new NumberFormatException("First number is empty!");
			}
			
			try {
				Double.parseDouble(number1Txt);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("First number contains invalid characters");
			}
			
			if(number2Txt == null || number2Txt.isBlank() || number2Txt.isEmpty()) {
				throw new NumberFormatException("Second number is empty!");
			}
			
			try {
				Double.parseDouble(number2Txt);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Second number contains invalid characters");
			}
			
			double number1 = Double.parseDouble(number1Txt);
			double number2 = Double.parseDouble(number2Txt);
			double sum = number1 + number2;
			lblResult.setText(String.format("%.2f", sum));
			
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Invalid Number Format", e.getMessage(), AlertType.ERROR);
		} catch (RuntimeException e) {
			Alerts.showAlert("Error", "Unknow error", e.getMessage(), AlertType.ERROR);
		} catch (Exception e) {
			Alerts.showAlert("Error", "Unexpected error", e.getMessage(), AlertType.ERROR);
		}
		
	}

}
