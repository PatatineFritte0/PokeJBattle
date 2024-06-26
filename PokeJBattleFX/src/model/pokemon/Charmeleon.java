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
public class Charmeleon extends Pokemon{
	
	/**
	 * Costruttore classe
	 */
	public Charmeleon() {
		super("Charmeleon", Tipo.FUOCO, null, new Mossa []{Mossa.GRAFFIO, Mossa.RUGGITO, Mossa.BRACIERE, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.MURODIFUMO); put(12, Mossa.DRAGOSPIRO); put(17, Mossa.ROGODENTI); put(20, Mossa.LACERAZIONE); put(24, Mossa.LANCIAFIAMME); put(28, Mossa.VISOTRUCE);}}, 
				1, 36, new Charizard(), 58, 80, 64, 80, 58, 65);
	}
}
