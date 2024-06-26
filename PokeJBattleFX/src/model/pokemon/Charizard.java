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
public class Charizard extends Pokemon{

	public Charizard() {
		super("Charizard", Tipo.FUOCO, Tipo.VOLANTE, new Mossa []{Mossa.GRAFFIO, Mossa.RUGGITO, Mossa.BRACIERE, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.MURODIFUMO); put(12, Mossa.DRAGOSPIRO); put(17, Mossa.ROGODENTI); put(20, Mossa.LACERAZIONE); put(24, Mossa.LANCIAFIAMME); put(28, Mossa.VISOTRUCE); put(46, Mossa.RUOTAFUOCO); put(54, Mossa.INFERNO);}}, 
				1, 101, new MissingNo(), 78, 100, 84, 109, 78, 85);
	}
}
