package model.pokemon;

import java.util.HashMap;

import model.Pokemon;
import model.costanti.Mossa;
import model.costanti.Tipo;

public class Squirtle extends Pokemon {
	
	public Squirtle(String nome, Tipo t1, Tipo t2, Mossa[] mosse, HashMap<Integer, Mossa> parcoMosse, int lvl,
			int evoLvl, Pokemon evo, int maxPs, int velocita, int attacco, int attaccoSP, int difesa, int difesaSP) {
		super(nome, t1, t2, mosse, parcoMosse, lvl, evoLvl, evo, maxPs, velocita, attacco, attaccoSP, difesa, difesaSP);
		// TODO Auto-generated constructor stub
	}
}
