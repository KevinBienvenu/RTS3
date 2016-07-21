package game;

import java.util.Vector;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import control.Controller;
import graphic.GraphicEngine;
import graphic.GraphicsData;
import model.Objet;
import physic.PhysicEngine;
import sound.SoundEngine;

public class Game extends BasicGame {
	
	
	GraphicEngine graphicEngine;
	PhysicEngine physicEngine;
	SoundEngine soundEngine;
	Controller controller;
	
	public static World world;
	
	public Game(String title) {
		super(title);
		
		//Init all the Object Pools
		// Init all the engines (except sounds and graphisms - do that in init()
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
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
		world = new World(2,new Vector<Objet>());
		world.objets.add(new Objet(100,100,"philippe", 1));
		world.objets.add(new Objet(200,100,"marcel", 0));
		world.objets.add(new Objet(100,300,"roger", 2));
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
		world.update();
	}
	
	
}