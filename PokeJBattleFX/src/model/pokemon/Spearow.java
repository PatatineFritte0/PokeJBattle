package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Spearow extends Pokemon{

	public Spearow() {
		super("Spearow", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.GRAFFIO); put(4, Mossa.BECCATA); put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCODALA); put(19, Mossa.VOLO);}}, 
				1, 20, new Fearow(), 40, 70, 60, 31, 30, 31);
	}
}
