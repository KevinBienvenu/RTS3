package utils;

import java.io.File;
import java.util.HashMap;
import java.util.Vector;


public class Utils {

	public static HashMap<String, String> loadRepertoire(String nameRepertoire, Vector<String> extensionsFichier){
		HashMap<String, String> toReturn = new HashMap<String, String>();
		File repertoire = new File(nameRepertoire);
		File[] files=repertoire.listFiles();
		String s, si;
		for(int i=0; i<files.length; i++){
			s = files[i].getName();
			for(String ext : extensionsFichier){
				if(s.contains("."+ext)){
					// on load l'image
					toReturn.put(s.substring(0, s.length()-ext.length()-1).toLowerCase(), nameRepertoire+s);
					continue;
				} 
			}
			if (!s.contains(".")){
				// nouveau répertoire
				toReturn.putAll(loadRepertoire(nameRepertoire+s+"/", extensionsFichier));
			}
		} 
		return toReturn;
	}
	
	public static HashMap<String, String> loadRepertoire(String nameRepertoire, String extension){
		Vector<String> extensions = new Vector<String>();
		extensions.add(extension);
		return loadRepertoire(nameRepertoire, extensions);
	}
}
