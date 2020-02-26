package s16.ChessSystem.BoardGame;

public class Board {

	// atributos base
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	// construtores
	public Board(Integer rows, Integer columns) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	// getter e setters
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	
	// metodos
	public Piece piece(Integer row, Integer column) {
		return this.pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return this.pieces[position.getRow()][position.getColumn()];
	}
	
	

}
