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
	private ChessPiece enPassantVulnerable;

	// construtores
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		capturedPieces = new ArrayList<ChessPiece>();
		piecesOnBoard = new ArrayList<ChessPiece>();
		check = false;
		checkMate = false;
		enPassantVulnerable = null;
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

	public ChessPiece getEnPassantVulnerable() {
		return enPassantVulnerable;
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

		if (!board.thereIsAPiece(position.toPosition())) {
			throw new ChessException("There is no piece at specified position " + position);
		}

		if (!currentPlayer.equals(((ChessPiece) board.piece(position.toPosition())).getColor())) {
			throw new ChessException("You cannot move an opponent piece");
		}

		if (!board.piece(position.toPosition()).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece");
		}

		return board.piece(position.toPosition()).possibleMoves();
	}

	public void performChessMove(ChessPosition sourceMove, ChessPosition targetPosition) {

		Position source = sourceMove.toPosition();
		Position target = targetPosition.toPosition();

		if (!board.thereIsAPiece(source)) {
			throw new ChessException("No piece found on position " + source);
		}

		if (!currentPlayer.equals(((ChessPiece) board.piece(source)).getColor())) {
			throw new ChessException("You cannot move an opponent piece");
		}

		if (!board.piece(source).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece");
		}

		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("It is not possible to move the piece [" + board.piece(source) + "] from "
					+ ChessPosition.fromPosition(source) + " to " + ChessPosition.fromPosition(target));
		}

		Piece capturedPiece = makeMove(source, target);

		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can not put yourself in CHECK");
		}

		ChessPiece movedPiece = (ChessPiece) board.piece(target);
		check = testCheck(opponent(currentPlayer)) ? true : false;

		if (testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		} else {
			nextTurn();
		}

		// movimento especial: enPassant
		if (movedPiece instanceof Pawn && target.getRow() == source.getRow() - 2
				|| target.getRow() == source.getRow() + 2) {
			enPassantVulnerable = movedPiece;
		} else {
			enPassantVulnerable = null;
		}

	}

	private Piece makeMove(Position source, Position target) {

		ChessPiece pieceSource = (ChessPiece) this.board.removePiece(source);
		ChessPiece pieceTarget = (ChessPiece) this.board.removePiece(target);
		board.placePiece(pieceSource, target);
		pieceSource.increaseMoveCount();

		if (pieceTarget != null) {
			capturedPieces.add((ChessPiece) pieceTarget);
			piecesOnBoard.remove((ChessPiece) pieceTarget);
		}

		// movimento especial: roque pequeno
		if (pieceSource instanceof King && target.getColumn() == source.getColumn() + 2) {
			Position sourceRook = new Position(source.getRow(), source.getColumn() + 3);
			Position targetRook = new Position(source.getRow(), source.getColumn() + 1);
			ChessPiece rook = (ChessPiece) board.removePiece(sourceRook);
			board.placePiece(rook, targetRook);
			rook.increaseMoveCount();
		}

		// movimento especial: roque grande
		if (pieceSource instanceof King && target.getColumn() == source.getColumn() - 2) {
			Position sourceRook = new Position(source.getRow(), source.getColumn() - 4);
			Position targetRook = new Position(source.getRow(), source.getColumn() - 1);
			ChessPiece rook = (ChessPiece) board.removePiece(sourceRook);
			board.placePiece(rook, targetRook);
			rook.increaseMoveCount();
		}

		// movimento especial: enPassant
		if (pieceSource instanceof Pawn) {
			if (source.getColumn() != target.getColumn() && pieceTarget == null) {
				Position pawnPosition;
				if (pieceSource.getColor() == Color.WHITE) {
					pawnPosition = new Position(target.getRow() + 1, target.getColumn());
				} else {
					pawnPosition = new Position(target.getRow() - 1, target.getColumn());
				}
				pieceTarget = (ChessPiece) board.removePiece(pawnPosition);
				capturedPieces.add(pieceTarget);
				piecesOnBoard.remove(pieceTarget);
			}
		}

//		ChessPiece pieceSource = (ChessPiece) this.board.removePiece(source);
//		ChessPiece pieceTarget;
//
//		// movimento especial: roque
//		if (pieceSource instanceof King) {
//			Position roqueMenor = new Position(target.getRow(), target.getColumn() + 1);
//			Position roqueMaior = new Position(target.getRow(), target.getColumn() - 2);
//
//			// roque menor
//			if (board.positionExists(roqueMenor) && ((King) pieceSource).testRookCastling(roqueMenor)) {
//				board.placePiece(pieceSource, target);
//				pieceSource.increaseMoveCount();
//				pieceTarget = (ChessPiece) board.removePiece(roqueMenor);
//				board.placePiece(pieceTarget, new Position(target.getRow(), target.getColumn() - 1));
//				pieceTarget.increaseMoveCount();
//			}
//			// roque maior
//			else if (board.positionExists(roqueMaior) && ((King) pieceSource).testRookCastling(roqueMaior)) {
//				board.placePiece(pieceSource, target);
//				pieceSource.increaseMoveCount();
//				pieceTarget = (ChessPiece) board.removePiece(roqueMaior);
//				board.placePiece(pieceTarget, new Position(target.getRow(), target.getColumn() + 1));
//				pieceTarget.increaseMoveCount();
//			}
//			// movimento normal do rei
//			else {
//				pieceTarget = (ChessPiece) this.board.removePiece(target);
//				board.placePiece(pieceSource, target);
//				pieceSource.increaseMoveCount();
//
//				if (pieceTarget != null) {
//					this.capturedPieces.add((ChessPiece) pieceTarget);
//					this.piecesOnBoard.remove((ChessPiece) pieceTarget);
//				}
//			}
//
//		} else {
//			pieceTarget = (ChessPiece) this.board.removePiece(target);
//			board.placePiece(pieceSource, target);
//			pieceSource.increaseMoveCount();
//
//			if (pieceTarget != null) {
//				this.capturedPieces.add((ChessPiece) pieceTarget);
//				this.piecesOnBoard.remove((ChessPiece) pieceTarget);
//			}
//		}

		return pieceTarget;
	}

	private void undoMove(Position source, Position target, Piece capturedPiece) {

		ChessPiece pieceSource = (ChessPiece) board.removePiece(target);
		board.placePiece(pieceSource, source);
		((ChessPiece) pieceSource).decreaseMoveCount();

		if (capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove((ChessPiece) capturedPiece);
			piecesOnBoard.add((ChessPiece) capturedPiece);
		}

		// movimento especial: roque pequeno
		if (pieceSource instanceof King && target.getColumn() == source.getColumn() + 2) {
			Position sourceRook = new Position(source.getRow(), source.getColumn() + 3);
			Position targetRook = new Position(source.getRow(), source.getColumn() + 1);
			ChessPiece rook = (ChessPiece) board.removePiece(targetRook);
			board.placePiece(rook, sourceRook);
			rook.decreaseMoveCount();
		}

		// movimento especial: roque grande
		if (pieceSource instanceof King && target.getColumn() == source.getColumn() - 2) {
			Position sourceRook = new Position(source.getRow(), source.getColumn() - 4);
			Position targetRook = new Position(source.getRow(), source.getColumn() - 1);
			ChessPiece rook = (ChessPiece) board.removePiece(targetRook);
			board.placePiece(rook, sourceRook);
			rook.decreaseMoveCount();
		}

		// movimento especial: enPassant
		if (pieceSource instanceof Pawn) {
			if (source.getColumn() != target.getColumn() && capturedPiece == enPassantVulnerable) {
				ChessPiece pawn = (ChessPiece) board.removePiece(target);
				Position pawnPosition;
				if (pieceSource.getColor() == Color.WHITE) {
					pawnPosition = new Position(3, target.getColumn());
				} else {
					pawnPosition = new Position(4, target.getColumn());
				}
				board.placePiece(pawn, pawnPosition);
			}
		}

//		ChessPiece pieceSource = (ChessPiece) this.board.removePiece(target);
//		if (pieceSource instanceof King && capturedPiece != null && capturedPiece instanceof Rook
//				&& ((Rook) capturedPiece).getColor() == pieceSource.getColor()) {
//
//			Position undoRoqueMenor = new Position(target.getRow(), target.getColumn() + 1);
//			Position undoRoqueMaior = new Position(target.getRow(), target.getColumn() - 2);
//			ChessPiece rightRook = (ChessPiece) board.piece(new Position(target.getRow(), target.getColumn() - 1));
//			ChessPiece leftRook = (ChessPiece) board.piece(new Position(target.getRow(), target.getColumn() + 1));
//
//			// undo roque menor
//			if (capturedPiece.equals(rightRook)) {
//				board.placePiece(capturedPiece, undoRoqueMenor);
//				((ChessPiece) capturedPiece).decreaseMoveCount();
//			} // undo roque maior
//			else if (capturedPiece.equals(leftRook)) {
//				board.placePiece(capturedPiece, undoRoqueMaior);
//				((ChessPiece) capturedPiece).decreaseMoveCount();
//			}
//
//			capturedPiece = null;
//		}
//
//		board.placePiece(pieceSource, source);
//		((ChessPiece) pieceSource).decreaseMoveCount();
//
//		if (capturedPiece != null) {
//			board.placePiece(capturedPiece, target);
//			capturedPieces.remove((ChessPiece) capturedPiece);
//			piecesOnBoard.add((ChessPiece) capturedPiece);
//		}

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
		this.placeNewPiece('e', 8, new King(this.board, Color.BLACK, this));
		this.placeNewPiece('f', 8, new Bishop(this.board, Color.BLACK));
		this.placeNewPiece('g', 8, new Knight(this.board, Color.BLACK));
		this.placeNewPiece('h', 8, new Rook(this.board, Color.BLACK));
		this.placeNewPiece('a', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('b', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('c', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('d', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('e', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('f', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('g', 7, new Pawn(this.board, Color.BLACK, this));
		this.placeNewPiece('h', 7, new Pawn(this.board, Color.BLACK, this));

		// WHITE PIECES
		this.placeNewPiece('a', 1, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('b', 1, new Knight(this.board, Color.WHITE));
		this.placeNewPiece('c', 1, new Bishop(this.board, Color.WHITE));
		this.placeNewPiece('d', 1, new Queen(this.board, Color.WHITE));
		this.placeNewPiece('e', 1, new King(this.board, Color.WHITE, this));
		this.placeNewPiece('f', 1, new Bishop(this.board, Color.WHITE));
		this.placeNewPiece('g', 1, new Knight(this.board, Color.WHITE));
		this.placeNewPiece('h', 1, new Rook(this.board, Color.WHITE));
		this.placeNewPiece('a', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('b', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('c', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('d', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('e', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('f', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('g', 2, new Pawn(this.board, Color.WHITE, this));
		this.placeNewPiece('h', 2, new Pawn(this.board, Color.WHITE, this));

	}

}
