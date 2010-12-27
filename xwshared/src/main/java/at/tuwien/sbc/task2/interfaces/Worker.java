package at.tuwien.sbc.task2.interfaces;

public interface Worker {
    
    String getId();
    
    void setId(String id);

    TaskResult execute(Task task);
}
