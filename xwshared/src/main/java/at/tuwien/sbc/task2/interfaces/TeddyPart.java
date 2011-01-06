package at.tuwien.sbc.task2.interfaces;

import at.tuwien.sbc.task2.xwmodel.TeddyBearPart;

public interface TeddyPart extends XMasWorkshopEntry {

	String getId();

	void setId(String id);

	String getProducerId();

	void setProducerId(String workerId);

	boolean isDefective();

	void setDefective(boolean defective);
	
	TeddyBearPart getTeddyPartType();

}
