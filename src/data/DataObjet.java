package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class DataObjet {

	// Generic fields
	public HashMap<Attributs, Float> attributs;
	private static String location ="";

	public DataObjet(String filename){

		String fichier = location+filename;
		attributs = new HashMap<Attributs, Float>();
		// Constructeur par défaut, associe le mapping standard
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			String[] tab;
			while ((ligne=br.readLine())!=null){
				if(!ligne.contains("_")){
					throw new Exception();
				}
				tab = ligne.split("_");
				attributs.put(Attributs.valueOf(tab[0]),Float.parseFloat(tab[1]));
			}

			br.close(); 
		}		
		catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public String toString(){
		String s = "";
		for(Attributs a : attributs.keySet()){
			s += a + " _ " + attributs.get(a)+"\r\n";
		}
		return s;
	}
}
