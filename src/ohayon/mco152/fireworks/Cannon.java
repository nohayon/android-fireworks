package ohayon.mco152.fireworks;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Cannon {

	private Stack<FireworkAndTime> fats;

	public Cannon() {
		fats = new Stack<FireworkAndTime>();
	}

	public void addFAT(FireworkAndTime fat) {
		fats.push(fat);
		Collections.sort(fats, new Comparator<FireworkAndTime>() {
			@Override
			public int compare(FireworkAndTime a, FireworkAndTime b) {
				return (int) (b.getTime() - a.getTime());
			}
		});
	}

	public Firework getNext(double time) {
		if (!fats.isEmpty()) {
			if (fats.peek().getTime() <= time) {
				return fats.pop().getFirework();
			}
		}
		return null;
	}

	public Stack<FireworkAndTime> getFats() {
		return fats;
	}

}
