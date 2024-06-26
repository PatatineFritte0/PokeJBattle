package model.pokemon;

import java.util.HashMap;
import model.Pokemon;
import model.costanti.*;

/**
 * Classe che crea un determinato pokemon
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class Kakuna extends Pokemon {
	
	public Kakuna() {
		super("Kakuna", Tipo.COLEOTTERO, Tipo.VELENO, new Mossa []{Mossa.AZIONE, null, null, null},
				new HashMap<Integer, Mossa>() {{put(7 , Mossa.MILLEBAVE); put(9 , Mossa.VELENOSPINA); put(7 , Mossa.RAFFORZATORE);}},
				1, 10, new Beedrill() , 45, 35, 25, 25, 50, 25);	
	}
}
