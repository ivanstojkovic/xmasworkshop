package at.tuwien.sbc.task2.connection;

import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.production.ProductionElf;

public interface Controller {
	void write(XMasWorkshopEntry o);
	void writePart(ProductionElf elf, int partNr, boolean defect);
}
