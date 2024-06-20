package model;

import model.costanti.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Franco extends Allenatore {
	
	Random strategia;
	Allenatore enemy;
	Pokemon enemyMain;
	boolean scambioConsentito;
	
	public Franco(Allenatore enemy) {
		super("Franco", new Pokemon[] {FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random()});
		
		this.strategia = new Random();
		
		this.enemy = enemy;
		this.enemyMain = enemy.getSquadra()[0];
		this.scambioConsentito = true;
		
		int lvlMedio = 1;
		int nPkmnEnemy = 0;
		for(Pokemon pkmn:enemy.getSquadra()) {
			if(pkmn != null) {				
				lvlMedio += pkmn.getLvl();
				nPkmnEnemy += 1;
			}
		}
		
		
		for(Pokemon pkmn:this.getSquadra()) {
			if(pkmn != null) {
				pkmn.setLvl(lvlMedio-3);
				pkmn.setCurrentExp(-100000);
				for(Mossa m:pkmn.getMoveSet()) {
					Set<Integer> setChiavi = pkmn.getParcoMosse().keySet();
					ArrayList<Integer> listChiavi = new ArrayList<>();
					for(Integer i:setChiavi) listChiavi.add(i);
					Mossa m1 = pkmn.getParcoMosse().get(listChiavi.get(this.strategia.nextInt(0, listChiavi.size())));
					Mossa m2 = pkmn.getParcoMosse().get(listChiavi.get(this.strategia.nextInt(0, listChiavi.size())));
					Mossa m3 = pkmn.getParcoMosse().get(listChiavi.get(this.strategia.nextInt(0, listChiavi.size())));
					Mossa m4 = pkmn.getParcoMosse().get(listChiavi.get(this.strategia.nextInt(0, listChiavi.size())));
					pkmn.setMoveSet(new Mossa[] {m1, m2, m3, m4});
				}
			}
		}
	}
	
	public Mossa agisci() {
		
		Mossa sceltaFinale = null;
		
		Mossa[] set = this.getMainPokemon().getMoveSet();
		
		int numMosse = 0;
		for(Mossa move:set) {
			if(move != null) numMosse += 1;
		}
		
		if(enemy.getMainPokemon() != this.enemyMain) {
			this.scambioConsentito = true;
			this.enemyMain = this.enemy.getMainPokemon();
		}
		
		if(scambioConsentito && this.strategia.nextInt(0, 99) < 30) {
			this.scambioConsentito = false;
			return Mossa.CAMBIA;
		}
		
		
		ArrayList<Mossa> mosseCorrette = new ArrayList<>();
		for(Mossa m:this.getMainPokemon().getMoveSet()) {
			if(m != null && (m.getCategoria() == Categoria.STATO || m.getTipo().checkSuperefficacia(this.enemy.getMainPokemon().getTipi()[0]) || m.getTipo().checkSuperefficacia(this.enemy.getMainPokemon().getTipi()[1]))) {
				mosseCorrette.add(m);
			}
		}
		
		if(mosseCorrette.size() > 0) {
			return mosseCorrette.get(strategia.nextInt(0, mosseCorrette.size()));
		}
		
		int mossa = strategia.nextInt(0, numMosse);
		
		switch(mossa) {
			case 0:
				sceltaFinale = this.getMainPokemon().getMoveSet()[0];
				break;
			case 1:
				sceltaFinale = this.getMainPokemon().getMoveSet()[1];
				break;
			case 2:
				sceltaFinale = this.getMainPokemon().getMoveSet()[2];
				break;
			case 3:
				sceltaFinale = this.getMainPokemon().getMoveSet()[3];
				break;
		}
		
		return sceltaFinale;
	}
	
	public String cambia() {
		
		Integer scelta = controllaSquadra();
		if(scelta != -1) return scelta.toString();
		
		int nPkmn = this.getSquadra().length;	
		scelta = strategia.nextInt(0, nPkmn);
		
		return scelta.toString();
	}
	
	private int controllaSquadra() {
		int id = -1;
		
		Tipo e1 = this.enemy.getMainPokemon().getTipi()[0];
		Tipo e2 = this.enemy.getMainPokemon().getTipi()[1];
		
		for(Pokemon pkmn:this.getSquadra()) {
			if(pkmn.getBattlePs() > 0 && pkmn != this.getMainPokemon() && 
			  (pkmn.getTipi()[0].checkSuperefficacia(e1) || pkmn.getTipi()[0].checkSuperefficacia(e2) ||
			  (pkmn.getTipi()[1] != null && (pkmn.getTipi()[1].checkSuperefficacia(e1) || pkmn.getTipi()[1].checkSuperefficacia(e2))))) {
				id = this.getPokemonId(pkmn);
			}
		}
		
		return id;
	}
}
