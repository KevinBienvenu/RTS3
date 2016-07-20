package action;

import control.InputModel;
import model.Objet;

public abstract class Action {
	
	/*
	 * Classe générique pour exprimer une action
	 * Peut être un sort, une production, un déplacement etc ..
	 * Un objet est donc résumé par un état initial et une liste d'action
	 */
	
	public int id;
	
	public abstract boolean shouldUpdate(InputModel im, Object o);
	public abstract void update(InputModel im,Objet o);
	
}
