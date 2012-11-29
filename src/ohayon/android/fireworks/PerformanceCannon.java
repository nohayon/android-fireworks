package ohayon.android.fireworks;

import ohayon.android.fireworks.explosions.RandomExplosion;
import android.graphics.Color;

public class PerformanceCannon extends Cannon {
	
	public PerformanceCannon(){
		addFAT(new FireworkAndTime(new Firework(0, 0, 60, 45, Color.RED, 3,
				new RandomExplosion(), new Trail(3.0)), .2));
//		addFAT(new FireworkAndTime(new Firework(170, 0, 73, 95, Color.BLUE, 3,
//				new SpiderExplosion(), new Trail(3.0)), 5));
//
//		addFAT(new FireworkAndTime(new Firework(25, 30, 90, 85, Color.YELLOW, 3,
//				new SmileyFaceExplosion(), null), 6.5));
//		addFAT(new FireworkAndTime(new Firework(245, 30, 90, 95, Color.YELLOW, 3,
//				new SmileyFaceExplosion(), null), 6.5));
//	
//		addFAT(new FireworkAndTime(new Firework(50, 30, 73, 80, Color.RED, 4,
//				new RandomExplosion(), new Trail(2.5)), 11));
//		addFAT(new FireworkAndTime(new Firework(315, 30, 73, 100, Color.RED, 4,
//				new RandomExplosion(), new Trail(2.5)), 11));
//		
//		addFAT(new FireworkAndTime(new Firework(115, 30, 94, 90, Color.GREEN, 3,
//				new ThreeCircleExplosion(), null), 16));
//		addFAT(new FireworkAndTime(new Firework(115, 90, 94, 90, Color.GREEN, 3,
//				new ThreeCircleExplosion(), null), 16));
//
//		addFAT(new FireworkAndTime(new Firework(100, 30, 73, 90, Color.YELLOW, 3,
//				new SmileyFaceExplosion(), null), 20));
//		addFAT(new FireworkAndTime(new Firework(25, 30, 73, 90, Color.GREEN, 3,
//				new MultipleExplosion(), null), 20));
//		addFAT(new FireworkAndTime(new Firework(240, 30, 73, 90, Color.GREEN, 3,
//				new MultipleExplosion(), null), 20));
	}

}
