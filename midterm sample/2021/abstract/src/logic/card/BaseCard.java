package logic.card;

import logic.player.Player;

public abstract class BaseCard { //37.48 min
	private String name;
	private int power;
	private int health;
	
	public BaseCard(String name, int power, int health) {
		this.setName(name);
		this.setPower(power);
		this.setHealth(health);
	}
	
	public abstract void play(Player player);
	
	public abstract boolean canPlay(Player player);

	public int attack(BaseCard target) {
		int damage = 0;
		if (this.getPower() > target.getHealth()) {
			damage = Math.abs(target.getHealth() - this.getPower());
			target.setHealth(0);
		} else {
			target.setHealth(target.getHealth() - this.getPower());
		}
		return damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power < 0) {
			this.power = 0;
		} else {
			this.power = power;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			this.health = 0;
		} else {
			this.health = health;
		}
	}
	
	
}
