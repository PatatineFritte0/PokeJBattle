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
public class Nidoran_F extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Nidoran_F() {
		super("Nidoran_F", Tipo.TERRA, null, new Mossa []{Mossa.RUGGITO, Mossa.GRAFFIO, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RIDUTTORE); put(12, Mossa.MEGAPUGNO);}}, 
				1, 15, new Nidorina(), 55, 41, 47, 40, 52, 40);
	}
}
