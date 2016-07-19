package model;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import action.Action;

public abstract class Objet {
	/*
	 * Un objet est la classe de base dont hérite n'importe quel élément du monde
	 * Il se compose d'un état (indexé par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 */
	public float[] state;
	public Vector<Action> actions;
	// On stipule qu'on ne peut faire qu'une seule action à la fois , cad un seul état
	public Action currentAction;
	
	public void update(){
		
	}
	public abstract void render(Graphics g);
	
	
}
