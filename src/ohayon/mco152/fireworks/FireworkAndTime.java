package ohayon.mco152.fireworks;

public class FireworkAndTime {
	
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
