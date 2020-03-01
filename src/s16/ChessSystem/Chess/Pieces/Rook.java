package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.Enum.Color;

public class Rook extends ChessPiece {

	// construtores
	public Rook(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return " WR ";
		} else {
			return " BR ";
		}
	}

	@Override
	public Boolean[][] possibleMoves() {
		Boolean possibleMoves[][] = new Boolean[this.getBoard().getRows()][this.getBoard().getColumns()];  
		return possibleMoves;
	}
	
}
