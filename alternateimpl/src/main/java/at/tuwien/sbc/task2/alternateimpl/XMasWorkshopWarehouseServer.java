package at.tuwien.sbc.task2.alternateimpl;

import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.alternateimpl.ws.XMasWorkshopWarehouseService;

public class XMasWorkshopWarehouseServer {

	private static Logger logger = Logger.getLogger(XMasWorkshopWarehouseServer.class);

	public static void main(String[] args) {
		initXMasWorkshopWS();
	}

	private static void initXMasWorkshopWS() {
		logger.info("Publishing WebService XMasWorkshopWarehouseService on http://localhost:8080/xmasworkshop");
		Endpoint.publish("http://localhost:8080/xmasworkshop", new XMasWorkshopWarehouseService());
		// readInput();
	}
}
