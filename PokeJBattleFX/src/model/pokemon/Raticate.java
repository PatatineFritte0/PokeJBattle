package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Raticate extends Pokemon{

	public Raticate() {
		super("Raticate", Tipo.NORMALE, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(4, Mossa.COLPOCODA); put(8, Mossa.ATTACCORAPIDO); put(17, Mossa.IPERZANNA); put(24, Mossa.FORZA); put(32, Mossa.GIGAIMPATTO);}}, 
				1, 101, new MissingNo(), 55, 97, 81, 50, 60, 70);
	}
}
