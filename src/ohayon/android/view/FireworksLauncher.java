package ohayon.android.view;

import java.util.ArrayList;
import java.util.Random;

import ohayon.android.fireworks.Firework;
import ohayon.android.fireworks.R;
import ohayon.android.fireworks.explosions.CircleExplosion;
import ohayon.android.fireworks.explosions.Explosion;
import ohayon.android.fireworks.explosions.RandomExplosion;
import ohayon.android.fireworks.explosions.SmileyFaceExplosion;
import ohayon.android.fireworks.explosions.SpiderExplosion;
import ohayon.android.fireworks.explosions.ThreeCircleExplosion;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class FireworksLauncher extends Activity implements OnTouchListener {

	FireworkComponent fc;
	int fireworkType = -1;
	private ArrayList<Class<? extends Explosion>> explosionTypes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("OnCreateMsg", "running onCreate...");
		fc = new FireworkComponent(this);
		InvalidateThread invalidate = new InvalidateThread(fc);
		invalidate.start();
		fc.setOnTouchListener(this);
		setContentView(fc);
		createExplosionList();
	}

	private void createExplosionList() {
		explosionTypes = new ArrayList<Class<? extends Explosion>>();
		explosionTypes.add(RandomExplosion.class);
		explosionTypes.add(SpiderExplosion.class);
		explosionTypes.add(SmileyFaceExplosion.class);
		explosionTypes.add(CircleExplosion.class);
		explosionTypes.add(ThreeCircleExplosion.class);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		float y = fc.getHeight() - event.getY();
		fc.getWorld().addFirework(
				new Firework(event.getX(), y, 60, 90, Color.RED, 0,
						getExplosionType(), null));
		Log.d("OnTouch", "onTouch was called @: " + event.getX() + ":" + y);
		v.invalidate();
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.randomFW:
			setFireworkType(0);
			return true;
		case R.id.spiderFW:
			setFireworkType(1);
			return true;
		case R.id.smileyFaceFW:
			setFireworkType(2);
			return true;
		default:
			return false;
		}

	}

	private void setFireworkType(int type) {
		fireworkType = type;
	}

	private Explosion getExplosionType() {
		try {
			if (fireworkType == -1) {
				int explsn = new Random().nextInt(explosionTypes.size());
				return explosionTypes.get(explsn).newInstance();
			} else {
				return explosionTypes.get(fireworkType).newInstance();
			}
		} catch (InstantiationException e) {
			Log.d("Error", e.getMessage());
			return new RandomExplosion();
		} catch (IllegalAccessException e) {
			Log.d("Error", e.getMessage());
			return new RandomExplosion();
		}
	}

}