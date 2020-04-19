package s22.javafx.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
	

}
