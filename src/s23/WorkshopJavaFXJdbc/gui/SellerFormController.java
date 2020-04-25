package s23.WorkshopJavaFXJdbc.gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import common.utils.db.DBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import s23.WorkshopJavaFXJdbc.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.exceptions.ValidationException;
import s23.WorkshopJavaFXJdbc.gui.listerners.DataChangeListener;
import s23.WorkshopJavaFXJdbc.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.gui.util.Constraints;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.entities.Seller;
import s23.WorkshopJavaFXJdbc.model.services.DepartmentService;
import s23.WorkshopJavaFXJdbc.model.services.SellerService;

public class SellerFormController implements Initializable {

	// atributos
	@FXML private TextField txtSellerId;
	@FXML private TextField txtSellerName;
	@FXML private TextField txtSellerEmail;
	@FXML private DatePicker dpBirthDate;
	@FXML private TextField txtSellerBaseSalary;
	@FXML private ComboBox<Department> cmbBxDepartment;
	@FXML private Label lblErrSellerName;
	@FXML private Label lblErrSellerEmail;
	@FXML private Label lblErrSellerBirthDate;
	@FXML private Label lblErrSellerBaseSalary;
	@FXML private Label lblErrSellerDepartment;
	@FXML private Button btSave;
	@FXML private Button btCancel;
	private Seller entity;
	private SellerService service;
	private List<DataChangeListener> targetListerners = new ArrayList<DataChangeListener>();
	private DepartmentService departmentService;
	private ObservableList<Department> obsCmbBxDepartment;
	
	
	// getters e setters
	public void setSeller(Seller seller) {
		System.out.println();
		System.out.println(getClass() + " ==== setSeller()");
		
		entity = seller;
	}
	
	public void setServices(SellerService service, DepartmentService departmentService) {
		System.out.println();
		System.out.println(getClass() + " ==== setService()");
		
		this.service = service;
		this.departmentService = departmentService;
	}
	
	
	// métodos
	public void notifyChangedListeners() {
		System.out.println();
		System.out.println(getClass() + " ==== notifyChangedListeners()");
		
		targetListerners.forEach(DataChangeListener::onDataChanged);
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		System.out.println();
		System.out.println(getClass() + " ==== subscribeDataChangeListener()");
		
		targetListerners.add(listener);
	}
	
	public void updateFormData() {
		System.out.println();
		System.out.println(getClass() + " ==== updateFormData()");
		
		if(entity == null) {
			throw new MainException("Seller entity IS NULL!");
		}
			
		txtSellerId.setText(String.valueOf(entity.getId()));
		txtSellerName.setText(entity.getName());
		txtSellerEmail.setText(entity.getEmail());
		txtSellerBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
		
		if(entity.getBirthDate() != null) {
			dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
		}
		
		if(entity.getDepartament() != null) {
			cmbBxDepartment.setValue(entity.getDepartament());
		} 

	}
	
	@FXML public void onBtSaveAction(ActionEvent event) {
		System.out.println();
		System.out.println(getClass() + " ==== onBtSaveAction()");
		
		if(entity == null) {
			throw new MainException("Entity object IS NULL!");
		}
		
		if(service == null) {
			throw new MainException("SellerService IS NULL!");
		}
		
		try {
			clearErrorMessages();
			entity = getFormData();
			service.saveOrUpdate(entity);
			notifyChangedListeners();
			Utils.currentStage(event).close();
		} catch(ValidationException e) {
			setErrorMessages(e.getErrors());
		} catch (DBException e) {
			Alerts.showAlert("DBException", null, e.getMessage(), AlertType.ERROR);
		}
			
	}
	
	private void clearErrorMessages() {
		System.out.println();
		System.out.println(getClass() + " ==== clearErrorMessages()");
		
		lblErrSellerName.setText("");
		lblErrSellerEmail.setText("");
		lblErrSellerBirthDate.setText("");
		lblErrSellerBaseSalary.setText("");
		lblErrSellerDepartment.setText("");
		
	}

	private void setErrorMessages(Map<String, String> errors) {
		System.out.println();
		System.out.println(getClass() + " ==== setErrorMessages()");
			
		lblErrSellerName.setText(errors.keySet().contains("SellerName") ? errors.get("SellerName") : "");
		lblErrSellerEmail.setText(errors.keySet().contains("SellerEmail") ? errors.get("SellerEmail") : "");
		lblErrSellerBirthDate.setText(errors.keySet().contains("SellerBirthDate") ? errors.get("SellerBirthDate") : "");
		lblErrSellerBaseSalary.setText(errors.keySet().contains("SellerBaseSalary") ? errors.get("SellerBaseSalary") : "");
		lblErrSellerDepartment.setText(errors.keySet().contains("SellerDepartment") ? errors.get("SellerDepartment") : "");
		
	}

	private Seller getFormData() {
		System.out.println();
		System.out.println(getClass() + " ==== getFormData()");
		
		ValidationException exception = new ValidationException("Validation error");
		if(txtSellerName.getText() == null || txtSellerName.getText().trim().isBlank() || txtSellerName.getText().trim().isEmpty()) {
			exception.addError("SellerName", "Field is empty or blank!");
		}
		
		if(txtSellerEmail.getText() == null || txtSellerEmail.getText().trim().isBlank() || txtSellerEmail.getText().trim().isEmpty()) {
			exception.addError("SellerEmail", "Field is empty or blank!");
		}
		
		if(dpBirthDate.getEditor().getText() == null || dpBirthDate.getEditor().getText().trim().isBlank() || dpBirthDate.getEditor().getText().trim().isEmpty()) {
			exception.addError("SellerBirthDate", "Field is empty or blank!");
		}
		
		if(!exception.getErrors().containsKey("SellerBirthDate")) {
			try {
				LocalDate.parse(dpBirthDate.getEditor().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			} catch(DateTimeParseException e) {
				exception.addError("SellerBirthDate", "Invalid date value! Cause: " + e.getMessage());
			}
		}
		
		if(txtSellerBaseSalary.getText() == null || txtSellerBaseSalary.getText().trim().isBlank() || txtSellerBaseSalary.getText().trim().isEmpty()) {
			exception.addError("SellerBaseSalary", "Field is empty or blank!");
		}
		
		if(txtSellerBaseSalary.getText().trim().replace(',','0').replace('.', '0').chars().anyMatch(Character::isAlphabetic)  ) {
			exception.addError("SellerBaseSalary", "Invalid number format!");
		}
		
		if(!exception.getErrors().containsKey("SellerBaseSalary")) {
			try {
				Double.valueOf(txtSellerBaseSalary.getText().replace(',', '.'));
			} catch(NumberFormatException e) {
				exception.addError("SellerBaseSalary", "Invalid number format! Cause: " + e.getMessage() );
			}	
		}
		
		if(cmbBxDepartment.getValue() == null) {
			exception.addError("SellerDepartment", "Field is empty or blank");
		}
		
		if(exception.containErrors()) {
			throw exception;
		}
		
		Integer sellerId = Utils.tryParseToInt(txtSellerId.getText());
		String sellerName = txtSellerName.getText().trim();
		String sellerEmail = txtSellerEmail.getText().trim();
//		Date sellerBirthDate = Date.from(dpBirthDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date sellerBirthDate = Date.from(LocalDate.parse(dpBirthDate.getEditor().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Double sellerBaseSalary = Double.valueOf(txtSellerBaseSalary.getText().replace(',', '.'));
		Department dept = cmbBxDepartment.getValue();
		
		return new Seller(sellerId, sellerName, sellerEmail, sellerBirthDate, sellerBaseSalary, dept);
	}

	@FXML public void onBtCancelAction(ActionEvent event) {
		System.out.println();
		System.out.println(getClass() + " ==== onBtCancelAction()");
		
		Utils.currentStage(event).close();

	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		System.out.println();
		System.out.println(getClass() + " ==== initialize()");
		
		initializeNodes();
	}

	private void initializeNodes() {
		System.out.println();
		System.out.println(getClass() + " ==== initializeNodes()");
		
		initializeComboBoxDepartment();
		
		Constraints.setTextFieldInteger(txtSellerId);
		Constraints.setTextFieldMaxLength(txtSellerName, 100);
		Constraints.setTextFieldMaxLength(txtSellerEmail, 100);
		Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");
		Constraints.setTextFieldDouble(txtSellerBaseSalary);
		
	}
	
	public void loadAssociatedObjects() {
		System.out.println();
		System.out.println(getClass() + " ==== loadAssociatedObjects()");
		
		if(departmentService == null) {
			throw new MainException("DepartmentService object IS NULL");
		}
		
		obsCmbBxDepartment = FXCollections.observableArrayList(departmentService.findAll());
		cmbBxDepartment.setItems(obsCmbBxDepartment);
	}
	
	private void initializeComboBoxDepartment() {
		
		// Coding functional interfaces
		// Callback --- cmbBxDepartment factory
		Callback<ListView<Department>, ListCell<Department>> factory = new Callback<ListView<Department>, ListCell<Department>>() {
		
			@Override public ListCell<Department> call(ListView<Department> factory) {
				ListCell<Department> cell = new ListCell<Department>() {
					
					@Override protected void updateItem(Department dept, boolean empty) {
						super.updateItem(dept, empty);
						setText(empty ? "" : dept.getName().toUpperCase());
					}
					
				};
				
				return cell;
			}
		};
		
		System.out.println();
		System.out.println(getClass() + " ==== initializeComboBoxDepartment()");
		
		cmbBxDepartment.setCellFactory(factory);
		cmbBxDepartment.setButtonCell(factory.call(null));	
	}
	
}
