package model;
import model.pokemon.*;

public class factoryPkmn {

	private Pokemon pkmn; 
	
	public Pokemon crea(String scelta, int... lvl) {
		switch(scelta) {
			case "bulbasaur":
				this.pkmn = new Bulbasaur();
				break;
			case "squirtle":
				this.pkmn = new Squirtle();
				break;
			case "charmander":
				this.pkmn = new Charmander();
				break;
			default:
				this.pkmn = null;
		}
		
		int l = 0;
        for (int i : lvl) { l += l; }
        l = l - 5;
        
        if(l != 0) {this.pkmn.goToLvl(l);}
		
		return this.pkmn;
	}
}
