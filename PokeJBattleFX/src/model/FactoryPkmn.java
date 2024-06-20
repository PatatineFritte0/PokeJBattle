package model;
import model.pokemon.*;

public class FactoryPkmn {

	public static Pokemon crea(String scelta, int... lvl) {
		
		Pokemon pkmn; 
		
		switch(scelta) {
			case "bulbasaur":
				pkmn = new Bulbasaur();
				break;
			case "ivysaur":
				pkmn = new Ivysaur();
				break;
			case "venosaur":
				pkmn = new Venosaur();
				break;
			case "squirtle":
				pkmn = new Squirtle();
				break;
			case "wortortle":
				pkmn = new Wortortle();
				break;
			case "blastoise":
				pkmn = new Blastoise();
				break;
			case "charmander":
				pkmn = new Charmander();
				break;
			case "charmeleon":
				pkmn = new Charmeleon();
				break;
			case "charizard":
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
}
