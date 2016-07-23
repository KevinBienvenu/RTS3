package game;

import java.util.Vector;

import action.Action;
import control.InputModel;
import model.Objet;
import pathfinding.MapGrid;


public class World {
	
	/*
	 * Plateau store only the world , not the interface to interact with it
	 */
	
	public float sizeX, sizeY;
	
	public Vector<Objet> objets; // Tous les objets en jeu
	public Action[] actions ; // On instanciera une seule fois toutes les actions du monde ...
	public MapGrid grid; // La grille pour le pathfinding
	
	public World(int nPlayers,Map map){

		actions = new Action[4];
		
		sizeX = map.sizeX;
		sizeY = map.sizeY;
		// TODO : cloner le vecteur ou créer les objets manuellement
		objets = map.objets;
		
		// Build the grid function of buildings
		buildGrid();
	}
	
	public void buildGrid(){
		/*
		 * Loop over vector of objets and find cells occupied by buildings
		 */
		grid = new MapGrid(0,sizeX,0,sizeY);
		for(Objet o : this.objets){
			// TODO : updater la grille en fonction des objets inamovibles
		}
		
	}
	
	public void update(InputModel im){
		/*// TODO : gérer plusieurs input
		 * 
		 * Update the world state
		 */
		for(Objet o : this.objets){
			o.update(im);
		}
		
	}
	// TODO : Idée : Etre totalement générique entre une IA et un joueur réel (Pas de switch dégueu entre lan et ia).
	
	// TODO : Déplacement en groupe utilisant les papiers qu'on a lu
	
	// TODO : Recherche par octree pour les interactions
	
	// TODO : Gérer la puissance de la musique selon la position de la caméra
	
	// TODO : Instancier le moins possible d'objets !!!! SUPER IMPORTANT, pas besoin d'instancier deux fois les actions

	
}
