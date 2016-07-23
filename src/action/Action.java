package action;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Vector;

import control.InputModel;
import model.Objet;

public abstract class Action {
	
	/*
	 * Classe g�n�rique pour exprimer une action
	 * Peut �tre un sort, une production, un d�placement etc ..
	 * Un objet est donc r�sum� par un �tat initial et une liste d'action
	 */
	
	public int id;
	public abstract void init(InputModel im, Objet o);
	public abstract boolean shouldUpdate(InputModel im, Object o);
	public abstract void updateAction(InputModel im, Objet o);
	public abstract void handleChangeAction(InputModel im, Objet o);
	public abstract boolean checkChangeAction(InputModel im, Objet o);
	public final void update(InputModel im,Objet o){
		updateAction(im, o);
		handleChangeAction(im, o);
	}
	
	
	public static HashMap<EnumAction,Action> actions;
	
	
	

	
	public static void loadActions(){
		// Load automatically all the actions here
		Action.actions = new HashMap<EnumAction , Action>();
		
		for(EnumAction action : EnumAction.values()){
			Class<?> clazz;
			try {
				clazz = Class.forName("action."+action.toString());
				Constructor<?> ctor = clazz.getConstructor();
				Action object = (Action) ctor.newInstance();
				Action.actions.put(action, object);
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public static Action getAction(EnumAction action){
		return Action.actions.get(action);
	}
	
}
