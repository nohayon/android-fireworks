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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class FireworksLauncher extends Activity implements OnTouchListener{

	FireworkComponent fc;
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
		explosionTypes.add(CircleExplosion.class);
		explosionTypes.add(RandomExplosion.class);
		explosionTypes.add(SmileyFaceExplosion.class);
		explosionTypes.add(SpiderExplosion.class);
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
		fc.getWorld().addFirework(new Firework(event.getX(), y, 60, 90, Color.RED, 0,
				getExplosionType(), null));
		Log.d("OnTouch","onTouch was called @: " + event.getX() + ":" + y);
		v.invalidate();
		return false;
	}

	private Explosion getExplosionType() {
		int explsn = new Random().nextInt(explosionTypes.size());
		try {
			return explosionTypes.get(explsn).newInstance();
		} catch (InstantiationException e) {
			Log.d("Error", e.getMessage());
			return new RandomExplosion();
		} catch (IllegalAccessException e) {
			Log.d("Error", e.getMessage());
			return new RandomExplosion();
		}
	} 

	
}