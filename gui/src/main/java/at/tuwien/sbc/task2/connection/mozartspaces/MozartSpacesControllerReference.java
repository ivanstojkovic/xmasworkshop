package at.tuwien.sbc.task2.connection.mozartspaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.FifoCoordinator;
import org.mozartspaces.capi3.KeyCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.connection.Controller;
import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.Hat;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class MozartSpacesControllerReference implements Controller {

    private static Logger logger = Logger.getLogger(MozartSpacesControllerReference.class);

    public static final String SERVER_URI = "xvsm://localhost:9876";

    private static MozartSpacesControllerReference instance = new MozartSpacesControllerReference();

    private MzsCore core;
    private Capi capi;
    private ContainerReference hatContainer;
    private ContainerReference headContainer;
    private ContainerReference bodyContainer;
    private ContainerReference armContainer;
    private ContainerReference legContainer;
    private ContainerReference teddyBearContainer;
    private URI uri;

    private MozartSpacesControllerReference() {
        initMozartSpaces();
    }

    private void initMozartSpaces() {
        logger.info("init MozartSpaces");
        try {
            uri = new URI(SERVER_URI);
            core = DefaultMzsCore.newInstance(0);
            ;
            capi = new Capi(core);
            hatContainer = capi.lookupContainer("hatContainer", uri, 0, null);
            headContainer = capi.lookupContainer("headContainer", uri, 0, null);
            bodyContainer = capi.lookupContainer("bodyContainer", uri, 0, null);
            armContainer = capi.lookupContainer("armContainer", uri, 0, null);
            legContainer = capi.lookupContainer("legContainer", uri, 0, null);
            teddyBearContainer = capi.lookupContainer("teddyBearContainer", uri, 0, null);
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
            Entry entry = new Entry(o, KeyCoordinator.newCoordinationData(o.getId()));

            if (o instanceof TeddyBear) {
                capi.write(teddyBearContainer, entry);

            } else if (o instanceof Hat) {
                capi.write(hatContainer, entry);

            } else if (o instanceof Head) {
                capi.write(headContainer, entry);

            } else if (o instanceof Body) {
                capi.write(bodyContainer, entry);

            } else if (o instanceof Hand) {
                capi.write(armContainer, entry);

            } else if (o instanceof Leg) {
                capi.write(legContainer, entry);
            }

        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
    }

    public void shutdownTheServer() {
        try {
            capi.destroyContainer(hatContainer, null);
            capi.destroyContainer(teddyBearContainer, null);
            core.shutdown(true);
        } catch (MzsCoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void writePart(ProductionElf elf, int partNr, boolean defect) {
        try {
            TeddyPart objToWrite = null;
            Entry entry = null; 
            switch (elf.getFunction()) {
                case ARM:
                    objToWrite = new Hand("arm_" + elf.getId() + "_" + partNr, elf.getId(), defect);
                    entry = new Entry(objToWrite, KeyCoordinator.newCoordinationData("arm_" + elf.getId() + "_" + partNr));
                    capi.write(armContainer, entry);
                    break;
                case LEG:
                    objToWrite = new Leg("leg_" + elf.getId() + "_" + partNr, elf.getId(), defect);
                    entry = new Entry(objToWrite, KeyCoordinator.newCoordinationData("leg_" + elf.getId() + "_" + partNr));
                    capi.write(legContainer, entry);
                    break;
                case HEAD:
                    objToWrite = new Head("head_" + elf.getId() + "_" + partNr, elf.getId(), defect);
                    entry = new Entry(objToWrite, KeyCoordinator.newCoordinationData("head_" + elf.getId() + "_" + partNr));
                    capi.write(headContainer, entry);
                    break;
                case BODY:
                    objToWrite = new Body("body_" + elf.getId() + "_" + partNr, elf.getId(), defect);
                    entry = new Entry(objToWrite, KeyCoordinator.newCoordinationData("body_" + elf.getId() + "_" + partNr));
                    capi.write(bodyContainer, entry);
                    break;
                case HAT_RED:
                    objToWrite = new Hat("hat_" + elf.getId() + "_" + partNr, elf.getId(),
                            elf.getFunction().toString(), defect);
                    entry = new Entry(objToWrite, KeyCoordinator.newCoordinationData("hat_" + elf.getId() + "_" + partNr));
                    capi.write(hatContainer, entry);
                    break;
                case HAT_GREEN:
                    objToWrite = new Hat("hat_" + elf.getId() + "_" + partNr, elf.getId(),
                            elf.getFunction().toString(), defect);
                    entry = new Entry(objToWrite, KeyCoordinator.newCoordinationData("hat_" + elf.getId() + "_" + partNr));
                    capi.write(hatContainer, entry);
                    break;
                default:
                    break;
            }
        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TeddyBear> findTeddyBears() {
        ArrayList<TeddyBear> foundTeddyBears = new ArrayList<TeddyBear>();
        try {
            foundTeddyBears = capi.read(teddyBearContainer, Arrays.asList(LabelCoordinator.newSelector("teddyBear",
                    LabelCoordinator.LabelSelector.COUNT_ALL)), 0, null);
            logger.info("found " + foundTeddyBears.size() + " TeddyBears");
        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
        return foundTeddyBears;
    }

    //TODO set transaction
    @Override
    public List<TeddyPart> findTeddyParts() {
        ArrayList<TeddyPart> foundTeddyParts = new ArrayList<TeddyPart>();
        ArrayList<TeddyPart> tmp = new ArrayList<TeddyPart>();
        try {
            tmp = capi.read(hatContainer, Arrays.asList(FifoCoordinator
                    .newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
            foundTeddyParts.addAll(tmp);
            
            tmp = capi.read(headContainer, Arrays.asList(FifoCoordinator
                    .newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
            foundTeddyParts.addAll(tmp);
            
            tmp = capi.read(bodyContainer, Arrays.asList(FifoCoordinator
                    .newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
            foundTeddyParts.addAll(tmp);
            
            tmp = capi.read(armContainer, Arrays.asList(FifoCoordinator
                    .newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
            foundTeddyParts.addAll(tmp);
            
            tmp = capi.read(legContainer, Arrays.asList(FifoCoordinator
                    .newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
            foundTeddyParts.addAll(tmp);
            
            logger.info("found " + foundTeddyParts.size() + " TeddyParts");
        } catch (MzsCoreException e) {
            e.printStackTrace();
        }
        return foundTeddyParts;
    }

}
