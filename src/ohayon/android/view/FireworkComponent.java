package ohayon.android.view;

import ohayon.android.fireworks.Firework;
import ohayon.android.fireworks.World;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class FireworkComponent extends View {

//	private static final Logger logger = Logger
//			.getLogger(FireworkComponent.class.getName());

	private Paint paint;
	private World world;
	private Bitmap foregroundImg;
	private Bitmap backgroundImg;
	private Canvas canvas;

	public FireworkComponent(Context context) {
		super(context);
		world = new World();
		paint = new Paint(Color.BLACK);
/*
		try {
			backgroundImg = ImageIO
					.read(ClassLoader.class
							.getResourceAsStream("/ohayon/mco152/fireworks/background.png"));

			foregroundImg = ImageIO
					.read(ClassLoader.class
							.getResourceAsStream("/ohayon/mco152/fireworks/foreground.png"));

		} catch (IOException e) {
			logger.log(Level.INFO, e.getMessage());
		}
		*/
	}

	public void paintBackground(Canvas c) {
		c.drawBitmap(backgroundImg, this.getWidth(), this.getHeight(),
				null);
	}

	public void paintForeground(Canvas c) {
		c.drawBitmap(foregroundImg, this.getWidth(), this.getHeight(),
				null);
	}

	@Override
	protected void onDraw(Canvas c) {
		this.canvas = c;
		super.onDraw(canvas);
		//paintBackground(c);
		canvas.translate(0, this.getHeight());

		world.tick();
		drawFireworks();

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