package s16.ChessSystem.BoardGame;

import s16.ChessSystem.BoardGame.Exceptions.BoardException;

public class Board {

	// atributos base
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	// construtores
	public Board(Integer rows, Integer columns) {
		super();

		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}

		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	// getter e setters
	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	// metodos
	private boolean positionExists(Integer row, Integer column) {
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns ? true : false;
	}

	public boolean positionExists(Position position) {
		return this.positionExists(position.getRow(), position.getColumn());
	}

	public Piece piece(Integer row, Integer column) {

		if (!this.positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}

		return this.pieces[row][column];
	}

	public Piece piece(Position position) {

		if (!this.positionExists(position)) {
			throw new BoardException("Position not on the board");
		}

		return this.piece(position.getRow(), position.getColumn());
	}

	public void placePiece(Piece piece, Position position) {

		if (this.thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}

		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	public Piece removePiece(Position position) {
		
		if (!this.positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		Piece piece = this.piece(position);
		
		if(piece == null) {
			return null;
		}
		
		piece.position = null;
		this.pieces[position.getRow()][position.getColumn()] = null;
		return piece;
	}

	public boolean thereIsAPiece(Position position) {

		if (!this.positionExists(position)) {
			throw new BoardException("Position not on the board");
		}

		return piece(position) != null;
	}

}
