package disease;

import java.util.ArrayList;

import util.Patient;
import util.SevereLevel;
import disease.Covid19;

public class Hospital { // exceed 1 hours
	private ArrayList<Patient> patients;
	
	public Hospital() {
		this.patients = new ArrayList<>();
	}
	
	public void admit(String firstname, String lastname, String id, String disease, boolean isVacinated) {
		Patient newpatient = new Patient(firstname, lastname, id, new Hypopnea(), isVacinated);

	    if (disease.equals("Covid19")) {
	        newpatient = new Patient(firstname, lastname, id, new Covid19(), isVacinated);
	    } else if (disease.equals("Delta")) {
	        newpatient = new Patient(firstname, lastname, id, new Delta(), isVacinated);
	    } else if (disease.equals("Hypopnea")) {
	        newpatient = new Patient(firstname, lastname, id, new Hypopnea(), isVacinated);
	    }

	    this.patients.add(newpatient);
	}
	
	public ArrayList<Patient> getCovidPatients(SevereLevel s) {
		ArrayList<Patient> covids = new ArrayList<>();
		for (Patient selected : this.patients) {
			if (selected.getServeLevel().equals(s) && selected.getDisease() instanceof Covid19) {
				covids.add(selected);
			}
		}
		return covids;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}	
}
