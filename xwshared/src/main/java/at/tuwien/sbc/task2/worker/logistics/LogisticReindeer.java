package at.tuwien.sbc.task2.worker.logistics;

import at.tuwien.sbc.task2.interfaces.Worker;

public class LogisticReindeer implements Worker {

    
    private String id;
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
