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
public class Raticate extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Raticate() {
		super("Raticate", Tipo.NORMALE, null, new Mossa []{Mossa.GRAFFIO, Mossa.COLPOCODA, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.ATTACCORAPIDO); put(17, Mossa.IPERZANNA); put(24, Mossa.FORZA); put(32, Mossa.GIGAIMPATTO);}}, 
				1, 101, new MissingNo(), 55, 97, 81, 50, 60, 70);
	}
}
