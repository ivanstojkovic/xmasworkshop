package at.tuwien.sbc.task2.connection.webservice;

import java.util.List;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.Controller;
import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class WebServiceControllerReference implements Controller {

	private static Logger logger = Logger.getLogger(WebServiceControllerReference.class);

	private static WebServiceControllerReference instance = new WebServiceControllerReference();

	private WebServiceControllerReference() {
		initWebService();
	}

	private void initWebService() {
		logger.info("initWebService");
	}

	public static WebServiceControllerReference getInstance() {
		return instance;
	}

	@Override
	public void write(XMasWorkshopEntry o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writePart(ProductionElf elf, int partNr, boolean defect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeddyBear> findTeddyBears() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeddyPart> findTeddyParts() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<TeddyBear> findDefectiveTeddyBears() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TeddyBear> findReadyTeddyBears() {
        // TODO Auto-generated method stub
        return null;
    }


}
