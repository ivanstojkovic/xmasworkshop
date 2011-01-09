package at.tuwien.sbc.task2.worker.production;

import java.io.Serializable;

import at.tuwien.sbc.task2.interfaces.Worker;
import at.tuwien.sbc.task2.xwmodel.TeddyBearPart;

public class ProductionElf implements Worker, Serializable {

	private static final long serialVersionUID = -2634915623543199423L;

	private String id;

	private int errorRate;

	private TeddyBearPart function;

	private int quantity;

	public ProductionElf() {
		super();
	}

	public ProductionElf(String id, int errorRate, TeddyBearPart function, int quantity) {
		super();
		this.id = id;
		this.errorRate = errorRate;
		this.function = function;
		this.quantity = quantity;
	}

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setErrorRate(int errorRate) {
		this.errorRate = errorRate;
	}

	public int getErrorRate() {
		return errorRate;
	}

	public TeddyBearPart getFunction() {
		return function;
	}

	public void setFunction(TeddyBearPart function) {
		this.function = function;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
