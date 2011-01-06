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
import at.tuwien.sbc.task2.xvsmimpl.XMasWorkshopWarehouse;

public class LogisticReindeerThread extends Thread {

    private static Logger logger = Logger.getLogger(LogisticReindeerThread.class);

    private LogisticReindeer logisticReindeer;
    private boolean running;

    private MzsCore core;
    private Capi capi;
    private ContainerReference teddyBearContainer;
    private URI uri;

    public LogisticReindeerThread() {
        logisticReindeer = new LogisticReindeer();
        running = true;
        initMozartSpaces();
    }

    public void run() {
        while (running) {
            //TODO
        }
        
        logger.info("Stopping Thread " + this.getName());
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java LogisticReindeerThread [id]");
            System.exit(1);
        }

        LogisticReindeerThread thread = new LogisticReindeerThread();
        thread.logisticReindeer.setId(args[0]);
        thread.setName("LogisticReindeer_" + args[0]);
        thread.start();
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
