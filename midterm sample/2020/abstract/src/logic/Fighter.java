package logic;


public class Fighter extends Piece{
	private boolean promoted;
	private PositionList promotedMovePositions;

	public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
		super(initialPositionX, initialPositionY, reverse, name);
		this.promotedMovePositions = new PositionList();
		this.movePositions.add(-1,2);
		this.movePositions.add(1,2);
		this.promotedMovePositions.add(0,2);
		this.promotedMovePositions.add(1,0);
		this.promotedMovePositions.add(0,-2);
		this.promotedMovePositions.add(-1,0);
		
		if (this.isReverse()) {
			for (Position each : this.promotedMovePositions) {
				each.reverse();
			}
			for (Position e : this.movePositions) {
				e.reverse();
			}
			this.setPromoted(false);
		}
	}

	@Override
	public void move(int movePattern) {
		Position target = null;
		if (this.isPromoted()) {
			target = this.currentPosition.addPositionValue(this.promotedMovePositions.get(movePattern));
		} else {
			target = this.currentPosition.addPositionValue(movePositions.get(movePattern));
		}
		this.setCurrentPosition(target);
		this.currentPosition.normalizedPosition();
	}

	@Override
	public Position attackTargetPosition(int actionPattern) {
		Position selected = this.currentPosition.addPositionValue(this.movePositions.get(actionPattern));
		this.move(actionPattern);
		selected.normalizedPosition();
		return selected;
	}

	public boolean isPromoted() {
		return promoted;
	}

	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}

	public PositionList getPromotedMovePositions() {
		return promotedMovePositions;
	}

	
}
