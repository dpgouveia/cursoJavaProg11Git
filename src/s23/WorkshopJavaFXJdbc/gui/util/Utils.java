package s23.WorkshopJavaFXJdbc.gui.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class Utils {

	public static Stage currentStage(ActionEvent event) {
		System.out.println();
		System.out.println(Utils.class + " ==== currentStage()");

		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}

	public static Integer tryParseToInt(String str) {
		System.out.println();
		System.out.println(Utils.class + " ==== tryParseToInt()");

		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return null;
		}

	}

	public static <T> void formatTableColumnDate(TableColumn<T, Date> tableColumn, String format) {
		
		// Implementing functional interfaces:
		// Callback 
		Callback<TableColumn<T, Date>, TableCell<T, Date>> formattedDateColumn = new Callback<TableColumn<T, Date>, TableCell<T, Date>>() {
		
			// Redefinindo o método "updateItem" para atualizar o conteúdo de cada TableCell
			// para popular a célula com base em uma string formatada pela class
			// SimpleDateFormat
			@Override public TableCell<T, Date> call(TableColumn<T, Date> column) {
				TableCell<T, Date> cell = new TableCell<T, Date>() {
					SimpleDateFormat sdf = new SimpleDateFormat(format);					
					
					@Override protected void updateItem(Date date, boolean empty) {
						super.updateItem(date, empty);
						this.setAlignment(Pos.CENTER);

						if (empty || date == null) {
							setText(null);
						} else {
							setText(sdf.format(date));
						}
					}
					
				};
				return cell;
			}

		};

		// mainCode --- formatTableColumnDate()
		System.out.println();
		System.out.println(Utils.class + " ==== formatTableColumnDate()");
		
		tableColumn.setCellFactory(formattedDateColumn);
	}
	
	public static <T> void formatTableColumnDouble(TableColumn<T, Double> tableColumn, int decimalPlaces) {
		
		// Implementing functional interfaces:
		// Callback 
		Callback<TableColumn<T, Double>, TableCell<T, Double>> formattedDoubleColumn = new Callback<TableColumn<T,Double>, TableCell<T,Double>>() {

			@Override public TableCell<T, Double> call(TableColumn<T, Double> column) {
				TableCell<T, Double> cell = new TableCell<T, Double>() {
					
					@Override protected void updateItem(Double item, boolean empty) {
						super.updateItem(item, empty);
						
						if(empty || item == null) {
							setText(null);
						} else {
							setText(String.format("%." + decimalPlaces + "f", item));
						}
						
					}
				};
				
				return cell;
			}
			
		};
		
		// mainCode --- formatTableColumnDouble() 
		System.out.println();
		System.out.println(Utils.class + " ==== formatTableColumnDouble()");
		
		tableColumn.setCellFactory(formattedDoubleColumn);	
	}
	
	public static void formatDatePicker(DatePicker dp, String format) {
		System.out.println();
		System.out.println(Utils.class + " ==== formatDatePicker()");
		
		dp.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
			
			@Override
			public String toString(LocalDate localDate) {
				String output = localDate == null ? "" : localDate.format(formatter); 
				return output;
			}
			
			@Override
			public LocalDate fromString(String stringDate) {
				LocalDate localDate = (stringDate == null || stringDate.isBlank() || stringDate.isEmpty()) ? null : LocalDate.parse(stringDate, formatter);
				return localDate;
			}
		});
		
	}
	
	
	
}
