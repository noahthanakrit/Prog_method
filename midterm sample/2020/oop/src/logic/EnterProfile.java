package logic;

public class EnterProfile {
	private Person person;
	private int bodyTemperature;
	
	public EnterProfile(Person person, int bodyTemperature) {
		this.person = person;
		this.setBodyTemperature(bodyTemperature);
	}

	public Person getPerson() {
		return person;
	}

	public int getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(int bodyTemperature) {
		if (bodyTemperature < 35) {
			this.bodyTemperature = 35;
		} else if (bodyTemperature > 42) {
			this.bodyTemperature = 42;
		} else {
			this.bodyTemperature = bodyTemperature;
		}
	}
	
	public boolean hasFever() {
		if (this.getBodyTemperature() >= 37) {
			return true;
		}
		return false;
	}
}
