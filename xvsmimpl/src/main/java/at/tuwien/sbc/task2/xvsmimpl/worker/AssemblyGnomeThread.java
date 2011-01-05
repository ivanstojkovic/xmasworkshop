package at.tuwien.sbc.task2.xvsmimpl.worker;

import org.apache.log4j.Logger;
import org.mozartspaces.core.ContainerReference;

import at.tuwien.sbc.task2.worker.assembly.AssemblyGnome;

public class AssemblyGnomeThread extends Thread {

	private static Logger logger = Logger.getLogger(AssemblyGnomeThread.class);

	private AssemblyGnome assemblyGnome;
	private ContainerReference partContainer;
	private ContainerReference teddyBearContainer;

	public AssemblyGnomeThread(AssemblyGnome assemblyGnome, ContainerReference partContainer, ContainerReference teddyBearContainer) {
		this.assemblyGnome = assemblyGnome;
	}

	public void run() {
		
	}

}
