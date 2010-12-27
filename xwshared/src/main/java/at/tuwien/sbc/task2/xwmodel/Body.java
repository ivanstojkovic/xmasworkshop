package at.tuwien.sbc.task2.xwmodel;

import at.tuwien.sbc.task2.xwapi.teddy.TeddyPart;

public class Body implements TeddyPart {
    
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
        return "TeddyBody [id= " + this.id + "]";
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

    public void setProducerId(String worker) {
        this.workerId = worker;
    }
}
