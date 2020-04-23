package s23.WorkshopJavaFXJdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import s23.WorkshopJavaFXJdbc.application.Main;
import s23.WorkshopJavaFXJdbc.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.gui.listerners.DataChangeListener;
import s23.WorkshopJavaFXJdbc.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Seller;
import s23.WorkshopJavaFXJdbc.model.services.SellerService;

public class SellerListController implements Initializable, DataChangeListener {

	// atributos
	@FXML private Button btNewSeller;
	@FXML private TableView<Seller> tableViewSeller;
	@FXML private TableColumn<Seller, Integer> tableColumnSellerId;
	@FXML private TableColumn<Seller, String> tableColumnSellerName;
	@FXML private TableColumn<Seller, String> tableColumnSellerEmail;
	@FXML private TableColumn<Seller, Date> tableColumnSellerBirthDate;
	@FXML private TableColumn<Seller, Double> tableColumnSellerBaseSalary;
	@FXML private TableColumn<Seller, Integer> tableColumnDepartmentID;
	@FXML private TableColumn<Seller, Seller> tableColumnEdit;
	@FXML private TableColumn<Seller, Seller> tableColumnRemove;
	private SellerService service;
	private ObservableList<Seller> obsList;
	
	// getters e setters
	public void setSellerService(SellerService service) {
		System.out.println();
		System.out.println(getClass() + " ==== setSellerService()");
		
		this.service = service;
	}
	
	
	// métodos
	@FXML public void onBtNewSellerAction(ActionEvent event) {
		System.out.println();
		System.out.println(getClass() + " ==== onBtNewSellerAction()");
		
		Seller seller = new Seller();
		createDialogForm(seller, "", Utils.currentStage(event));   // necessita do form
		
	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		System.out.println();
		System.out.println(getClass() + " ==== initialize()");
		
		initializeNodes();
	}

	private void initializeNodes() {
		System.out.println();
		System.out.println(getClass() + " ==== initializeNodes()");
		
		tableColumnSellerId.setCellValueFactory(new PropertyValueFactory<Seller, Integer>("id"));
		tableColumnSellerName.setCellValueFactory(new PropertyValueFactory<Seller, String>("name"));
		tableColumnSellerEmail.setCellValueFactory(new PropertyValueFactory<Seller, String>("email"));
		tableColumnSellerBirthDate.setCellValueFactory(new PropertyValueFactory<Seller, Date>("birthDate"));
		tableColumnSellerBaseSalary.setCellValueFactory(new PropertyValueFactory<Seller, Double>("baseSalary"));
		tableColumnDepartmentID.setCellValueFactory(new PropertyValueFactory<Seller, Integer>("departmentId"));
		
		Utils.formatTableColumnDate(tableColumnSellerBirthDate, "dd/MM/yyyy");
		Utils.formatTableColumnDouble(tableColumnSellerBaseSalary, 2);
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewSeller.prefHeightProperty().bind(stage.heightProperty());
	}
	
	@Override public void onDataChanged() {
		System.out.println();
		System.out.println(getClass() + " ==== onDataChanged()");
		
		updateTableView();
	}
	
	public void updateTableView() {
		System.out.println();
		System.out.println(getClass() + " ==== updateTableView()");
		
		if(service == null) {
			throw new MainException("SellerService IS NULL!");
		}
		
		obsList = FXCollections.observableArrayList(service.findAll());
		tableViewSeller.setItems(obsList);
		
		initEditButtons();
		initRemoveButtons();
	}

	private void initEditButtons() {
		System.out.println();
		System.out.println(getClass() + " ==== initEditButtons()");
		
		tableColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEdit.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button editButton = new Button("Edit");
										
			@Override protected void updateItem(Seller seller, boolean empty) {
				super.updateItem(seller, empty);
				
				this.setAlignment(Pos.CENTER);
				
				if(seller == null) {
					setGraphic(null);
					return;
				}
											
				setGraphic(editButton);
				editButton.setOnAction(event -> createDialogForm(seller, "", Utils.currentStage(event))); // necessita do form
											
			}			
		});
		
	}
	
	private void initRemoveButtons() {
		System.out.println();
		System.out.println(getClass() + " ==== initRemoveButtons()");
		
		tableColumnRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnRemove.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button removeButton = new Button("Delete");
										
			@Override protected void updateItem(Seller seller, boolean empty) {
				super.updateItem(seller, empty);
				
				this.setAlignment(Pos.CENTER);
				
				if(seller == null) {
					setGraphic(null);
					return;
				}
											
				setGraphic(removeButton);
				removeButton.setOnAction(event -> removeEntity(seller));								
			}						
		});
		
	}
	
	private void createDialogForm(Seller seller, String absoluteName, Stage currentStage) {
		System.out.println();
		System.out.println(getClass() + " ==== createDialogForm()");
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter seller data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(currentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	protected void removeEntity(Seller seller) {
		System.out.println();
		System.out.println(getClass() + " ==== removeEntity()");
		
		Optional<ButtonType> result =  Alerts.showConfirmation("Confirmation", "Are you sure do you want to remove this entity from database?");
		
		if(result.get() == ButtonType.OK) {
			
			if(service == null) {
				throw new MainException("SellerService IS NULL!");
			}
			
			try {
				service.remove(seller);
				updateTableView();	
			} catch (MainException | DBException e) {
				Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
			}
		}
	}


}
