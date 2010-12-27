package at.tuwien.sbc.task2.common;

import at.tuwien.sbc.task2.interfaces.TaskResult;
import at.tuwien.sbc.task2.interfaces.Worker;

public class UnknownTaskResult implements TaskResult {

    private String result;
    
    private Worker worker;
    
    public UnknownTaskResult(final Worker worker, final String result) {
        this.worker = worker;
        this.result = result;
    }

    public void setResult(final String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Worker getWorker() {
        return this.worker;
    }

    public void setWorker(final Worker worker) {
        this.worker = worker;
    }
}
