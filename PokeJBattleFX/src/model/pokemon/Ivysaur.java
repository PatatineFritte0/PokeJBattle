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
public class Ivysaur extends Pokemon {
	
	/**
	 * Costruttore classe
	 */
	public Ivysaur() {
		super("Ivysaur", Tipo.ERBA, Tipo.VELENO, new Mossa []{Mossa.AZIONE, Mossa.RUGGITO, Mossa.FRUSTATA, null},
				new HashMap<Integer, Mossa>() {{put(6, Mossa.CRESCITA); put(9, Mossa.FOGLIELAMA); put(16, Mossa.SEMEBOMBA); put(20, Mossa.FOGLIAMAGICA); put(25, Mossa.LACCIOERBOSO);}},
				1, 36, new Venosaur() , 60, 60, 62, 80, 63, 80);	
	}
}
