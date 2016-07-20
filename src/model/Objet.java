package model;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import action.Action;
import control.InputModel;

public class Objet {
	/*
	 * Un objet est la classe de base dont h�rite n'importe quel �l�ment du monde
	 * Il se compose d'un �tat (index� par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 * Ainsi qu'une action courante (� m�diter si une suffit)
	 */
	public float x;
	public float y;
	
	
	
	public Vector<Action> actions;// Par ordre de priorit�
	//public Vector<Action> currentActions;
	/*
	 *  On stipule qu'on  peut faire plus qu'une seule action � la fois , cad un seul �tat, � r�fl�chir
	 *  pour les �tats incompatibles ...
	 */
	public Objet(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(InputModel im){
		
		// Comportement commun � tous les objets , pas termin�, ou alors si ?
		for(Action a : actions){
			if(a.shouldUpdate(im, this)){
				a.update(im, this);
			}
		}
	}

	
}
