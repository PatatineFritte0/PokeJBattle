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
public class Nidorino extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Nidorino() {
		super("Nidorino", Tipo.TERRA, null, new Mossa []{Mossa.VELENOSPINA, Mossa.AZIONE, Mossa.INCORNATA, Mossa.DOPPIOCALCIO},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RIDUTTORE); put(12, Mossa.FOSSA); put(18, Mossa.PERFORCORNO);}}, 
				1, 22, new Nidoking(), 61, 65, 72, 55, 57, 55);
	}
}
