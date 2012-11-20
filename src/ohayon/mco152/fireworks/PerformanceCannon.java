package ohayon.mco152.fireworks;

import ohayon.mco152.fireworks.explosions.RandomExplosion;
import ohayon.mco152.fireworks.explosions.SmileyFaceExplosion;
import ohayon.mco152.fireworks.explosions.SpiderExplosion;
import android.graphics.Color;

public class PerformanceCannon extends Cannon {
	
	public PerformanceCannon(){
		addFAT(new FireworkAndTime(new Firework(0, 0, 60, 45, Color.RED, 3,
				new RandomExplosion(), new Trail(3.0)), .2));
		addFAT(new FireworkAndTime(new Firework(50, 110, 60, 90, Color.YELLOW, 3,
				new SmileyFaceExplosion(), null), .10));
		addFAT(new FireworkAndTime(new Firework(150, 0, 73, 95, Color.BLUE, 3,
				new SpiderExplosion(), new Trail(3.0)), .19));

//		addFAT(new FireworkAndTime(new Firework(25, 30, 90, 85, Color.YELLOW, 3,
//				new SmileyFaceExplosion(), null), 6.5));
//		addFAT(new FireworkAndTime(new Firework(55, 30, 90, 95, Color.YELLOW, 3,
//				new SmileyFaceExplosion(), null), 6.5));
//		
//		addFAT(new FireworkAndTime(new Firework(25, 30, 73, 105, Color.RED, 4,
//				new RandomExplosion(), new Trail(2.5)), 11));
//		addFAT(new FireworkAndTime(new Firework(55, 30, 73, 75, Color.RED, 4,
//				new RandomExplosion(), new Trail(2.5)), 11));
//		
//		addFAT(new FireworkAndTime(new Firework(25, 30, 94, 90, Color.GREEN, 3,
//				new ThreeCircleExplosion(), null), 16));
//		addFAT(new FireworkAndTime(new Firework(55, 30, 94, 90, Color.GREEN, 3,
//				new ThreeCircleExplosion(), null), 16));
//
//		addFAT(new FireworkAndTime(new Firework(45, 30, 73, 90, Color.YELLOW, 3,
//				new SmileyFaceExplosion(), null), 20));
//		addFAT(new FireworkAndTime(new Firework(70, 30, 73, 90, Color.GREEN, 3,
//				new MultipleExplosion(), null), 20));
//		addFAT(new FireworkAndTime(new Firework(10, 30, 73, 90, Color.GREEN, 3,
//				new MultipleExplosion(), null), 20));
	}

}
