package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.Enum.Color;

public class Pawn extends ChessPiece {

	// construtores
	public Pawn(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public boolean[][] possibleMoves() {
		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		Position evalMove = new Position(0, 0);

		if (this.getColor() == Color.WHITE) {

			// N
			boolean validLastMove = false;
			evalMove.setValues(this.position.getRow() - 1, this.position.getColumn());
			if (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
				validLastMove = true;
			}

			evalMove.setValues(this.position.getRow() - 2, this.position.getColumn());
			if (this.getMoveCount() == 0 && validLastMove && this.getBoard().positionExists(evalMove)
					&& !this.getBoard().thereIsAPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			}

			// NW
			evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
			if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			}

			// NE
			evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
			if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			}

		} else {

			// S
			boolean validLastMove = false;
			evalMove.setValues(this.position.getRow() + 1, this.position.getColumn());
			if (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
				validLastMove = true;
			}

			evalMove.setValues(this.position.getRow() + 2, this.position.getColumn());
			if (this.getMoveCount() == 0 && validLastMove && this.getBoard().positionExists(evalMove)
					&& !this.getBoard().thereIsAPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			}

			// SW
			evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
			if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			}

			// SE
			evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
			if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
				possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			}

		}

		return possibleMoves;
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "WP";
		} else {
			return "BP";
		}
	}

}
