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
public class Pikachu extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Pikachu() {
		super("Pikachu", Tipo.ELETTRO, null, new Mossa []{Mossa.TUONOSHOCK, Mossa.RUGGITO, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.COLPOCODA); put(12, Mossa.ATTACCORAPIDO); put(14, Mossa.DOPPIOTEAM); put(16, Mossa.COMETE); put(19, Mossa.FULMINE);}}, 
				1, 20, new Raichu(), 35, 90, 55, 50, 40, 50);
	}
}
