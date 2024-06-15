package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import model.costanti.*;

public class Partita implements Runnable {
	private Allenatore allenatore;
	private AtomicInteger nPkmnAllenatore = new AtomicInteger();
	private Allenatore sfidante;
	private AtomicInteger nPkmnSfidante = new AtomicInteger();;
	
	private ArrayList<String> log = new ArrayList<>();
	
	public Partita(Allenatore allenatore, Allenatore sfidante) {
		this.allenatore = allenatore;
		this.nPkmnAllenatore.set(contaPkmn(allenatore));
		this.sfidante = sfidante;
		this.nPkmnSfidante.set(contaPkmn(sfidante));
	}
	
	@Override
	public void run() {
			Turno t = new Turno(allenatore, sfidante, nPkmnAllenatore, nPkmnSfidante);
			t.run();
			log.add(t.getLog());
	}
	
	public ArrayList<String> getLog() { return log; }

	private int contaPkmn(Allenatore t) {
		int pkmn = 0;
		
		Pokemon[] squadraAll = t.getSquadra();
		for(Pokemon poke: squadraAll) {
			pkmn += (poke != null) ? 1 : 0;
		}
		return pkmn;
	}
	
	public Allenatore checkVincitore() {
		if(this.nPkmnAllenatore.get() <= 0) {return this.sfidante;}
		if(this.nPkmnSfidante.get()  <= 0) {return this.allenatore;}
		return null;
	}
	
}
