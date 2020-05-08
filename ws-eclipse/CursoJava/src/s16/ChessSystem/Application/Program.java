package s16.ChessSystem.Application;

import java.util.Locale;
import java.util.Scanner;

import common.utils.MyUtils;
import s16.ChessSystem.Chess.ChessMatch;
import s16.ChessSystem.Chess.ChessPosition;
import s16.ChessSystem.Chess.Exceptions.ChessException;

public class Program {

	public static void main(String args[]) {

//		Position pos = new Position(3, 5);
//		System.out.println(pos);
//		
//		Board board = new Board(8,8);

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		ChessMatch chessMatch = new ChessMatch();

		try {
			while (!chessMatch.getCheckMate()) {
				try {
					ChessUI.clearScreen();
					ChessUI.printMatch(chessMatch);
					System.out.print("Source: ");
					ChessPosition source = ChessUI.readChessPosition(input);

					boolean possibleMoves[][] = chessMatch.possibleMoves(source);

					ChessUI.clearScreen();
					ChessUI.printBoard(chessMatch.getPieces(), possibleMoves);

					System.out.print("Target: ");
					ChessPosition target = ChessUI.readChessPosition(input);

					chessMatch.performChessMove(source, target);

					if (chessMatch.getPromoted() != null) {

						String type = "";
						boolean invalidType = true;
						while (invalidType) {
							System.out.print("Enter piece for promotion (B/N/R/Q): ");
							type = MyUtils.readString(input).trim().toUpperCase();
							if (type.charAt(0) == 'B' || type.charAt(0) == 'N' || type.charAt(0) == 'R'
									|| type.charAt(0) == 'Q') {
								invalidType = false;
							}
						}
						chessMatch.replacePromotedPiece(type);
					}

				} catch (ChessException e) {
					System.out.println(e);
					input.hasNextLine();
				}
			}

			ChessUI.clearScreen();
			ChessUI.printMatch(chessMatch);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
			System.out.println();
			System.out.println("--------------------");
			System.out.println("FIM DO PROGRAMA");
		}

	}

}
