package s23.WorkshopJavaFXJdbc.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import common.utils.db.DBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import s22.javafx.exceptions.MainException;
import s22.javafx.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.exceptions.ValidationException;
import s23.WorkshopJavaFXJdbc.gui.listerners.DataChangeListener;
import s23.WorkshopJavaFXJdbc.gui.util.Constraints;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	// atributos
	@FXML private TextField txtDepartmentID;
	@FXML private TextField txtDepartmentName;
	@FXML private Label labelStatus;
	@FXML private Button btSaveAction;
	@FXML private Button btCancelAction;
	private Department entity;
	private DepartmentService service;
	private List<DataChangeListener> targetListeners = new ArrayList<DataChangeListener>();
	
	// getters e setters
	public void setDepartment(Department entity) {
		System.out.println();
		System.out.println(getClass() + " ==== setDepartment()");
		
		this.entity = entity;
	}
	
	public void setDepartmentService(DepartmentService service) {
		System.out.println();
		System.out.println(getClass() + " ==== setDepartmentService()");
		
		this.service = service;
	}
	
	// métodos
	private void notifyDataChangeListeners() {
		System.out.println();
		System.out.println(getClass() + " ==== notifyDataChangeListeners()");
		
		targetListeners.forEach(DataChangeListener::onDataChanged);
//		dataChangedListeners.forEach(x -> x.onDataChanged());
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		System.out.println();
		System.out.println(getClass() + " ==== subscribeDataChangeListener()");
		
		targetListeners.add(listener);
	}
	
	private Department getFormData() {
		System.out.println();
		System.out.println(getClass() + " ==== getFormData()");
		
		ValidationException exception = new ValidationException("Validation error");
		if(txtDepartmentName.getText() == null 
				|| txtDepartmentName.getText().trim().isBlank()
				|| txtDepartmentName.getText().trim().isEmpty()) {
			exception.addError("DepartmentName", "Field is empty or blank!");
		}
		
		if(exception.containErrors()) {
			throw exception;
		}
		
		Integer deptId = Utils.tryParseToInt(txtDepartmentID.getText());
		String deptName = txtDepartmentName.getText();
		
		return new Department(deptId, deptName);
	}
	
	private void initializeNodes() {
		System.out.println();
		System.out.println(getClass() + " ==== initializeNodes()");
		
		Constraints.setTextFieldInteger(txtDepartmentID);
		Constraints.setTextFieldMaxLength(txtDepartmentName, 30);
	}
	
	@FXML public void onBtSaveAction(ActionEvent event) {
		System.out.println();
		System.out.println(getClass() + " ==== onBtSave()");
		
		if(entity == null) {
			throw new MainException("Department entity IS NULL!");
		}
		
		if(service == null) {
			throw new MainException("DepartmentService IS NULL");
		}
		
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			notifyDataChangeListeners();
			Utils.currentStage(event).close();
		} catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		}catch (DBException e) {
			Alerts.showAlert("Erro saving object", null, e.getMessage(), AlertType.ERROR);
		}
		
	}
	
	@FXML public void onBtCancelAction(ActionEvent event) {
		System.out.println();
		System.out.println(getClass() + " ==== onBtCancel()");
		
		Utils.currentStage(event).close();
	}
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println();
		System.out.println(getClass() + " ==== initialize()");
		
		// TODO Auto-generated method stub
		initializeNodes();
	}
	
	public void updateFormData() {
		System.out.println();
		System.out.println(getClass() + " ==== updateFormData()");
		
		if(entity == null) {
			throw new MainException("Department entity IS NULL");
		}
		
		txtDepartmentID.setText(String.valueOf(entity.getId()));
		txtDepartmentName.setText(entity.getName());
	}
	
	private void setErrorMessages(Map<String, String> errors) {
		System.out.println();
		System.out.println(getClass() + " ==== setErrorMessages()");
		
		if(errors.keySet().contains("DepartmentName")) {
			labelStatus.setText(errors.get("DepartmentName"));
		}
	
	}

}
