package s16.ChessSystem.BoardGame;

public class Piece {

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

}
