package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class DataObjet {
	// Generic fields
	public HashMap<Attributs, Float> attributs = new HashMap<Attributs, Float>();
	private static String location ="";
	public static Gson gson = new Gson();
	public DataObjet(String filename){
		try {
			attributs = gson.fromJson(new JsonReader(new FileReader(location+filename)), new TypeToken<HashMap<Attributs, Float>>(){}.getType());
			System.out.println(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String toString(){
		return gson.toJson(attributs);
	}
}