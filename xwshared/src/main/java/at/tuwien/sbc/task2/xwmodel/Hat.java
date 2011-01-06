package at.tuwien.sbc.task2.xwmodel;

import at.tuwien.sbc.task2.interfaces.TeddyPart;

public class Hat implements TeddyPart {

    private static final long serialVersionUID = -3930567611610841393L;

    private String id;

	private String workerId;

	private boolean defective;
	
	private String color;

	public Hat(String id, String workerId, String color, boolean defective) {
		super();
		this.id = id;
		this.workerId = workerId;
		this.color = color;
		this.defective = defective;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Hat [id=" + id + ", workerId=" + workerId + ", color=" + color + ", defective=" + defective + "]";
	}

	public String getProducerId() {
		return this.workerId;
	}

	public boolean isDefective() {
		return this.defective;
	}

	public void setDefective(boolean defective) {
		this.defective = defective;
	}

	public void setProducerId(String workerId) {
		this.workerId = workerId;
	}

	@Override
	public TeddyBearPart getTeddyPartType() {
		if (color.equals(TeddyBearPart.HAT_GREEN.name())) {
		    return TeddyBearPart.HAT_GREEN;
		}
		
		return TeddyBearPart.HAT_RED;
	}

}
