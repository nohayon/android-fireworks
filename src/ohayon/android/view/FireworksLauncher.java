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
import ohayon.android.show.RecordedShow;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class FireworksLauncher extends Activity implements OnTouchListener {

	private FireworkComponent fc;
	int fireworkType = -1;
	private ArrayList<Class<? extends Explosion>> explosionTypes;
	private Random random;
	private RecordedShow recording;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		random = new Random();
		Log.d("OnCreateMsg", "running onCreate...");
		fc = new FireworkComponent(this);
		InvalidateThread invalidate = new InvalidateThread(fc);
		invalidate.start();
		
		recording = new RecordedShow(fc.getWorld());

		fc.setOnTouchListener(this);
		createExplosionList();

		setContentView(fc);
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
//		Debug.startMethodTracing("FWonTouch");
		float y = fc.getHeight() - event.getY();
		Explosion xplsn = getExplosionType();
		int color = getColor();
		fc.getWorld().addFirework(
				new Firework(event.getX(), y, 60, 90, color, 0,
						xplsn, null));
		if (recording.isRecording()) {
			recording.addFirework(event.getX(), y, xplsn, color);
		}
		v.invalidate();
//		Debug.stopMethodTracing();
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int duration = Toast.LENGTH_SHORT;
		Toast toast;
		Context context = getApplicationContext();
		switch (item.getItemId()) {
		case R.id.menu_startRecording:
			recording.startRecording();
			toast = Toast.makeText(context, "Recording", duration);
			toast.show();
			return true;
		case R.id.menu_stopRecording:
			recording.stopRecording();
			toast = Toast.makeText(context, "Stopped recording", duration);
			toast.show();
			return true;
		case R.id.menu_startShow:
			recording.startShow();
			toast = Toast.makeText(context, "Playing back most recent recording", duration);
			toast.show();
			return true;
		case R.id.scatteredFW:
			setFireworkType(0);
			toast = Toast.makeText(context, "Set to Scattered Fireworks", duration);
			toast.show();
			return true;
		case R.id.spiderFW:
			setFireworkType(1);
			toast = Toast.makeText(context, "Set to Spider Fireworks", duration);
			toast.show();
			return true;
		case R.id.smileyFaceFW:
			setFireworkType(2);
			toast = Toast.makeText(context, "Set to Smiley Face Fireworks", duration);
			toast.show();
			return true;
		case R.id.circleFW:
			setFireworkType(3);
			toast = Toast.makeText(context, "Set to Circle Fireworks", duration);
			toast.show();
			return true;
		case R.id.threeCircleFW:
			setFireworkType(4);
			toast = Toast.makeText(context, "Set to 3Circles Fireworks", duration);
			toast.show();
			return true;
		case R.id.randomFW:
			setFireworkType(-1);
			toast = Toast.makeText(context, "Set to Random Fireworks", duration);
			toast.show();
			return true;
		case R.id.menu_saveShow:
			String toastText = recording.saveShow(getApplicationContext());
			toast = Toast.makeText(context, toastText, duration);
			toast.show();
			return true;
		case R.id.menu_startSavedShow:
			toastText = recording.startSavedShow(getApplicationContext());
			toast = Toast.makeText(context, toastText, duration);
			toast.show();
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

	private int getColor() {
		return Color.rgb(random.nextInt(), random.nextInt(), random.nextInt());
		
	}
	
	/*
	 * traceView - cant get the files from my phone
	 * profiler in java
	 * then maybe openGL
	 * */
	
}