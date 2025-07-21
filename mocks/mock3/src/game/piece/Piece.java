package game.piece;

import java.util.Objects;
import java.util.Set;

import game.board.Board;
import game.position.Position;
import game.util.Movement;

public abstract class Piece {
	protected boolean white;
	protected boolean moved;
	protected Position position;
	protected Board board;
	
	
	public Piece(boolean white, Position position, Board board) {
		this.setWhite(white);
		this.setPosition(position);
		this.setBoard(board);
		
		board.placePiece(this, position);
	}
	
	public Set<Position> getLegalMove() {
		Movement o = new Movement(this.getPosition(), this.getBoard());
		o.getMovePositions(this);
		return o.getMoves();
	}
	
	public abstract Object deepCopy();
	
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.getPosition() +")";
	}
	
	public void moveHandle(Position to) {
		if (this.hadMoved()) {
			this.setPosition(to);
		}
	}
	
	public boolean hadMoved() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return Objects.equals(board, other.board) && moved == other.moved && Objects.equals(position, other.position)
				&& white == other.white;
	}

	public boolean isWhite() {
		return white;
	}
	
	public void setWhite(boolean white) {
		this.white = white;
	}
	
	public boolean isMoved() {
		return moved;
	}
	
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
}
