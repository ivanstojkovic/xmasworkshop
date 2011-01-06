package at.tuwien.sbc.task2.worker.assembly;

import at.tuwien.sbc.task2.interfaces.Worker;

//MontageWichtel
public class AssemblyGnome implements Worker {

	private String id;

	public AssemblyGnome() {
		super();
	}

	public AssemblyGnome(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
