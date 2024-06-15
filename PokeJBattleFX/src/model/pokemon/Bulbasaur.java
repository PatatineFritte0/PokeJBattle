package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Bulbasaur extends Pokemon {
	
	public Bulbasaur() {
		super("Bulbasaur", Tipo.ERBA, Tipo.VELENO, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.AZIONE); put(2, Mossa.RUGGITO); put(3, Mossa.FRUSTATA); put(6, Mossa.CRESCITA); put(9, Mossa.FOGLIELAMA); put(12, Mossa.DRAGOSPIRO);}},
				1, 16, new Ivysaur() , 45, 45, 49, 65, 49, 65);	
	}
}
