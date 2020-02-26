package s16.ChessSystem.Application;

import s16.ChessSystem.BoardGame.Exceptions.BoardException;
import s16.ChessSystem.Chess.ChessMatch;

public class Program {

	public static void main(String args[]) {

//		Position pos = new Position(3, 5);
//		System.out.println(pos);
//		
//		Board board = new Board(8,8);

		try {
			ChessMatch cm = new ChessMatch();
			ChessUI.printBoard(cm.getPieces());
		} catch (BoardException e) {
			System.out.println(e);
		} catch (Exception e)  {
			System.out.println(e);
		}

	}

}
