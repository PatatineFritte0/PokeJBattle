package model;
import model.pokemon.*;

public class factoryPkmn {

	private Pokemon pkmn; 
	
	public Pokemon crea(String scelta, int... lvl) {
		switch(scelta) {
			case "bulbasaur":
				this.pkmn = new Bulbasaur();
				break;
			case "ivysaur":
				this.pkmn = new Ivysaur();
				break;
			case "venosaur":
				this.pkmn = new Venosaur();
				break;
			case "squirtle":
				this.pkmn = new Squirtle();
				break;
			case "wortortle":
				this.pkmn = new Wortortle();
				break;
			case "blastoise":
				this.pkmn = new Blastoise();
				break;
			case "charmander":
				this.pkmn = new Charmander();
				break;
			case "charmeleon":
				this.pkmn = new Charmeleon();
				break;
			case "charizard":
				this.pkmn = new Charizard();
				break;
			case "missingNo":
				this.pkmn = new MissingNo();
				break;
			default:
				this.pkmn = null;
		}
		
		int l = 0;
        for (int i : lvl) { l += i; }
        l = (l>1)? l-1 : 0;
        
        if(l != 0) {this.pkmn.goToLvl(l);}
		
		return this.pkmn;
	}
}
