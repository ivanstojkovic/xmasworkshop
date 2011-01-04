package at.tuwien.sbc.task2.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.Hat;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;

public class CentralController implements Controller {

	private static Logger logger = Logger.getLogger(CentralController.class);

	private static CentralController instance = new CentralController();

	private boolean webServicesActivated = false;

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
				webServicesActivated = true;
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
		if (!webServicesActivated) {
			MozartSpacesControllerReference.getInstance().write(o);
		} else {
			// TODO
		}
	}

	@Override
	public void writePart(ProductionElf elf, int partNr, boolean defect) {
		TeddyPart objToWrite = null;
		switch (elf.getFunction()) {
		case ARM:
			objToWrite = new Hand("hand_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case LEG:
			objToWrite = new Leg("hand_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case HEAD:
			objToWrite = new Head("hand_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case BODY:
			objToWrite = new Body("hand_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case HAT_GREEN:
			objToWrite = new Hat("hand_" + elf.getId() + "_" + partNr, "GREEN", elf.getId(), defect);
			break;
		case HAT_RED:
			objToWrite = new Hat("hand_" + elf.getId() + "_" + partNr, "RED", elf.getId(), defect);
			break;
		default:
			break;
		}
		if (!webServicesActivated) {
			MozartSpacesControllerReference.getInstance().write(objToWrite);
		} else {
			// TODO
		}
	}

	public static CentralController getInstance() {
		return instance;
	}

	public static void setInstance(CentralController instance) {
		CentralController.instance = instance;
	}

}
