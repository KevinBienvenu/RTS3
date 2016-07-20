package control;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class Controller {

	/*
	 * Handle selection and all things control related
	 */
	InputModel[] inputs;
	int idCurrentPlayer;
	
	public Controller(int nPlayers){
		inputs = new InputModel[nPlayers];
		for(int i = 0; i< inputs.length;i++){
			inputs[i] = new InputModel();
		}
	}
	public void getInputs(Input i){
		
		inputs[idCurrentPlayer].update(i);
		for(int idx = 0 ; idx<inputs.length; idx++){
			if(idx!=idCurrentPlayer){
				/*
				 * Insert multiplayer inputs here or AI
				 */
			}
		}
	}
	public Rectangle getSelectionRectangleCurrentPlayer(){
		return inputs[idCurrentPlayer].selectionRectangle;
	}
	
}
