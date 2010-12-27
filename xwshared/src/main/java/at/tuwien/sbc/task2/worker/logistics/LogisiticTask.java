package at.tuwien.sbc.task2.worker.logistics;

import at.tuwien.sbc.task2.interfaces.Task;
import at.tuwien.sbc.task2.interfaces.TaskResult;
import at.tuwien.sbc.task2.interfaces.UnknownTaskResultProducer;

public abstract class LogisiticTask implements Task {

    private UnknownTaskResultProducer producer;

    public UnknownTaskResultProducer getProducer() {
        return this.producer;
    }
    
    public abstract TaskResult doTask();
}
