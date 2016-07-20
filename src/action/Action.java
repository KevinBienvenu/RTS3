package action;

import control.InputModel;
import model.Objet;

public abstract class Action {
	
	/*
	 * Classe g�n�rique pour exprimer une action
	 * Peut �tre un sort, une production, un d�placement etc ..
	 * Un objet est donc r�sum� par un �tat initial et une liste d'action
	 */
	
	public int id;
	
	public abstract boolean shouldUpdate(InputModel im, Object o);
	public abstract void update(InputModel im,Objet o);
	
}
