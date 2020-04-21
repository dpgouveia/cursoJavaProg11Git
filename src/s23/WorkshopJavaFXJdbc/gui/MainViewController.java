package s23.WorkshopJavaFXJdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	// m�todos JavaFX
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println();
		System.out.println("==== onMenuItemSellerAction() ");
	}

	@FXML
	public void onmenuItemDepartmentAction() {
		System.out.println();
		System.out.println("==== onmenuItemDepartmentAction() ");

		loadView("../gui/DepartmentList.fxml", 
				(DepartmentListController controller) -> {
					controller.setDepartmentService(new DepartmentService());
					controller.updateTableView();
				});
	}

	@FXML
	public void onmenuItemAboutAction() {
		System.out.println();
		System.out.println("==== onmenuItemAboutAction() ");

		loadView("../gui/AboutView.fxml", x -> {});
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			initializingAction.accept(loader.getController());
		
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}

	}

}