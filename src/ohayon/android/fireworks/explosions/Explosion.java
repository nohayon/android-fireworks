package ohayon.android.fireworks.explosions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import ohayon.android.fireworks.Firework;

public interface Explosion extends Serializable {

	public Random random = new Random();
	public ArrayList<Firework> explode(Firework f);
	
	
}
