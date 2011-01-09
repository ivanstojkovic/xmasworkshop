package at.tuwien.sbc.task2.alternateimpl.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.alternateimpl.XMasWorkshopWarehouse;
import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;
import at.tuwien.sbc.task2.xwmodel.XMasWorkshopObject;

@WebService(
		name = "XMasWorkshopWarehouseService",
		serviceName = "XMasWorkshopWarehouseService", 
		targetNamespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
public class XMasWorkshopWarehouseService {
	private static Logger logger = Logger.getLogger(XMasWorkshopWarehouseService.class);
	
	public XMasWorkshopWarehouseService() {
		
	}

	@WebMethod
	public String sayHello() {
		return "XMasWorkshop WebService Implementation";
	}

	@WebMethod
	public void write(XMasWorkshopObject entry) {
		logger.info("writting entry: " + entry);
		XMasWorkshopWarehouse.getInstance().insertEntry(entry);
	}

	@WebMethod
	public void writePart(ProductionElf elf, int partNr, boolean defect) {
		XMasWorkshopWarehouse.getInstance().writePart(elf, partNr, defect);
	}

	@WebMethod
	public List<TeddyBear> findTeddyBears() {
		return XMasWorkshopWarehouse.getInstance().findTeddyBears();
	}

	@WebMethod
	public List<XMasWorkshopObject> findTeddyParts() {
		return XMasWorkshopWarehouse.getInstance().findTeddyParts();
	}
	
	public void tryToAssembleTeddyBear(String teddyId) {
		XMasWorkshopWarehouse.getInstance().tryToAssembleTeddyBear(teddyId);
	}
}
