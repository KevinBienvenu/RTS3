package action;

import Utils.InputModel;
import model.Objet;

public abstract class Action {
	
	/*
	 * Classe générique pour exprimer une action
	 * Peut être un sort, une production, un déplacement etc ..
	 * Un objet est donc résumé par un état initial et une liste d'action
	 */
	
	public int id;
	
	public abstract boolean shouldStart(InputModel im, Object o);
	public abstract boolean shouldStop(InputModel im, Object o);
	public abstract void update(InputModel im,Objet o);
	public abstract void undo(InputModel im,Objet o); // Reverse situation for player
}
