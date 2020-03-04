package s16.ChessSystem.Application;

import java.util.Locale;
import java.util.Scanner;

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
			while (true) {
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

				} catch (ChessException e) {
					System.out.println(e);
					input.hasNextLine();
				} 
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println();
			System.out.println("--------------------");
			System.out.println("FIM DO PROGRAMA");
			input.hasNextLine();
		} finally {
			input.close();
		}

	}

}
