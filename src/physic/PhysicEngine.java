package physic;

import java.util.Vector;

import model.Objet;

public class PhysicEngine {

	/*
	 * Generic collision handler
	 */
	
	
	public static void collision(Objet o1,Objet o2){
		
	}
	
	/*
	 * Generic pathfinding handler, return an array of point
	 */
	public static Vector<Integer[]> pathFinding(int departX,int departY,int objectifX,int objectifY ,Boolean[][] map ){
		
		return new Vector<Integer[]>();
	}
	
	public void update(){
		/*
		 * Update world physic
		 */
	}
}
