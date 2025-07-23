package logic.task;

import interfaces.Computable;
import interfaces.Modifiable;
import logic.compute.ProcessUnit;

public class CalculationTask extends Task implements Computable, Modifiable{

	public CalculationTask(String name, double workload) {
		super(name, workload);
		// TODO Auto-generated constructor stub
	}
	
	public void changeWorkload(int workload) {
		this.setWorkload(getWorkload() + workload);
	}

	@Override
	public void modify(int modifyValue) {
		// TODO Auto-generated method stub
		this.changeWorkload(modifyValue);
	}

	@Override
	public double compute(ProcessUnit processUnit) {
		// TODO Auto-generated method stub
		return processUnit.compute(this);
	}

	@Override
	public String fullTaskName() {
		// TODO Auto-generated method stub
		return "Calculation Task";
	}

}
