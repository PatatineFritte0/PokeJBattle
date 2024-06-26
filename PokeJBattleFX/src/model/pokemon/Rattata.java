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
public class Rattata extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Rattata() {
		super("Rattata", Tipo.NORMALE, null, new Mossa []{Mossa.GRAFFIO, Mossa.COLPOCODA, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.ATTACCORAPIDO); put(17, Mossa.IPERZANNA);}}, 
				1, 20, new Raticate(), 30, 72, 56, 25, 35, 35);
	}
}
