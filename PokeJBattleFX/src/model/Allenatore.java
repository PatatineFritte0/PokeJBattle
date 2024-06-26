package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;


/**
 * Classe che definisce cosa deve avere un allenatore,
 * essa verra usata come classe da salvare su file.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class Allenatore {
	/**
	 * Questo campo indica in nickname dell'allenatore
	 */
	private String nickname;
	/**
	 * Questo campo indica la squadra dell'allenatore
	 */
	private Pokemon[] squadra = new Pokemon[6];
	/**
	 * Questo campo indica il pokemon in uso dall'allenatore
	 */
	private Pokemon mainPokemon;
	/**
	 * Questo campo indica quanti pokemon ha nella squadra dell'allenatore
	 */
	private int nPokemon;
	/**
	 * Questo campo indica il numero di vittorie dell'allenatore
	 */
	private int vittorie;
	/**
	 * Questo campo indica il numero di sconfitte dell'allenatore
	 */
	private int sconfitte;
	/**
	 * Questo campo indica la differenza tra vittorie e sconfitte dell'allenatore
	 */
	private double winRadio;
	/**
	 * Questo campo indica l'ultimo accesso dell'allenatore
	 */
	private String ultimoAccesso;
	
	/**
	 * Costruttore della classe Allenatore
	 * 
	 * @param nickname String
	 * @param pokemon Pokemon[]
	 * @param vittorie int
	 * @param sconfitte int
	 */
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
	
	/**
	 * Overload del costruttore della classe Allenatore
	 * @param nickname
	 * @param pokemon
	 */
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
	
	/**
	 * Questo metodo restituisce il numero di partite giocate in totale
	 * 
	 * @return int
	 */
	public int getGiocate() { return this.vittorie + this.sconfitte; }
	
	/**
	 * Questo metodo restituisce il campo nickname
	 * 
	 * @return String
	 */
	public String getNickname() { return nickname; }
	
	/**
	 * Questo metodo setta il valore nickname
	 * 
	 * @param name String
	 * @return void
	 */
	public void setNickname(String name) { this.nickname = name; }

	/**
	 * Questo metodo restituisce il campo squadra
	 * 
	 * @return Pokemon[]
	 */
	public Pokemon[] getSquadra() { return squadra; }
	
	/**
	 * Questo metodo restituisce il campo squadra
	 * 
	 * @param squadra Pokemon[]
	 * @return void
	 */
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
	
	/**
	 * Questo metodo restituisce una stringa con all interno
	 * tutti i pokemon
	 * 
	 * @return String
	 */
	public String squadraToString() {
		String ms = "[";
		for(int i = 0; i < this.squadra.length; i++) {
			ms += (this.squadra[i] == null) ? "" : this.squadra[i].getNome() + "[" + (i) +"], ";
		}
		ms += "]";
		return ms;
	}
	
	/**
	 * Questo metodo restituisce il pokemon presente nell index
	 * 
	 * @param index int
	 * @return Pokemon
	 */
	public Pokemon getPokemonById(int index) { return squadra[index];}
	
	
	/**
	 * Questo metodo restituisce l'index della squadra dove all interno c'e' il pokemon
	 * 
	 * @param pkmn Pokemon
	 * @return int
	 */
	public int getPokemonId(Pokemon pkmn) {
		
		int id = -1;
		
		for(int i = 0; i < this.squadra.length; i++) {
			if(this.squadra[i]==pkmn) id = i;
		}
		
		return id;
	}
	
	/**
	 * Questo metodo restituisce il campo mainPokemon
	 * 
	 * @return Pokemon
	 */
	public Pokemon getMainPokemon() { return mainPokemon; }
	
	/**
	 * Questo metodo setta il valore mainPokemon attraverso l'index
	 * 
	 * @param index int
	 * @return void
	 */
	public void setMainPokemon(int index) {
		if (index >= 0 && index <= 5 ) {
			this.mainPokemon = this.squadra[index];
		}
	}

	/**
	 * Questo metodo restituisce il valore del campo vittorie
	 * 
	 * @return int
	 */
	public int getVittorie() { return vittorie; }
	
	/**
	 * Questo metodo setta il valore di vittorie
	 * 
	 * @param vittorie int
	 * @return void
	 */
	public void setVittorie(int vittorie) { this.vittorie = vittorie; }
	
	/**
	 * Questo metodo restituisce il valore del campo sconfitte
	 * 
	 * @return int
	 */
	public int getSconfitte() { return sconfitte; }
	
	/**
	 * Questo metodo setta il valore di sconfitte
	 * 
	 * @param sconfitte int
	 * @return void
	 */
	public void setSconfitte(int sconfitte) { this.sconfitte = sconfitte; }
	
	@Override
	public String toString() {
		return "Allenatore [nickname=" + nickname + ", nPokemon=" + nPokemon + ", vittorie=" + vittorie + ", sconfitte="
				+ sconfitte + ", winRadio=" + winRadio + ", ultimoAccesso=" + ultimoAccesso + "]";
	}
}

