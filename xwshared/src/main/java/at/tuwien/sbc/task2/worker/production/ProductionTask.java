package at.tuwien.sbc.task2.worker.production;

import at.tuwien.sbc.task2.interfaces.Task;
import at.tuwien.sbc.task2.interfaces.TaskResult;

public abstract class ProductionTask implements Task {
    
    private Class part;
    
    private int quantity;
    
    private int errorRate;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPart(Class part) {
        this.part = part;
    }

    public Class getPart() {
        return part;
    }

    public void setErrorRate(int errorRate) {
        this.errorRate = errorRate;
    }

    public int getErrorRate() {
        return errorRate;
    }
    
    public abstract TaskResult doTask();
}
