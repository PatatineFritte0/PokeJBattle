package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Caterpie extends Pokemon {
	
	public Caterpie() {
		super("Caterpie", Tipo.COLEOTTERO, null, new Mossa []{Mossa.AZIONE, Mossa.COLEOMORSO, null, null},
				new HashMap<Integer, Mossa>() {{put(7, Mossa.MILLEBAVE);}},
				1, 7, new Metapod() , 45, 45, 30, 20, 35, 20);	
	}
}