package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Position;
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

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
				
		if (piece != null && !this.isThereOpponentPiece(position)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean[][] possibleMoves() {

		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

		// obter a posicao da torre no tabuleiro
		Position evalMove = new Position(0, 0);

//		 avaliar posicao acima do rei
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn());
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao diagonal direta acima do rei
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao direita do rei
		evalMove.setValues(this.position.getRow(), this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao diagonal direta abaixo do rei
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao abaixo do rei
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn());
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao diagonal esquerda abaixo do rei
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao esquerda do rei
		evalMove.setValues(this.position.getRow(), this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

//		avaliar posicao diagonal esquerda acima do rei
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		return possibleMoves;

	}

}
