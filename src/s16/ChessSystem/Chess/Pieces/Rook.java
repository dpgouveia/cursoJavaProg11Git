package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Position;
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
			return "WR";
		} else {
			return "BR";
		}
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

		// obter a posicao da torre no tabuleiro
		Position evalMove = new Position(0, 0);

		// identificar as casas livres acima da torre
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn());
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setRow(evalMove.getRow() - 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// identificar as casas livres a direita da torre
		evalMove.setValues(this.position.getRow(), this.position.getColumn() + 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setColumn(evalMove.getColumn() + 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// identificar as casas livres abaixo da torre
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn());
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setRow(evalMove.getRow() + 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// identificar as casas livres a esquerda da torre
		evalMove.setValues(this.position.getRow(), this.position.getColumn() - 1);
		while (this.getBoard().positionExists(evalMove) && !this.getBoard().thereIsAPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
			evalMove.setColumn(evalMove.getColumn() - 1);
		}
		if (this.getBoard().positionExists(evalMove) && this.isThereOpponentPiece(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		return possibleMoves;
	}

}
