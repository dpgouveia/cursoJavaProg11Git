package s22.javafx.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	// atributos
	@FXML
	private Button btTeste;
	
	// m�todos
	// Action = Click
	@FXML
	public void onBtTesteAction() {
		System.out.println("Click");
	}

}
