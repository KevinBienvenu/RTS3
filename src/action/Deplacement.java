package action;

import control.InputModel;
import control.KeyMapper.KeyEnum;
import data.Attributs;
import game.Game;
import main.Main;
import model.Objet;
import pathfinding.Case;

public class Deplacement extends Action{

	@Override
	public void init(InputModel im, Objet o) {
		// TODO : g�rer le d�placement en groupe
		o.xTarget = im.x;
		o.yTarget = im.y;
		o.casesPathfinding = Game.world.grid.pathfinding(o.x, o.y, im.x, im.y);
	}

	@Override
	public boolean shouldUpdate(InputModel im, Object o) {
		// TODO : G�rer les cas o� le d�placement ne devrait pas avoir lieu
		// exemple : �tat gel�
		return true;
	}

	@Override
	public void updateAction(InputModel im, Objet o) {
		if(o.casesPathfinding.size()>1){
			Case c = Game.world.grid.getCase(o.casesPathfinding.get(0));
			moveToward(o,c.x,c.y);
		} else {
			moveToward(o,o.xTarget,o.yTarget);
		}

	}

	@Override
	public void handleChangeAction(InputModel im, Objet o) {
		// condition d'arr�t
		if((o.x-o.xTarget)*(o.x-o.xTarget)+(o.y-o.yTarget)*(o.y-o.yTarget)<10){
			o.changeAction(Action.actions.get(0), im);
		}
		// gestion du click droit (d�placement uniquement)
		if(im.selection.contains(o) && im.isPressed(KeyEnum.RightClick)){
			o.changeAction(Action.actions.get(1), im);
		}
	}



	private void moveToward(Objet o, float tx, float ty){

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


}
