package model;

import java.io.Serializable;
import java.util.Vector;

import action.Action;
import action.EnumAction;
import control.InputModel;
import data.Attributs;
import data.Data;
import game.Game;
import game.World;

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
	
	// Allocation in memory
	public boolean isInWorld;
	
	
	
	
	// Liste d'actions et action courante
	public Vector<EnumAction> actions;
	private EnumAction actionCourante;

	/*
	 * Attributs des actions, ces attributs doivent �tre dans objet, car ils sont propres
	 * � chaque objet, et font partie des donn�es � envoyer lors des resynchros.
	 * Ces attributs sont des variables de travail et peuvent �tre utilis�s par plusieurs actions diff�rentes
	 */
	
	public Vector<Integer> casesPathfinding;
	public int idTarget;
	public int idWork;
	
	protected Objet(float x, float y, String name, int team){
		this.id = World.generateUniqueId();
		this.init(x,y,name,team);
		
	}
	public void init(float x, float y ,String name, int team){
		this.x = x;
		this.y = y;
		this.name = name;
		this.team = team;
		// TODO : cr�er les actions uniques et les linker plut�t que de les cr�er, ici on teste alors c'est bon...
		this.actionCourante = EnumAction.ActionDefault;
		this.actions = new Vector<EnumAction>();
		// Temporary
		for(EnumAction action : EnumAction.values()){
			this.actions.add(action);
		}
	}
	public static Objet getObjet(float x, float y,String name, int team){
		Objet toReturn = ObjetPool.pull();
		toReturn.init(x, y, name, team);
		return toReturn;
	}
	
	public void update(InputModel im){
		// au d�but on v�rifie si on doit pas changer d'action
		for(EnumAction action : this.actions){
			if(Action.actions.get(action).checkChangeAction(im, this)){
				this.changeAction(action, im);
			}
		}
		// update l'�tat de l'action courante
		if(getCurrentAction().shouldUpdate(im, this)){
			getCurrentAction().update(im, this);
		}
		// check mouseOver
		if(isMouseOver(im)){
			im.idObjetMouse = id;
		}
	}
	
	/*
	 * TODO : Remove it
	 */
	public Action getCurrentAction(){
		return Action.getAction(actionCourante);
	}
	
	
	public float getAttribut(Attributs att){
		if(Game.data.datas.containsKey(this.name)){
			if(Game.data.datas.get(this.name).attributs.containsKey(att)){
				return Game.data.datas.get(this.name).attributs.get(att);
			} else {
				//System.out.println("l'objet "+name+" ne contient pas d'attribut "+att);
				return Data.nullValue;
			}
		} else {
			//System.out.println("donn�es introuvables pour l'objet :"+name);
			return Data.nullValue;
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

	public void changeAction(EnumAction action, InputModel im){
		// On v�rifie que c'est possible
		if(this.actions.contains(action)){
			this.actionCourante = action;
			getCurrentAction().init(im, this);
		} else {
			System.out.println("changement d'action impossible : "+action);
		}
	}
	
	public boolean isMouseOver(InputModel im){
		if(getAttribut(Attributs.isRect)!=Data.nullValue){
			// selection box rectangle
			
		} else {
			// selection box circle
			float radius = getAttribut(Attributs.radius);
			if(radius != Data.nullValue){
				if((im.x-x)*(im.x-x)+(im.y-y)*(im.y-y)<radius*radius){
					return true;
				}
			}
		}
		return false;
	}
	
}
