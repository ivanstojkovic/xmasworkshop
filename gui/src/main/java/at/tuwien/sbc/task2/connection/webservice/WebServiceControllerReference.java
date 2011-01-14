package at.tuwien.sbc.task2.connection.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.TeddyBearPart;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopObject;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService_Service;
import at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.TeddyBear.DoneTests.Entry;
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

public class WebServiceControllerReference implements Controller {

    private static Logger logger = Logger.getLogger(WebServiceControllerReference.class);

    private static WebServiceControllerReference instance = new WebServiceControllerReference();

    XMasWorkshopWarehouseService xmasWarehouse;

    private WebServiceControllerReference() {
        initWebService();
    }

    private void initWebService() {
        logger.info("initWebService");

        XMasWorkshopWarehouseService_Service xMasWorkshopServiceService = new XMasWorkshopWarehouseService_Service();

        xmasWarehouse = xMasWorkshopServiceService.getXMasWorkshopWarehouseServicePort();

        ((BindingProvider) xmasWarehouse).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8080/xmasworkshop");

        logger.info(((BindingProvider) xmasWarehouse).toString());

        logger.info("From XMasWarehouse: " + xmasWarehouse.sayHello());

    }

    public static WebServiceControllerReference getInstance() {
        return instance;
    }

    @Override
    public void write(XMasWorkshopEntry o) {
        xmasWarehouse.write((XMasWorkshopObject) o);
    }

    @Override
    public void writePart(ProductionElf elf, int partNr, boolean defect) {
        at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.ProductionElf wsElf = new at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.ProductionElf();
        wsElf.setId(elf.getId());
        wsElf.setErrorRate(elf.getErrorRate());
        wsElf.setFunction(TeddyBearPart.valueOf(elf.getFunction().name()));
        wsElf.setQuantity(elf.getQuantity());
        xmasWarehouse.writePart(wsElf, partNr, defect);
    }

    @Override
    public List<TeddyBear> findTeddyBears() {
        return this.getTeddyBearsList(xmasWarehouse.findTeddyBears());
    }

    @Override
    public List<TeddyBear> findDefectiveTeddyBears() {
        return this.getTeddyBearsList(xmasWarehouse.findDefectiveTeddyBears());
    }

    @Override
    public List<TeddyBear> findReadyTeddyBears() {
        return this.getTeddyBearsList(xmasWarehouse.findReadyTeddyBears());
    }

    @Override
    public List<TeddyPart> findTeddyParts() {
        List<TeddyPart> toReturn = new ArrayList<TeddyPart>();
        List<XMasWorkshopObject> partsFromWs = xmasWarehouse.findTeddyParts();
        for (XMasWorkshopObject obj : partsFromWs) {
            if (obj instanceof at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Head) {
                at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Head wrapper = (at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Head) obj;
                toReturn.add(new Head(wrapper.getId(), wrapper.getProducerId(), wrapper.isDefective()));
            }
            if (obj instanceof at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Hat) {
                at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Hat wrapper = (at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Hat) obj;
                toReturn.add(new Hat(wrapper.getId(), wrapper.getProducerId(), wrapper.getColor(), wrapper
                        .isDefective()));
            }
            if (obj instanceof at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Body) {
                at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Body wrapper = (at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Body) obj;
                toReturn.add(new Body(wrapper.getId(), wrapper.getProducerId(), wrapper.isDefective()));
            }
            if (obj instanceof at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Hand) {
                at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Hand wrapper = (at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Hand) obj;
                toReturn.add(new Hand(wrapper.getId(), wrapper.getProducerId(), wrapper.isDefective()));
            }
            if (obj instanceof at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Leg) {
                at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Leg wrapper = (at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.Leg) obj;
                toReturn.add(new Leg(wrapper.getId(), wrapper.getProducerId(), wrapper.isDefective()));
            }
        }
        return toReturn;
    }

    private List<TeddyBear> getTeddyBearsList(
            List<at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.TeddyBear> wsList) {
        List<TeddyBear> toReturn = new ArrayList<TeddyBear>();
        for (at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.TeddyBear tb : wsList) {
            TeddyBear tbNew = new TeddyBear(tb.getId(), new Head(tb.getHead().getId(), tb.getHead().getProducerId(), tb
                    .getHead().isDefective()), new Body(tb.getBody().getId(), tb.getBody().getProducerId(), tb
                    .getBody().isDefective()), new Hand(tb.getLeftHand().getId(), tb.getLeftHand().getProducerId(), tb
                    .getLeftHand().isDefective()), new Hand(tb.getRightHand().getId(), tb.getRightHand()
                    .getProducerId(), tb.getRightHand().isDefective()), new Leg(tb.getLeftLeg().getId(), tb
                    .getLeftLeg().getProducerId(), tb.getLeftLeg().isDefective()), new Leg(tb.getRightLeg().getId(), tb
                    .getRightLeg().getProducerId(), tb.getRightLeg().isDefective()), new Hat(tb.getHat().getId(), tb
                    .getHat().getProducerId(), tb.getHat().getColor(), tb.getHat().isDefective()), tb.isDefective(), tb
                    .isReady());

            Map<String, Boolean> tests = new HashMap<String, Boolean>();
            List<Entry> entries = tb.getDoneTests().getEntry();

            for (Entry e : entries) {
                tests.put(e.getKey(), e.isValue());
            }

            tbNew.setDoneTests(tests);
            toReturn.add(tbNew);
        }
        return toReturn;
    }

}
