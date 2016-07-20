package game;

import java.util.Vector;

import action.Action;
import control.InputModel;
import model.Objet;


public class World {
	
	/*
	 * Plateau store only the world , not the interface to interact with it
	 */
	public Vector<Objet> objets; // Tous les objets en jeu
	public Action[] actions ; // On instanciera une seule fois toutes les actions du monde ...
	public Boolean[][] grid; // La grille pour le pathfinding
	
	public World(int nPlayers,Vector<Objet> map){

		actions = new Action[4];
		
		objets = new Vector<Objet>();
		
		// Build the grid function of buildings
		buildGrid();
	}
	
	public void buildGrid(){
		/*
		 * Loop over vector of objets and find cells occupied by buildings
		 */
	}
	
	public void update(){
		/*
		 * Update the world state
		 */
		
		
	}
	// TODO : Id�e : Etre totalement g�n�rique entre une IA et un joueur r�el (Pas de switch d�gueu entre lan et ia).
	
	// TODO : D�placement en groupe utilisant les papiers qu'on a lu
	
	// TODO : Recherche par octree pour les interactions
	
	// TODO : G�rer la puissance de la musique selon la position de la cam�ra
	
	// TODO : Instancier le moins possible d'objets !!!! SUPER IMPORTANT, pas besoin d'instancier deux fois les actions

	
}
