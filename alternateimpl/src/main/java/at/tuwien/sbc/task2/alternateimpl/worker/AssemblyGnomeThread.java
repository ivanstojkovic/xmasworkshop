package at.tuwien.sbc.task2.alternateimpl.worker;

import java.util.Random;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService_Service;
import at.tuwien.sbc.task2.worker.assembly.AssemblyGnome;

public class AssemblyGnomeThread extends Thread {
    
    private static Logger logger = Logger.getLogger(AssemblyGnomeThread.class);
    
    private AssemblyGnome assemblyGnome;
    private Random randomGen;
    private boolean running;
    
    
    private XMasWorkshopWarehouseService xmasWarehouse;
    
    public AssemblyGnomeThread() {
        assemblyGnome = new AssemblyGnome();
        randomGen = new Random();
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
    
    // TODO pass id as argument....
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java AssemblyGnomeThread [id]");
            System.exit(1);
        }
        
        AssemblyGnomeThread thread = new AssemblyGnomeThread();
        thread.assemblyGnome.setId(args[0]);
        thread.setName("AssemblyGnome_" + args[0]);
        thread.start();
    }
    
    
    public void run() {
        while (running) {
        	xmasWarehouse.tryToAssembleTeddyBear("teddy_" + assemblyGnome.getId() + "_r_" + randomGen.nextInt(10000));
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        logger.info("Stopping Thread " + this.getName());
    }
  
    
}
