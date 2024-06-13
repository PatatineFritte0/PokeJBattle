package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.factoryPkmn;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Charmander extends Pokemon {
	
	public Charmander() {	
		super("Charmander", Tipo.FUOCO, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(2, Mossa.RUGGITO); put(4, Mossa.BRACIERE); put(8, Mossa.MURODIFUMO); put(12, Mossa.DRAGOSPIRO);}}, 
				5, 16, new Charmeleon(), 39, 65, 52, 60, 43, 50);
	}

}