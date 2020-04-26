package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.Enum.Color;

public class Knight extends ChessPiece {

	// construtores
	public Knight(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public boolean[][] possibleMoves() {
		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		Position evalMove = new Position(0, 0);
			
		// M1 (+2+1)
		evalMove.setValues(this.position.getRow() + 2, this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// M2 (+2-1)
		evalMove.setValues(this.position.getRow() + 2, this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// M3 (-2+1)
		evalMove.setValues(this.position.getRow() - 2, this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// M4 (-2-1)
		evalMove.setValues(this.position.getRow() - 2, this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}
		
		// M5 (+1+2)
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() + 2);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}
		
		// M6 (+1-2)
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() - 2);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}
		
		// M7 (-1+2)
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() + 2);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}
		
		// M8 (-1-2)
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() - 2);
		if (this.getBoard().positionExists(evalMove) && (!this.getBoard().thereIsAPiece(evalMove) || this.isThereOpponentPiece(evalMove))) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}
		
		return possibleMoves;
	}

	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE) {
			return "WN";
		} else {
			return "BN";
		}
	}

}
