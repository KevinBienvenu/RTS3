package graphic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import game.World;
import model.Objet;

public class GraphicEngine {

	/*
	 * Draw everything and do all the graphical transformation to fit screen here and only here
	 */
	
	public static void draw(Graphics g,Objet o){
		// Generic method for drawing anything
	}
	
	
	public static void update(Graphics g, World world){
		// Draw selection rectangle
		g.setColor(Color.green);
		g.draw(GraphicsData.selectionRectangle);
	}
}
