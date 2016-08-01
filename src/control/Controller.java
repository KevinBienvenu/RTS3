package control;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import data.Data;
import game.Game;

public class Controller {

	/*
	 * Handle selection and all things control related
	 */
	InputModel[] inputs;
	int idCurrentPlayer = 1;
	KeyMapper keymapper;
	
	
	public Controller(int nPlayers){
		keymapper = new KeyMapper();
		inputs = new InputModel[nPlayers];
		for(int i = 0; i< inputs.length;i++){
			inputs[i] = new InputModel(i);
		}
	}
	public void getInputs(Input i){
		
		inputs[idCurrentPlayer].update(i, keymapper);
		for(int idx = 0 ; idx<inputs.length; idx++){
			if(idx!=idCurrentPlayer){
				/*
				 * Insert multiplayer inputs here or AI
				 */
			}
		}
	}
	public InputModel getCurrentPlayerInputModel(){
		return inputs[idCurrentPlayer];
	}
	
	
}
