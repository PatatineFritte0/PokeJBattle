package model;
import model.pokemon.*;
import java.util.Random;

public class FactoryPkmn {

	public static Pokemon crea(String scelta, int... lvl) {
		
		Pokemon pkmn; 
		
		switch(scelta) {
			case "bulbasaur":
			case "0":
				pkmn = new Bulbasaur();
				break;
			case "ivysaur":
			case "1":
				pkmn = new Ivysaur();
				break;
			case "venosaur":
			case "2":
				pkmn = new Venosaur();
				break;
			case "squirtle":
			case "3":
				pkmn = new Squirtle();
				break;
			case "wortortle":
			case "4":
				pkmn = new Wortortle();
				break;
			case "blastoise":
			case "5":
				pkmn = new Blastoise();
				break;
			case "charmander":
			case "6":
				pkmn = new Charmander();
				break;
			case "charmeleon":
			case "7":
				pkmn = new Charmeleon();
				break;
			case "charizard":
			case "8":
				pkmn = new Charizard();
				break;
			case "missingNo":
				pkmn = new MissingNo();
				break;
			default:
				pkmn = null;
		}
		
		int l = 0;
        for (int i : lvl) { l += i; }
        l = (l>1)? l-1 : 0;
        
        if(l != 0) {pkmn.goToLvl(l);}
		
		return pkmn;
	}
	
	public static Pokemon random() {
		Random r = new Random();
		Integer n = r.nextInt(0, 9);
		
		return crea(n.toString());
		
		
	}
}
