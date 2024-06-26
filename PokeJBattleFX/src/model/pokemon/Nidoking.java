package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Nidoking extends Pokemon{

	public Nidoking() {
		super("Nidoking", Tipo.TERRA, Tipo.VELENO, new Mossa []{Mossa.VELENOSPINA, Mossa.AZIONE, Mossa.INCORNATA, Mossa.DOPPIOCALCIO},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RIDUTTORE); put(12, Mossa.FOSSA); put(18, Mossa.PERFORCORNO); put(23, Mossa.TERREMOTO); put(25, Mossa.ABISSO);}}, 
				1, 101, new MissingNo(), 81, 85, 102, 85, 77, 75);
	}
}
