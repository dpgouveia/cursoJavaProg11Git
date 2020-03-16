package s16.ChessSystem.Chess.Pieces;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.ChessMatch;
import s16.ChessSystem.Chess.ChessPiece;
import s16.ChessSystem.Chess.Enum.Color;

public class King extends ChessPiece {

	// atributos
	private ChessMatch chessMatch;

	// construtores
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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

	public boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor().equals(this.getColor())
				&& piece.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean possibleMoves[][] = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		Position evalMove = new Position(0, 0);

		// movimento especial: roque
		if (this.getMoveCount() == 0 && !chessMatch.getCheck()) {
			Position kingPosition = this.position;

			// roque pequeno
			possibleMoves[kingPosition.getRow()][kingPosition.getColumn() + 2] = !this.getBoard()
					.thereIsAPiece(new Position(kingPosition.getRow(), kingPosition.getColumn() + 1))
					&& !this.getBoard().thereIsAPiece(new Position(kingPosition.getRow(), kingPosition.getColumn() + 2))
					&& this.testRookCastling(new Position(kingPosition.getRow(), kingPosition.getColumn() + 3));

			// roque grande
			possibleMoves[kingPosition.getRow()][kingPosition.getColumn() - 2] = !this.getBoard()
					.thereIsAPiece(new Position(kingPosition.getRow(), kingPosition.getColumn() - 1))
					&& !this.getBoard().thereIsAPiece(new Position(kingPosition.getRow(), kingPosition.getColumn() - 2))
					&& !this.getBoard().thereIsAPiece(new Position(kingPosition.getRow(), kingPosition.getColumn() - 3))
					&& this.testRookCastling(new Position(kingPosition.getRow(), kingPosition.getColumn() - 4));
		}

		// N
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn());
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// NW
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// W
		evalMove.setValues(this.position.getRow(), this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// SW
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// S
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn());
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// SE
		evalMove.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// E
		evalMove.setValues(this.position.getRow(), this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		// NE
		evalMove.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		if (this.getBoard().positionExists(evalMove) && this.canMove(evalMove)) {
			possibleMoves[evalMove.getRow()][evalMove.getColumn()] = true;
		}

		return possibleMoves;

	}

}
