package at.tuwien.sbc.task2.xvsmimpl.worker;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.FifoCoordinator;
import org.mozartspaces.capi3.LabelCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.DefaultMzsCore;
import org.mozartspaces.core.Entry;
import org.mozartspaces.core.MzsCore;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.worker.assembly.AssemblyGnome;
import at.tuwien.sbc.task2.xvsmimpl.XMasWorkshopWarehouse;
import at.tuwien.sbc.task2.xwmodel.Body;
import at.tuwien.sbc.task2.xwmodel.Hand;
import at.tuwien.sbc.task2.xwmodel.Hat;
import at.tuwien.sbc.task2.xwmodel.Head;
import at.tuwien.sbc.task2.xwmodel.Leg;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;
import at.tuwien.sbc.task2.xwmodel.TeddyBearPart;

public class AssemblyGnomeThread extends Thread {

    private static Logger logger = Logger.getLogger(AssemblyGnomeThread.class);

    private AssemblyGnome assemblyGnome;
    private Random randomGen;

    private MzsCore core;
    private Capi capi;
    private ContainerReference hatContainer;
    private ContainerReference headContainer;
    private ContainerReference bodyContainer;
    private ContainerReference armContainer;
    private ContainerReference legContainer;
    private ContainerReference teddyBearContainer;
    private URI uri;

    public AssemblyGnomeThread() {
        assemblyGnome = new AssemblyGnome("AssemblyGnome_" + this.getName());
        randomGen = new Random();
        initMozartSpaces();
    }

    public static void main(String[] args) {
        new AssemblyGnomeThread().start();
    }

    private void initMozartSpaces() {
        logger.info("init MozartSpaces");
        try {
            uri = new URI(XMasWorkshopWarehouse.SERVER_URI);
            core = DefaultMzsCore.newInstance(0);
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

    public void run() {
        while (true) {

            ArrayList<TeddyPart> foundTeddyParts = new ArrayList<TeddyPart>();
            ArrayList<TeddyPart> tmp = new ArrayList<TeddyPart>();

            try {
                // TODO set transaction
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

                if (foundTeddyParts.size() > 0) {
                    if (allPartForTeddyBearThere(foundTeddyParts)) {
                        TeddyBear teddy = this.assembleTeddy(foundTeddyParts);
                        Entry entry = new Entry(teddy, LabelCoordinator.newCoordinationData("teddyBear"));
                        // pass the same transaction if possible if not commit
                        // and pass a new one
                        capi.write(teddyBearContainer, entry);

                        capi.delete(hatContainer, Arrays.asList(FifoCoordinator.newSelector(1)), 0, null);
                        capi.delete(headContainer, Arrays.asList(FifoCoordinator.newSelector(1)), 0, null);
                        capi.delete(bodyContainer, Arrays.asList(FifoCoordinator.newSelector(1)), 0, null);
                        capi.delete(armContainer, Arrays.asList(FifoCoordinator.newSelector(2)), 0, null);
                        capi.delete(legContainer, Arrays.asList(FifoCoordinator.newSelector(2)), 0, null);
                        // TODO commit transaction;
                        
                        logger.info("Teddy with id [" + teddy.getId() + "] created.");
                    }
                }

                Thread.sleep(3000);

            } catch (MzsCoreException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                // do nothing;
            }
        }
    }

    private TeddyBear assembleTeddy(ArrayList<TeddyPart> foundTeddyParts) {
        final StringBuffer buffer = new StringBuffer();
        final TeddyBear teddy = new TeddyBear();

        buffer.append("teddy_");
        for (TeddyPart part : foundTeddyParts) {
            TeddyBearPart type = part.getTeddyPartType();

            switch (type) {
                case ARM:
                    if (teddy.getLeftHand() == null) {
                        teddy.setLeftHand((Hand) part);
                    } else {
                        teddy.setRightHand((Hand) part);
                    }
                    buffer.append(part.getId());
                    break;
                case BODY:
                    teddy.setBody((Body) part);
                    buffer.append(part.getId());
                    break;

                case HAT:
                    teddy.setHat((Hat) part);
                    buffer.append(part.getId());
                    break;

                case HEAD:
                    teddy.setHead((Head) part);
                    buffer.append(part.getId());
                    break;

                case LEG:
                    if (teddy.getLeftLeg() == null) {
                        teddy.setLeftLeg((Leg) part);
                    } else {
                        teddy.setRightLeg((Leg) part);
                    }
                    buffer.append(part.getId());
                    break;
            }
        }

        buffer.append("_r" + randomGen.nextInt(1000));
        teddy.setId(buffer.toString());
        return teddy;
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
                case HAT:
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
