package at.tuwien.sbc.task2.xwapi.worker;

public interface Worker {
    
    String getId();
    
    void setId(String id);

    TaskResult execute(Task task);
}
