package s16.ChessSystem.BoardGame;

public abstract class Piece {

	// atributos base
	protected Position position;
	private Board board;

	// construtores
	public Piece(Board board) {
		super();
		this.board = board;
		this.position = null;
	}

	// getters e setters
	protected Board getBoard() {
		return board;
	}

	// metodos abstratos
	public abstract boolean[][] possibleMoves();

	// metodos
	public Boolean possibleMove(Position position) {
		return this.possibleMoves()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean possibleMoves[][] = this.possibleMoves();
		for (boolean i[] : possibleMoves) {
			for (boolean j : i) {
				if (j) {
					return true;
				}
			}
		}
		return false;
	}

}
