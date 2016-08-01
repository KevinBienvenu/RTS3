package control;

import java.util.Collection;

import control.KeyMapper.KeyEnum;
import data.Attributs;
import data.Data;
import game.Game;
import model.Objet;

public class SelectionHelper {
	
	public static float seuilDistanceClick = 150f;
	
	public static void updateSelection(InputModel im, Objet[] objects){
		if(!im.rectangleIsNone() && !im.isDown(KeyEnum.AjouterSelection)){
			im.selection.clear();
		}
		// flag qui se souvient si une unité a été selectionnée par le rectangle
		boolean flag = false;
		for(Objet o : objects){
			// suppression de la selection courant
			if(o.isInWorld && !(Game.getData(o,Attributs.isSelectionnable)==Data.True)){
				continue;
			}
			// ajout vis à vis du rectangle
			if(o.team == im.team 
					&& o.x>im.selectionRectangle.getMinX()
					&& o.x<im.selectionRectangle.getMaxX()
					&& o.y>im.selectionRectangle.getMinY()
					&& o.y<im.selectionRectangle.getMaxY()
					&& !im.selection.contains(o)){
				im.selection.addElement(o);
				flag = true;
			}
		}
		// gestion de la selection par click
		// si le rectangle est non nul, mais ne contient personne
		if(!im.rectangleIsNone() && !flag){
			Objet om = null;
			float distanceMinimale = 0, distance = 0;
			for(Objet o: objects){
				distance = (o.x-im.x)*(o.x-im.x)+(o.y-im.y)*(o.y-im.y);
				if(o.team == im.team &&(
						(om == null && distance<seuilDistanceClick)
						|| (om != null && distance<distanceMinimale))){
					om = o;
					distanceMinimale = distance;
				}
			}
			if(om!=null && Game.getData(om,Attributs.isSelectionnable)==Data.True){
				System.out.println(om.name);
				im.selection.add(om);
				flag = true;
			}
		}
		// gestion de la selection globale
		if(flag && im.isDown(KeyEnum.ToutSelection) && im.selection.size()==1){
			for(Objet o : objects){
				// suppression de la selection courant
				// ajout vis à vis du rectangle
				if(o.name == im.selection.get(0).name 
						&& !im.selection.contains(o) && o.team==im.selection.get(0).team && Game.getData(o,Attributs.isSelectionnable)==Data.True){
					im.selection.addElement(o);
				}
			}
		}
	}
}
