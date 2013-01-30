package ohayon.android.fireworks;

import android.graphics.Color;

import java.io.Serializable;
import java.util.Random;

public class Colors implements Serializable{
	
	private static final long serialVersionUID = -3062801980489171368L;

	public static int getColor() {
		Random generator = new Random();
		return Color.argb(255, generator.nextInt(256), generator.nextInt(256),
				generator.nextInt(256));
	}

}
