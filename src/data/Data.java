package data;

import java.util.HashMap;

import utils.Utils;

public class Data {
	
	public HashMap<String, DataObjet> datas;
	
	public Data(){
		datas = new HashMap<String, DataObjet>();
		// add the unit
		
		HashMap<String, String> files = Utils.loadRepertoire("data/miscellaneous/", "rtsdata");
		for(String name : files.keySet()){
			this.datas.put(name, new DataObjet(files.get(name)));
		}
	}
}
