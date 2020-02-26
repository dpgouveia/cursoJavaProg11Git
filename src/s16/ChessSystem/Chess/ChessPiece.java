package s16.ChessSystem.Chess;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Piece;
import s16.ChessSystem.Chess.Enum.Color;

public class ChessPiece extends Piece {

	// atributos base
	private Color color;
	private Integer moveCount;
	
	// construtores
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// getters e setters
	public Color getColor() {
		return color;
	}	
	
}
