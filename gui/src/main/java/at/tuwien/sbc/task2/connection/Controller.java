package at.tuwien.sbc.task2.connection;

import java.util.List;

import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public interface Controller {
	void write(XMasWorkshopEntry o);
	void writePart(ProductionElf elf, int partNr, boolean defect);
	List<TeddyBear> findTeddyBears();
	List<TeddyPart> findTeddyParts();
    List<TeddyBear> findReadyTeddyBears();
    List<TeddyBear> findDefectiveTeddyBears();
}
