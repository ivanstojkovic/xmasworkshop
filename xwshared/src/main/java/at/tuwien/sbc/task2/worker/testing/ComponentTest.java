package at.tuwien.sbc.task2.worker.testing;

import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class ComponentTest implements TeddyBearTest {
    
    private static final long serialVersionUID = 1814369076072425016L;
    
    private String name;
    
    public ComponentTest() {
        this.name = "component";
    }
    
    public boolean examine(TeddyBear bear) {
        boolean ok = true;
        
        if (bear.getHat().isDefective() || bear.getHead().isDefective() || bear.getLeftHand().isDefective()
            || bear.getRightHand().isDefective() || bear.getBody().isDefective() || bear.getLeftLeg().isDefective()
            || bear.getRightLeg().isDefective()) {
            ok = false;
        }
        
        return ok;
    }
    
    public String getName() {
        return this.name;
    }
}
