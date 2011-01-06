package at.tuwien.sbc.task2.xvsmimpl.worker;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.mozartspaces.capi3.FifoCoordinator;
import org.mozartspaces.core.Capi;
import org.mozartspaces.core.ContainerReference;
import org.mozartspaces.core.MzsCoreException;

import at.tuwien.sbc.task2.interfaces.TeddyPart;
import at.tuwien.sbc.task2.worker.assembly.AssemblyGnome;
import at.tuwien.sbc.task2.xwmodel.TeddyBearPart;

public class AssemblyGnomeThread extends Thread {

	private static Logger logger = Logger.getLogger(AssemblyGnomeThread.class);

	private AssemblyGnome assemblyGnome;
	private ContainerReference partContainer;
	private ContainerReference teddyBearContainer;
	private Capi capi;

	public AssemblyGnomeThread(Capi capi, AssemblyGnome assemblyGnome, ContainerReference partContainer, ContainerReference teddyBearContainer) {
		this.assemblyGnome = assemblyGnome;
	}

	public void run() {
		while(true) {
			
			ArrayList<TeddyPart> foundTeddyParts = new ArrayList<TeddyPart>();
			try {
				foundTeddyParts = capi.read(partContainer, Arrays.asList(FifoCoordinator.newSelector(FifoCoordinator.FifoSelector.COUNT_ALL)), 0, null);
				logger.info("found " + foundTeddyParts.size() + " TeddyParts");
			} catch (MzsCoreException e) {
				e.printStackTrace();
			}
			
			if(foundTeddyParts.size()>0) {
				if(allPartForTeddyBearThere(foundTeddyParts)) {
					
				}
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			}
		}
	}

	private boolean allPartForTeddyBearThere(ArrayList<TeddyPart> foundTeddyParts) {
		boolean hatExist = false;
		boolean headExist = false;
		boolean legLeftExist = false;
		boolean legRightExist = false;
		boolean armLeftExist = false;
		boolean armRightExist = false;
		boolean bodyExist = false;
		for(TeddyPart tp : foundTeddyParts) {
			switch (tp.getTeddyPartType()) {
			case HEAD:
				headExist = true;
				break;
			case HAT_GREEN:
				hatExist = true;
				break;
			case HAT_RED:
				hatExist = true;
				break;
			case LEG:
				if(legLeftExist) {
					legRightExist = true;
				}else{
					legLeftExist = true;
				}
				break;
			case ARM:
				if(armLeftExist) {
					armRightExist = true;
				}else{
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
		if(hatExist && headExist && legLeftExist && legRightExist && armLeftExist && armRightExist && bodyExist) {
			return true;
		}
		return false;
	}

}
