package game;

import java.util.HashMap;

import model.Objet;

public class Map {

	public String name;
	public float sizeX, sizeY;
	public HashMap<Integer, Objet> objets;
	
	public Map(){
		// TODO : constructeur par d�faut, � �liminer lors de la cr�ation des vraies map
		name = "map 01";
		sizeX = 800;
		sizeY = 600;
		objets = new HashMap<Integer, Objet>();
		Objet tempo = new Objet(100,100,"lancier", 1);
		objets.put(tempo.id, tempo);
		tempo = new Objet(200,100,"chevalier", 1);
		objets.put(tempo.id, tempo);
		tempo = new Objet(100,300,"lancier", 2);
		objets.put(tempo.id, tempo);
		tempo = new Objet(200,300,"lancier", 2);
		objets.put(tempo.id, tempo);
	}
}
