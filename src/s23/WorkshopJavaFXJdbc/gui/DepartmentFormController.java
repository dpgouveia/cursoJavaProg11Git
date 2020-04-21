package s23.WorkshopJavaFXJdbc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import s23.WorkshopJavaFXJdbc.gui.util.Constraints;

public class DepartmentFormController implements Initializable{

	// atributos
	@FXML private TextField txtDepartmentID;
	@FXML private TextField txtDepartmentName;
	@FXML private Label labelStatus;
	@FXML private Button btSaveAction;
	@FXML private Button btCancelAction;
	
	
	// métodos
	@FXML public void onBtSaveAction() {
		System.out.println();
		System.out.println("==== onBtSave()");
	}
	
	@FXML public void onBtCancelAction() {
		System.out.println();
		System.out.println("==== onBtCancel()");
	}
	
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtDepartmentID);
		Constraints.setTextFieldMaxLength(txtDepartmentName, 30);
	}
	

}
