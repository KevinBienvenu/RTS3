package Utils;


import org.newdawn.slick.Input;
import java.util.Vector;
public class InputModel implements java.io.Serializable{

	/**
	 * 
	 */
	
	public Vector<Integer> down;
	public Vector<Integer> pressed;
	public float x;
	public float y;
	
	public InputModel(){
		down = new Vector<Integer>();
		pressed = new Vector<Integer>();
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
	}
	
	public boolean isDown(int key){
		return down.contains(key);
	}
	public boolean isPressed(int key){
		return pressed.contains(key);
	}
	
	
	



}
