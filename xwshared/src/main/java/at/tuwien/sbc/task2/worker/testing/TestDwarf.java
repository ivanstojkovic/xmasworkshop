package at.tuwien.sbc.task2.worker.testing;

import at.tuwien.sbc.task2.common.Constants;
import at.tuwien.sbc.task2.common.UnknownTaskResult;
import at.tuwien.sbc.task2.interfaces.Task;
import at.tuwien.sbc.task2.interfaces.TaskResult;
import at.tuwien.sbc.task2.interfaces.Worker;

public class TestDwarf implements Worker {
    
    private String id;
    
    public TaskResult execute(Task task) {
        if (task instanceof TestTask) {
            TestTask t = (TestTask) task;
            //...
        }
        
        return new UnknownTaskResult(this, Constants.UNKNOWN_TASK);
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
 
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Arguments missing. Please provide an id and test type");
            System.err.println("Usage: java AssemblyGnome [id] [test type]");
            System.err.println("Possible types are 'w' or 'weight' and 'c' or 'component'");
            System.exit(1);
        }
        
        //TODO parse the id and the type
    }
}
