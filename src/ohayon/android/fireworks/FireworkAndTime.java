package ohayon.android.fireworks;

import java.io.Serializable;

public class FireworkAndTime implements Serializable{
	
	private static final long serialVersionUID = 4584945476482916423L;

	private Firework firework;
	private double time;
	
	public FireworkAndTime(Firework f, double t){
		this.firework = f;
		this.time = t;
	}

	public Firework getFirework() {
		return firework;
	}

	public double getTime() {
		return time;
	}
	

}
