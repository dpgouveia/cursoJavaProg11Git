package s22.javafx.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import s22.javafx.model.entities.Person;

public class ViewController260 implements Initializable {

	// atributos
	@FXML
	private ComboBox<Person> comboBoxPerson;

	@FXML
	private ObservableList<Person> obsList;

	@FXML
	private Button btnShowAllItemsComboBox;

	// métodos
	@FXML
	public void onComboBoxPersonAction() {
		System.out.println();
		System.out.println("==== onComboBoxPersonAction(): ");
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}

	@FXML
	private void onBtnShowAllItemsComboBoxAction() {
		System.out.println();
		System.out.println("==== onBtnShowAllItemsComboBoxAction(): ");
		comboBoxPerson.getItems().forEach(System.out::println);
	}

	// métodos estáticos

	// Este método é executado quando o controlar for criado
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// criando uma lista fixa de valores
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));
		list.sort((p1, p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		});

		obsList = FXCollections.observableArrayList(list);
		comboBoxPerson.setItems(obsList);

		// codigo para ajustar os valores apresentados na lista (não utilizar o
		// toString() definido na classe Person
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {

			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName().toUpperCase());
			}

		};

		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));

	}

}
