package ohayon.mco152.fireworks.explosions;

import android.graphics.Point;
import java.util.ArrayList;

import ohayon.mco152.fireworks.Firework;

public class MultipleExplosion implements Explosion {

	@Override
	public ArrayList<Firework> explode(Firework f) {
		ArrayList<Firework> list = new ArrayList<Firework>();
		Point p = f.getPosition();
		double v = f.getV();
		double theta = f.getTheta();
		double ttl = f.getTtl()-1;
		int color = f.getColor();
		
		list.add(new Firework(p.x, p.y, v, theta - 65, 
				color, ttl, new MiddleMultipleExplosion(), null));
		list.add(new Firework(p.x, p.y, v, theta - 30, 
				color, ttl, new MiddleMultipleExplosion(), null));
		list.add(new Firework(p.x, p.y, v, theta - 10, 
				color, ttl, new MiddleMultipleExplosion(), null));
		list.add(new Firework(p.x, p.y, v, theta + 10, 
				color, ttl, new MiddleMultipleExplosion(), null));
		list.add(new Firework(p.x, p.y, v, theta - 30, 
				color, ttl, new MiddleMultipleExplosion(), null));
		list.add(new Firework(p.x, p.y, v, theta + 65, 
				color, ttl, new MiddleMultipleExplosion(), null));

		return list;
	}


}
