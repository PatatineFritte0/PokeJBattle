package model;
import model.pokemon.*;

import java.util.ArrayList;
import java.util.List;
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
			case "caterpie":
			case "9":
				pkmn = new Caterpie();
				break;
			case "metapod":
			case "10":
				pkmn = new Metapod();
				break;
			case "butterfree":
			case "11":
				pkmn = new Butterfree();
				break;
			case "weedle":
			case "12":
				pkmn = new Weedle();
				break;
			case "kakuna":
			case "13":
				pkmn = new Kakuna();
				break;
			case "beedrill":
			case "14":
				pkmn = new Beedrill();
				break;
			case "pidgey":
			case "15":
				pkmn = new Pidgey();
				break;
			case "pidgeotto":
			case "16":
				pkmn = new Pidgeotto();
				break;
			case "pidgeot":
			case "17":
				pkmn = new Pidgeot();
				break;
			case "rattata":
			case "18":
				pkmn = new Rattata();
				break;
			case "raticate":
			case "19":
				pkmn = new Raticate();
				break;
			case "fearow":
			case "20":
				pkmn = new Fearow();
				break;
			case "spearow":
			case "21":
				pkmn = new Spearow();
				break;
			case "ekans":
			case "22":
				pkmn = new Ekans();
				break;
			case "arbok":
			case "23":
				pkmn = new Arbok();
				break;
			case "pikachu":
			case "24":
				pkmn = new Pikachu();
				break;
			case "raichu":
			case "25":
				pkmn = new Raichu();
				break;
			case "sandshrew":
			case "26":
				pkmn = new Sandshrew();
				break;
			case "sandslash":
			case "27":
				pkmn = new Sandslash();
				break;
			case "nidoran_f":
			case "28":
				pkmn = new Nidoran_F();
				break;
			case "nidorina":
			case "29":
				pkmn = new Nidorina();
				break;
			case "nidoqueen":
			case "30":
				pkmn = new Nidoqueen();
				break;
			case "nidoran_M":
			case "31":
				pkmn = new Nidoran_M();
				break;
			case "nidorino":
			case "32":
				pkmn = new Nidorino();
				break;
			case "nidoking":
			case "33":
				pkmn = new Nidoking();
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
		Integer n = r.nextInt(0, 34);
		
		return crea(n.toString());	
	}
	
	public static List<Pokemon> allPokemon() {
		int max = 34;
		
		List<Pokemon> all = new ArrayList<>();
		for(Integer i = 0; i < max; i++) {
			all.add(crea(i.toString(), 5));
		}
		
		return all;
	}
}
