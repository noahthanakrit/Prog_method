package logic.card;

import logic.player.Player;
import logic.card.BaseCard;

public class MageCard extends BaseCard{
	private Element mageType;
	
	public MageCard(String name, int power, int health, Element mageType) {
		super(name, power, health);
		this.setMageType(mageType);
	}

	@Override
	public void play(Player player) {
		int count = 0;
		for (BaseCard selected : player.getField()) {
			if (selected instanceof OrbCard) {
				OrbCard s = (OrbCard) selected;
				if (this.getMageType().equals(s.getOrbType())) {
					count += 1;
				}
			}
		}
		this.setPower(this.getPower() + count);
	}

	@Override
	public boolean canPlay(Player player) {
		for (BaseCard selected : player.getField()) {
			if (selected instanceof OrbCard) {
				OrbCard s = (OrbCard) selected;
				if (this.getMageType().equals(s.getOrbType())) {
					return true;
				}
			}
		}
		return false;
	}

	public Element getMageType() {
		return mageType;
	}

	public void setMageType(Element mageType) {
		this.mageType = mageType;
	}
}
