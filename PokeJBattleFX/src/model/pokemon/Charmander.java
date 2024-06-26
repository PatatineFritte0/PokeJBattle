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
public class Charmander extends Pokemon {
	
	/**
	 * Costruttore classe
	 */
	public Charmander() {	
		super("Charmander", Tipo.FUOCO, null, new Mossa []{Mossa.GRAFFIO, Mossa.RUGGITO, Mossa.BRACIERE, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.MURODIFUMO); put(12, Mossa.DRAGOSPIRO);}}, 
				1, 16, new Charmeleon(), 39, 65, 52, 60, 43, 50);
	}

}