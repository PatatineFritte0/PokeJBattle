package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Bulbasaur extends Pokemon {
	
	public Bulbasaur() {
		super("Bulbasaur", Tipo.ERBA, null, new Mossa []{Mossa.FRUSTATA, Mossa.RUGGITO, null, null},
				null, 5, 16, null , 45, 45, 49, 65, 49, 65);	
	}
}
