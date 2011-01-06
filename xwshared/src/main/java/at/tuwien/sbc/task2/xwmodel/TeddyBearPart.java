package at.tuwien.sbc.task2.xwmodel;

import java.util.Random;

public enum TeddyBearPart {
	HEAD, BODY, ARM, LEG, HAT;
	
	private String[] colors = {"red", "green"};
	
	private Random random = new Random();
	
	public String toString() {
	    switch (this) {
	        case ARM:
	            return "arm";
	        case BODY:
	            return "body";
	        case HAT:
	            return colors[random.nextInt(2)];
	        case HEAD:
	            return "head";
	        case LEG: 
	            return "leg";
	        default:
	            return "undefined";
	    }
	}
}
