package at.tuwien.sbc.task2.xvsmimpl.worker;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.worker.logistics.LogisticReindeer;
import at.tuwien.sbc.task2.worker.testing.ComponentTest;
import at.tuwien.sbc.task2.worker.testing.TestDwarf;
import at.tuwien.sbc.task2.worker.testing.WeightTest;
import at.tuwien.sbc.task2.xvsmimpl.XMasWorkshopWarehouse;

public class TestDwarfThread extends Thread {
    
    private static Logger logger = Logger.getLogger(LogisticReindeerThread.class);

    private TestDwarf testDwarf;
    private boolean running;

    private MzsCore core;
    private Capi capi;
    private ContainerReference teddyBearContainer;
    private URI uri;

    public TestDwarfThread() {
        testDwarf = new TestDwarf();
        running = true;
        initMozartSpaces();
    }

    public void run() {
        while (running) {
            //take one..
            //check if defective
                // yes
                // skip test
                // mark as ready
            // not
                //check if your kind of test is done...
                    // yes
                    //put back for further processing in logisticsContainer or something
                //if not 
                    //do test...
                    //mark test as done
                    //set defective if needed
                    //set ready if needed
                    //write back or in logisticsContainer
        }
        
        logger.info("Stopping Thread " + this.getName());
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java TestDwarfThread [id] [component|weight]");
            System.exit(1);
        }

        TestDwarfThread thread = new TestDwarfThread();
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
        }
        
        logger.info("No such test [" + test + "]. Creating default: WeightTest");
        
    }

    private void initMozartSpaces() {
        logger.info("init MozartSpaces");
        try {
            uri = new URI(XMasWorkshopWarehouse.SERVER_URI);
            core = DefaultMzsCore.newInstance(0);
            capi = new Capi(core);
            teddyBearContainer = capi.lookupContainer("teddyBearContainer", uri, 0, null);
        } catch (MzsCoreException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }



}
