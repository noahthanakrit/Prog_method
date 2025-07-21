package logic;

public class Person { //14.08 min
	private String name;
	private int ID;
	
	public Person(String name, int iD) {
		this.setName(name);
		this.setID(iD);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		if (iD < 1) {
			this.ID = 1;
		} else {
			this.ID = iD;
		}
	}
	
	
}
