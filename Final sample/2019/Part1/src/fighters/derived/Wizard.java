package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable{

	public Wizard(int maxHealth, int speed, int power, int location) {
		super("Wizard", "w", maxHealth, speed, location, true);
		this.setPower(power);
		this.setRange(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int attack(Unit e) {
		// TODO Auto-generated method stub
		int result = 0;
		if (e.sameTeam(this) || !BattleUtils.validRange(getRange(), getLocation(), e.getLocation())) {
			result = -1;
		} else {
			result = this.getPower();
		}
		return result;
	}

}
