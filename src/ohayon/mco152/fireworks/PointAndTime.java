package ohayon.mco152.fireworks;

import android.graphics.Point;

public class PointAndTime {
	
	private Point point;
	private double time;
	
	public PointAndTime(Point p, double t) {
		this.point = p;
		this.time = t;
	}

	public Point getPoint() {
		return point;
	}

	public double getTime() {
		return time;
	}

}
