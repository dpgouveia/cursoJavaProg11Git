package s16.ChessSystem.Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	private Integer turn;
	private Color currentPlayer;
	private List<ChessPiece> capturedPieces;
	private List<ChessPiece> piecesOnBoard;
	private Boolean check;

	// construtores
	public ChessMatch() {
		board = new Board(8, 8);
		this.turn = 1;
		this.currentPlayer = Color.WHITE;
		this.capturedPieces = new ArrayList<ChessPiece>();
		this.piecesOnBoard = new ArrayList<ChessPiece>();
		this.check = false;
		this.initialSetup();
	}

	// getters e setters
	public Integer getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public List<ChessPiece> getCapturedPieces() {
		return capturedPieces;
	}

	public List<ChessPiece> getPiecesOnTheBoard() {
		return piecesOnBoard;
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

	public boolean[][] possibleMoves(ChessPosition position) {

		if (!this.board.thereIsAPiece(position.toPosition())) {
			throw new ChessException("There is no piece at specified position " + position);
		}

		if (!this.getCurrentPlayer().equals(((ChessPiece) this.board.piece(position.toPosition())).getColor())) {
			throw new ChessException("You cannot move an opponent piece");
		}

		if (!this.board.piece(position.toPosition()).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece");
		}

		return this.board.piece(position.toPosition()).possibleMoves();
	}

	public void performChessMove(ChessPosition sourceMove, ChessPosition targetPosition) {

		Position source = sourceMove.toPosition();
		Position target = targetPosition.toPosition();

		if (!this.board.thereIsAPiece(source)) {
			throw new ChessException("No piece found on position " + source);
		}

		if (!this.getCurrentPlayer().equals(((ChessPiece) this.board.piece(source)).getColor())) {
			throw new ChessException("You cannot move an opponent piece");
		}

		if (!this.board.piece(source).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece");
		}

		if (!this.board.piece(source).possibleMove(target)) {
			throw new ChessException("It is not possible to move the piece [" + this.board.piece(source) + "] from "
					+ ChessPosition.fromPosition(source) + " to " + ChessPosition.fromPosition(target));
		}

		this.makeMove(source, target);
		this.nextTurn();
	}

	private Piece makeMove(Position source, Position target) {
		Piece pieceSource = this.board.removePiece(source);
		Piece pieceTarget = this.board.removePiece(target);
		this.board.placePiece(pieceSource, target);

		if (pieceTarget != null) {
			this.capturedPieces.add((ChessPiece) pieceTarget);
			this.piecesOnBoard.remove((ChessPiece) pieceTarget);
		}

		return pieceTarget;
	}

	private void undoMove(Position source, Position target, Piece capturedPiece) {

		Piece pieceSource = this.board.removePiece(target);
		this.board.placePiece(pieceSource, source);

		if (capturedPiece != null) {
			this.board.placePiece(capturedPiece, target);
			this.capturedPieces.remove((ChessPiece) capturedPiece);
			this.piecesOnBoard.add((ChessPiece) capturedPiece);
		}

	}

	private void nextTurn() {
		this.turn++;
		this.currentPlayer = currentPlayer.equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private void placeNewPiece(Character column, int row, ChessPiece piece) {
		this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
		this.piecesOnBoard.add(piece);
	}

	private Color opponent(Color color) {
		return color.equals(Color.WHITE) ? Color.BLACK : color.WHITE;
	}

	private ChessPiece king(Color color) {

		List<ChessPiece> list = this.piecesOnBoard.stream().filter(x -> color.equals(x.getColor()))
				.collect(Collectors.toList());
		for (ChessPiece piece : list) {
			if (piece instanceof King) {
				return piece;
			}
		}

//		for (int i = 0; i < this.board.getRows(); i++) {
//			for (int j = 0; j < this.board.getColumns(); j++) {
//				ChessPiece piece = (ChessPiece) this.board.piece(i, j);
//				if (piece instanceof King && color.equals(piece.getColor())) {
//					return piece;
//				}
//			}
//		}

		throw new IllegalStateException("There is no " + color + " king on the board!!");
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

//		exemplo do desenho do professor
//		this.placeNewPiece('d', 1, new Rook(this.board, Color.WHITE));
//		this.placeNewPiece('f', 1, new Rook(this.board, Color.WHITE));
//		this.placeNewPiece('d', 6, new Rook(this.board, Color.BLACK));

//		this.placeNewPiece('d', 4, new Rook(this.board, Color.WHITE));

	}

}
