package model;

public class ObjetPool {

	// Class for pulling and adding an object (avoid loading in memory a lot of objects)
	static Objet[] objets;
	static int poolSize = 100;
	public static void init(){
		objets = new Objet[poolSize];
		for(int i =0; i<poolSize;i++){
			objets[i] = new Objet(0,0,"lancier",0);
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
			
		}
		
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
	public static Objet[] getObjets(){
		return objets;
	}
	
	public void push(Objet o){
		
	}
}
