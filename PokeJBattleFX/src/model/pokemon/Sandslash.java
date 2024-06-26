package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

/**
 * Classe che crea un determinato pokemon
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class Sandslash extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Sandslash() {
		super("Sandslash", Tipo.TERRA, null, new Mossa []{Mossa.GRAFFIO, Mossa.TURBOSABBIA, Mossa.LACERAZIONE, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.DOPPIOTEAM); put(12, Mossa.COMETE); put(18, Mossa.FOSSA); put(23, Mossa.TERREMOTO); put(25, Mossa.FRANA);}}, 
				1, 101, new MissingNo(), 75, 65, 100, 45, 110, 55);
	}
}
