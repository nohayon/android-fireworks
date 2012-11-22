package ohayon.android.view;

import ohayon.android.fireworks.Firework;
import ohayon.android.fireworks.R;
import ohayon.android.fireworks.explosions.RandomExplosion;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class FireworksLauncher extends Activity implements OnTouchListener{

	FireworkComponent fc;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("OnCreateMsg", "running onCreate...");		
        fc = new FireworkComponent(this);
        InvalidateThread invalidate = new InvalidateThread(fc);
        invalidate.start();
        fc.setOnTouchListener(this);
        setContentView(fc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void alertMessage( View view ) {
    	TextView textView = (TextView) this.findViewById(R.id.helloWorldText);
    	Log.d("ButtonClick", "The start app button was clicked");    	
    	textView.setText("App was started!");
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		float y = fc.getHeight() - event.getY();
		fc.getWorld().addFirework(new Firework(event.getX(), y, 60, 90, Color.RED, 0,
				new RandomExplosion(), null));
		Log.d("OnTouch","onTouch was called @: " + event.getX() + ":" + y);
		v.invalidate();
		return false;
	} 

	
/*
 * canvas - draw on the screen 
 * openGL
 * move java code into android. fix the draw calls using canvas.
 */
}