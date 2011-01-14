package at.tuwien.sbc.task2.alternateimpl.worker;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService_Service;
import at.tuwien.sbc.task2.worker.testing.ComponentTest;
import at.tuwien.sbc.task2.worker.testing.TestDwarf;
import at.tuwien.sbc.task2.worker.testing.WeightTest;

public class TestDwarfThread extends Thread {
    
    private static Logger logger = Logger.getLogger(TestDwarfThread.class);
    
    private TestDwarf testDwarf;
    private boolean running;
    
    private XMasWorkshopWarehouseService xmasWarehouse;
    
    public TestDwarfThread() {
        testDwarf = new TestDwarf();
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
            xmasWarehouse.tryToTestTeddyBear(this.testDwarf.getTest().getName());
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
            logger.warn("No such test [" + test + "]. Creating default: WeightTest");
            testDwarf.setTest(new WeightTest());
        }
        
    }
}
