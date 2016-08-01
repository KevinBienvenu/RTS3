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
	
	// Different way of accessing objets
	public ObjetPool objets;
	public Vector<Integer> aliveObjets;
	public Vector<Vector<Integer>> teamObjets;
	
	
	
	
	public static int idObjet = 0;
	public static int idTeamObjet = 0;
	public static int generateUniqueId(){return idObjet++;};
	public static int generateUniqueTeamId(){return idTeamObjet++;};
	 // Tous les objets en jeu
	public Action[] actions ; // On instanciera une seule fois toutes les actions du monde ...
	public MapGrid grid; // La grille pour le pathfinding
	
	public World(int nPlayers,Map map){
		actions = new Action[4];
		sizeX = map.sizeX;
		sizeY = map.sizeY;
		objets = new ObjetPool();
		// Team objets 
		aliveObjets = new Vector<Integer>();
		teamObjets = new Vector<Vector<Integer>>();
		for(int i = 0 ; i<nPlayers+1;i++){
			teamObjets.add(new Vector<Integer>());
		}
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
	
	public Vector<Integer> getObjets(){
		return aliveObjets;
	}
	public Objet[] getAllObjets(){
		return ObjetPool.objets;
	}
	
	public void updateReferences(){
		// Repartit les int dans les tableaux (a chaque fin de tour)
		// TODO : Est ce qu'on tri par id ? (temps d'acces)
		aliveObjets.clear();
		for(int i =0;i<teamObjets.size();i++){
			teamObjets.clear();
		}
		for(Objet o : getAllObjets()){
			if(o.isInWorld){
				aliveObjets.addElement(o.id);
			}
			for(int i = 0;i<teamObjets.size();i++){
				if(o.team==i){
					
				}
			}
		}
	}
	
	public void update(InputModel im){
		/*// TODO : gérer plusieurs input
		 * 
		 * Update the world state
		 */
		for(Integer i : getObjets()){
			getObjetById(i).update(im);
		}
		//Update mapgrid
		//Update references
		updateReferences();
		//Resolve physic with mapgrid state
		// For the time being raw collision
		
	}
	
	public Objet getObjetById(int id){
		return objets.objets[id];
	}
	
	
	// TODO : Idée : Etre totalement générique entre une IA et un joueur réel (Pas de switch dégueu entre lan et ia).
	
	// TODO : Déplacement en groupe utilisant les papiers qu'on a lu
	
	// TODO : Recherche par octree pour les interactions
	
	// TODO : Gérer la puissance de la musique selon la position de la caméra
	
	// TODO : Instancier le moins possible d'objets !!!! SUPER IMPORTANT, pas besoin d'instancier deux fois les actions

	
}
