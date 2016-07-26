package data;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import utils.Utils;

public class Data {
	
	public HashMap<String, DataObjet> datas;

	public static final int nullValue = -1;
	
	public Data(){
		datas = new HashMap<String, DataObjet>();
		// add the unit
		
		HashMap<String, String> files = Utils.loadRepertoire("data/miscellaneous/", "json");
		for(String name : files.keySet()){
			this.datas.put(name, new DataObjet(files.get(name)));
		}
	}
}
