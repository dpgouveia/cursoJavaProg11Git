package myUtils;

import java.util.Locale;
import java.util.Scanner;

public class MyUtils {

	public static int readInt(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber;
		do {
			stringNumber = input.nextLine().trim();
		} while (stringNumber.isEmpty() || stringNumber.isBlank()
				|| !(stringNumber.matches("[0-9]*") || stringNumber.matches("-[0-9]*")));

		return Integer.parseInt(stringNumber);
	}

	public static Integer readInteger(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber;
		do {
			stringNumber = input.nextLine().trim();
		} while (stringNumber.isEmpty() || stringNumber.isBlank()
				|| !(stringNumber.matches("[0-9]*") || stringNumber.matches("-[0-9]*")));

		return Integer.valueOf(stringNumber);
	}

	public static double readDouble(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber;
		do {
			stringNumber = input.nextLine().trim();
		} while (stringNumber.isEmpty() || stringNumber.isBlank()
				|| !(stringNumber.matches("[0-9]*") || stringNumber.matches("[0-9]*.[0-9]*")
						|| stringNumber.matches(".[0-9]*") || stringNumber.matches("-[0-9]*")
						|| stringNumber.matches("-[0-9]*.[0-9]*") || stringNumber.matches("-.[0-9]*")));

		return Double.parseDouble(stringNumber);
	}

	public static String readString(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String string;
		do {
			string = input.nextLine();
		} while (string.isEmpty() || string.isBlank());

		return string;
	}

	public static String readChar(Scanner input, String regex) {

		Locale.setDefault(Locale.US);
		input.reset();

		String string;
		if (regex.isBlank() || regex.isEmpty()) {
			do {
				string = input.nextLine();
			} while (string.isEmpty() || string.isBlank());
		} else {
			do {
				string = input.nextLine();
			} while (string.isEmpty() || string.isBlank() || !string.matches(regex));
		}

		return string;
	}

}
