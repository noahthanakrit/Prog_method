package disease;

import util.R0;
import util.SevereLevel;

public class Delta extends Covid19 {
	private int spikeProtein;
	
	public Delta() {
		this.setReproductionNumber(new R0(5,7));
		this.setCountryOfFirstAppearance("India");
		this.minimumInfectionSpread(2);
	}
	
	@Override
	protected SevereLevel severeLevel(boolean isVaccinated) {
		SevereLevel ill = null;
		if (isVaccinated) {
			ill = SevereLevel.MildOrLess;
		} else {
			ill = SevereLevel.SevereIllness;
		}
		return ill;
	}

	public int getSpikeProtein() {
		return 10;
	}
	
	@Override
	public String toString() {
		return "Delta";
	}
}
