package s16.ChessSystem.BoardGame;

public class Position {

	// atributos base
	private Integer row;
	private Integer column;

	// construtores
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Integer row, Integer column) {
		super();
		this.row = row;
		this.column = column;
	}

	// getters e setters
	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	// metodos
	public void setValues(Integer row, Integer column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(row + ", " + column + "\n");
		return sb.toString();
	}

}
