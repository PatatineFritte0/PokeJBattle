package model;

import java.util.HashMap;

public class Partita {
	private Allenatore allenatore;
	private Allenatore sfidante;
	
	public Partita(Allenatore allenatore, Allenatore sfidante){
		this.allenatore = allenatore;
		this.sfidante = sfidante;
	}
	
	public void doTurno(Turno allenatore, Turno sfidante){
			
	}
	
	public Allenatore checkVincitore() {
		int nPokeVivi = 0;
		
		Pokemon[] squadraAll = this.allenatore.getSquadra();
		for(Pokemon poke: squadraAll) {
			if(poke != null) {
				nPokeVivi += (poke.getBattlePs() <= 0 ) ? 1 : 0;
			}
		}
		
		if(nPokeVivi == 0) return this.sfidante;
		else nPokeVivi = 0;
		
		Pokemon[] squadraSfid = this.sfidante.getSquadra();
		for(Pokemon poke: squadraSfid) {
			if(poke != null) {
				nPokeVivi += (poke.getBattlePs() <= 0 ) ? 1 : 0;
			}
		}
		
		if(nPokeVivi == 0) return this.allenatore;
		return null;
	}
	
}
