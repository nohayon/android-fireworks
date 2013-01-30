package ohayon.android.show;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ohayon.android.fireworks.FireworkAndTime;
import android.content.Context;
import android.util.Log;

public class SavedShow {

	private ArrayList<FireworkAndTime> fireworks;

	public SavedShow() {
		this.fireworks = new ArrayList<FireworkAndTime>();
	}

	public void addFireworks(ArrayList<FireworkAndTime> fats) {
		fireworks.addAll(fats);
	}

	public void saveShow(Context context) {
		try {
			FileOutputStream outStream = context.openFileOutput("savedShow.data", Context.MODE_PRIVATE);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
			objectOutStream.writeObject(fireworks);
			objectOutStream.close();
		} catch (IOException e) {
			Log.e("IOEXception SavedShow.data", e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<FireworkAndTime> getSavedShow(Context context){
		try {
			FileInputStream inStream = context.openFileInput("savedShow.data");
			ObjectInputStream objectOutStream = new ObjectInputStream(inStream);
			fireworks = (ArrayList<FireworkAndTime>) objectOutStream.readObject();
			objectOutStream.close();
			return fireworks;
		} catch (FileNotFoundException e) {
			Log.e("FileNotFoundEception SavedShow.data", e.getMessage());
		} catch (IOException e) {
			Log.e("IOEXception SavedShow.data", e.getMessage());
		} catch (ClassNotFoundException e) {
			Log.e("ClassNotFoundException FireworkAndTime", e.getMessage());
		}
		return fireworks;		
	}

}
