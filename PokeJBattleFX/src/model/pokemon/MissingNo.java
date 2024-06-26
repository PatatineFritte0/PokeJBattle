package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;

/**
 * Classe che crea un determinato pokemon ma questo vuoto
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class MissingNo extends Pokemon {
	
	public MissingNo() {
		super("MissingNo", null, null, new Mossa []{null, null, null, null},
				null, 0, 0, null , 0, 0, 0, 0, 0, 0);	
	}
}
