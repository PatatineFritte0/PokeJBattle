package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Squirtle extends Pokemon {
	
	public Squirtle() {
		super("Squirtle", Tipo.ACQUA, null, new Mossa []{Mossa.AZIONE, Mossa.COLPOCODA, Mossa.PISTOLACQUA, null},
				new HashMap<Integer, Mossa>() {{put(8, Mossa.RITIRATA); put(12, Mossa.MORSO); put(17, Mossa.IDROPOMPA); put(20, Mossa.IDROPULSAR); put(24, Mossa.FERROSCUDO); put(28, Mossa.IDRONDATA); put(32, Mossa.IDROPOMPA); put(37, Mossa.ONDASCHIANTO); put(41, Mossa.SURF);}},
				1, 16, new Wortortle(), 44, 43, 48, 50, 65, 64);
	}
}
