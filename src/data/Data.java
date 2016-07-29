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
		
		// Do the prototyping (overrides non existing attributes
		for(String s : datas.keySet()){
			overrides(s,s);
		}
		// Convert to float ...
		convertFloat();
		
		//Print result to see if i am wrong
		for(String name : files.keySet()){
			System.out.println(this.datas.get(name));
			
		}
		
	}
	
	public void overrides(String s,String parent){
		// On cherche le parent le plus vieux
		if(datas.get(parent).attributsString.containsKey(Attributs.prototype)){
			// Find parent...
			System.out.println(parent);
			overrides(s,datas.get(s).attributsString.get(Attributs.prototype));
			
		}else{
			////On a trouvé le parent le plus ancien donc on Merge 
			merge(datas.get(s).attributsString,datas.get(parent).attributsString);
		}
		
	}
	public void convertFloat(){
		for(String s : datas.keySet()){
			DataObjet d = datas.get(s);
			d.attributs = new HashMap<Attributs,Float>();
			for(Attributs a : d.attributsString.keySet()){
				if(a!=Attributs.prototype){
					d.attributs.put(a, Float.parseFloat(d.attributsString.get(a)));
				}
			}
		}
	}
	public static void merge(HashMap<Attributs,String> child,HashMap<Attributs,String> parent){
		for(Attributs s : parent.keySet()){
			if(!child.containsKey(s)){
				child.put(s, parent.get(s));
			}
		}
	}
}
