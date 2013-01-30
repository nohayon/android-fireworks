package ohayon.android.physics;

import java.io.Serializable;

import 	android.graphics.Point;

public class Projectile implements Serializable{
	private static final long serialVersionUID = 3992064043885285041L;

	private double Xi, Yi, V, theta, time;

	public Projectile(double Xi, double Yi, double V, double theta) {
		this.Xi = Xi;
		this.Yi = Yi;
		this.V = V;
		this.theta = theta;
		this.time =0;
	}

	public Point getPositionAtTime(double time) {
		Point point = new Point();
		double t = Math.toRadians(theta);
		point.x = (int) (Xi + V * Math.cos(t) * time);
		point.y = (int) (Yi + V * Math.sin(t) * time - (.5 * 9.8 * Math.pow(
				time, 2)));

		return point;
	}
	
	public Point addTime( double delta ) {
		this.time+= delta;
		return getPositionAtTime(time);
	}

	public double getXi() {
		return Xi;
	}

	public void setXi(double xi) {
		Xi = xi;
	}

	public double getYi() {
		return Yi;
	}

	public void setYi(double yi) {
		Yi = yi;
	}

	public double getV() {
		return V;
	}

	public void setV(double v) {
		V = v;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	
}
