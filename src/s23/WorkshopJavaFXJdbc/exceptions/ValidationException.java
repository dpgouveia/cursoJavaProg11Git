package s23.WorkshopJavaFXJdbc.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	// atributos estáticos
	private static final long serialVersionUID = 1L;

	// atritubos
	private Map<String, String> errors = new HashMap<String, String>();

	// getter e setters
	public Map<String, String> getErrors() {
		return errors;
	}

	// métodos
	public ValidationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public void addError(String fieldName, String errorMessage) {
		System.out.println();
		System.out.println(getClass() + " ==== addError()");
		
		errors.put(fieldName, errorMessage);
	}
	
	public boolean containErrors() {
		System.out.println();
		System.out.println(getClass() + " ==== containErrors()");
		
		return errors.size() > 0;
	}

}
