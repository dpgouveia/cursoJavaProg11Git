package s16.ChessSystem.Chess;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Piece;
import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.Enum.Color;
import s16.ChessSystem.Chess.Exceptions.ChessException;
import s16.ChessSystem.Chess.Pieces.King;
import s16.ChessSystem.Chess.Pieces.Rook;

public class ChessMatch {

	// atributos base
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		this.initialSetup();
	}

	// metodos
	public ChessPiece[][] getPieces() {
		ChessPiece mat[][] = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}

	public ChessPiece performChessMove(ChessPosition sourceMove, ChessPosition targetPosition) {

		Position source = sourceMove.toPosition();
		Position target = targetPosition.toPosition();

		if (!board.thereIsAPiece(source)) {
			throw new ChessException("No piece found on position " + source);
		}

		if (!board.piece(source).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece");
		}

		Piece piece = this.makeMove(source, target);
		return (ChessPiece) piece;

	}

	private Piece makeMove(Position source, Position target) {
		Piece pieceSource = this.board.removePiece(source);
		Piece pieceTarget = this.board.removePiece(target);
		this.board.placePiece(pieceSource, target);
		return pieceTarget;
	}

	private void placeNewPiece(Character column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {

		this.placeNewPiece('c', 1, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('c', 2, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('d', 2, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('e', 2, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('e', 1, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('d', 1, new King(this.board, Color.WHITE));

		this.placeNewPiece('c', 8, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('c', 7, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('d', 7, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('e', 7, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('e', 8, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('d', 8, new King(this.board, Color.BLACK));

	}

}
