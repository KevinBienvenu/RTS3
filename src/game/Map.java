package game;

import java.util.Vector;

import model.Objet;

public class Map {

	public String name;
	public float sizeX, sizeY;
	public Vector<Objet> objets;
	
	public Map(){
		// TODO : constructeur par défaut, à éliminer lors de la création des vraies map
		name = "map 01";
		sizeX = 800;
		sizeY = 600;
		objets = new Vector<Objet>();
		objets.add(new Objet(100,100,"lancier", 1));
		objets.add(new Objet(200,100,"chevalier", 1));
		objets.add(new Objet(100,300,"lancier", 2));
		objets.add(new Objet(200,300,"lancier", 2));
	}
}
