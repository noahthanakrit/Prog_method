package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard{
	private int energyCost;

	public RobotCard(String name, int power, int health, int energyCost) {
		super(name, power, health);
		this.setEnergyCost(energyCost);
	}

	@Override
	public void play(Player player) {
		player.setEnergy(player.getEnergy() - this.getEnergyCost());
		if (player.getEnergy() < 0) {
			player.setEnergy(0);
		}
	}

	@Override
	public boolean canPlay(Player player) {
		if (player.getEnergy() >= this.getEnergyCost()) {
			return true;
		} else if (this.getEnergyCost() == 0) {
			return true;
		}
		return false;
	}

	public int getEnergyCost() {
		return energyCost;
	}

	public void setEnergyCost(int energyCost) {
		if (energyCost < 0) {
			this.energyCost = 0;
		} else {
			this.energyCost = energyCost;
		}
	}
	
	

}
