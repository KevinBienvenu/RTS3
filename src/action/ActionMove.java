package action;

import control.InputModel;
import control.KeyMapper.KeyEnum;
import data.Attributs;
import data.Data;
import game.Game;
import main.Main;
import model.Objet;
import model.ObjetPool;
import model.ObjetUtil;
import pathfinding.Case;

public class ActionMove extends Action{

	@Override
	public void init(InputModel im, Objet o) {
		// TODO : gérer le déplacement en groupe
		//o.idTarget = im.idObjetMouse;
		o.casesPathfinding = Game.world.grid.pathfinding(o.x, o.y, im.x, im.y);
		o.idWork = Game.world.grid.getCase(im.x, im.y).id;
	}	

	@Override
	public boolean shouldUpdate(InputModel im, Object o) {
		// TODO : Gérer les cas où le déplacement ne devrait pas avoir lieu
		// exemple : état gelé,ou pas de target
		return true;
	}

	@Override
	public void updateAction(InputModel im, Objet o) {
		//TODO : Make it work when target change case
		if(o.casesPathfinding.size()>1){
			Case c = Game.world.grid.getCase(o.casesPathfinding.get(0));
			moveToward(o,c.x,c.y);
		} else {
			Objet o2 = Game.world.getObjetById(o.idTarget);
			if(o2!=null){
				moveToward(o,o2.x,o2.y);
			}
			
		}
	}

	@Override
	public void handleChangeAction(InputModel im, Objet o) {
		// Get target
		Objet o2 = Game.world.getObjetById(o.idTarget);
		// condition d'arrêt
		if(ObjetUtil.isNear(o, o2)){
			if(o2.name.equals("checkpoint")){
				//Kill the checkpoint
				o2.destroy();
				o.idTarget=Data.nullValue;
			}
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
		if(im.selection.contains(o) && im.isPressed(KeyEnum.RightClick) ){
			//Destroy previous target
			Objet o2 = Game.world.getObjetById(o.idTarget);
			if(o2!=null && o2.name.equals("checkpoint")){
				o2.destroy();
			}
			// Click on void
			// If we want only one checkpoint update idObjet mouse each time in the if..
			if(im.idObjetMouse()==Data.nullValue){
				o.idTarget = Objet.getObjet(im.x, im.y, "checkpoint", o.team).id;
			}
			// Click on Id
			else{
				o.idTarget = im.idObjetMouse();
			}
			return true;
		}
		return false;
	}


}
