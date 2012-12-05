package ohayon.android.view;

import ohayon.android.fireworks.Firework;
import ohayon.android.fireworks.R;
import ohayon.android.fireworks.World;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class FireworkComponent extends View {

//	private static final Logger logger = Logger
//			.getLogger(FireworkComponent.class.getName());

	private Paint paint;
	private World world;
	private Canvas canvas;
	private Bitmap backgroundImg;
	private Bitmap foregroundImg;

	public FireworkComponent(Context context) {
		super(context);
		world = new World();
		paint = new Paint(Color.BLACK);
		
		BitmapFactory.Options options = new BitmapFactory.Options();  
		backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background, options);
		foregroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.foreground, options);

		setBackgroundDrawable(new BitmapDrawable(backgroundImg));
	}

	public void paintBackground() {
		canvas.drawBitmap(backgroundImg, 0, 0, paint);
	}

	public void paintForeground() {
	    paint.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
		canvas.drawBitmap(foregroundImg, null, new Rect(0, 0, this.getWidth(), this.getHeight()), paint);
	}

	@Override
	protected void onDraw(Canvas c) {
		this.canvas = c;
		super.onDraw(canvas);
		canvas.translate(0, this.getHeight());

		world.tick();
		drawFireworks();

		canvas.translate(0, -this.getHeight());
		paintForeground();
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
