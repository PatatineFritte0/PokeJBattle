package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Pidgeot extends Pokemon{

	public Pidgeot() {
		super("Pidgeot", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(4, Mossa.BECCATA); put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCORAPIDO); put(17, Mossa.RIDUTTORE); put(24, Mossa.VOLO); put(28, Mossa.AEREOATTACCO); put(32, Mossa.ATTACCODALA); put(37, Mossa.AGILITA);}}, 
				1, 101, new MissingNo(), 83, 101, 80, 70, 75, 70);
	}
}
