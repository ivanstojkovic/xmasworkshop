package at.tuwien.sbc.task2.alternateimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.Hat;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;
import at.tuwien.sbc.task2.xwmodel.XMasWorkshopObject;

public class XMasWorkshopWarehouse {

	private static Logger logger = Logger.getLogger(XMasWorkshopWarehouse.class);

	private static XMasWorkshopWarehouse instance = new XMasWorkshopWarehouse();

	private List<Hat> hatContainer;
	private List<Head> headContainer;
	private List<Body> bodyContainer;
	private List<Hand> armContainer;
	private List<Leg> legContainer;
	private List<TeddyBear> teddyBearContainer;

	private XMasWorkshopWarehouse() {
		hatContainer = Collections.synchronizedList(new ArrayList<Hat>());
		headContainer = Collections.synchronizedList(new ArrayList<Head>());
		bodyContainer = Collections.synchronizedList(new ArrayList<Body>());
		armContainer = Collections.synchronizedList(new ArrayList<Hand>());
		legContainer = Collections.synchronizedList(new ArrayList<Leg>());
		teddyBearContainer = Collections.synchronizedList(new ArrayList<TeddyBear>());
		generateTestData();
	}

	private void generateTestData() {
		TeddyBear tb1 = new TeddyBear("ivan", new Head("h", "1", false), new Body("b", "2", true), new Hand("hl", "2", false), new Hand(
				"hr", "3", false), new Leg("l1", "3", false), new Leg("l2", "4", true), new Hat("hat", "5", "red", false), true, false);
		TeddyBear tb2 = new TeddyBear("ivan1", new Head("h1", "1", false), new Body("1b", "2", false), new Hand("h1l", "2", false),
				new Hand("h1r", "3", false), new Leg("l11", "3", false), new Leg("l12", "4", false), new Hat("ha1t", "5", "green", false),
				false, true);
		teddyBearContainer.add(tb1);
		teddyBearContainer.add(tb2);
	}

	public void insertEntry(XMasWorkshopObject entry) {
		logger.info("insert Entry: " + entry);
		if (entry == null) {
			return;
		}
		if (entry instanceof Hat) {
			synchronized (hatContainer) {
				hatContainer.add((Hat) entry);
			}
		}
		if (entry instanceof Head) {
			synchronized (headContainer) {
				headContainer.add((Head) entry);
			}
		}
		if (entry instanceof Body) {
			synchronized (bodyContainer) {
				bodyContainer.add((Body) entry);
			}
		}
		if (entry instanceof Hand) {
			synchronized (armContainer) {
				armContainer.add((Hand) entry);
			}
		}
		if (entry instanceof Leg) {
			synchronized (legContainer) {
				legContainer.add((Leg) entry);
			}
		}
		if (entry instanceof TeddyBear) {
			synchronized (teddyBearContainer) {
				teddyBearContainer.add((TeddyBear) entry);
			}
		}

		logger.info("Container info: " + hatContainer.size() + " " + headContainer.size() + " " + bodyContainer.size() + " "
				+ armContainer.size() + " " + legContainer.size() + " " + teddyBearContainer.size());
	}

	public void writePart(ProductionElf elf, int partNr, boolean defect) {
		XMasWorkshopObject objToWrite = null;
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
		case HAT_RED:
			objToWrite = new Hat("hat_" + elf.getId() + "_" + partNr, elf.getId(), elf.getFunction().toString(), defect);
			break;
		case HAT_GREEN:
			objToWrite = new Hat("hat_" + elf.getId() + "_" + partNr, elf.getId(), elf.getFunction().toString(), defect);
			break;
		default:
			break;
		}
		insertEntry(objToWrite);
	}

	public static synchronized XMasWorkshopWarehouse getInstance() {
		if(instance == null) {
			instance = new XMasWorkshopWarehouse();
		}
		return instance;
	}

	public synchronized List<TeddyBear> findTeddyBears() {
		return teddyBearContainer;
	}

	public synchronized List<XMasWorkshopObject> findTeddyParts() {
		List<XMasWorkshopObject> toReturn = new ArrayList<XMasWorkshopObject>();
		toReturn.addAll(hatContainer);
		toReturn.addAll(headContainer);
		toReturn.addAll(armContainer);
		toReturn.addAll(legContainer);
		toReturn.addAll(bodyContainer);
		return toReturn;
	}

	public synchronized void tryToAssembleTeddyBear(String teddyId) {
		logger.info("tryToAssembleTeddyBear " + teddyId);
		synchronized (this) {
			if (!hatContainer.isEmpty() && !headContainer.isEmpty() && !bodyContainer.isEmpty() && legContainer.size() > 1 && armContainer.size() > 1) {
				TeddyBear newTeddy = new TeddyBear(teddyId, headContainer.remove(0), bodyContainer.remove(0), armContainer.remove(1), armContainer.remove(0), legContainer.remove(1), legContainer.remove(0), hatContainer.remove(0), false, false);
				logger.info("TeddyBear " + newTeddy.toString() + " created!");
				teddyBearContainer.add(newTeddy);
			}
		}
	}

}
