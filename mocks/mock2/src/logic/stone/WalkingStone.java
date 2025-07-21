package logic.stone;

import logic.game.GameManager;
import render.MapManager;
import utils.GameUtilities;

public class WalkingStone extends Stone{

	public WalkingStone(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public void dig(int digPower) {
		if (digPower > 1) {
			GameManager.getInstance().setGameScore(GameManager.getInstance().getGameScore() + 1);
		}
		MapManager.getInstance().removeStoneAtPos(getPosX(), getPosY());
	}
	
	public void walk() {
		GameUtilities.moveWalkingRock(this);
	}
}
