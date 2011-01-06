package at.tuwien.sbc.task2.worker.testing;

import at.tuwien.sbc.task2.interfaces.Worker;


public class TestDwarf implements Worker {
    
    private String id;
    
    private TeddyBearTest test;
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setTest(TeddyBearTest test) {
        this.test = test;
    }

    public TeddyBearTest getTest() {
        return test;
    }
 
}
