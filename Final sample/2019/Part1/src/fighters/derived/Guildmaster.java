package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Guardable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Guildmaster extends Unit implements Attackable, Guardable{

	public Guildmaster(int maxHealth, int speed, int power, int defense, int location) {
		super("Guildmaster", "G", maxHealth, speed, location, false);
		this.setPower(power);
		this.setDefense(defense);
		this.setRange(1);
		// TODO Auto-generated constructor stub
	}
	
	public boolean move(int spaces) {
		return super.move(-1);
	}

	@Override
	public void guard() {
		// TODO Auto-generated method stub
	}

	@Override
	public int attack(Unit e) {
		// TODO Auto-generated method stub
		int result = 0;
		if (e.sameTeam(this) || !BattleUtils.validRange(getRange(), getLocation(), e.getLocation())) {
			result = -1;
		} else {
			result = BattleUtils.calculateDamage(getPower(), e);
		}
		return result;
	}

}
