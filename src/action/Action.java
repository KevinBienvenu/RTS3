package action;

import java.util.Vector;

import control.InputModel;
import model.Objet;

public abstract class Action {
	
	/*
	 * Classe générique pour exprimer une action
	 * Peut être un sort, une production, un déplacement etc ..
	 * Un objet est donc résumé par un état initial et une liste d'action
	 */
	
	public int id;
	public abstract void init(InputModel im, Objet o);
	public abstract boolean shouldUpdate(InputModel im, Object o);
	public abstract void updateAction(InputModel im, Objet o);
	public abstract void handleChangeAction(InputModel im, Objet o);
	public final void update(InputModel im,Objet o){
		updateAction(im, o);
		handleChangeAction(im, o);
	}
	
	public static Vector<Action> actions;
	
}
