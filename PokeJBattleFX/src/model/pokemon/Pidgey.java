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
public class Pidgey extends Pokemon{

	public Pidgey() {
		super("Pidgey", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{Mossa.GRAFFIO, Mossa.BECCATA, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCORAPIDO); put(17, Mossa.RIDUTTORE);}}, 
				1, 18, new Pidgeotto(), 40, 56, 45, 35, 40, 35);
	}
}
