package at.tuwien.sbc.task2.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.mozartspaces.MozartSpacesControllerReference;
import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.Hat;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;
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
				//	TODO technologyInstance = WebServiceControllerReference.getInstance(); 
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
		TeddyPart objToWrite = null;
		switch (elf.getFunction()) {
		case ARM:
			objToWrite = new Hand("arm_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case LEG:
			objToWrite = new Leg("leg_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case HEAD:
			objToWrite = new Head("head_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case BODY:
			objToWrite = new Body("body_" + elf.getId() + "_" + partNr, elf.getId(), defect);
			break;
		case HAT_GREEN:
			objToWrite = new Hat("hat_green_" + elf.getId() + "_" + partNr, "GREEN", elf.getId(), defect);
			break;
		case HAT_RED:
			objToWrite = new Hat("hat_red_" + elf.getId() + "_" + partNr, "RED", elf.getId(), defect);
			break;
		default:
			break;
		}
		technologyInstance.write(objToWrite);
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
