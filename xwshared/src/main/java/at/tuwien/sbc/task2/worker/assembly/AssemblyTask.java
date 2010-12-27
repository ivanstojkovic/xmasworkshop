package at.tuwien.sbc.task2.worker.assembly;

import at.tuwien.sbc.task2.interfaces.Task;
import at.tuwien.sbc.task2.interfaces.TaskResult;
import at.tuwien.sbc.task2.interfaces.UnknownTaskResultProducer;

public abstract class AssemblyTask implements Task {

    private UnknownTaskResultProducer producer;

    public UnknownTaskResultProducer getProducer() {
        return this.producer;
    }
    
    public abstract TaskResult doTask();
}
