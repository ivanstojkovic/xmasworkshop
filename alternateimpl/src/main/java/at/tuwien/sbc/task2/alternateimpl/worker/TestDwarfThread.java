package at.tuwien.sbc.task2.alternateimpl.worker;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.worker.testing.ComponentTest;
import at.tuwien.sbc.task2.worker.testing.TestDwarf;
import at.tuwien.sbc.task2.worker.testing.WeightTest;

public class TestDwarfThread extends Thread {
    
    private static Logger logger = Logger.getLogger(TestDwarfThread.class);
    
    private TestDwarf testDwarf;
    private boolean running;
    
    public TestDwarfThread() {
        testDwarf = new TestDwarf();
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
        if (args.length != 2) {
            System.err.println("Usage: java TestDwarfThread [id] [component|weight]");
            System.exit(1);
        }
        
        final TestDwarfThread thread = new TestDwarfThread();
        thread.testDwarf.setId(args[0]);
        thread.initTestComponent(args[1]);
        thread.setName("TestDwarf_" + args[0]);
        thread.start();
    }
    
    private void initTestComponent(String test) {
        if (test.equals("component")) {
            testDwarf.setTest(new ComponentTest());
        } else if (test.equals("weight")) {
            testDwarf.setTest(new WeightTest());
        } else {
            logger.info("No such test [" + test + "]. Creating default: WeightTest");
            testDwarf.setTest(new WeightTest());
        }
        
    }
}
