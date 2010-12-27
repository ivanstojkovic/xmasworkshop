package at.tuwien.sbc.task2.xwapi.teddy;


public interface TeddyPart {
    
    String getId();
    
    void setId(String id);
    
    String getProducerId();
    
    void setProducerId(String workerId);
    
    boolean isDefective();
    
    void setDefective(boolean defective);
}
