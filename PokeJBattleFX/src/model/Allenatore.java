package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Allenatore {
	@Override
	public String toString() {
		return "Allenatore [nickname=" + nickname + ", nPokemon=" + nPokemon + ", vittorie=" + vittorie + ", sconfitte="
				+ sconfitte + ", winRadio=" + winRadio + ", ultimoAccesso=" + ultimoAccesso + "]";
	}
	private String nickname;
	private Pokemon[] squadra = new Pokemon[6];
	private Pokemon mainPokemon;
	private int nPokemon;
	private int vittorie;
	private int sconfitte;
	private double winRadio;
	private String ultimoAccesso;
	
	public Allenatore(String nickname, Pokemon[] pokemon, int vittorie, int sconfitte) {
		this.nickname = nickname;
		
		// nel caso [x,x,null,null,x,null] otterremmo [x,x,x,null,null,null]
		int countNull = 0;
		for(int i = 0; i < pokemon.length; i++) {
			if(pokemon[i] != null) {
				this.squadra[i-countNull] = pokemon[i];
			}else {
				countNull++;
			}
		}

		this.nPokemon = 0;
		for(Pokemon poke: squadra) {
			if(poke != null) this.nPokemon += 1;
		}
		
		this.setMainPokemon(0);
		
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.winRadio = (sconfitte != 0) ? this.vittorie/this.sconfitte : this.vittorie;
		 this.ultimoAccesso = LocalDateTime.now().toString().replace("T", "/").substring(0, 21);
	}
	
	public Allenatore(String nickname, Pokemon[] pokemon) {
		this.nickname = nickname;
		
		// nel caso [x,x,null,null,x,null] otterremmo [x,x,x,null,null,null]
		int countNull = 0;
		for(int i = 0; i < pokemon.length; i++) {
			if(pokemon[i] != null) {
				this.squadra[i-countNull] = pokemon[i];
			}else {
				countNull++;
			}
		}
			
		this.nPokemon = 0;
		for(Pokemon poke: squadra) {
			if(poke != null) this.nPokemon += 1;
		}
		
		this.setMainPokemon(0);
		
		this.vittorie = 0;
		this.sconfitte = 0;
		this.winRadio = (sconfitte != 0) ? this.vittorie/this.sconfitte : this.vittorie;
		 this.ultimoAccesso = LocalDateTime.now().toString().replace("T", "/").substring(0, 19);
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
	
	public String squadraToString() {
		String ms = "[";
		for(int i = 0; i < this.squadra.length; i++) {
			ms += (this.squadra[i] == null) ? "" : this.squadra[i].getNome() + "[" + (i) +"], ";
		}
		ms += "]";
		return ms;
	}
	
	public Pokemon getPokemonById(int index) { return squadra[index];}
	
	public int getPokemonId(Pokemon pkmn) {
		
		int id = -1;
		
		for(int i = 0; i < this.squadra.length; i++) {
			if(this.squadra[i]==pkmn) id = i;
		}
		
		return id;
	}
	
	public Pokemon getMainPokemon() { return mainPokemon; }
	public void setMainPokemon(int index) {
		if (index >= 0 && index <= 5 ) {
			this.mainPokemon = this.squadra[index];
		}
	}

	public int getVittorie() { return vittorie; }
	public void setVittorie(int vittorie) { this.vittorie = vittorie; }

	public int getSconfitte() { return sconfitte; }
	public void setSconfitte(int sconfitte) { this.sconfitte = sconfitte; }
}
