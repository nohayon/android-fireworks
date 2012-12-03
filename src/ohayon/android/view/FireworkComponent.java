package ohayon.android.view;

import ohayon.android.fireworks.Firework;
import ohayon.android.fireworks.R;
import ohayon.android.fireworks.World;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public class FireworkComponent extends View {

//	private static final Logger logger = Logger
//			.getLogger(FireworkComponent.class.getName());

	private Paint paint;
	private World world;
	private Canvas canvas;
	private Bitmap backgroundImg;
	private Bitmap foregroundImg;
	private Drawable backImg;
	private Drawable frontImg;

	public FireworkComponent(Context context) {
		super(context);
		world = new World();
		paint = new Paint(Color.CYAN);
		backImg = getResources().getDrawable(R.drawable.background);
		frontImg = getResources().getDrawable(R.drawable.foreground);
//		backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
//		foregroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.foreground);

	}

	public void paintBackground() {
		backImg.draw(canvas);
		Log.d("paintBackground", "painting backrgound");
		//canvas.drawBitmap(backgroundImg, this.getWidth(), this.getHeight(), paint);
	}

	public void paintForeground() {
		frontImg.draw(canvas);
		//canvas.drawBitmap(foregroundImg, this.getWidth(), this.getHeight(), paint);
	}

	@Override
	protected void onDraw(Canvas c) {
		this.canvas = c;
		super.onDraw(canvas);
		canvas.translate(0, this.getHeight());
		paintBackground();

		world.tick();
		drawFireworks();

		paintForeground();
		canvas.translate(0, -this.getHeight());
	}

	private void drawFireworks() {
		for (int i = 0; i < world.getFireworks().size(); i++) {
			drawFirework(world.getFireworks().get(i));
		}
	}

	public void drawFirework(Firework f) {
		f.drawFirework(canvas, paint);
		if (f.getTrail() != null) {
			f.drawTrail(canvas, paint);
		}
	}

	public World getWorld() {
		return world;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
		
}