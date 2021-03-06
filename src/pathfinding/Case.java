package pathfinding;

import java.util.Vector;

import model.Objet;

public class Case {
	
	public boolean ok;
	
	public int id;
	public MapGrid map;
	
	public float x;
	public float y;
	
	public int i, j;
	
	public float sizeX;
	public float sizeY;

	public Vector<Objet> objets = new Vector<Objet>();
	public Vector<Objet> surroundingObjets = new Vector<Objet>();
	
	public Case(boolean ok, int id, MapGrid map){
		this.ok = ok;
		this.map = map;
		this.id = id;
	}

	public void updateX(float x, float x1){
		this.x = x;
		this.sizeX = x1-x;
	}
	
	public void updateY(float y, float y1){
		this.y = y;
		this.sizeY = y1-y;
	}
	public void update(float x, float y, float x1, float y1){
		this.x = x;
		this.sizeX = x1-x;
		this.y = y;
		this.sizeY = y1-y;
	}
	
	
	public String toString(){
		String s ="";
		s+= "case "+id+" = x:" + x+" y:"+y+"   sizeX:"+sizeX+" sizeY:"+sizeY;
		return s;
	}
	
	public void updateSurroundingChar(){
		this.surroundingObjets = this.map.getSurroundingChars(this);
	}
	
}
