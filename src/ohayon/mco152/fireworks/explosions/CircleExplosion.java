package ohayon.mco152.fireworks.explosions;

import java.util.ArrayList;
import java.util.Random;

import ohayon.mco152.fireworks.Firework;
import android.graphics.Point;

public class CircleExplosion implements Explosion{
	
	
	@Override
	public ArrayList<Firework> explode(Firework f) {
		ArrayList<Firework> list = new ArrayList<Firework>();
		Point p = f.getPosition();
		double v = f.getV();
		int color = f.getColor();
		double ttl = f.getTtl()+2;
		
		Random generator = new Random();
		for(int i =0; i<50; i++){
			list.add(new Firework(p.x, p.y, v, (double)generator.nextInt(360), 
				color, ttl, null, null));
		}
		
		return list;
	}

}
