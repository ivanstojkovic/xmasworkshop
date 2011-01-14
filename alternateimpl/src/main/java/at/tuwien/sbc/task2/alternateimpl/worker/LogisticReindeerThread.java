package at.tuwien.sbc.task2.alternateimpl.worker;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.worker.logistics.LogisticReindeer;

public class LogisticReindeerThread extends Thread {

    private static Logger logger = Logger.getLogger(LogisticReindeerThread.class);

    private LogisticReindeer logisticReindeer;
    private boolean running;

    public LogisticReindeerThread() {
        logisticReindeer = new LogisticReindeer();
        running = true;
    }

    public void run() {
        while (running) {
          

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        logger.info("Stopping Thread " + this.getName());
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java LogisticReindeerThread [id]");
            System.exit(1);
        }

        final LogisticReindeerThread thread = new LogisticReindeerThread();
        thread.logisticReindeer.setId(args[0]);
        thread.setName("LogisticReindeer_" + args[0]);
        thread.start();
    }
  
}
