package s23.WorkshopJavaFXJdbc.gui;

import java.net.URL;
import java.util.ResourceBundle;

import common.utils.db.DBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import s22.javafx.exceptions.MainException;
import s22.javafx.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.gui.util.Constraints;
import s23.WorkshopJavaFXJdbc.gui.util.Utils;
import s23.WorkshopJavaFXJdbc.model.entities.Department;
import s23.WorkshopJavaFXJdbc.model.services.DepartmentService;

public class DepartmentFormController implements Initializable{

	// atributos
	@FXML private TextField txtDepartmentID;
	@FXML private TextField txtDepartmentName;
	@FXML private Label labelStatus;
	@FXML private Button btSaveAction;
	@FXML private Button btCancelAction;
	private Department entity;
	private DepartmentService service;
	
	// getters e setters
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	// métodos
	private Department getFormData() {
		Integer deptId = Utils.tryParseToInt(txtDepartmentID.getText());
		String deptName = txtDepartmentName.getText();
		return new Department(deptId, deptName);
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtDepartmentID);
		Constraints.setTextFieldMaxLength(txtDepartmentName, 30);
	}
	
	@FXML public void onBtSaveAction(ActionEvent event) {
		System.out.println();
		System.out.println("==== onBtSave()");
		
		if(entity == null) {
			throw new MainException("Department entity IS NULL!");
		}
		
		if(service == null) {
			throw new MainException("DepartmentService IS NULL");
		}
		
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.currentStage(event).close();
		} catch (DBException e) {
			Alerts.showAlert("Erro saving object", null, e.getMessage(), AlertType.ERROR);
		}
		
		
	}
	
	
	@FXML public void onBtCancelAction(ActionEvent event) {
		System.out.println();
		System.out.println("==== onBtCancel()");
		
		Utils.currentStage(event).close();
	}
	
	@Override public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initializeNodes();
	}
	
	public void updateFormData() {
		
		System.out.println();
		System.out.println("==== updateFormData()");
		
		if(entity == null) {
			throw new MainException("Department entity IS NULL");
		}
		
		txtDepartmentID.setText(String.valueOf(entity.getId()));
		txtDepartmentName.setText(entity.getName());
	}

}
