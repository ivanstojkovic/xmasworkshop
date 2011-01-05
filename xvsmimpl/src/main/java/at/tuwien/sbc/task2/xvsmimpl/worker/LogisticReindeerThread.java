package at.tuwien.sbc.task2.xvsmimpl.worker;

import org.apache.log4j.Logger;
import org.mozartspaces.core.ContainerReference;

import at.tuwien.sbc.task2.worker.assembly.AssemblyGnome;
import at.tuwien.sbc.task2.worker.logistics.LogisticReindeer;

public class LogisticReindeerThread extends Thread {

	private static Logger logger = Logger.getLogger(LogisticReindeerThread.class);

	private LogisticReindeer logisticReindeer;
	private ContainerReference teddyBearContainer;

	public LogisticReindeerThread(LogisticReindeer logisticReindeer, ContainerReference teddyBearContainer) {
		this.logisticReindeer = logisticReindeer;
	}

	public void run() {
		
	}

}
