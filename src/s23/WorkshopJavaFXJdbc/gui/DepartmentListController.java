package s23.WorkshopJavaFXJdbc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import s23.WorkshopJavaFXJdbc.application.Main;
import s23.WorkshopJavaFXJdbc.model.entities.Department;

public class DepartmentListController implements Initializable {

	// atributos
	@FXML private Button btNewDepartment;
	@FXML private TableView<Department> tableViewDepartment;
	@FXML private TableColumn<Department, Integer> tableColumnId;
	@FXML private TableColumn<Department, String> tableColumnName;

	// métodos
	@FXML public void onBtNewDepartmentAction() {
		System.out.println();
		System.out.println("==== onBtNewDepartmentAction()");
	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
	
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
	}

}
