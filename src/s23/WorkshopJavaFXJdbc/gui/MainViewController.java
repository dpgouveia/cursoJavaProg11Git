package s23.WorkshopJavaFXJdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import s22.javafx.gui.util.Alerts;
import s23.WorkshopJavaFXJdbc.application.Main;
import s23.WorkshopJavaFXJdbc.model.services.DepartmentService;

public class MainViewController implements Initializable {

	// atributos JavaFX
	@FXML private MenuItem menuItemSeller;
	@FXML private MenuItem menuItemDepartment;
	@FXML private MenuItem menuItemAbout;

	// m�todos JavaFX
	@FXML public void onMenuItemSellerAction() {
		System.out.println();
		System.out.println("==== onMenuItemSellerAction() ");
	}

	@FXML public void onmenuItemDepartmentAction() {
		System.out.println();
		System.out.println("==== onmenuItemDepartmentAction() ");
		
		loadView2("../gui/DepartmentList.fxml");
	}

	@FXML public void onmenuItemAboutAction() {
		System.out.println();
		System.out.println("==== onmenuItemAboutAction() ");
		
		loadView("../gui/AboutView.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}
	
	private synchronized void loadView(String absoluteName) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		} catch(IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
		
	}
	
	private synchronized void loadView2(String absoluteName) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			DepartmentListController dsc = loader.getController();
			dsc.setDepartmentService(new DepartmentService());
			dsc.updateTableView();
			
		} catch(IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
		
	}

}
