package model;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import action.Action;

public abstract class Objet {
	/*
	 * Un objet est la classe de base dont hérite n'importe quel élément du monde
	 * Il se compose d'un état (indexé par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 * Ainsi qu'une action courante (à méditer si une suffit)
	 */
	public float[] state;
	public Vector<Action> actions;
	public Action currentAction;// On stipule qu'on ne peut faire qu'une seule action à la fois , cad un seul état, à réfléchir
	
	public void update(){
		// Comportement commun à tous les objets
		for(Action a : actions){
			
		}
	}
	public abstract void render(Graphics g);//TODO :  La aussi idéalement lecomportementdevrait être commun, à méditer
	
	
}
