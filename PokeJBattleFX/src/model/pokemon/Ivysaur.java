package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Ivysaur extends Pokemon {
	
	public Ivysaur() {
		super("Ivysaur", Tipo.ERBA, Tipo.VELENO, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.AZIONE); put(2, Mossa.RUGGITO); put(3, Mossa.FRUSTATA); put(6, Mossa.CRESCITA); put(9, Mossa.FOGLIELAMA); put(12, Mossa.DRAGOSPIRO); put(16, Mossa.SEMEBOMBA); put(20, Mossa.FOGLIAMAGICA); put(25, Mossa.LACCIOERBOSO);}},
				1, 36, new Venosaur() , 60, 60, 62, 80, 63, 80);	
	}
}
