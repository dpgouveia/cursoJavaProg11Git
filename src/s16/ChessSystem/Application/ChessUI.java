package s16.ChessSystem.Application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.ChessPosition;

public class ChessUI {

	// metodos estaticos
	public static void printBoard(ChessPiece pieces[][]) {

		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + "  ");
			for (int j = 0; j < pieces[i].length; j++) {
				ChessUI.printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("   " + "  A  " + "  B  " + "  C  " + "  D  " + "  E  " + "  F  " + "  G  " + "  H  ");

	}

	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("----");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

	public static ChessPosition readChessPosition(Scanner input) {

		try {
			String position = MyUtils.readString(input);
			return new ChessPosition(position.trim().toLowerCase().charAt(0), Integer.parseInt(position.substring(1)));
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are a1 to h8.");
		}

	}

	public static void clearScreen() throws IOException {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}

}
