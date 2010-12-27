package at.tuwien.sbc.task2.xwmodel;

import at.tuwien.sbc.task2.xwapi.teddy.TeddyPart;

public class Leg implements TeddyPart {
    
    private String id;
    
    private String workerId;
    
    private boolean defective;
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String toString() {
        return "TeddyLeg [id= " + this.id + "]";
    }

    public String getProducerId() {
        return this.workerId;
    }

    public boolean isDefective() {
        return this.defective;
    }

    public void setDefective(boolean defective) {
        this.defective = defective;
    }

    public void setProducerId(String workerId) {
        this.workerId = workerId;
    }
}
