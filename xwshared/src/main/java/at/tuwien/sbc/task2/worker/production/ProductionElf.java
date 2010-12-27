package at.tuwien.sbc.task2.worker.production;


import at.tuwien.sbc.task2.common.Constants;
import at.tuwien.sbc.task2.common.UnknownTaskResult;
import at.tuwien.sbc.task2.interfaces.Task;
import at.tuwien.sbc.task2.interfaces.TaskResult;
import at.tuwien.sbc.task2.interfaces.Worker;

public class ProductionElf implements Worker {
    
    private String id;
    
    private int errorRate;
    
    public ProductionElf(final String id, final int errorRate) {
        this.id = id;
        this.errorRate = errorRate;
    }
    
    public TaskResult execute(final Task task) {
        if (task instanceof ProductionTask) {
            final ProductionTask t = (ProductionTask) task;
            t.setErrorRate(this.errorRate);
            return t.doTask();
        }

        return new UnknownTaskResult(this, Constants.UNKNOWN_TASK);
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }

    public void setErrorRate(int errorRate) {
        this.errorRate = errorRate;
    }

    public int getErrorRate() {
        return errorRate;
    }
    
}
