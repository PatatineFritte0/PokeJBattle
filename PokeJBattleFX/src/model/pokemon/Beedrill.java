package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Beedrill extends Pokemon {
	
	public Beedrill() {
		super("Beedrill", Tipo.COLEOTTERO, Tipo.VELENO, new Mossa []{Mossa.AZIONE, null, null, null},
				new HashMap<Integer, Mossa>() {{put(7 , Mossa.MILLEBAVE); put(9 , Mossa.VELENOSPINA); put(7 , Mossa.RAFFORZATORE); put(12, Mossa.DOPPIOAGO); put(14, Mossa.AGILITA); put(17, Mossa.COLEOMORSO); put(21, Mossa.DOPPIOTEAM);}},
				1, 101, new MissingNo() , 65, 75, 90, 45, 40, 80);	
	}
}
