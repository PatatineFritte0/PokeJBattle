package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Squirtle extends Pokemon {
	
	public Squirtle() {
		super("Squirtle", Tipo.ACQUA, null, new Mossa []{Mossa.PISTOLACQUA, Mossa.RITIRATA, null, null},
				null, 5, 16, null, 44, 43, 48, 50, 65, 64);
	}
}
