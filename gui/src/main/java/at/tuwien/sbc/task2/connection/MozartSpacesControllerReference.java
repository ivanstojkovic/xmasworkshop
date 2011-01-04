package at.tuwien.sbc.task2.connection;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;

public class MozartSpacesControllerReference {

	private static Logger logger = Logger.getLogger(MozartSpacesControllerReference.class);

	public static final String SERVER_URI = "xvsm://localhost:9876";

	private static MozartSpacesControllerReference instance = new MozartSpacesControllerReference();

	private MzsCore core;
	private Capi capi;
	private ContainerReference containerRef;
	private URI uri;
	private boolean webServicesActivated = false;

	private MozartSpacesControllerReference() {
		initMozartSpaces();
	}

	private void initMozartSpaces() {
		logger.info("init MozartSpaces");
		try {
			uri = new URI(SERVER_URI);
			core = DefaultMzsCore.newInstance();
			capi = new Capi(core);
			containerRef = capi.createContainer(uri, null, null);
		} catch (MzsCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MozartSpacesControllerReference getInstance() {
		return instance;
	}

	public void write(XMasWorkshopEntry o) {
		try {
			Entry entry = new Entry(o);
			capi.write(containerRef, entry);
		} catch (MzsCoreException e) {
			e.printStackTrace();
		}
	}

	public void shutdownTheServer() {
		try {
			capi.destroyContainer(containerRef, null);
			core.shutdown(true);
		} catch (MzsCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
