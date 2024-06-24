package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Fearow extends Pokemon{

	public Fearow() {
		super("Fearow", Tipo.NORMALE, Tipo.VOLANTE, new Mossa []{Mossa.GRAFFIO, Mossa.BECCATA, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.TURBOSABBIA); put(12, Mossa.ATTACCODALA); put(19, Mossa.VOLO); put(24, Mossa.RIDUTTORE); put(27, Mossa.PERFORBECCO); put(32, Mossa.AGILITA);}}, 
				1, 101, new MissingNo(), 65, 100, 90, 61, 65, 61);
	}
}
