package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;


public class Weedle extends Pokemon {
	
	public Weedle() {
		super("Weedle", Tipo.COLEOTTERO, Tipo.VELENO, new Mossa []{Mossa.AZIONE, null, null, null},
				new HashMap<Integer, Mossa>() {{put(7 , Mossa.MILLEBAVE); put(9 , Mossa.VELENOSPINA);}},
				1, 7, new Kakuna() , 40, 50, 35, 20, 30, 20);	
	}
}
