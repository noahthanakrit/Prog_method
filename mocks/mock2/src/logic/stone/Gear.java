package logic.stone;

import logic.game.GameManager;
import render.MapManager;

public class Gear extends HardStone{
	private int upgradeValue;

	public Gear(int posX, int posY) {
		super(posX, posY, 2);
		this.setUpgradeValue(1);
		// TODO Auto-generated constructor stub
	}

	public Gear(int posX, int posY, int upgradeValue) {
		super(posX, posY, 2);
		this.setUpgradeValue(upgradeValue);
	}
	
	public void destroy() {
		if (this.getDurability() <= 0) {
			GameManager.getInstance().addDigPower(this.getUpgradeValue());
			MapManager.getInstance().removeStoneAtPos(getPosX(), getPosY());
		}
	}

	public int getUpgradeValue() {
		return upgradeValue;
	}

	public void setUpgradeValue(int upgradeValue) {
		if (upgradeValue < 1) this.upgradeValue = 1;
		else this.upgradeValue = upgradeValue;
	}

	
}
