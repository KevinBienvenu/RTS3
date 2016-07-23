package model;

import java.io.Serializable;
import java.util.Vector;

import action.Action;
import action.ActionDefault;
import action.Deplacement;
import control.InputModel;
import data.Attributs;
import game.Game;

public class Objet implements Serializable{
	/*
	 * Un objet est la classe de base dont h�rite n'importe quel �l�ment du monde
	 * Il se compose d'un �tat (index� par Index) ainsi qu'un vecteur d'actions possibles (Action)
	 * Ainsi qu'une action courante (� m�diter si une suffit)
	 */
	
	// Attributs uniques
	public int id;
	public float x, y;
	public float vx, vy;
	public String name;
	public int team;
	
	// Liste d'actions et action courante
	public Vector<Action> actions;
	private Action actionCourante;

	/*
	 * Attributs des actions, ces attributs doivent �tre dans objet, car ils sont propres
	 * � chaque objet, et font partie des donn�es � envoyer lors des resynchros.
	 * Ces attributs sont des variables de travail et peuvent �tre utilis�s par plusieurs actions diff�rentes
	 */
	public Vector<Integer> casesPathfinding;
	public float xTarget, yTarget;
	
	public Objet(float x, float y, String name, int team){
		this.x = x;
		this.y = y;
		this.name = name;
		this.team = team;
		// TODO : cr�er les actions uniques et les linker plut�t que de les cr�er, ici on teste alors c'est bon...
		this.actionCourante = Action.actions.get(0);
		this.actions = Action.actions;
	}
	
	public void update(InputModel im){
		
		if(actionCourante.shouldUpdate(im, this)){
			actionCourante.update(im, this);
		}
	}
	
	public float getAttribut(Attributs att){
		if(Game.data.datas.containsKey(this.name)){
			if(Game.data.datas.get(this.name).attributs.containsKey(att)){
				return Game.data.datas.get(this.name).attributs.get(att);
			} else {
				System.out.println("l'objet "+name+" ne contient pas d'attribut "+att);
				return -1;
			}
		} else {
			System.out.println("donn�es introuvables pour l'objet :"+name);
			return -1;
		}
	}

	public void setVXVY(float newvx, float newvy) {
		vx = newvx;
		vy = newvy;
	}

	public void setXY(float newX, float newY) {
		x = newX;
		y = newY;
	}

	public void changeAction(Action action, InputModel im){
		// on v�rifie que c'est possible
		if(this.actions.contains(action)){
			action.init(im, this);
			this.actionCourante = action;
		} else {
			System.out.println("changement d'action impossible : "+action);
		}
	}
	
}
