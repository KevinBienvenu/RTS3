package game;


import java.util.Vector;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import action.Action;
import action.ActionDefault;
import action.ActionMove;
import control.Controller;
import data.Attributs;
import data.Data;
import graphic.GraphicEngine;
import graphic.GraphicsData;
import model.Objet;
import model.ObjetPool;
import physic.PhysicEngine;
import sound.SoundEngine;

public class Game extends BasicGame {
	
	
	static GraphicEngine graphicEngine;
	static PhysicEngine physicEngine;
	static SoundEngine soundEngine;
	static Controller controller;
	static Player[] players;
	
	public static World world;
	// TODO : à mettre au bon endroit
	public static Data data;

	
	public Game(String title) {
		super(title);
		
		//Init all the Object Pools
		// Init all the engines (except sounds and graphisms - do that in init()
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// Call the graphic engine
		GraphicEngine.update(g, world);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		int nbPlayers = 2;
		//Init engines
		ObjetPool.init();
		physicEngine = new PhysicEngine();
		soundEngine = new SoundEngine();
		controller = new Controller(nbPlayers);
		players = new Player[nbPlayers+1];
		for(int i = 0 ; i<nbPlayers+1;i++){
			players[i] = new Player(i);
		}
		
		GraphicsData.currentPlayerInputModel = controller.getCurrentPlayerInputModel();
		
		// TODO : à virer et/ou à réarranger
		// => les datas sont à créer pour chaque joueur/ équipe
		data = new Data();
		// => création des actions, faudra trouver une meilleure manière d'y accéder ceci dit...
		// Idéalement faut un helper pour tout loader ça sera plus clair
		Action.loadActions();
		world = new World(2,new Map());
		ObjetPool.assignToWorld();
		world.buildGrid();
		
	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		// Game control the loop and is orchestrating everything
		updateController(gc);
		updateWorld();
		physicEngine.update();
	}
	
	public static Float getData(Objet o,Attributs attribut){
		return players[o.team].getData(o.name,attribut);
	}
	
	public void updateController(GameContainer gc){
		controller.getInputs(gc.getInput());
		
	}
	public void updateWorld(){
		world.update(controller.getCurrentPlayerInputModel());
	}
	
	
}