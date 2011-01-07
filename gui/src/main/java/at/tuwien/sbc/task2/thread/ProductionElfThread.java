package at.tuwien.sbc.task2.thread;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.CentralController;
import at.tuwien.sbc.task2.worker.production.ProductionElf;

public class ProductionElfThread extends Thread {

	private static Logger logger = Logger.getLogger(ProductionElfThread.class);

	private ProductionElf elf;

	public ProductionElfThread(ProductionElf elf) {
		this.elf = elf;
		this.elf.setId(elf.getId()+"_"+this.getName());
	}

	public void run() {
		int everyXDefective = (int) Math.ceil(((double) elf.getErrorRate() * elf.getQuantity() / 100));
		logger.info("Elf will produce " + everyXDefective + " defective parts");
		
		for (int i = 0; i < elf.getQuantity(); i++) {
			CentralController.getInstance().writePart(elf, i+1, ((i < everyXDefective) ? true : false));
			logger.info("Elf " + elf.getId() + " created " + (i + 1) + "/" + elf.getQuantity() + " " + elf.getFunction() + "s");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}

}
