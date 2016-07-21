package data;

import java.util.HashMap;

public class Data {
	
	public static HashMap<String, DataObjet> datas;
	
	public Data(){
		datas = new HashMap<String, DataObjet>();
		// add the unit
		datas.put("roger", new DataObjet());
	}
}
