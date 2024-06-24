package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Raichu extends Pokemon{

	public Raichu() {
		super("Raichu", Tipo.ELETTRO, null, new Mossa []{Mossa.TUONOSHOCK, Mossa.RUGGITO, null, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.COLPOCODA); put(12, Mossa.ATTACCORAPIDO); put(14, Mossa.DOPPIOTEAM); put(16, Mossa.COMETE); put(19, Mossa.FULMINE); put(24, Mossa.TUONO); put(30, Mossa.TUONOPUGNO);}}, 
				1, 101, new MissingNo(), 60, 110, 90, 90, 55, 80);
	}
}
