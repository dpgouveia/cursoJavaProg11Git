package s23.WorkshopJavaFXJdbc.gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import s23.WorkshopJavaFXJdbc.exceptions.MainException;
import s23.WorkshopJavaFXJdbc.exceptions.ValidationException;
import s23.WorkshopJavaFXJdbc.gui.listerners.DataChangeListener;
import s23.WorkshopJavaFXJdbc.gui.util.Constraints;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.entities.Seller;
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
	
	
	// getters e setters
	public void setSeller(Seller seller) {
		System.out.println();
		System.out.println(getClass() + " ==== setSeller()");
		
		entity = seller;
	}
	
	public void setService(SellerService service) {
		System.out.println();
		System.out.println(getClass() + " ==== setService()");
		
		this.service = service;
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
		
	}
	
	@FXML public void onBtSaveAction() {
		System.out.println();
		System.out.println(getClass() + " ==== onBtSaveAction()");
		
		if(entity == null) {
			throw new MainException("Entity object IS NULL!");
		}
		
		if(service == null) {
			throw new MainException("SellerService IS NULL!");
		}
		
		try {
			entity = getFormData();
		} catch(ValidationException e) {
			setErrorMessages(e.getErrors());
		}
		
		notifyChangedListeners();
		
	}
	
	private void setErrorMessages(Map<String, String> errors) {
		System.out.println();
		System.out.println(getClass() + " ==== setErrorMessages()");
		
		if(errors.keySet().contains("SellerName")) {
			lblErrSellerName.setText(errors.get("SellerName"));
		}
		
		if(errors.keySet().contains("SellerEmail")) {
			lblErrSellerEmail.setText(errors.get("SellerEmail"));
		}
		
		if(errors.keySet().contains("SellerBirthDate")) {
			lblErrSellerBirthDate.setText(errors.get("SellerBirthDate"));
		}
		
		if(errors.keySet().contains("SellerBaseSalary")) {
			lblErrSellerBaseSalary.setText(errors.get("SellerBaseSalary"));
		}
		
	}

	private Seller getFormData() {
		System.out.println();
		System.out.println(getClass() + " ==== getFormData()");
		
		ValidationException exception = new ValidationException("Validation error");
		if(txtSellerName == null || txtSellerName.getText().trim().isBlank() || txtSellerName.getText().trim().isEmpty()) {
			exception.addError("SellerName", "Field is empty or blank!");
		}
		
		if(txtSellerEmail == null || txtSellerEmail.getText().trim().isBlank() || txtSellerEmail.getText().trim().isEmpty()) {
			exception.addError("SellerEmail", "Field is empty or blank!");
		}
		
		if(dpBirthDate.getValue() == null) {
			exception.addError("SellerBirthDate", "Field is empty or blank!");
		}
		
		if(txtSellerBaseSalary == null || txtSellerBaseSalary.getText().trim().isBlank() || txtSellerBaseSalary.getText().trim().isEmpty()) {
			exception.addError("SellerBaseSalary", "Field is empty or blank!");
		}
		
		if(exception.containErrors()) {
			throw exception;
		}
		
		Integer sellerId = Utils.tryParseToInt(txtSellerId.getText());
		String sellerName = txtSellerName.getText().trim();
		String sellerEmail = txtSellerEmail.getText().trim();
		Double sellerBaseSalary = Double.valueOf(txtSellerBaseSalary.getText().replace(',', '.'));
		Date sellerBirthDate = Date.from(dpBirthDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return null;
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
		
		Constraints.setTextFieldInteger(txtSellerId);
		Constraints.setTextFieldMaxLength(txtSellerName, 100);
		Constraints.setTextFieldMaxLength(txtSellerEmail, 100);
		Constraints.setTextFieldDouble(txtSellerBaseSalary);
		
	}
	
}
