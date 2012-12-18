package ohayon.android.show;

import java.util.ArrayList;

import ohayon.android.fireworks.Firework;
import ohayon.android.fireworks.FireworkAndTime;
import ohayon.android.fireworks.World;
import ohayon.android.fireworks.explosions.Explosion;
import android.util.Log;

public class RecordedShow {

	private Boolean isRecording;
	private World world;
	private ArrayList<FireworkAndTime> fats;
	private long startTime;
	
	public RecordedShow(World world) {
		isRecording = false;
		fats = new ArrayList<FireworkAndTime>();
		this.world = world;
		this.startTime = 0;
	}
	
	public void startRecording() {
		startTime = System.currentTimeMillis();
		isRecording = true;
		Log.d("stop Recording", "isRecording: " + isRecording);
	}
	
	public void stopRecording() {
		isRecording = false;
		Log.d("stop Recording", "isRecording: " + isRecording);
	}
	
	public void addFirework(float x, float y, Explosion xplsn, int color) {
		if(isRecording) {
			double currTime = (System.currentTimeMillis() - startTime)/1000.0;
			fats.add(new FireworkAndTime
						(new Firework(x, y, 60, 90, color, 0, xplsn, null),
							currTime) );			
		}
	}

	public boolean isRecording() {
		return isRecording;
	}
	
	public void startShow(){
		if(isRecording) {
			return;
		} else {
			world.setTime(0);
			for(FireworkAndTime f: fats){
				world.getCannon().addFAT(f);
			}
			fats.clear();
		}
	}
	
}
