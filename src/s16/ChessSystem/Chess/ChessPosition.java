package s16.ChessSystem.Chess;

import s16.ChessSystem.BoardGame.Position;
import s16.ChessSystem.Chess.Exceptions.ChessException;

public class ChessPosition {

	// atributos base
	private Character column;
	private Integer row;

	// construtores
	public ChessPosition(Character column, Integer row) {
		super();

		if (row < 1 || row > 8 || column < 'a' || column > 'h') {
			throw new ChessException("Error instantiating ChessPosition. Valid values are a1 to h8.");
		}

		this.column = column;
		this.row = row;
	}

	// getters e setters
	public Character getColumn() {
		return column;
	}

	public Integer getRow() {
		return row;
	}

	// metodos
	protected Position toPosition() {
		return new Position(8 - this.row, this.column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("" + column + row);
		return sb.toString();
	}

}
