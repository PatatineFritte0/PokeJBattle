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
public class Arbok extends Pokemon{

	/**
	 * Costruttore classe
	 */
	public Arbok() {
		super("Arbok", Tipo.VELENO, null, new Mossa []{Mossa.VELENOSPINA, Mossa.FULMISGUARDO, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.MORSO); put(12, Mossa.STRIDIO); put(18, Mossa.FANGO); put(22, Mossa.ACIDO); put(25, Mossa.SMOG);}}, 
				1, 101, new MissingNo(), 60, 80, 95, 65, 69, 79);
	}
}
