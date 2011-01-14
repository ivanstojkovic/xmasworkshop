package at.tuwien.sbc.task2.alternateimpl.worker;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService_Service;
import at.tuwien.sbc.task2.worker.logistics.LogisticReindeer;

public class LogisticReindeerThread extends Thread {

    private static Logger logger = Logger.getLogger(LogisticReindeerThread.class);

    private LogisticReindeer logisticReindeer;
    private boolean running;

    private XMasWorkshopWarehouseService xmasWarehouse;
    
    public LogisticReindeerThread() {
        logisticReindeer = new LogisticReindeer();
        running = true;
        initWebService();
    }

    private void initWebService() {
        logger.info("initWebService");

        XMasWorkshopWarehouseService_Service xMasWorkshopServiceService = new XMasWorkshopWarehouseService_Service();

        xmasWarehouse = xMasWorkshopServiceService.getXMasWorkshopWarehouseServicePort();

        ((BindingProvider) xmasWarehouse).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8080/xmasworkshop");

        logger.info(((BindingProvider) xmasWarehouse).toString());

        logger.info("From XMasWarehouse: " + xmasWarehouse.sayHello());

    }
    public void run() {
        while (running) {
            xmasWarehouse.transportTeddyBear();

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
