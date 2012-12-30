package ohayon.android.show;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ohayon.android.fireworks.FireworkAndTime;
import ohayon.android.fireworks.explosions.CircleExplosion;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;

public class SavedShow {

	private Gson gson;
	private ArrayList<FireworkAndTime> fireworks;

	public SavedShow() {
		this.gson = new Gson();
		this.fireworks = new ArrayList<FireworkAndTime>();
	}

	public void addFireworks(ArrayList<FireworkAndTime> fats) {
		fireworks.addAll(fats);
	}

	public void saveShow(Context context) {
		String gsonStr = gson.toJson(fireworks);
		Log.d("gsonStr", gsonStr);
		FileOutputStream outStream;
		try {
			File sdcard = new File(Environment.getExternalStorageDirectory(), "savedShow.txt");
			outStream = new FileOutputStream(sdcard);
			outStream.write(gsonStr.getBytes());
			outStream.flush();
			outStream.close();
		} catch (IOException e) {
			Log.e("IOEXception SavedShow.java", e.getMessage());
		}
	}
	
	public ArrayList<FireworkAndTime> getSavedShow(Context context){
		String gsonStr = null;
		try {
			FileInputStream inStream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), "savedShow.txt"));
			InputStreamReader inputReader = new InputStreamReader(inStream);
			BufferedReader buffer = new BufferedReader(inputReader);
			StringBuilder strBuilder = new StringBuilder();
			
			while ( (gsonStr = buffer.readLine()) != null){
				strBuilder.append(gsonStr);
			}
			
			inStream.close();
					
			JsonParser parser = new JsonParser();
		    JsonArray array = parser.parse(strBuilder.toString()).getAsJsonArray();
		    for ( int i = 0; i < array.size(); i++ ) {
		    	fireworks.add( gson.fromJson(array.get(i), FireworkAndTime.class) );
		    }
		    return fireworks;
		} catch (FileNotFoundException e) {
			Log.e("FileNotFoundEception SavedShow.java", e.getMessage());
		} catch (IOException e) {
			Log.e("IOEXception SavedShow.java", e.getMessage());
		}
		return fireworks;		
	}

}
