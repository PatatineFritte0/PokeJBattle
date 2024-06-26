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
public class Wortortle extends Pokemon {
	
	/**
	 * Costruttore classe
	 */
	public Wortortle() {
		super("Wortortle", Tipo.ACQUA, null, new Mossa []{Mossa.AZIONE, Mossa.COLPOCODA, Mossa.PISTOLACQUA, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RITIRATA); put(12, Mossa.MORSO); put(17, Mossa.IDROPOMPA); put(20, Mossa.IDROPULSAR); put(24, Mossa.FERROSCUDO); put(28, Mossa.IDRONDATA); put(32, Mossa.IDROPOMPA); put(37, Mossa.ONDASCHIANTO); put(41, Mossa.SURF);}},
				1, 16, new Blastoise(), 59, 58, 63, 65, 80, 80);
	}
}
