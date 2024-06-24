package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Pidgey extends Pokemon{

	public Pidgey() {
		super("Pidgey", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(4, Mossa.BECCATA); put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCORAPIDO); put(17, Mossa.RIDUTTORE);}}, 
				1, 18, new Pidgeotto(), 40, 56, 45, 35, 40, 35);
	}
}
