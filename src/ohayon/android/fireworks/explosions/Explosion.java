package ohayon.android.fireworks.explosions;

import java.util.ArrayList;
import java.util.Random;

import ohayon.android.fireworks.Firework;

public interface Explosion {

	public Random random = new Random();
	public ArrayList<Firework> explode(Firework f);
	
	
}
