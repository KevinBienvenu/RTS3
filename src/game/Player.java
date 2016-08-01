package game;

import data.Attributs;
import data.Data;

public class Player {

	
	int team;
	Data datas;
	public Player(int team){
		datas = new Data();
	}
	
	public Float getData(String type,Attributs attribut){
		System.out.println(datas.datas.containsKey(type));
		System.out.println(type);
		System.out.println("vanneau" +datas.datas.get(type).attributs.containsKey(attribut));
		
		return datas.datas.get(type).attributs.get(attribut);
	}
}
