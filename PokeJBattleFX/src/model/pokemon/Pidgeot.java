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
public class Pidgeot extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Pidgeot() {
		super("Pidgeot", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{Mossa.GRAFFIO, Mossa.BECCATA, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCORAPIDO); put(17, Mossa.RIDUTTORE); put(24, Mossa.VOLO); put(28, Mossa.AEREOATTACCO); put(32, Mossa.ATTACCODALA); put(37, Mossa.AGILITA);}}, 
				1, 101, new MissingNo(), 83, 101, 80, 70, 75, 70);
	}
}
