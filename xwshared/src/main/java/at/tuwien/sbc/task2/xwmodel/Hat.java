package at.tuwien.sbc.task2.xwmodel;

import at.tuwien.sbc.task2.interfaces.TeddyPart;

public class Hat implements TeddyPart {

	private String id;

	private String color;

	private String workerId;

	private boolean defective;

	public Hat(String id, String color, String workerId, boolean defective) {
		super();
		this.id = id;
		this.color = color;
		this.workerId = workerId;
		this.defective = defective;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public String toString() {
		return "TeddyHat [id= " + this.id + "][color= " + this.color + "]";
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

}
