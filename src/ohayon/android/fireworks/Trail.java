package ohayon.android.fireworks;

import java.util.ArrayList;
import java.util.Iterator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class Trail {

//	private static final Logger logger = Logger
//			.getLogger(World.class.getName());

	private double duration;
	private ArrayList<PointAndTime> points;

	public Trail(Double duration) {
		this.duration = duration;
		points = new ArrayList<PointAndTime>();
	}

	public ArrayList<PointAndTime> getPath() {
		return points;
	}

	public void addPoint(Point p, double time) {
		points.add(new PointAndTime(p, time));

		Iterator<PointAndTime> iter = points.iterator();
		while (iter.hasNext()) {
			PointAndTime pt = iter.next();
			if (pt.getTime() < (time - duration)) {
				iter.remove();
			}
		}
	}

	public void drawTrail(Canvas c, Paint paint) {
		for (int i = 1; i < points.size(); i++) {
			Point p= points.get(i - 1).getPoint();
			Point q = points.get(i).getPoint();
			c.drawLine(p.x, -(p.y), q.x, -(q.y), paint);
		}
	}

}
