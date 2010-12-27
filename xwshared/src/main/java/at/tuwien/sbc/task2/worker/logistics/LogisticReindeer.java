package at.tuwien.sbc.task2.worker.logistics;

import at.tuwien.sbc.task2.interfaces.Task;
import at.tuwien.sbc.task2.interfaces.TaskResult;
import at.tuwien.sbc.task2.interfaces.Worker;

public class LogisticReindeer implements Worker {

    
    private String id;
    
    public TaskResult execute(Task task) {
        if (task instanceof LogisiticTask) {
            LogisiticTask t = (LogisiticTask) task;
            t.doTask();
        }
        
        return task.getProducer().produceResult();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Argument id missing. Please provide an id");
            System.err.println("Usage: java AssemblyGnome [id]");
            System.exit(1);
            
        }
        
        //TODO parse the id
    }
}
