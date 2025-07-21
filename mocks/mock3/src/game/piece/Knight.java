package game.piece;

import game.board.Board;
import game.position.Position;

public class Knight extends Piece{

	public Knight(boolean white, Position position, Board board) {
		super(white, position, board);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object deepCopy() {
		// TODO Auto-generated method stub
		Knight k = new Knight(white, position, board);
		if (this.hadMoved()) {
			Object o = k;
			return o;
		}
		return null;
	}

}
