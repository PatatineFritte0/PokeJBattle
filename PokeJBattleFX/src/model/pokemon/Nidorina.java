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
public class Nidorina extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Nidorina() {
		super("Nidorina", Tipo.TERRA, null, new Mossa []{Mossa.AZIONE, Mossa.GRAFFIO, Mossa.COLPOCODA, Mossa.DOPPIOCALCIO},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RIDUTTORE); put(12, Mossa.MEGAPUGNO); put(18, Mossa.VELENOSPINA);}}, 
				1, 22, new Nidoqueen(), 70, 56, 62, 55, 67, 55);
	}
}
