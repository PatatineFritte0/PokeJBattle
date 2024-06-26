package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Nidoran_M extends Pokemon{

	public Nidoran_M() {
		super("Nidoran_M", Tipo.TERRA, null, new Mossa []{Mossa.VELENOSPINA, Mossa.AZIONE, Mossa.INCORNATA, Mossa.DOPPIOCALCIO},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RIDUTTORE); put(12, Mossa.FOSSA);}}, 
				1, 14, new Nidorino(), 46, 50, 57, 40, 40, 40);
	}
}
