package model;

import data.Attributs;
import game.Game;

public class ObjetUtil {

	private static int groupCheckpointId;
	private static boolean checkpointUsed=false;
	
	public static boolean isNear(Objet o1,Objet o2){
		float dist = (float)Math.sqrt((o1.x-o2.x)*(o1.x-o2.x)+(o1.y-o2.y)*(o1.y-o2.y));
		return dist<(Game.getData(o1,Attributs.radius)>0 ? Game.getData(o1,Attributs.radius)+Game.getData(o2,Attributs.radius):10 );
	}
	
	
	private int getCurrentCheckpoint(){
		if(!checkpointUsed){
			checkpointUsed = true;
			int toReturn =  groupCheckpointId;
			groupCheckpointId = Objet.getObjet(0, 0, "checkpoint", 0).id;
			return toReturn;
		}else{
			return groupCheckpointId;
		}

	}
	
	private void updateGroupCheckpoint(){
		if(checkpointUsed){
			groupCheckpointId = Objet.getObjet(0, 0, "checkpoint", 0).id;
		}
	}
	
	
}
