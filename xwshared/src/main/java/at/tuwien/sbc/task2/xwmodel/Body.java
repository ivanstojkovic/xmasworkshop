package at.tuwien.sbc.task2.xwmodel;

import at.tuwien.sbc.task2.interfaces.TeddyPart;

public class Body extends XMasWorkshopObject implements TeddyPart {

	private static final long serialVersionUID = -3455228566335648270L;

	private String id;

	private String workerId;

	private boolean defective;

	public Body(String id, String workerId, boolean defective) {
		super();
		this.id = id;
		this.workerId = workerId;
		this.defective = defective;
	}

	public Body() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Body [id=" + id + ", workerId=" + workerId + ", defective=" + defective + "]";
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

	public void setProducerId(String worker) {
		this.workerId = worker;
	}

	@Override
	public TeddyBearPart getTeddyPartType() {
		return TeddyBearPart.BODY;
	}

}
