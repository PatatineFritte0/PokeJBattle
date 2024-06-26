package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Nidoqueen extends Pokemon{

	public Nidoqueen() {
		super("Nidoqueen", Tipo.TERRA, Tipo.VELENO, new Mossa []{Mossa.AZIONE, Mossa.GRAFFIO, Mossa.COLPOCODA, Mossa.DOPPIOCALCIO},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RIDUTTORE); put(12, Mossa.MEGAPUGNO); put(18, Mossa.VELENOSPINA); put(23, Mossa.TERREMOTO); put(25, Mossa.ABISSO);}}, 
				1, 101, new MissingNo(), 90, 76, 92, 75, 87, 85);
	}
}
