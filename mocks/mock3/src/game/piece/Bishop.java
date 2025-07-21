package game.piece;

import game.board.Board;
import game.position.Position;

public class Bishop extends Piece{

	public Bishop(boolean white, Position position, Board board) {
		super(white, position, board);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object deepCopy() {
		// TODO Auto-generated method stub
		Bishop o = new Bishop(this.isWhite(), this.getPosition(), this.getBoard());
		if (this.hadMoved()) {
			return o;
		}
		return null;
	}

}
