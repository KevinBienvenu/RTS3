package model;

import java.util.Iterator;
import java.util.stream.Stream;

import game.Game;

public class ObjetPool {

	// Class for pulling and adding an object (avoid loading in memory a lot of objects)
	private static Objet[] objets;
	private static int poolSize = 100;
	public static Iterator<Objet> aliveIterator ;
	public static void init(){
		objets = new Objet[poolSize];

		for(int i =0; i<poolSize;i++){
			objets[i] = new Objet();
		}

	}

	public static Objet pull(){
		
		for(int i = 0 ; i<objets.length; i++){
			if(!objets[i].isInWorld){
				objets[i].isInWorld = true;
				return objets[i];
			}
		}
		
		// Issue of memory allocate a doubled size array and print a Gilles message...
		System.out.println("Tu sais pas gérer ta mémoire enculé ....");
		Objet[] newArray = new Objet[objets.length*2];
		// Copie l'ancien tableau
		// Rajoute des objets par défaut
		for(int i =0;i<newArray.length;i++){
			if(i<objets.length){
				newArray[i] = objets[i];
			}
			else{
				newArray[i] = new Objet();
			}
		}
		objets = newArray;
		
		return pull();
	}
	
	public static Objet[] getAliveObjets(){
		int compteur = 0;
		for(int i = 0 ; i<objets.length;i++){
			if(objets[i].isInWorld){
				compteur++;
			}
		}
		Objet[] result = new Objet[compteur];
		int compteur2 = 0;
		for(int i = 0 ; i<objets.length; i++){
			if(objets[i].isInWorld){
				result[compteur2] = objets[i];
				compteur2++;
			}
			if(compteur2 == compteur){
				break;
			}
		}
		return  result;
	}


	public static void assignToWorld() {
		Game.world.objets = objets;
		
	}
	

}
