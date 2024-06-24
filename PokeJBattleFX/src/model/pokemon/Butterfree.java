package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Butterfree extends Pokemon {
	
	public Butterfree() {
		super("Butterfree", Tipo.COLEOTTERO, Tipo.VOLANTE, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(3, Mossa.AZIONE); put(5, Mossa.COLEOMORSO); put(7, Mossa.MILLEBAVE); put(9, Mossa.RAFFORZATORE); put(13, Mossa.RAFFICA); put(14, Mossa.CONFUSIONE); put(17, Mossa.PSICORAGGIO); put(21, Mossa.VOLO);}},
				1, 101, new MissingNo() , 60, 70, 45, 90, 50, 80);	
	}
}
