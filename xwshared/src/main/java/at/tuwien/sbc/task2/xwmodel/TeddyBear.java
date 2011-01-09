package at.tuwien.sbc.task2.xwmodel;

import java.util.HashMap;
import java.util.Map;

import at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry;
import at.tuwien.sbc.task2.worker.testing.ComponentTest;
import at.tuwien.sbc.task2.worker.testing.TeddyBearTest;
import at.tuwien.sbc.task2.worker.testing.WeightTest;

public class TeddyBear extends XMasWorkshopObject implements XMasWorkshopEntry {

	private static final long serialVersionUID = 3114700564168942855L;

	private String id;

	private Head head;

	private Body body;

	private Hand leftHand;

	private Hand rightHand;

	private Leg leftLeg;

	private Leg rightLeg;

	private Hat hat;

	private boolean defective;

	private boolean ready;
	
	private Map<TeddyBearTest, Boolean> doneTests;
	
	public TeddyBear(String id, Head head, Body body, Hand leftHand, Hand rightHand, Leg leftLeg, Leg rightLeg, Hat hat, boolean defective,
			boolean ready) {
		super();
		this.id = id;
		this.head = head;
		this.body = body;
		this.leftHand = leftHand;
		this.rightHand = rightHand;
		this.leftLeg = leftLeg;
		this.rightLeg = rightLeg;
		this.hat = hat;
		this.defective = defective;
		this.ready = ready;
		this.doneTests = new HashMap<TeddyBearTest, Boolean>();
		this.doneTests.put(new ComponentTest(), new Boolean(false));
		this.doneTests.put(new WeightTest(), new Boolean(false));
	}
	
	public TeddyBear() {
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Hand getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(Hand leftHand) {
		this.leftHand = leftHand;
	}

	public Hand getRightHand() {
		return rightHand;
	}

	public void setRightHand(Hand rightHand) {
		this.rightHand = rightHand;
	}

	public Leg getLeftLeg() {
		return leftLeg;
	}

	public void setLeftLeg(Leg leftLeg) {
		this.leftLeg = leftLeg;
	}

	public Leg getRightLeg() {
		return rightLeg;
	}

	public void setRightLeg(Leg rightLeg) {
		this.rightLeg = rightLeg;
	}

	public Hat getHat() {
		return hat;
	}

	public void setHat(Hat hat) {
		this.hat = hat;
	}

	public boolean isDefective() {
		return defective;
	}

	public void setDefective(boolean defective) {
		this.defective = defective;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	@Override
	public String toString() {
		return "TeddyBear [id=" + id + ", head=" + head + ", body=" + body + ", leftHand=" + leftHand + ", rightHand=" + rightHand
				+ ", leftLeg=" + leftLeg + ", rightLeg=" + rightLeg + ", hat=" + hat + ", defective=" + defective + ", ready=" + ready
				+ "]";
	}

}
