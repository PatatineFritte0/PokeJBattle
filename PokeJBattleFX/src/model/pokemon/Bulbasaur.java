package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;

/**
 * Classe che crea un determinato pokemon
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class Bulbasaur extends Pokemon {
	
	public Bulbasaur() {
		super("Bulbasaur", Tipo.ERBA, Tipo.VELENO, new Mossa []{Mossa.AZIONE, Mossa.RUGGITO, Mossa.FRUSTATA, null},
				new HashMap<Integer, Mossa>() {{put(6, Mossa.CRESCITA); put(9, Mossa.FOGLIELAMA);}},
				1, 16, new Ivysaur() , 45, 45, 49, 65, 49, 65);	
	}
}
