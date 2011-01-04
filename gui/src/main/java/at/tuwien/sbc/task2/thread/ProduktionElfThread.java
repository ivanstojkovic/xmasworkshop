package at.tuwien.sbc.task2.thread;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.CentralController;
import at.tuwien.sbc.task2.worker.production.ProductionElf;

public class ProduktionElfThread extends Thread {

	private static Logger logger = Logger.getLogger(ProduktionElfThread.class);

	private ProductionElf elf;

	public ProduktionElfThread(ProductionElf elf) {
		this.elf = elf;
	}

	public void run() {
		// each X part will be defective
		int everyXDefective = elf.getErrorRate() * elf.getQuantity();
		for (int i = 0; i < elf.getQuantity(); i++) {
			CentralController.getInstance().writePart(elf, i+1, ((i % everyXDefective == 0) ? true : false));
			logger.info("Elf " + elf.getId()+"_"+this.getName() + " created " + (i + 1) + "/" + elf.getQuantity() + " " + elf.getFunction() + "s");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}

}
