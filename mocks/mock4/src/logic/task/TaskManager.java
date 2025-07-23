package logic.task;


import java.util.ArrayList;

import interfaces.Duplicatable;

public class TaskManager {
	public static ArrayList<Task> getTaskByType(ArrayList<Class> types) {
    	// TODO implement this method
        ArrayList<Task> tasks = TaskList.getTasks();
        ArrayList<Task> returnTask = new ArrayList<>();
        
        for (Task task : tasks) {
        	Class<?> taskClass = task.getClass();
        	for (Class<?> type : types) {
        		if (type.isAssignableFrom(taskClass)) {
        			returnTask.add(task);
        			break;
        		}
        	}
        }
        return returnTask;
    }
	
	
    public static void deleteDuplicateTasks() {
    	// TODO implement this method
    	ArrayList<Task> tasks = TaskList.getTasks();
    	for (int i = tasks.size()-1; i >= 0; i--) {
    		Task task = tasks.get(i);
    		if (task instanceof Duplicatable && task.toString().contains("-")) {
    			tasks.remove(i);
    		}
    	}
    }

    public static boolean instanceOf(Class checkClass, Class interfaceClass) {
        return interfaceClass.isAssignableFrom(checkClass);
    }
}
