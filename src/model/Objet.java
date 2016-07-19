package model;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import action.Action;

public abstract class Objet {
	/*
	 * Un objet est la classe de base dont h�rite n'importe quel �l�ment du monde
	 * Il se compose d'un �tat (index� par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 * Ainsi qu'une action courante (� m�diter si une suffit)
	 */
	public float[] state;
	public Vector<Action> actions;
	public Action currentAction;// On stipule qu'on ne peut faire qu'une seule action � la fois , cad un seul �tat, � r�fl�chir
	
	public void update(){
		// Comportement commun � tous les objets
		for(Action a : actions){
			
		}
	}
	public abstract void render(Graphics g);//TODO :  La aussi id�alement lecomportementdevrait �tre commun, � m�diter
	
	
}
