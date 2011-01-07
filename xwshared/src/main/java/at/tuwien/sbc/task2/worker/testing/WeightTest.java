package at.tuwien.sbc.task2.worker.testing;

import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class WeightTest implements TeddyBearTest {
    
    private static final long serialVersionUID = -7143253802555657236L;
    
    private String name;
    
    public WeightTest() {
        this.name = "weight";
    }
    /**
     * {@inheritDoc}
     */
    public boolean examine(TeddyBear bear) {
        return true;
    }
    
    public String getName() {
        return this.name;
    }
    
}
