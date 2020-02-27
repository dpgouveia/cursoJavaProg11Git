package s16.ChessSystem.Application;

import s16.ChessSystem.Chess.ChessPiece;

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

}
