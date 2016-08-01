package graphic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import game.Game;
import game.World;
import model.Objet;
import model.ObjetPool;

public class GraphicEngine {

	/*
	 * Draw everything and do all the graphical transformation to fit screen here and only here
	 */
	
	public static void draw(Graphics g,Objet o){
		// Generic method for drawing anything
		if(GraphicsData.currentPlayerInputModel.selection.contains(o)){
			g.setColor(Color.green);
			g.fillRect(o.x-12f, o.y-12f, 24f, 24f);
		}
		switch(o.team){
		case 1 : g.setColor(Color.blue); break;
		case 2 : g.setColor(Color.red);break;
		default : g.setColor(Color.darkGray);
		}
		g.fillRect(o.x-10f, o.y-10f, 20f, 20f);
		g.setColor(Color.white);
		g.drawString(o.name+" "+o.id+" "+o.isInWorld, o.x-g.getFont().getWidth(o.name)/2, o.y-10);
	}
	
	
	public static void update(Graphics g, World world){
		// Draw selection rectangle
		for(Integer i : Game.world.getObjets()){	
				draw(g, Game.world.getObjetById(i));
		}
		g.setColor(Color.green);
		g.draw(GraphicsData.currentPlayerInputModel.selectionRectangle);
		
	}
}
