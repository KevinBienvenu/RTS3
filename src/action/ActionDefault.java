package action;

import control.InputModel;
import control.KeyMapper.KeyEnum;
import model.Objet;

public class ActionDefault extends Action{

	@Override
	public void init(InputModel im, Objet o) {
		
	}

	@Override
	public boolean shouldUpdate(InputModel im, Object o) {
		return true;
	}

	@Override
	public void updateAction(InputModel im, Objet o) {
		
	}

	@Override
	public void handleChangeAction(InputModel im, Objet o) {
		
		
	}

	@Override
	public boolean checkChangeAction(InputModel im, Objet o) {
		// TODO appui sur la touche stop
		return false;
	}

}
