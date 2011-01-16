package at.tuwien.sbc.task2.xvsmimpl.worker;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.KeyCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.capi3.RandomCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;
import org.mozartspaces.core.TransactionReference;

import at.tuwien.sbc.task2.worker.testing.ComponentTest;
import at.tuwien.sbc.task2.worker.testing.TestDwarf;
import at.tuwien.sbc.task2.worker.testing.WeightTest;
import at.tuwien.sbc.task2.xvsmimpl.XMasWorkshopWarehouse;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class TestDwarfThread extends Thread {
    
    private static Logger logger = Logger.getLogger(TestDwarfThread.class);
    
    private TestDwarf testDwarf;
    private boolean running;
    private boolean taken;
    private TeddyBear current;
    
    private MzsCore core;
    private Capi capi;
    private ContainerReference teddyBearContainer;
    private ContainerReference logisticsContainer;
    private URI uri;
    
    public TestDwarfThread() {
        testDwarf = new TestDwarf();
        running = true;
        taken = false;
        initMozartSpaces();
    }
    
    public void run() {
        while (running) {
            TransactionReference tx = null;
            try {
                tx = capi.createTransaction(10000, uri);
                
                ArrayList<TeddyBear> teddies = capi.take(this.teddyBearContainer, Arrays.asList(RandomCoordinator.newSelector(1)), 5000, tx);
                capi.commitTransaction(tx);
              
                if (teddies.size() > 0) {
                    taken = true;
                    for (TeddyBear t : teddies) {
                        current = t;
                        
                        Map<String, Boolean> tests = t.getDoneTests();
                        boolean allTestsDone = true;
                        for (String test : tests.keySet()) {
                            if (tests.get(test) == null && test.equals(testDwarf.getTest().getName())) {
                                logger.info("Test [" + test + "] not done yet on teddy [" + t.getId() + "], performing");
                                boolean examination = this.testDwarf.getTest().examine(t);
                                t.getDoneTests().put(test, examination);
                                logger.info("Test [" + test + "] passed: " + examination);
                                if (!t.isDefective()) {
                                    t.setDefective(!examination); // mind the
                                    // negation...
                                }
                                
                            } 
                            
                            if (t.getDoneTests().get(test) == null) {
                                allTestsDone = false;
                                logger.info("Test [" + test + "] is not done yet.");
                            } else {
                                logger.info("Test [" + test + "] is done.");
                            }
                        }
                        
                        tx = capi.createTransaction(10000, uri);
                        Entry entry = new Entry(t, Arrays.asList(KeyCoordinator.newCoordinationData(t.getId()), LabelCoordinator.newCoordinationData("teddyBear")));
                        capi.write(entry, this.teddyBearContainer, 10000, tx);
                        capi.commitTransaction(tx);
                        
                        taken = false;
                        current = null;
                        logger.info("written");
                        
                        if (allTestsDone) {
                            tx = capi.createTransaction(10000, uri);
                            logger.info("all tests done for teddy [" + t.getId() + "], sending to logistics");
                            capi.delete(this.teddyBearContainer, Arrays.asList(KeyCoordinator.newSelector(t.getId())),
                                0, tx);
                            entry = new Entry(t, KeyCoordinator.newCoordinationData(t.getId()));
                            capi.write(entry, this.logisticsContainer, 0, tx);
                            capi.commitTransaction(tx);
                        }
                    }
                }
                
                //capi.commitTransaction(tx);
                
            } catch (MzsCoreException e) {
                logger.warn(e.getMessage());
                try {
                    if (tx != null) {
                        capi.rollbackTransaction(tx);
                        if (taken && current == null) {
                            taken = false;
                        }
                    }
                } catch (MzsCoreException e1) {
                    logger.error(e1.getMessage());
                }
            }
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        logger.info("Stopping Thread " + this.getName());
    }
    
    private void releaseTeddy() {
        try {
            if (current != null) {
                Entry entry = new Entry(current, Arrays.asList(KeyCoordinator.newCoordinationData(current.getId()), LabelCoordinator.newCoordinationData("teddyBear")));
                capi.write(this.teddyBearContainer, 5000, null, entry);
            } else {
                logger.warn("Entry is most likely in space, please check");
            }
        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
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
        
        //add shutdown hook
        //eclipse doesn't call this fucker
        // shall work from the console...
        Runtime rt = Runtime.getRuntime();
        logger.info("adding shutdown hook");
        rt.addShutdownHook(new Thread() {
          public void run() {
              logger.info("ShutdownHook called");
              if (thread.taken) {
                  logger.info("release teddy bear");
                  thread.releaseTeddy();
                  
              }
          }
        });
        
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
    
    private void initMozartSpaces() {
        logger.info("init MozartSpaces");
        try {
            uri = new URI(XMasWorkshopWarehouse.SERVER_URI);
            core = DefaultMzsCore.newInstance(0);
            capi = new Capi(core);
            teddyBearContainer = capi.lookupContainer("teddyBearContainer", uri, 0, null);
            logisticsContainer = capi.lookupContainer("logisticsContainer", uri, 0, null);
        } catch (MzsCoreException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
}
