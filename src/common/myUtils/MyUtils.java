package common.myUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MyUtils {

	// for test purposes
//	public static void main(String args[]) {
//		Scanner input = new Scanner(System.in);
//
//		Date data = MyUtils.readDate(input);
//		System.out.println(data);
//
//		input.close();
//	}

	public static int readInt(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber = "";
		boolean invalidString;
		do {
			invalidString = true;
			try {
				stringNumber = input.nextLine().trim();
				Integer.parseInt(stringNumber);
				invalidString = false;
			} catch (Exception e) {
			}
		} while (invalidString);

		return Integer.parseInt(stringNumber);
	}

	public static Integer readInteger(Scanner input) {
		return MyUtils.readInt(input);
	}

	public static double readDouble(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String stringNumber = "";
		boolean invalidString;
		do {
			invalidString = true;
			try {
				stringNumber = input.nextLine().trim().replace(",", ".");
				Double.parseDouble(stringNumber);
				invalidString = false;
			} catch (Exception e) {

			}
		} while (invalidString);

		return Double.parseDouble(stringNumber);
	}

	public static String readString(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		String string = "";
		boolean invalidString;
		do {
			invalidString = true;
			try {
				string = input.nextLine();
				if (string == null || string.isBlank() || string.isEmpty()) {
					throw new Exception("String is NULL, EMPTY or BLANK");
				}
				invalidString = false;
			} catch (Exception e) {
			}
		} while (invalidString);
		return string;
	}

	public static String readChar(Scanner input, String regex) {

		Locale.setDefault(Locale.US);
		input.reset();

		String string = "";
		boolean invalidString;

		do {
			invalidString = true;
			try {
				string = input.nextLine();
				if (string == null || string.isEmpty() || string.isBlank() || !string.matches(regex)) {
					throw new Exception("String is NULL, EMPTY, BLANK or DOESNT MATCH WITH REGEX PATTERN");
				}
				invalidString = false;
			} catch (Exception e) {
			}
		} while (invalidString);
		return string;
	}

	public static Date readDate(Scanner input) {

		Locale.setDefault(Locale.US);
		input.reset();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		String string;
		Date output = null;
		boolean invalidDate;

		do {
			invalidDate = true;
			string = input.nextLine().trim().toLowerCase();
			if (string.replace('/', ' ').replace(' ', '0').chars().allMatch(Character::isDigit)) {
				try {
					output = sdf.parse(string);
					invalidDate = false;
				} catch (Exception e) {
				}
			}
		} while (invalidDate);
		return output;
	}

}
