package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster{
	private int maxChargeTurns;
	private int currentChargeTurns;
	private boolean isGuard;
	
	public Leader(String name, int hp, int def, int sp_def, Attack attack, int changeTurn) {
		super(name, hp, def, sp_def, attack);
		this.setMaxChargeTurns(changeTurn);
		this.setCurrentChargeTurns(0);
	}

	public int getMaxChargeTurns() {
		return maxChargeTurns;
	}

	public void setMaxChargeTurns(int maxChargeTurns) {
		this.maxChargeTurns = maxChargeTurns;
	}

	public int getCurrentChargeTurns() {
		return currentChargeTurns;
	}

	public void setCurrentChargeTurns(int currentChargeTurns) {
		if (currentChargeTurns < 0) {
			this.currentChargeTurns = 0;
		} else if (currentChargeTurns > this.getMaxChargeTurns()) {
			this.currentChargeTurns = this.getMaxChargeTurns();
		} else {
			this.currentChargeTurns = currentChargeTurns;
		}
	}
	public boolean isReady() {
		if (this.getCurrentChargeTurns() > this.getMaxChargeTurns()) {
			return true;
		}
		return false;
	}
	
	public int takeDamage(Attack attack) {
		int damage = 0;
		if (this.isGuard()) {
			damage = 0;
		} else {
			if (attack.isLeader()) {
				damage = super.takeDamage(attack);
			} else {
				this.setHp((int) (this.getHp() - Math.ceil(0.5*super.takeDamage(attack))));
			}
			
			if (this.getHp() <= 0) { 
				this.setDead(true);
			}
		}
		return damage;
	}

	public boolean isGuard() {
		return isGuard;
	}

	public void setGuard(boolean isGuard) {
		this.isGuard = isGuard;
	}

	
}
