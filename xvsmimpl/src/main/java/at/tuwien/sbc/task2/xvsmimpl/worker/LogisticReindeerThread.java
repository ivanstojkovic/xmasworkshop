package at.tuwien.sbc.task2.xvsmimpl.worker;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.KeyCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.capi3.LindaCoordinator;
import org.mozartspaces.capi3.RandomCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;
import org.mozartspaces.core.TransactionReference;

import at.tuwien.sbc.task2.worker.logistics.LogisticReindeer;
import at.tuwien.sbc.task2.xvsmimpl.XMasWorkshopWarehouse;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class LogisticReindeerThread extends Thread {

    private static Logger logger = Logger.getLogger(LogisticReindeerThread.class);

    private LogisticReindeer logisticReindeer;
    private boolean running;
    private boolean taken;

    private MzsCore core;
    private Capi capi;
    private ContainerReference logisticsContainer;
    private ContainerReference defectiveContainer;
    private URI uri;

    private TeddyBear current;

    public LogisticReindeerThread() {
        logisticReindeer = new LogisticReindeer();
        running = true;
        initMozartSpaces();
    }

    public void run() {
        while (running) {
            TransactionReference tx = null;
            try {
                tx = capi.createTransaction(10000, uri);

                TeddyBear template = new TeddyBear(null, null, null, null, null, null, null, null, null, false);
                ArrayList<TeddyBear> teddies = capi.take(this.logisticsContainer, Arrays.asList(LindaCoordinator
                        .newSelector(template, 1)), 5000, tx);
                capi.commitTransaction(tx);
                logger.info("Found [" + teddies.size() + "] teddies in logsitics.");
                if (teddies.size() > 0) {
                    taken = true;
                    for (TeddyBear t : teddies) {
                        current = t;

                        t.setReady(true);
                        Entry entry;

                        logger.info("Found teddy [" + t.getId() + "] in logistics.");
                        if (t.isDefective()) {
                            logger.info("Teddy is defective, sorting out!");
                            entry = new Entry(t, Arrays.asList(KeyCoordinator.newCoordinationData(t.getId())));
                            capi.write(entry, this.defectiveContainer);
                            taken = false;
                            current = null;
                        } else {
                            logger.info("Teddy passed the tests, leaving in logsitics for transport.");
                            entry = new Entry(t, Arrays.asList(KeyCoordinator.newCoordinationData(t.getId())));
                            capi.write(entry, this.logisticsContainer);
                            taken = false;
                            current = null;
                        }
                    }
                }

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

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java LogisticReindeerThread [id]");
            System.exit(1);
        }

        final LogisticReindeerThread thread = new LogisticReindeerThread();
        thread.logisticReindeer.setId(args[0]);
        thread.setName("LogisticReindeer_" + args[0]);

        // add shutdown hook
        // eclipse doesn't call this fucker
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

    private void initMozartSpaces() {
        logger.info("init MozartSpaces");
        try {
            uri = new URI(XMasWorkshopWarehouse.SERVER_URI);
            core = DefaultMzsCore.newInstance(0);
            capi = new Capi(core);
            logisticsContainer = capi.lookupContainer("logisticsContainer", uri, 0, null);
            defectiveContainer = capi.lookupContainer("defectiveContainer", uri, 0, null);
        } catch (MzsCoreException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void releaseTeddy() {
        try {
            if (current != null) {
                Entry entry = new Entry(current, Arrays.asList(KeyCoordinator.newCoordinationData(current.getId()),
                        LabelCoordinator.newCoordinationData("teddyBear")));
                capi.write(this.logisticsContainer, 5000, null, entry);
            } else {
                logger.warn("Entry is most likely in space, please check");
            }
        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
    }

}
