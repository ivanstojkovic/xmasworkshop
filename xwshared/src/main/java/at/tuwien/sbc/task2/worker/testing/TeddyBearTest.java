package at.tuwien.sbc.task2.worker.testing;

import java.io.Serializable;

import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public interface TeddyBearTest extends Serializable {
    
    /**
     * Returns true if the bear that is examined passes the test, false
     * otherwise.
     * 
     * @param bear
     *            the bear to examine.
     * @return true if ok, false otherwise
     */
    boolean examine(TeddyBear bear);
    
    String getName();
}
