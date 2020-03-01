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
	public abstract Boolean[][] possibleMoves();

	// metodos
	public Boolean possibleMove(Position position) {
		return this.possibleMoves()[position.getRow()][position.getColumn()];
	}

	public Boolean isThereAnyPossibleMove() {
		Boolean possibleMoves[][] = this.possibleMoves();
		for (Boolean i[] : possibleMoves) {
			for (Boolean j : i) {
				if (j != null && j) {
					return true;
				}
			}
		}
		return false;
	}

}
