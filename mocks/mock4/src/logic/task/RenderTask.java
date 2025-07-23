package logic.task;

import interfaces.Computable;
import interfaces.Parallelizable;
import logic.compute.ProcessUnit;
import interfaces.Duplicatable;

public class RenderTask extends Task implements Computable, Parallelizable, Duplicatable{

	public RenderTask(String name, double workload) {
		super(name, workload);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void duplicateTask(int taskNumber) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= taskNumber; i++) {
			RenderTask renderTask = new RenderTask(this.getName() + "-" + i, this.getWorkload());
			TaskList.addTasks(renderTask);
		}
	}

	@Override
	public double parallelCompute(ProcessUnit processUnit) {
		// TODO Auto-generated method stub
		return processUnit.parallelCompute(this);
	}

	@Override
	public double compute(ProcessUnit processUnit) {
		// TODO Auto-generated method stub
		return processUnit.compute(this);
	}

	@Override
	public String fullTaskName() {
		// TODO Auto-generated method stub
		return "Rendering Task";
	}

}
