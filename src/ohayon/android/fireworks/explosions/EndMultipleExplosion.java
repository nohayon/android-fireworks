package ohayon.android.fireworks.explosions;

import android.graphics.Point;
import java.util.ArrayList;

import ohayon.android.fireworks.Firework;

public class EndMultipleExplosion implements Explosion {

	private static final long serialVersionUID = -5258860396080512062L;

	@Override
	public ArrayList<Firework> explode(Firework f) {
		ArrayList<Firework> list = new ArrayList<Firework>();
		Point p = f.getPosition();
		double v = f.getV();
		double theta = f.getTheta();
		double ttl = f.getTtl()+2;
		int color = f.getColor();
		
		list.add(new Firework(p.x, p.y, v, theta - 65, 
				color, ttl, null, null));
		list.add(new Firework(p.x, p.y, v, theta - 30, 
				color, ttl, null, null));
		list.add(new Firework(p.x, p.y, v, theta - 10, 
				color, ttl, null, null));
		list.add(new Firework(p.x, p.y, v, theta + 10, 
				color, ttl, null, null));
		list.add(new Firework(p.x, p.y, v, theta - 30, 
				color, ttl, null, null));
		list.add(new Firework(p.x, p.y, v, theta + 65, 
				color, ttl, null, null));

		return list;
	}

}
