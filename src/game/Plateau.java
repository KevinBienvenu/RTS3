package game;

import java.util.Vector;

import Utils.InputModel;
import action.Action;
import model.Objet;

public class Plateau {

	public Vector<Objet> objets;
	public InputModel[] inputs; // Pour ne pas les réinstancier
	public Action[] actions ; // On instancie une seule fois toutes les actions ...
	
	public Plateau(int nPlayers){
		inputs = new InputModel[nPlayers];
		for(int i = 0; i<nPlayers; i++){
			inputs[i] = new InputModel();
		}
		actions = new Action[4];
		for(int i = 0; i<nPlayers; i++){
			//actions[i] = new Action();
		}
		objets = new Vector<Objet>();
	}
	
	// TODO : Idée : Etre totalement générique entre une IA et un joueur réel (Pas de switch dégueu entre lan et ia).
	
	// TODO : Déplacement en groupe utilisant les papiers qu'on a lu
	
	// TODO : Recherche par octree pour les interactions
	
	// TODO : Gérer la puissance de la musique selon la position de la caméra
	
	// TODO : Instancier le moins possible d'objets !!!! SUPER IMPORTANT, pas besoin d'instancier deux fois les actions

	
}
