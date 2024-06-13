package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Charizard extends Pokemon{

	public Charizard() {
		super("Charizard", Tipo.FUOCO, Tipo.VOLANTE, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(2, Mossa.RUGGITO); put(4, Mossa.BRACIERE); put(8, Mossa.MURODIFUMO); put(12, Mossa.DRAGOSPIRO); put(17, Mossa.ROGODENTI); put(20, Mossa.LACERAZIONE); put(24, Mossa.LANCIAFIAMME); put(28, Mossa.VISOTRUCE); put(46, Mossa.RUOTAFUOCO); put(54, Mossa.INFERNO);}}, 
				1, 101, new MissingNo(), 78, 100, 84, 109, 78, 85);
	}
}
