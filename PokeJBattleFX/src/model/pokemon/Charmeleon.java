package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Charmeleon extends Pokemon{

	public Charmeleon() {
		super("Charmeleon", Tipo.FUOCO, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(17, Mossa.ROGODENTI); put(20, Mossa.LACERAZIONE); put(24, Mossa.LANCIAFIAMME); put(28, Mossa.VISOTRUCE); put(36, Mossa.MARCHIATURA);}}, 
				5, 36, null, 58, 64, 58, 80, 65, 80);
	}
	
	public Charmeleon(int lvl) {
		super("Charmeleon", Tipo.FUOCO, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(17, Mossa.ROGODENTI); put(20, Mossa.LACERAZIONE); put(24, Mossa.LANCIAFIAMME); put(28, Mossa.VISOTRUCE); put(36, Mossa.MARCHIATURA);}}, 
				lvl, 36, null, 58, 64, 58, 80, 65, 80);
	}

}
