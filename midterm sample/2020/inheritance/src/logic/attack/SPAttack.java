package logic.attack;

import logic.monster.Monster;

public class SPAttack extends Attack{

	public SPAttack(int power, String name, boolean isLeader) {
		super(power, name, isLeader);
	}

	public int calculateDamage (Monster target) {
		int damage = 0;
		if (target.getSpecialDefense() < this.getPower()) {
			damage = Math.abs(target.getSpecialDefense() - this.getPower());
			target.setSpecialDefense(0);
		}
		return damage;
	}
}
