package at.tuwien.sbc.task2.connection.mozartspaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.FifoCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsConstants;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.connection.Controller;
import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.HatRed;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class MozartSpacesControllerReference implements Controller {

	private static Logger logger = Logger.getLogger(MozartSpacesControllerReference.class);

	public static final String SERVER_URI = "xvsm://localhost:9876";

	private static MozartSpacesControllerReference instance = new MozartSpacesControllerReference();

	private MzsCore core;
	private Capi capi;
	private ContainerReference partContainer;
	private ContainerReference teddyBearContainer;
	private URI uri;

	private MozartSpacesControllerReference() {
		initMozartSpaces();
	}

	private void initMozartSpaces() {
		logger.info("init MozartSpaces");
		try {
			uri = new URI(SERVER_URI);
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

	public static MozartSpacesControllerReference getInstance() {
		return instance;
	}

	public void write(XMasWorkshopEntry o) {
		try {
			Entry entry = new Entry(o, FifoCoordinator.newCoordinationData());
			capi.write(partContainer, entry);
		} catch (MzsCoreException e) {
			e.printStackTrace();
		}
	}

	public void shutdownTheServer() {
		try {
			capi.destroyContainer(partContainer, null);
			capi.destroyContainer(teddyBearContainer, null);
			core.shutdown(true);
		} catch (MzsCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void writePart(ProductionElf elf, int partNr, boolean defect) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TeddyBear> findTeddyBears() {
		ArrayList<TeddyBear> foundTeddyBears = new ArrayList<TeddyBear>();
		try {
			foundTeddyBears = capi.read(teddyBearContainer, Arrays.asList(LabelCoordinator.newSelector("teddyBear", LabelCoordinator.LabelSelector.COUNT_ALL)), 0, null);
			logger.info("found " + foundTeddyBears.size() + " TeddyBears");
		} catch (MzsCoreException e) {
			e.printStackTrace();
		}
		return foundTeddyBears;
	}

	@Override
	public List<TeddyPart> findTeddyParts() {
		ArrayList<TeddyPart> foundTeddyParts = new ArrayList<TeddyPart>();
		try {
			foundTeddyParts = capi.read(partContainer, Arrays.asList(FifoCoordinator.newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
			logger.info("found " + foundTeddyParts.size() + " TeddyParts");
		} catch (MzsCoreException e) {
			e.printStackTrace();
		}
		return foundTeddyParts;
	}

}
