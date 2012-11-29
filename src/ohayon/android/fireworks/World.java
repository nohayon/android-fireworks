package ohayon.android.fireworks;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class World {

	private ArrayList<Firework> fireworks;
	private ArrayList<Firework> newFireworks;
	private double time;
	private long currentTime;
	private PerformanceCannon cannon;

	public World() {
		fireworks = new ArrayList<Firework>();
		newFireworks = new ArrayList<Firework>();
		time = 0;
		currentTime = -1;
		cannon = new PerformanceCannon();
		
	}

	public Cannon getCannon() {
		return cannon;
	}

	public void addFirework(Firework f) {
		fireworks.add(f);
	}

	public ArrayList<Firework> getFireworks() {
		return fireworks;
	}

	public double getTime() {
		return time;
	}

	public void tick(double delta) {
		Firework startFirework = cannon.getNext(time);

		newFireworks.clear();
		if (startFirework != null) {
			fireworks.add(startFirework);
		}

		Iterator<Firework> iter = fireworks.iterator();
		while (iter.hasNext()) {
			Firework f = iter.next();
			f.addTime(delta);
			Point p = f.getPosition();
			Trail trail = f.getTrail();

			if (trail != null) {
				trail.addPoint(p, f.getTime());
			}

			if (f.isPastTimeToLive()) {
				iter.remove();
				//push back on to the stack
				if (f.hasExplosion()) {
					newFireworks.addAll(f.getExplosion());
				}
			}
		}
		fireworks.addAll(newFireworks);
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public void setCurrentTime(long time) {
		this.currentTime = time;
	}

	public void tick() {
		if ( currentTime == -1 ) {
			currentTime = System.currentTimeMillis();
		}
		long t = System.currentTimeMillis();
		double deltaTime = (double) (t - currentTime) / 1000.0;
		currentTime = t;
		time += deltaTime;
		tick(deltaTime);
	}

}
