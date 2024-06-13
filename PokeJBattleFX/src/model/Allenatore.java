package model;

import java.time.LocalDate;
import java.util.HashMap;

public class Allenatore {
	private String nickname;
	private Pokemon[] squadra = new Pokemon[6];
	private Pokemon mainPokemon;
	private int nPokemon;
	private int vittorie;
	private int sconfitte;
	private double winRadio;
	private LocalDate ultimoAccesso;
	
	public Allenatore(String nickname, Pokemon[] pokemon, int vittorie, int sconfitte) {
		this.nickname = nickname;
		
		// nel caso [x,x,null,null,x] otterremmo [x,x,x,null,null,null]
		int countNull = 0;
		for(int i = 0; i < pokemon.length; i++) {
			if(pokemon[i] != null) {
				this.squadra[i-countNull] = pokemon[i];
			}
		}
			
		this.mainPokemon = this.squadra[0];
		this.nPokemon = 0;
		for(Pokemon poke: squadra) {
			if(poke != null) this.nPokemon += 1;
		}
		
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.winRadio = (sconfitte != 0) ? this.vittorie/this.sconfitte : this.vittorie;
		this.ultimoAccesso = LocalDate.now();
	}
	
	public int getGiocate() { return this.vittorie + this.sconfitte; }

	public String getNickname() { return nickname; }
	public void setNickname(String name) { this.nickname = name; }

	public Pokemon[] getSquadra() { return squadra; }
	public void setSquadra(Pokemon[] squadra) { 	
		Pokemon[] newSquadra = new Pokemon[6];
		int countNull = 0;
		for(int i = 0; i < squadra.length; i++) {
			if(squadra[i] != null) {
				newSquadra[i-countNull] = squadra[i];
			}
		}
		this.squadra = newSquadra;
		this.mainPokemon = this.squadra[0];
	}
	
	public Pokemon getPokemonById(int index) { return squadra[index];}
	
	public Pokemon getMainPokemon() { return mainPokemon; }
	public void setMainPokemon(int index) {
		if (index >= 0 && index <= 5 ) {
			this.mainPokemon = this.squadra[index];
		}
	}
}
