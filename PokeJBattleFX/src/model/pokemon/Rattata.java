package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Rattata extends Pokemon{

	public Rattata() {
		super("Rattata", Tipo.NORMALE, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(4, Mossa.COLPOCODA); put(8, Mossa.ATTACCORAPIDO); put(17, Mossa.IPERZANNA);}}, 
				1, 20, new Raticate(), 30, 72, 56, 25, 35, 35);
	}
}
