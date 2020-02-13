package myUtils;

import java.util.Locale;
import java.util.Scanner;

public class MyUtils {

	public static int readInt(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber;
		boolean invalidString = true;
		do {
			stringNumber = input.nextLine().trim();
			invalidString = stringNumber.isEmpty() || stringNumber.isBlank()
					|| !(stringNumber.matches("[0-9]*") || stringNumber.matches("-[0-9]*"));
		} while (invalidString);

		return Integer.parseInt(stringNumber);
	}

	public static Integer readInteger(Scanner input) {
		return MyUtils.readInt(input);
	}

	public static double readDouble(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber;
		boolean invalidString = true;
		do {
			stringNumber = input.nextLine().trim().replace(",", ".");
			invalidString = stringNumber.isEmpty() || stringNumber.isBlank()
					|| !(stringNumber.matches("[0-9]*") || stringNumber.matches("[0-9]*.[0-9]*")
							|| stringNumber.matches(".[0-9]*") || stringNumber.matches("-[0-9]*")
							|| stringNumber.matches("-[0-9]*.[0-9]*") || stringNumber.matches("-.[0-9]*"));
		} while (invalidString);

		return Double.parseDouble(stringNumber);
	}

	public static String readString(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String string;
		boolean invalidString = true;
		do {
			string = input.nextLine();
			invalidString = string.isEmpty() || string.isBlank();
		} while (invalidString);

		return string;
	}

	public static String readChar(Scanner input, String regex) {

		Locale.setDefault(Locale.US);
		input.reset();

		String string;
		boolean invalidString = true;
		if (regex.isBlank() || regex.isEmpty()) {
			do {
				string = input.nextLine();
				invalidString = string.isEmpty() || string.isBlank();
			} while (invalidString);
		} else {
			do {
				string = input.nextLine();
				invalidString = string.isEmpty() || string.isBlank() || !string.matches(regex);
			} while (invalidString);
		}

		return string;
	}

}
