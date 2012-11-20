package ohayon.android.fireworks;

import java.util.ArrayList;
import java.util.Random;

import ohayon.mco152.fireworks.Firework;
import ohayon.mco152.fireworks.explosions.RandomExplosion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.View;

public class DrawPanel extends View {

	public Paint paint;
	public ArrayList<Point> points;
	public ArrayList<Integer> colors;
	public Canvas canvas;

	public DrawPanel(Context context) {
		super(context);
		paint = new Paint();
		points = new ArrayList<Point>();
		colors = new ArrayList<Integer>();
		paint.setColor(Color.WHITE);
	}

	@SuppressLint({ "DrawAllocation", "DrawAllocation" })
	@Override
	protected void onDraw(Canvas c) {
		this.canvas = c;
		super.onDraw(canvas);

		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeWidth(8);
		drawFireworks();
		//drawPoints();
	}

	public void drawFireworks(){
		Point point = points.get(points.size() - 1);
		int c = colors.get(colors.size() - 1);
		Firework f = new Firework(point.x, point.y, 20, 20, c, 5, new RandomExplosion(), null);
		f.drawFirework(canvas, paint);
	}
	
	public void drawPoints() {
		Point point;
		for (int i = 0; i < points.size(); i++) {
			point = points.get(i);
			paint.setColor(colors.get(i));
			canvas.drawPoint(point.x, point.y, paint);
			Log.d("drawPoints()", point.x + ":" + point.y);
		}
	}

	public int getColor() {
		Random generator = new Random();
		return Color.rgb(generator.nextInt(256), generator.nextInt(256),
				generator.nextInt(256));
	}

}

/*
 * Firework f = new Firework(100, 300, 73, 90, null, 3, new RandomExplosion(),
 * null);
 */
