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
import data.Data;
import graphic.GraphicEngine;
import graphic.GraphicsData;
import physic.PhysicEngine;
import sound.SoundEngine;

public class Game extends BasicGame {
	
	
	GraphicEngine graphicEngine;
	PhysicEngine physicEngine;
	SoundEngine soundEngine;
	Controller controller;
	
	public static World world;
	
	// TODO : � mettre au bon endroit
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
		
		//Init engines
		
		physicEngine = new PhysicEngine();
		soundEngine = new SoundEngine();
		controller = new Controller(2);
		
		GraphicsData.currentPlayerInputModel = controller.getCurrentPlayerInputModel();
		
		// TODO : � virer et/ou � r�arranger
		// => les datas sont � cr�er pour chaque joueur/ �quipe
		data = new Data();
		// => cr�ation des actions, faudra trouver une meilleure mani�re d'y acc�der ceci dit...
		// Id�alement faut un helper pour tout loader �a sera plus clair
		Action.loadActions();
		world = new World(2,new Map());
	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		// Game control the loop and is orchestrating everything
		updateController(gc);
		updateWorld();
		physicEngine.update();
	}
	
	
	public void updateController(GameContainer gc){
		controller.getInputs(gc.getInput());
		
	}
	public void updateWorld(){
		world.update(controller.getCurrentPlayerInputModel());
	}
	
	
}