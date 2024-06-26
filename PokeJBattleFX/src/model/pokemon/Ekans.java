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
public class Ekans extends Pokemon{

	public Ekans() {
		super("Ekans", Tipo.VELENO, null, new Mossa []{Mossa.VELENOSPINA, Mossa.FULMISGUARDO, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.MORSO); put(12, Mossa.STRIDIO); put(18, Mossa.FANGO);}}, 
				1, 20, new Arbok(), 35, 55, 60, 40, 44, 54);
	}
}
