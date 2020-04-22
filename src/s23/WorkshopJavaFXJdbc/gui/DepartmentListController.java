package s23.WorkshopJavaFXJdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import s22.javafx.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.application.Main;
import s23.WorkshopJavaFXJdbc.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.gui.listerners.DataChangeListener;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListener {

	// atributos
	@FXML private Button btNewDepartment;
	@FXML private TableView<Department> tableViewDepartment;
	@FXML private TableColumn<Department, Integer> tableColumnId;
	@FXML private TableColumn<Department, String> tableColumnName;
	private DepartmentService service;
	private ObservableList<Department> obsList;
	
	// getters e setters
	public void setDepartmentService(DepartmentService service) {
		System.out.println();
		System.out.println("==== setDepartmentService()");
		
		this.service = service;
	}

	// métodos
	@FXML public void onBtNewDepartmentAction(ActionEvent event) {
		System.out.println();
		System.out.println("==== onBtNewDepartmentAction()");
		
		Department dept = new Department();
		createDialogForm(dept, "../gui/DepartmentForm.fxml", Utils.currentStage(event));
		
	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		System.out.println();
		System.out.println("==== initialize()");
		
		initializeNodes();
	}
	
	private void initializeNodes() {
		System.out.println();
		System.out.println("==== initializeNodes()");
		
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void updateTableView() {
		System.out.println();
		System.out.println("==== updateTableView()");
		
		if(service == null) {
			throw new MainException("service IS NULL!");
		}
		
		obsList = FXCollections.observableArrayList(service.findAll());
		tableViewDepartment.setItems(obsList);

	}
	
	private void createDialogForm(Department dept, String absoluteName, Stage parentStage) {
		System.out.println();
		System.out.println("==== createDialogForm()");
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			DepartmentFormController controller = loader.getController();
			controller.setDepartment(dept);
			controller.setDepartmentService(service);
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter department data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
		
	}

	@Override
	public void onDataChanged() {
		System.out.println();
		System.out.println("==== onDataChanged()");
		
		updateTableView();
	}

}
