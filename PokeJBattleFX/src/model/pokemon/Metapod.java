package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Metapod extends Pokemon {
	
	public Metapod() {
		super("Metapod", Tipo.COLEOTTERO, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(3, Mossa.AZIONE); put(5, Mossa.COLEOMORSO); put(7, Mossa.MILLEBAVE); put(9, Mossa.RAFFORZATORE);}},
				1, 12, new Butterfree() , 50, 30, 20, 25, 20, 25);	
	}
}