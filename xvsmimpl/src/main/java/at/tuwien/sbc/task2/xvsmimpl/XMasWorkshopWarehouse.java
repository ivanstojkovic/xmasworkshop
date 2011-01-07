package at.tuwien.sbc.task2.xvsmimpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.FifoCoordinator;
import org.mozartspaces.capi3.KeyCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsConstants;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.Hat;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class XMasWorkshopWarehouse {
    
    private static Logger logger = Logger.getLogger(XMasWorkshopWarehouse.class);
    
    public static final String SERVER_URI = "xvsm://localhost:9876";
    
    private static MzsCore core;
    private static Capi capi;
    private static ContainerReference hatContainer;
    private static ContainerReference headContainer;
    private static ContainerReference bodyContainer;
    private static ContainerReference armContainer;
    private static ContainerReference legContainer;
    private static ContainerReference teddyBearContainer;
    private static ContainerReference logisticsContainer;
    private static ContainerReference defectiveContainer;
    private static URI uri;
    
    private XMasWorkshopWarehouse() {
    }
    
    public static void main(String[] args) {
        initMozartSpaces();
    }
    
    private static void initMozartSpaces() {
        logger.info("init MozartSpaces");
        try {
            uri = new URI(SERVER_URI);
            core = DefaultMzsCore.newInstance(9876);
            capi = new Capi(core);
            hatContainer = capi.createContainer("hatContainer", uri, MzsConstants.Container.UNBOUNDED, Arrays.asList(
                new KeyCoordinator(), new FifoCoordinator()), null, null);
            headContainer = capi.createContainer("headContainer", uri, MzsConstants.Container.UNBOUNDED, Arrays.asList(
                new KeyCoordinator(), new FifoCoordinator()), null, null);
            bodyContainer = capi.createContainer("bodyContainer", uri, MzsConstants.Container.UNBOUNDED, Arrays.asList(
                new KeyCoordinator(), new FifoCoordinator()), null, null);
            armContainer = capi.createContainer("armContainer", uri, MzsConstants.Container.UNBOUNDED, Arrays.asList(
                new KeyCoordinator(), new FifoCoordinator()), null, null);
            legContainer = capi.createContainer("legContainer", uri, MzsConstants.Container.UNBOUNDED, Arrays.asList(
                new KeyCoordinator(), new FifoCoordinator()), null, null);
            teddyBearContainer = capi.createContainer("teddyBearContainer", uri, MzsConstants.Container.UNBOUNDED,
                Arrays.asList(new FifoCoordinator(), new LabelCoordinator()), null, null);
            logisticsContainer = capi.createContainer("logisticsContainer", uri, MzsConstants.Container.UNBOUNDED,
                Arrays.asList(new KeyCoordinator()), null, null);
            
            generateTestData();
            
            // TODO create a shutdown hook to stop the space...
            
        } catch (MzsCoreException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    private static void generateTestData() {
        TeddyBear tb1 = new TeddyBear("ivan", new Head("h", "1", false), new Body("b", "2", true), new Hand("hl", "2",
            false), new Hand("hr", "3", false), new Leg("l1", "3", false), new Leg("l2", "4", true), new Hat("hat",
            "5", "red", false), true, false);
        TeddyBear tb2 = new TeddyBear("ivan1", new Head("h1", "1", false), new Body("1b", "2", false), new Hand("h1l",
            "2", false), new Hand("h1r", "3", false), new Leg("l11", "3", false), new Leg("l12", "4", false), new Hat(
            "ha1t", "5", "green", false), false, true);
        try {
            Entry entry1 = new Entry(tb1, LabelCoordinator.newCoordinationData("teddyBear"));
            Entry entry2 = new Entry(tb2, LabelCoordinator.newCoordinationData("teddyBear"));
            capi.write(teddyBearContainer, entry1);
            logger.info("Writting test TeddyBear: " + tb1.toString());
            capi.write(teddyBearContainer, entry2);
            logger.info("Writting test TeddyBear: " + tb2.toString());
        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
        
    }
    
}
