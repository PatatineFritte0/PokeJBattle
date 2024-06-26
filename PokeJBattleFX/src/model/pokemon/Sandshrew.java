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
public class Sandshrew extends Pokemon{

	public Sandshrew() {
		super("Sandshrew", Tipo.TERRA, null, new Mossa []{Mossa.GRAFFIO, Mossa.TURBOSABBIA, Mossa.LACERAZIONE, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.DOPPIOTEAM); put(12, Mossa.COMETE); put(18, Mossa.FOSSA);}}, 
				1, 22, new Sandslash(), 50, 40, 75, 20, 85, 30);
	}
}
