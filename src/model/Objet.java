package model;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import action.Action;
import control.InputModel;

public class Objet {
	/*
	 * Un objet est la classe de base dont hérite n'importe quel élément du monde
	 * Il se compose d'un état (indexé par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 * Ainsi qu'une action courante (à méditer si une suffit)
	 */
	public float x;
	public float y;
	
	
	
	public Vector<Action> actions;// Par ordre de priorité
	//public Vector<Action> currentActions;
	/*
	 *  On stipule qu'on  peut faire plus qu'une seule action à la fois , cad un seul état, à réfléchir
	 *  pour les états incompatibles ...
	 */
	public Objet(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(InputModel im){
		
		// Comportement commun à tous les objets , pas terminé, ou alors si ?
		for(Action a : actions){
			if(a.shouldUpdate(im, this)){
				a.update(im, this);
			}
		}
	}

	
}
