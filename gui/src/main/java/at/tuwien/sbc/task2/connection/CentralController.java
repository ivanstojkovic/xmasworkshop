package at.tuwien.sbc.task2.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.mozartspaces.MozartSpacesControllerReference;
import at.tuwien.sbc.task2.connection.webservice.WebServiceControllerReference;
import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class CentralController implements Controller {

	private static Logger logger = Logger.getLogger(CentralController.class);

	private static CentralController instance = new CentralController();

	private Controller technologyInstance;

	private CentralController() {
		initConfiguration();
	}

	private void initConfiguration() {
		logger.info("initConfiguration");
		Properties props = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("gui.properties");
			props.load(fis);
			fis.close();
			String technology = props.getProperty("technology");
			if (technology.equals("webservices")) {
				technologyInstance = WebServiceControllerReference.getInstance(); 
			}else{
				technologyInstance = MozartSpacesControllerReference.getInstance(); 
			}
			logger.info("Technology selected: " + technology);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write(XMasWorkshopEntry o) {
		technologyInstance.write(o);
	}

	@Override
	public void writePart(ProductionElf elf, int partNr, boolean defect) {
		technologyInstance.writePart(elf, partNr, defect);
	}

	public static CentralController getInstance() {
		return instance;
	}

	public List<TeddyBear> findTeddyBears() {
		return technologyInstance.findTeddyBears();
	}

	@Override
	public List<TeddyPart> findTeddyParts() {
		return technologyInstance.findTeddyParts();
	}

}
