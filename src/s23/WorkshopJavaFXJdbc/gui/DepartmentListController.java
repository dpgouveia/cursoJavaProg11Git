package s23.WorkshopJavaFXJdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import common.utils.db.DBException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import s23.WorkshopJavaFXJdbc.application.Main;
import s23.WorkshopJavaFXJdbc.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.gui.listerners.DataChangeListener;
import s23.WorkshopJavaFXJdbc.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListener {

	// atributos
	@FXML private Button btNewDepartment;
	@FXML private TableView<Department> tableViewDepartment;
	@FXML private TableColumn<Department, Integer> tableColumnId;
	@FXML private TableColumn<Department, String> tableColumnName;
	@FXML private TableColumn<Department, Department> tableColumnEdit;
	@FXML private TableColumn<Department, Department> tableColumnRemove;
	private DepartmentService service;
	private ObservableList<Department> obsList;
	
	// getters e setters
	public void setDepartmentService(DepartmentService service) {
		System.out.println();
		System.out.println(getClass() + "  ==== setDepartmentService()");
		
		this.service = service;
	}

	// métodos
	@FXML public void onBtNewDepartmentAction(ActionEvent event) {
		System.out.println();
		System.out.println(getClass() + " ==== onBtNewDepartmentAction()");
		
		Department dept = new Department();
		createDialogForm(dept, "../gui/DepartmentForm.fxml", Utils.currentStage(event));
		
	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		System.out.println();
		System.out.println(getClass() +  " ==== initialize()");
		
		initializeNodes();
	}
	
	private void initializeNodes() {
		System.out.println();
		System.out.println(getClass() + " ==== initializeNodes()");
		
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void updateTableView() {
		System.out.println();
		System.out.println(getClass() + " ==== updateTableView()");
		
		if(service == null) {
			throw new MainException("DepartmentService IS NULL");
		}
		
		obsList = FXCollections.observableArrayList(service.findAll());
		tableViewDepartment.setItems(obsList);
		initEditButtons();
		initRemoveButtons();

	}
	
	private void createDialogForm(Department dept, String absoluteName, Stage parentStage) {
		System.out.println();
		System.out.println(getClass() + " ==== createDialogForm()");
		
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

	@Override public void onDataChanged() {
		System.out.println();
		System.out.println(getClass() + " ==== onDataChanged()");
		
		updateTableView();
	}
	
	private void initEditButtons() {
		System.out.println();
		System.out.println(getClass() + " ==== initEditButtons()");
		
		tableColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEdit.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button editButton = new Button("Edit");
										
			@Override protected void updateItem(Department dept, boolean empty) {
				super.updateItem(dept, empty);
				
				this.setAlignment(Pos.CENTER);
				
				if(empty || dept == null) {
					setGraphic(null);
					return;
				}
											
				setGraphic(editButton);
				editButton.setOnAction(event -> createDialogForm(dept, "../gui/DepartmentForm.fxml", Utils.currentStage(event)));
											
			}			
		});
				
	}
	
	private void initRemoveButtons() {
		System.out.println();
		System.out.println(getClass() + " ==== initRemoveButtons()");
		
		tableColumnRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnRemove.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button removeButton = new Button("Delete");
										
			@Override protected void updateItem(Department dept, boolean empty) {
				super.updateItem(dept, empty);
				
				this.setAlignment(Pos.CENTER);
				
				if(empty || dept == null) {
					setGraphic(null);
					return;
				}
											
				setGraphic(removeButton);
				removeButton.setOnAction(event -> removeEntity(dept));								
			}						
		});
				
	}

	private void removeEntity(Department dept) {
		
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you sure do you want to delete this entity from database?");
		if(result.get() == ButtonType.OK ) {
			
			if(service == null) {
				throw new MainException("DepartmentService IS NULL");
			}
			
			try {
				service.remove(dept);
				updateTableView();
			} catch (MainException | DBException e) {
				Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
			}
	
		}
	}
	
}
