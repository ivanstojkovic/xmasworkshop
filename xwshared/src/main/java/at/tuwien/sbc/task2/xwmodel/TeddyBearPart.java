package at.tuwien.sbc.task2.xwmodel;


public enum TeddyBearPart {
	HEAD, BODY, ARM, LEG, HAT_RED, HAT_GREEN;
	
	public String toString() {
	    switch (this) {
	        case ARM:
	            return "Arm";
	        case BODY:
	            return "Body";
	        case HAT_RED:
	            return "Red Hat";
	        case HAT_GREEN:
	            return "Green Hat";
	        case HEAD:
	            return "Head";
	        case LEG: 
	            return "Leg";
	        default:
	            return "undefined";
	    }
	}
}
