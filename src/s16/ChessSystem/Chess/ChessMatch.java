package s16.ChessSystem.Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import s16.ChessSystem.BoardGame.Board;
import s16.ChessSystem.BoardGame.Piece;
import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.Enum.Color;
import s16.ChessSystem.Chess.Exceptions.ChessException;
import s16.ChessSystem.Chess.Pieces.Bishop;
import s16.ChessSystem.Chess.Pieces.King;
import s16.ChessSystem.Chess.Pieces.Knight;
import s16.ChessSystem.Chess.Pieces.Pawn;
import s16.ChessSystem.Chess.Pieces.Queen;
import s16.ChessSystem.Chess.Pieces.Rook;

public class ChessMatch {

	// atributos base
	private Board board;
	private Integer turn;
	private Color currentPlayer;
	private List<ChessPiece> capturedPieces;
	private List<ChessPiece> piecesOnBoard;
	private Boolean check;
	private Boolean checkMate;

	// construtores
	public ChessMatch() {
		board = new Board(8, 8);
		this.turn = 1;
		this.currentPlayer = Color.WHITE;
		this.capturedPieces = new ArrayList<ChessPiece>();
		this.piecesOnBoard = new ArrayList<ChessPiece>();
		this.check = false;
		this.checkMate = false;
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

	public Boolean getCheck() {
		return check;
	}

	public Boolean getCheckMate() {
		return checkMate;
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

		Piece capturedPiece = this.makeMove(source, target);

		if (this.testCheck(this.currentPlayer)) {
			this.undoMove(source, target, capturedPiece);
			throw new ChessException("You can not put yourself in CHECK");
		}

		this.check = this.testCheck(this.opponent(this.currentPlayer)) ? true : false;

		if (this.testCheckMate(this.opponent(currentPlayer))) {
			this.checkMate = true;
		} else {
			this.nextTurn();
		}

	}

	private Piece makeMove(Position source, Position target) {
		Piece pieceSource = this.board.removePiece(source);
		Piece pieceTarget = this.board.removePiece(target);
		this.board.placePiece(pieceSource, target);
		((ChessPiece) pieceSource).increaseMoveCount();

		if (pieceTarget != null) {
			this.capturedPieces.add((ChessPiece) pieceTarget);
			this.piecesOnBoard.remove((ChessPiece) pieceTarget);
		}

		return pieceTarget;
	}

	private void undoMove(Position source, Position target, Piece capturedPiece) {

		Piece pieceSource = this.board.removePiece(target);
		this.board.placePiece(pieceSource, source);
		((ChessPiece) pieceSource).decreaseMoveCount();

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
		return color.equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private ChessPiece king(Color color) {

		List<ChessPiece> list = this.piecesOnBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());
		for (ChessPiece chessPiece : list) {
			if (chessPiece instanceof King) {
				return chessPiece;
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

	private boolean testCheck(Color color) {
		// testar se todos os movimentos possiveis da peca adversaria podem "atacar" o
		// meu rei
		// caso positivo voce esta em xeque

		Position position = new Position(0, 0);
		List<ChessPiece> oppositePieces = this.piecesOnBoard.stream().filter(x -> ((ChessPiece) x).getColor() != color)
				.collect(Collectors.toList());

		for (ChessPiece piece : oppositePieces) {
			if (piece.isThereAnyPossibleMove()) {
				boolean piecePossibleMoves[][] = piece.possibleMoves();
				for (int i = 0; i < piecePossibleMoves.length; i++) {
					for (int j = 0; j < piecePossibleMoves[i].length; j++) {
						if (piecePossibleMoves[i][j]) {
							position.setValues(i, j);
							if (this.board.thereIsAPiece(position) && this.board.piece(position).equals(king(color))) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	private boolean testCheckMate(Color color) {
		// verifica se algum movimento possivel de qualquer uma das minhas pecas tira o
		// meu rei do check
		// caso negativo o meu rei entra em cheque mate

		if (!this.testCheck(color)) {
			return false;
		}

		List<ChessPiece> oppositePieces = this.piecesOnBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());

		for (ChessPiece piece : oppositePieces) {
			boolean piecePossibleMoves[][] = piece.possibleMoves();
			for (int i = 0; i < this.board.getRows(); i++) {
				for (int j = 0; j < this.board.getColumns(); j++) {
					if (piecePossibleMoves[i][j]) {
						Position source = piece.getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = this.makeMove(source, target);
						boolean testCheck = this.testCheck(color);
						this.undoMove(source, target, capturedPiece);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private void initialSetup() {

		// BLACK PIECES
		this.placeNewPiece('a', 8, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('b', 8, new Knight(this.board, Color.BLACK));
		this.placeNewPiece('c', 8, new Bishop(this.board, Color.BLACK));
		this.placeNewPiece('d', 8, new Queen(this.board, Color.BLACK));
		this.placeNewPiece('e', 8, new King(this.board, Color.BLACK));
		this.placeNewPiece('f', 8, new Bishop(this.board, Color.BLACK));
		this.placeNewPiece('g', 8, new Knight(this.board, Color.BLACK));
		this.placeNewPiece('h', 8, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('a', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('b', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('c', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('d', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('e', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('f', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('g', 7, new Pawn(this.board, Color.BLACK));
		this.placeNewPiece('h', 7, new Pawn(this.board, Color.BLACK));
		
		// WHITE PIECES 
		this.placeNewPiece('a', 1, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('b', 1, new Knight(this.board, Color.WHITE));
		this.placeNewPiece('c', 1, new Bishop(this.board, Color.WHITE));
		this.placeNewPiece('d', 1, new Queen(this.board, Color.WHITE));
		this.placeNewPiece('e', 1, new King(this.board, Color.WHITE));
		this.placeNewPiece('f', 1, new Bishop(this.board, Color.WHITE));
		this.placeNewPiece('g', 1, new Knight(this.board, Color.WHITE));
		this.placeNewPiece('h', 1, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('a', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('b', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('c', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('d', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('e', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('f', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('g', 2, new Pawn(this.board, Color.WHITE));
		this.placeNewPiece('h', 2, new Pawn(this.board, Color.WHITE));
		
	}

}
