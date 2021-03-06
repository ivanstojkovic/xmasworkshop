package at.tuwien.sbc.task2.xwmodel;

import at.tuwien.sbc.task2.interfaces.TeddyPart;

public class Hand extends XMasWorkshopObject implements TeddyPart {

	private static final long serialVersionUID = 9053548900952656436L;

	private String id;

	private String workerId;

	private boolean defective;

	public Hand(String id, String workerId, boolean defective) {
		super();
		this.id = id;
		this.workerId = workerId;
		this.defective = defective;
	}

	public Hand() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Hand [id=" + id + ", workerId=" + workerId + ", defective=" + defective + "]";
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
		return TeddyBearPart.ARM;
	}

}
