package control;


import java.util.Vector;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import game.Game;
import model.Objet;

public class InputModel implements java.io.Serializable{

	/**
	 * Handle selection rectangle ( it is part of inputs at the end ...)
	 */
	
	public int team;
	
	public Vector<Integer> down;
	public Vector<Integer> pressed;
	public float x;
	public float y;
	
	public Rectangle selectionRectangle ;
	public Vector<Objet> selection;
	private float anchorX;
	private float anchorY;
	
	public InputModel(int team){
		down = new Vector<Integer>();
		pressed = new Vector<Integer>();
		
		this.team = team;
		
		selection = new Vector<Objet>();
		selectionRectangle = new Rectangle(-1000f,-1000f,0.1f,0.1f);
	}

	/*
	 * On a pas besoin de le réinstancier à chaque fois ...
	 */
	public void update(Input input){
		down.clear();
		pressed.clear();
		x = input.getMouseX();
		y = input.getMouseY();
		// IL y a surement plus simple et moins coûteux
		// TODO : Ajouter ratio space
		for(int i=0; i<250;i++){
			if(input.isKeyDown(i)){
				down.addElement(i);
			}
			if(input.isKeyPressed(i)){
				down.addElement(i);
			}
		}
		// Mouse
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			pressed.addElement(Input.MOUSE_LEFT_BUTTON);
		}
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			down.addElement(Input.MOUSE_LEFT_BUTTON);
		}
		
		updateSelectionRectangle();
		updateSelection(Game.world.objets);
	}
	
	private void updateSelectionRectangle() {
		if(!isDown(Input.MOUSE_LEFT_BUTTON) ){
			resetRectangle();
			return;
		}

		if (isPressed(Input.MOUSE_LEFT_BUTTON)) {

			selectionRectangle.setBounds(x,y,x+0.1f,y+0.1f);
			anchorX = x;
			anchorY = y;
			
		}
		selectionRectangle.setBounds((float) Math.min(anchorX, x),
				(float) Math.min(anchorY, y), (float) Math.abs(x - anchorX) + 0.1f,
				(float) Math.abs(y - anchorY) + 0.1f);
	}
	
	public void resetRectangle(){
		selectionRectangle.setX(-1000f);
		selectionRectangle.setY(-1000f);
		selectionRectangle.setHeight(0.1f);
		selectionRectangle.setWidth(0.1f);
		anchorX = 0f;
		anchorY = 0f;
	}
	public boolean rectangleIsNone(){
		return selectionRectangle.getX()==-1000f;
	}
	public boolean isDown(int key){
		return down.contains(key);
	}
	public boolean isPressed(int key){
		return pressed.contains(key);
	}
	
	private void updateSelection(Vector<Objet> objects){
		if(!this.rectangleIsNone()){
			this.selection.clear();
		}
		for(Objet o : objects){
			// suppression de la selection courant
			// ajout vis à vis du rectangle
			if(o.team == this.team 
					&& o.x>selectionRectangle.getMinX()
					&& o.x<selectionRectangle.getMaxX()
					&& o.y>selectionRectangle.getMinY()
					&& o.y<selectionRectangle.getMaxY()
					&& !this.selection.contains(o)){
				this.selection.addElement(o);
			}
		}
	}
	



}
