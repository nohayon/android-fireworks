package ohayon.android.fireworks;

import java.io.Serializable;
import java.util.ArrayList;

import ohayon.android.fireworks.explosions.Explosion;
import ohayon.android.physics.Projectile;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
//import java.awt.Graphics;

public class Firework extends Projectile implements Serializable {

	private static final long serialVersionUID = -2530561254107826465L;

	private int color;
	private double ttl;
	private Explosion explosion;
	private Trail trail;

	public Firework(double xi, double yi, double v, double theta, int color,
			double ttl, Explosion explosion, Trail trail) {
		super(xi, yi, v, theta);
		this.color = color;
		this.ttl = ttl;
		this.explosion = explosion;
		this.trail = trail;
	}
	
	public double getTtl() {
		return this.ttl;
	}

	public int getColor() {
		return color;
	}

	public Point getPosition() {
		return getPositionAtTime(getTime());
	}

	public void drawFirework(Canvas c, Paint p) {
		Point point = getPosition();
		p.setColor(color);
		p.setStyle(Style.FILL);
		p.setStrokeWidth(4);
		c.drawPoint(point.x, -(point.y), p );
	}

	public boolean isPastTimeToLive() {
		return getTime() >= ttl;
	}

	public ArrayList<PointAndTime> getPath() {
		return trail.getPath();
	}

	public Trail getTrail() {
		return trail;
	}

	public boolean hasExplosion() {
		return explosion != null;
	}

	public boolean hasTrail() {
		return trail != null;
	}

	public ArrayList<Firework> getExplosion() {
		return explosion.explode(this);
	}

	public void drawTrail(Canvas c, Paint p) {
		trail.drawTrail(c, p);		
	}
}
