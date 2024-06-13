package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Blastoise extends Pokemon {
	
	public Blastoise() {
		super("Wortortle", Tipo.ACQUA, null, new Mossa []{null, null, null, null},
				new HashMap<Integer, Mossa>() {{put(1, Mossa.AZIONE); put(2, Mossa.COLPOCODA); put(4, Mossa.PISTOLACQUA); put(8, Mossa.RITIRATA); put(12, Mossa.MORSO); put(17, Mossa.IDROPOMPA); put(20, Mossa.IDROPULSAR); put(24, Mossa.FERROSCUDO); put(28, Mossa.IDRONDATA); put(32, Mossa.IDROPOMPA); put(37, Mossa.ONDASCHIANTO); put(41, Mossa.SURF);}},
				1, 101, new MissingNo(), 79, 78, 83, 85, 100, 105);
	}
}
