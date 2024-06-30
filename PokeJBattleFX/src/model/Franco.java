package model;

import model.costanti.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

/**
 * Questa classe e' l'inteligenza dell'NPC che serve
 * all allenatore per allenare il pokemon
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class Franco extends Allenatore {
	/**
	 * questo campo server per generare i numeri in modo casuale
	 */
	Random strategia;
	/**
	 * questo campo serve a Franco per gestire le sue mosse
	 * sapendo chi ha contro potrebbe fare qualche mossa non randomica
	 */
	Allenatore enemy;
	/**
	 * questo campo serve per tener conto a Franco di chi ha di fronte
	 */
	Pokemon enemyMain;
	/**
	 * questo campo serve per evitare che Franco cambi pokemon inutilmente
	 */
	boolean scambioConsentito;
	/**
	 * questo campo serve per evitare che Franco utilizzi troppe mosse di stato
	 */
	int statusCounter;
	
	/**
	 * 
	 * Costruttore di Franco, una volta passato il nemico, lui si adattera facendo
	 * qualche volta una mossa randomica e qualche volta una mossa sensata
	 * 
	 * @param enemy Allenatore
	 */
	public Franco(Allenatore enemy) {
		super("Franco", new Pokemon[] {FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random(), FactoryPkmn.random()});
		
		this.strategia = new Random();
		
		this.enemy = enemy;
		this.enemyMain = enemy.getSquadra()[0];
		this.scambioConsentito = true;
		this.statusCounter = 0;
		
		int lvlMedio = 1;
		int nPkmnEnemy = 0;
		for(Pokemon pkmn:enemy.getSquadra()) {
			if(pkmn != null) {				
				lvlMedio += pkmn.getLvl();
				nPkmnEnemy += 1;
			}
		}
		
		lvlMedio = Integer.valueOf(lvlMedio/nPkmnEnemy);
		
		
		for(Pokemon pkmn:this.getSquadra()) {
			if(pkmn != null) {
				pkmn.goToLvl(lvlMedio + strategia.nextInt(-3, +3));
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
	
	/**
	 * Questo metodo serve a Franco per capire come agire e quindi che mossa fare
	 * 
	 * @return Mossa
	 */
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
			if(m != null && ((m.getCategoria() == Categoria.STATO && this.statusCounter < 6) || m.getTipo().checkSuperefficacia(this.enemy.getMainPokemon().getTipi()[0]) || m.getTipo().checkSuperefficacia(this.enemy.getMainPokemon().getTipi()[1]))) {
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
		
		if(sceltaFinale.getCategoria() == Categoria.STATO) {
			this.statusCounter += 1;
		}
		
		return sceltaFinale;
	}
	
	/**
	 * Questo metodo serve a Franco di capire con chi deve scambiare il pokemon
	 * 
	 * @return (int) l'index della posizione del pokemon della sua squadra che ha scelto
	 */
	public int cambia() {
		
		Integer scelta = controllaSquadra();
		if(scelta != -1) return scelta;
			
		ArrayList<Integer> disponibili = new ArrayList<Integer>();
		for(Pokemon p : this.getSquadra()) {
			if(p.getBattlePs() > 0 && p != this.getMainPokemon()) {
				disponibili.add(this.getPokemonId(p));
			}
		}

		scelta = disponibili.get(strategia.nextInt(0, disponibili.size()));
		
		this.statusCounter = 0;
		
		return scelta;
	}
	
	/**
	 * Questo metodo serve a Franco per ragionare e capire quale pokemon
	 * scagliare contro al nemico.
	 * 
	 * @return int
	 */
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
	
	/**
	 * Questo metodo serve per settare il campo scambioConsentito 
	 * 
	 * @param scambioConsentito boolean
	 * @return void
	 */
	public void setScambioConsentito(boolean scambioConsentito) { this.scambioConsentito = scambioConsentito; }
	
}
