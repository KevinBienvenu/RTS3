package action;

import Utils.InputModel;
import model.Objet;

public abstract class Action {
	
	/*
	 * Classe g�n�rique pour exprimer une action
	 * Peut �tre un sort, une production, un d�placement etc ..
	 * Un objet est donc r�sum� par un �tat initial et une liste d'action
	 */
	
	public int id;
	
	public abstract boolean shouldStart(InputModel im, Object o);
	public abstract boolean shouldStop(InputModel im, Object o);
	public abstract void update(InputModel im,Objet o);
	public abstract void undo(InputModel im,Objet o); // Reverse situation for player
}
