package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Venosaur extends Pokemon {
	
	public Venosaur() {
		super("Venosaur", Tipo.ERBA, Tipo.VELENO, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.AZIONE); put(2, Mossa.RUGGITO); put(3, Mossa.FRUSTATA); put(6, Mossa.CRESCITA); put(9, Mossa.FOGLIELAMA); put(12, Mossa.DRAGOSPIRO); put(16, Mossa.SEMEBOMBA); put(20, Mossa.FOGLIAMAGICA); put(25, Mossa.LACCIOERBOSO); put(36, Mossa.VIGORCOLPO); put(40, Mossa.VERDEBUFERA); put(43, Mossa.FIORTEMPESTA);}},
				1, 101, new MissingNo() , 80, 80, 82, 100, 83, 100);	
	}
}