package logic.stone;

import logic.game.GameManager;
import render.MapManager;

public class HardStone extends Stone{ // 45.04 min
	protected int durability;

	public HardStone(int posX, int posY, int durability) {
		super(posX, posY);
		this.setDurability(durability);
		// TODO Auto-generated constructor stub
	}
	
	public void dig(int digPower) {
		this.setDurability(getDurability() - digPower);
		if (this.getDurability() <= 0) {
			MapManager.getInstance().removeStoneAtPos(getPosX(), getPosY());
		}
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		if (durability < 0) this.durability = 0;
		else if (durability > 5) this.durability = 5;
		else this.durability = durability;
	}
	
	
}
