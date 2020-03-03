package s16.ChessSystem.Application;

import java.io.IOException;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s16.ChessSystem.Chess.ChessMatch;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.ChessPosition;
import s16.ChessSystem.Chess.Exceptions.ChessException;

public class ChessUI {

	// metodos estaticos
	public static void clearScreen() throws IOException {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}

	public static void printMatch(ChessMatch chessMatch) {
		ChessUI.printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting Player: " + chessMatch.getCurrentPlayer());
		System.out.println();
	}

	public static void printBoard(ChessPiece pieces[][]) {

		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + "  ");
			for (int j = 0; j < pieces[i].length; j++) {
				ChessUI.printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("   " + "  A  " + "  B  " + "  C  " + "  D  " + "  E  " + "  F  " + "  G  " + "  H  ");

	}

	public static void printBoard(ChessPiece pieces[][], boolean possibleMoves[][]) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + "  ");
			for (int j = 0; j < pieces[i].length; j++) {
				ChessUI.printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("   " + "  A  " + "  B  " + "  C  " + "  D  " + "  E  " + "  F  " + "  G  " + "  H  ");

	}

	private static void printPiece(ChessPiece piece, boolean possibleMove) {

		if (possibleMove) {
			if (piece == null) {
				System.out.print("[--]");
			} else {
				System.out.print("[" + piece + "]");
			}
			System.out.print(" ");
		} else {
			if (piece == null) {
				System.out.print("----");
			} else {
				System.out.print(" " + piece + " ");
			}
			System.out.print(" ");
		}
	}

	public static ChessPosition readChessPosition(Scanner input) {

		try {
			String position = MyUtils.readString(input);
			return new ChessPosition(position.trim().toLowerCase().charAt(0), Integer.parseInt(position.substring(1)));
		} catch (RuntimeException e) {
			throw new ChessException("Error reading ChessPosition. Valid values are a1 to h8.");
		}

	}

}
