package at.tuwien.sbc.task2.xvsmimpl.worker;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.FifoCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.MzsConstants;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.worker.assembly.AssemblyGnome;
import at.tuwien.sbc.task2.xvsmimpl.XMasWorkshopWarehouse;

public class AssemblyGnomeThread extends Thread {

	private static Logger logger = Logger.getLogger(AssemblyGnomeThread.class);

	private static AssemblyGnome assemblyGnome;

	private static MzsCore core;
	private static Capi capi;
	private static ContainerReference partContainer;
	private static ContainerReference teddyBearContainer;
	private static URI uri;

	public AssemblyGnomeThread() {
		assemblyGnome = new AssemblyGnome("AssemblyGnome_" + this.getName());
		initMozartSpaces();
	}

	public static void main(String[] args) {
		new AssemblyGnomeThread().start();
	}
	
	private static void initMozartSpaces() {
		logger.info("init MozartSpaces");
		try {
			uri = new URI(XMasWorkshopWarehouse.SERVER_URI);
			core = DefaultMzsCore.newInstance(0);;
			capi = new Capi(core);
			partContainer = capi.lookupContainer("partsContainer", uri, 0, null);
			teddyBearContainer = capi.lookupContainer("teddyBearContainer", uri, 0 ,null);
		} catch (MzsCoreException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {

			ArrayList<TeddyPart> foundTeddyParts = new ArrayList<TeddyPart>();
			try {
				foundTeddyParts = capi.read(partContainer,
						Arrays.asList(FifoCoordinator.newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
				logger.info("found " + foundTeddyParts.size() + " TeddyParts");
			} catch (MzsCoreException e) {
				e.printStackTrace();
			}

			if (foundTeddyParts.size() > 0) {
				if (allPartForTeddyBearThere(foundTeddyParts)) {
					// TODO	
				}
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			}
		}
	}

	private boolean allPartForTeddyBearThere(ArrayList<TeddyPart> foundTeddyParts) {
		boolean hatExist = false;
		boolean headExist = false;
		boolean legLeftExist = false;
		boolean legRightExist = false;
		boolean armLeftExist = false;
		boolean armRightExist = false;
		boolean bodyExist = false;
		for (TeddyPart tp : foundTeddyParts) {
			switch (tp.getTeddyPartType()) {
			case HEAD:
				headExist = true;
				break;
			case HAT_GREEN:
				hatExist = true;
				break;
			case HAT_RED:
				hatExist = true;
				break;
			case LEG:
				if (legLeftExist) {
					legRightExist = true;
				} else {
					legLeftExist = true;
				}
				break;
			case ARM:
				if (armLeftExist) {
					armRightExist = true;
				} else {
					armLeftExist = true;
				}
				break;
			case BODY:
				bodyExist = true;
				break;
			default:
				break;
			}
		}
		if (hatExist && headExist && legLeftExist && legRightExist && armLeftExist && armRightExist && bodyExist) {
			return true;
		}
		return false;
	}

}
