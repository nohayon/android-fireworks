package ohayon.mco152.fireworks.explosions;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Random;

import ohayon.mco152.fireworks.Colors;
import ohayon.mco152.fireworks.Firework;
import ohayon.mco152.fireworks.Trail;

public class SpiderExplosion implements Explosion {
	
	private Random generator = new Random();

	@Override
	public ArrayList<Firework> explode(Firework f) {
		ArrayList<Firework> list = new ArrayList<Firework>();
		Point p = f.getPosition();
		
		for (int i = 0; i < 50; i++) {
			list.add(new Firework(p.x, p.y, (double) generator.nextInt(90),
				(double) generator.nextInt(250), Colors.getColor(), 5, null, new Trail(2.5)));
		}
		return list;
	}


}
