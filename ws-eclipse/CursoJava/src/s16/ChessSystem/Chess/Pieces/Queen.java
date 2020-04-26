package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.Enum.Color;

public class Queen extends ChessPiece {

	// construtores
	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public boolean[][] possibleMoves() {
		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		Position evalMove = new Position(0, 0);

		// N
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn());
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow() - 1, evalMove.getColumn());
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// NW
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow() - 1, evalMove.getColumn() + 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// W
		evalMove.setValues(this.position.getRow(), this.position.getColumn() + 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow(), evalMove.getColumn() + 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// SW
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow() + 1, evalMove.getColumn() + 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// S
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn());
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow() + 1, evalMove.getColumn());
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// SE
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow() + 1, evalMove.getColumn() - 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// E
		evalMove.setValues(this.position.getRow(), this.position.getColumn() - 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow(), evalMove.getColumn() - 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// NE
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setValues(evalMove.getRow() - 1, evalMove.getColumn() - 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		return possibleMoves;
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "WQ";
		} else {
			return "BQ";
		}
	}

}
