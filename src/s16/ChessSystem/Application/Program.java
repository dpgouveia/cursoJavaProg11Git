package s16.ChessSystem.Application;

import java.util.Locale;
import java.util.Scanner;

import s16.ChessSystem.BoardGame.Exceptions.BoardException;
import s16.ChessSystem.Chess.ChessMatch;
import s16.ChessSystem.Chess.ChessPosition;

public class Program {

	public static void main(String args[]) {

//		Position pos = new Position(3, 5);
//		System.out.println(pos);
//		
//		Board board = new Board(8,8);
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		try {
			
			ChessMatch cm = new ChessMatch();
			
			while(true) {
				ChessUI.clearScreen();
				ChessUI.printBoard(cm.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = ChessUI.readChessPosition(input);
				
				System.out.print("Target: ");
				ChessPosition target = ChessUI.readChessPosition(input);
				
				cm.performChessMove(source, target);
				
			}
			
		} catch (BoardException e) {
			System.out.println(e);
		} catch (Exception e)  {
			System.out.println(e);
		}
		
		input.close();

	}

}
