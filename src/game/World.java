package game;

import java.util.Vector;

import model.Objet;
import model.ObjetPool;
import pathfinding.MapGrid;
import action.Action;
import control.InputModel;


public class World {
	
	/*
	 * Plateau store only the world , not the interface to interact with it
	 */
	
	public float sizeX, sizeY;
	public int[] objets;
	
	public int[] teamObjets;
	
	public static int idObjet = 0;
	public static int generateUniqueId(){idObjet++;return idObjet;}
	 // Tous les objets en jeu
	public Action[] actions ; // On instanciera une seule fois toutes les actions du monde ...
	public MapGrid grid; // La grille pour le pathfinding
	
	public World(int nPlayers,Map map){

		actions = new Action[4];
		
		sizeX = map.sizeX;
		sizeY = map.sizeY;
		
		
		// Team objets 
		teamObjets = new int[nPlayers];
//		for(int i = 0 ; i<teamObjets.length;i++){
//			teamObjets[i] = new Vector<Integer>();
//		}
		
		
		// Build the grid function of buildings
		
		
	}
	
	public void buildGrid(){
		/*
		 * Loop over vector of objets and find cells occupied by buildings
		 */
		grid = new MapGrid(0,sizeX,0,sizeY);
//		for(Objet o : objets){
//			// TODO : updater la grille en fonction des objets inamovibles
//		}
		
	}
	
	public Objet[] getObjets(){
		return ObjetPool.objets;
	}
	
	public void updateReferences(){
		// Repartit les int dans les tableaux (a chaque fin de tour)
		// TODO : Est ce qu'on tri par id ? (temps d'acces)
		
	}
	
	public void update(InputModel im){
		/*// TODO : gérer plusieurs input
		 * 
		 * Update the world state
		 */
		for(Objet o : getObjets()){
			if(o.isInWorld){
				o.update(im);
			}
		}
		
		//Update mapgrid
		
		
		//Resolve physic with mapgrid state
		// For the time being raw collision
		
	}
	
	public Objet getObjetById(int id){
		for(Objet o : getObjets()){
			if(o.id == id && o.isInWorld ){
				return o;
			}
		}
		return null;
	}
	
	
	// TODO : Idée : Etre totalement générique entre une IA et un joueur réel (Pas de switch dégueu entre lan et ia).
	
	// TODO : Déplacement en groupe utilisant les papiers qu'on a lu
	
	// TODO : Recherche par octree pour les interactions
	
	// TODO : Gérer la puissance de la musique selon la position de la caméra
	
	// TODO : Instancier le moins possible d'objets !!!! SUPER IMPORTANT, pas besoin d'instancier deux fois les actions

	
}
