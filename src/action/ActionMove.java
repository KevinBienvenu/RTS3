package action;

import control.InputModel;
import control.KeyMapper.KeyEnum;
import data.Attributs;
import data.Data;
import game.Game;
import main.Main;
import model.Objet;
import pathfinding.Case;

public class ActionMove extends Action{

	@Override
	public void init(InputModel im, Objet o) {
		// TODO : gérer le déplacement en groupe
		o.idTarget = im.idObjetMouse;
		o.casesPathfinding = Game.world.grid.pathfinding(o.x, o.y, im.x, im.y);
		o.idWork = Game.world.grid.getCase(im.x, im.y).id;
	}	

	@Override
	public boolean shouldUpdate(InputModel im, Object o) {
		// TODO : Gérer les cas où le déplacement ne devrait pas avoir lieu
		// exemple : état gelé
		return true;
	}

	@Override
	public void updateAction(InputModel im, Objet o) {
		if(o.casesPathfinding.size()>1){
			Case c = Game.world.grid.getCase(o.casesPathfinding.get(0));
			moveToward(o,c.x,c.y);
		} else {
			Objet o2 = Game.world.objets.get(o.idTarget);
			moveToward(o,o2.x,o2.y);
		}
	}

	@Override
	public void handleChangeAction(InputModel im, Objet o) {
		// condition d'arrêt
		Objet o2 = Game.world.objets.get(o.idTarget);
		if((o.x-o2.x)*(o.x-o2.x)+(o.y-o2.y)*(o.y-o2.y)<10){
			o.changeAction(EnumAction.ActionDefault, im);
		}
		// gestion du click droit (déplacement uniquement)
		if(im.selection.contains(o) && im.isPressed(KeyEnum.RightClick)){
			o.changeAction(EnumAction.ActionMove, im);
		}
	}



	protected void moveToward(Objet o, float tx, float ty){

		float newvx, newvy;
		newvx = tx-o.x;
		newvy = ty-o.y;
		//Creating the norm of the acceleration and the new velocities among x and y
		float maxVNorm = o.getAttribut(Attributs.speed)/(Main.framerate);		
		float vNorm = (float) Math.sqrt(newvx*newvx+newvy*newvy);
		vNorm = (float) Math.sqrt(newvx*newvx+newvy*newvy);

		if(vNorm>maxVNorm){
			//if the velocity is too large it is reduced to the maxVelocity value
			newvx = newvx*maxVNorm/vNorm;
			newvy = newvy*maxVNorm/vNorm;
		}
		vNorm = (float)(Math.min(vNorm, maxVNorm));
		float newX,newY;
		newX = o.x+newvx;
		newY = o.y+newvy;
		//if the new coordinates are beyond the map's limits, it must be reassigned
		if(newX<0){
			newX = 0;
			newvx = Math.max(newvx,0f);
		}
		if(newY<0){
			newY = 0;
			newvy = Math.max(newvy, 0f);
		}
		if(newX>Game.world.sizeX){
			newX = Game.world.sizeX;
			newvx = Math.min(0f, newvx);
		}
		if(newY>Game.world.sizeY){
			newY = Game.world.sizeY;
			newvy = Math.min(0f, newvy);
		}
		//eventually we reassign the position and velocity variables
		o.setVXVY(newvx, newvy);
		o.setXY(newX, newY);

	}

	@Override
	public boolean checkChangeAction(InputModel im, Objet o) {
		// gestion du click droit (déplacement uniquement)
		if(im.selection.contains(o) && im.isPressed(KeyEnum.RightClick) && im.idObjetMouse==Data.nullValue){
			return true;
		}
		return false;
	}


}
