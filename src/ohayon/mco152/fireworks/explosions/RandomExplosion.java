package ohayon.mco152.fireworks.explosions;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Point;

import ohayon.mco152.fireworks.Colors;
import ohayon.mco152.fireworks.Firework;

public class RandomExplosion implements Explosion {

	@Override
	public ArrayList<Firework> explode(Firework f) {
		Random generator = new Random();
		ArrayList<Firework> list = new ArrayList<Firework>();
		Point p = f.getPosition();

		for (int i = 0; i < 65; i++) {
			list.add(new Firework(p.x, p.y, (double) generator.nextInt(90),
					(double) generator.nextInt(250), Colors.getColor(), generator.nextDouble()+ 2, null,
					null));
		}

		return list;
	}


}
