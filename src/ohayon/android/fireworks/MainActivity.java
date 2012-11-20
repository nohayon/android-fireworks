package ohayon.android.fireworks;

import java.util.Random;

import ohayon.mco152.fireworks.FireworkComponent;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener{

	DrawPanel draw;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FireworkComponent fc = new FireworkComponent(this);
        InvalidateThread invalidate = new InvalidateThread(fc);
        invalidate.start();
        Log.d("OnCreateMsg", "running onCreate...");		
        setContentView(fc);
//        setContentView(R.layout.activity_main);
//        draw = new DrawPanel(this);
//        draw.setOnTouchListener(this);
//        setContentView(draw);
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
		draw.points.add(new Point((int)event.getX(), (int)event.getY()) );
		draw.colors.add(getColor());
		//v.invalidate();
		Log.d("OnTouch", "on touch was called");
		return false;
	} 

	private int getColor() {
		Random generator = new Random();
		return Color.argb(255, generator.nextInt(256), generator.nextInt(256),
							generator.nextInt(256));
	}
	
/*
 * canvas - draw on the screen 
 * openGL
 * move java code into android. fix the draw calls using canvas.
 */
}