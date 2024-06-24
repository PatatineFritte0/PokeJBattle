package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Pidgeotto extends Pokemon{

	public Pidgeotto() {
		super("Pidgeotto", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(4, Mossa.BECCATA); put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCORAPIDO); put(17, Mossa.RIDUTTORE); put(24, Mossa.VOLO); put(28, Mossa.AEREOATTACCO); put(32, Mossa.ATTACCODALA);}}, 
				1, 36, new Pidgeot(), 63, 71, 60, 50, 55, 50);
	}
}
