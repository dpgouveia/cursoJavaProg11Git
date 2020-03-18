package s16.ChessSystem.Application;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import common.myUtils.MyUtils;
import s16.ChessSystem.Chess.ChessMatch;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.ChessPosition;
import s16.ChessSystem.Chess.Enum.Color;
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

	public static void printPiecesOnTheBoard(List<ChessPiece> list) {
		System.out.println("Pieces on the board: ");
		if (list == null) {
			System.out.println("White: [ ]");
			System.out.println("Black: [ ]");
		} else {
			System.out.print("White: [ ");
			for (ChessPiece piece : list) {
				if (piece.getColor().equals(Color.WHITE)) {
					System.out.print(piece + " ");
				}
			}
			System.out.println("]");

			System.out.print("Black: [ ");
			for (ChessPiece piece : list) {
				if (piece.getColor().equals(Color.BLACK)) {
					System.out.print(piece + " ");
				}
			}
			System.out.println("]");
		}
	}

	public static void printCapturedPieces(List<ChessPiece> list) {
		System.out.println("Captured pieces: ");
		if (list == null) {
			System.out.println("White: [ ]");
			System.out.println("Black: [ ]");
		} else {
			System.out.print("White: [ ");
			for (ChessPiece piece : list) {
				if (piece.getColor().equals(Color.BLACK)) {
					System.out.print(piece + " ");
				}
			}
			System.out.println("]");

			System.out.print("Black: [ ");
			for (ChessPiece piece : list) {
				if (piece.getColor().equals(Color.WHITE)) {
					System.out.print(piece + " ");
				}
			}
			System.out.println("]");
		}
	}

	public static void printMatch(ChessMatch chessMatch) {
		ChessUI.printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting Player: " + chessMatch.getCurrentPlayer());
		if (chessMatch.getCheckMate()) {
			System.out.println("CHECK MATE!");
			System.out.println("WINNER: " + chessMatch.getCurrentPlayer());
		} else if (chessMatch.getCheck()) {
			System.out.println("CHECK!");
		}
		
		System.out.println();
		ChessUI.printPiecesOnTheBoard(chessMatch.getPiecesOnTheBoard());
		System.out.println();
		ChessUI.printCapturedPieces(chessMatch.getCapturedPieces());
		System.out.println();
	}

	public static void printBoard(ChessPiece pieces[][]) {

		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " | ");
			for (int j = 0; j < pieces[i].length; j++) {
				ChessUI.printPiece(pieces[i][j], false);
			}
			System.out.print(" | " + (8 - i));
			System.out.println();
		}
		System.out.println("   " + "  A  " + "  B  " + "  C  " + "  D  " + "  E  " + "  F  " + "  G  " + "  H  ");

	}

	public static void printBoard(ChessPiece pieces[][], boolean possibleMoves[][]) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " | ");
			for (int j = 0; j < pieces[i].length; j++) {
				ChessUI.printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.print(" | " + (8 - i));
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
