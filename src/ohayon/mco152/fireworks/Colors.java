package ohayon.mco152.fireworks;

import android.graphics.Color;
import java.util.Random;

public class Colors {
	
	public static int getColor() {
		Random generator = new Random();
		return Color.argb(255, generator.nextInt(256), generator.nextInt(256),
				generator.nextInt(256));
	}

}
