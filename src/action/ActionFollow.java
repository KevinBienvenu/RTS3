package action;

import java.util.Vector;

import control.InputModel;
import game.Game;
import model.Objet;

public class ActionFollow extends Action {

	@Override
	public void init(InputModel im, Objet o) {
		// TODO Auto-generated method stub
		Action.actions.get(1).init(im, o);
	}

	@Override
	public boolean shouldUpdate(InputModel im, Object o) {
		// TODO Auto-generated method stub
		
		return Action.actions.get(1).shouldUpdate(im, o);
	}

	@Override
	public void updateAction(InputModel im, Objet o) {
		// TODO Auto-generated method stub
		Objet followed = Game.world.getObjetById(o.idTarget);
		o.xTarget = followed.x;
		o.yTarget = followed.y;
	}

	@Override
	public void handleChangeAction(InputModel im, Objet o) {
		// TODO Auto-generated method stub
		Action.actions.get(1).handleChangeAction(im, o);
		
	}

}
