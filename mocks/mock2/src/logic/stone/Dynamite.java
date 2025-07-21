package logic.stone;

import render.MapManager;
import utils.GameUtilities;

public class Dynamite extends Stone{

	public Dynamite(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		MapManager.getInstance().removeStoneAtPos(getPosX(), getPosY());
		for (Stone each : GameUtilities.getAdjacentStones(this.getPosX(), this.getPosY())) {
			MapManager.getInstance().removeStoneAtPos(each.getPosX(), each.getPosY());
		}
	}
}
