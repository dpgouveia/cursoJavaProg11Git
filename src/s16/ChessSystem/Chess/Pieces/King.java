package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.Enum.Color;

public class King extends ChessPiece {

	// construtores
	public King(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "WK";
		} else {
			return "BK";
		}
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		return possibleMoves;
	}

}
