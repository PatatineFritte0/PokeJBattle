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
public class Blastoise extends Pokemon {
	
	/**
	 * Costruttore classe
	 */
	public Blastoise() {
		super("Blastoise", Tipo.ACQUA, null, new Mossa []{Mossa.AZIONE, Mossa.COLPOCODA, Mossa.PISTOLACQUA, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RITIRATA); put(12, Mossa.MORSO); put(17, Mossa.IDROPOMPA); put(20, Mossa.IDROPULSAR); put(24, Mossa.FERROSCUDO); put(28, Mossa.IDRONDATA); put(32, Mossa.IDROPOMPA); put(37, Mossa.ONDASCHIANTO); put(41, Mossa.SURF);}},
				1, 101, new MissingNo(), 79, 78, 83, 85, 100, 105);
	}
}
