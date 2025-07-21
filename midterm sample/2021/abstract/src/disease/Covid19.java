package disease;

import util.R0;
import util.SevereLevel;

public class Covid19 extends Hypopnea{
	private R0 reproductionNumber;
	private String countryOfFirstAppearance;
	
	public Covid19() {
		this.setReproductionNumber(new R0(2,3));
		this.setCountryOfFirstAppearance("China");
	}
	
	@Override
	protected SevereLevel severeLevel(boolean isVaccinated) {
		SevereLevel ill = null;
		if (isVaccinated) {
			ill = SevereLevel.Less;
		} else {
			ill = SevereLevel.SevereIllness;
		}
		return ill;
	}
	
	public int minimumInfectionSpread (int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += Math.pow(this.getReproductionNumber().getMin(), i);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "Covid19";
	}

	public R0 getReproductionNumber() {
		return reproductionNumber;
	}

	public void setReproductionNumber(R0 reproductionNumber) {
		this.reproductionNumber = reproductionNumber;
	}

	public String getCountryOfFirstAppearance() {
		return countryOfFirstAppearance;
	}

	public void setCountryOfFirstAppearance(String countryOfFirstAppearance) {
		this.countryOfFirstAppearance = countryOfFirstAppearance;
	}

}
