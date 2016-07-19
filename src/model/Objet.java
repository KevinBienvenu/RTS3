package model;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import action.Action;

public abstract class Objet {
	/*
	 * Un objet est la classe de base dont h�rite n'importe quel �l�ment du monde
	 * Il se compose d'un �tat (index� par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 */
	public float[] state;
	public Vector<Action> actions;
	// On stipule qu'on ne peut faire qu'une seule action � la fois , cad un seul �tat
	public Action currentAction;
	
	public void update(){
		
	}
	public abstract void render(Graphics g);
	
	
}
