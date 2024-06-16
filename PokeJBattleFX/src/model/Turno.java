package model;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import model.costanti.Mossa;

public class Turno implements Runnable {
	Allenatore allenatore;
	Allenatore sfidante;
	private Mossa m1;
	private Mossa m2;
	AtomicInteger countAllenatore;
	AtomicInteger countSfidante;
	
	private String log;
	
	public Turno(Allenatore allenatore, Allenatore sfidante, AtomicInteger countAllenatore, AtomicInteger countSfidante) {		
		this.allenatore = allenatore;
		this.sfidante = sfidante;
		this.m1 = this.scelta(allenatore);
		this.m2 = this.scelta(sfidante);
		this.countAllenatore = countAllenatore;
		this.countSfidante = countSfidante;
		this.log = "";
	}
	
	@Override
	public void run() {
		this.log += "\n-----\nInizio turno: [" + this.allenatore.getNickname() + ":" + this.countAllenatore + ", " + this.sfidante.getNickname() + ":" + this.countSfidante + "]";

		int danno = 0;
		
		if(this.m1 == Mossa.RESA) {
			this.countAllenatore.set(0);
			this.log += "\nRESA di " + this.allenatore.getNickname();
			return;
		}
		if(this.m2 == Mossa.RESA) {
			this.countSfidante.set(0);
			this.log += "\nRESA di " + this.sfidante.getNickname();
			return;
		}
		
		if(this.m1 == Mossa.CAMBIA && this.m2 != Mossa.CAMBIA) {
			this.cambia(this.allenatore);
			scontro(this.sfidante, this.allenatore, m2);
			
			if(this.allenatore.getMainPokemon().getBattlePs() < 0) {
				this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
				esausto(this.allenatore, this.countAllenatore);
			}
			
		} else if(this.m1 != Mossa.CAMBIA && this.m2 == Mossa.CAMBIA) {
			this.cambia(this.sfidante);
			scontro(this.allenatore, this.sfidante, this.m1);
			
			if(this.sfidante.getMainPokemon().getBattlePs() < 0) {
				this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
				esausto(this.sfidante, this.countSfidante);
			}
			
		}  else if(this.m1 == Mossa.CAMBIA && this.m2 == Mossa.CAMBIA) {
			this.cambia(this.sfidante);
			this.cambia(this.allenatore);	
			
		} else {
			if(this.allenatore.getMainPokemon().getVelocitaBattaglia() >= this.sfidante.getMainPokemon().getVelocitaBattaglia()) {
				scontro(this.allenatore, this.sfidante, this.m1);
				
				if(this.sfidante.getMainPokemon().getBattlePs() > 0) {
					scontro(this.sfidante, this.allenatore, this.m2);
					
					if(this.allenatore.getMainPokemon().getBattlePs() <= 0) {
						this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
						esausto(this.allenatore, this.countAllenatore);
					}
				} else {
					this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
					esausto(this.sfidante, this.countSfidante);
				}
				
			} else {
				scontro(this.sfidante, this.allenatore, this.m2);
				
				if(this.allenatore.getMainPokemon().getBattlePs() > 0) {
					scontro(this.allenatore, this.sfidante, this.m1);
					
					if(this.sfidante.getMainPokemon().getBattlePs() <= 0) {
						this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
						esausto(this.sfidante, this.countSfidante);
					}
				} else {
					this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
					esausto(this.allenatore, this.countAllenatore);
				}
			}
		}
		System.out.println(this.allenatore.getMainPokemon().battleData() + "\n\n" + this.sfidante.getMainPokemon().battleData());
		
		this.log += "\nFine turno: [" + this.allenatore.getNickname() + ":" + this.countAllenatore + ", " + this.sfidante.getNickname() + ":" + this.countSfidante + "]\n-----\n";
		return;
	}
	
	private void scontro(Allenatore attaccante, Allenatore ricevente, Mossa attacco) {
		int danno = attaccante.getMainPokemon().attacca(ricevente.getMainPokemon(), attacco);
		ricevente.getMainPokemon().incassa(danno);
		System.out.println("\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + ricevente.getMainPokemon().getNome() + " subisce " + danno + " danni!\n");
		this.log += "\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + ricevente.getMainPokemon().getNome() + " subisce " + danno + " danni!";
	}
	
	private Mossa scelta(Allenatore trainer) {
		Mossa[] ms = trainer.getMainPokemon().getMoveSet();
		Mossa atk;
		
		System.out.println("\nScegliere la mossa che " + trainer.getMainPokemon().getNome() + " dovrebbe usare " + trainer.getMainPokemon().moveSetToString() +". r=resa, c=cambio");
		Scanner s = new Scanner(System.in);
		String scelta = s.nextLine();
		switch(scelta) {
			case "r":
				atk = Mossa.RESA;
				break;
			case "c":
				atk = Mossa.CAMBIA;
				break;
			case "1":
				atk = ms[0];
				break;
			case "2":
				atk = ms[1];
				break;
			case "3":
				atk = ms[2];
				break;
			case "4":
				atk = ms[3];
				break;
			default:
				atk = ms[0];
		}
		return atk;
	}
	
	
	private void cambia(Allenatore trainer) {
		Pokemon p = trainer.getMainPokemon();
		boolean esatuso = false;
		String scelta = "";
		
		do{
		System.out.println("Scegliere il pokemon con il quale si desidera sostituire " + trainer.getMainPokemon().getNome() + ". " + trainer.squadraToString());
		Scanner s = new Scanner(System.in);
		scelta = s.nextLine();
		
			if(Integer.parseInt(scelta) >= 0 && Integer.parseInt(scelta) <= 5) {
				if(trainer.getPokemonById(Integer.parseInt(scelta)) == null) {
					System.out.println("lo slot selezionato e' vuoto");
					esatuso = true;
				} else if(trainer.getPokemonById(Integer.parseInt(scelta)).getBattlePs() <= 0) {
					System.out.println("il pkmn selezionato e' esausto");
					esatuso = true;
				} else {
					esatuso = false;
				}
			} else {
				System.out.println("lo slot non è disponibile");
				esatuso = true;
			}
		} while(esatuso);
							
		switch(scelta) {
		case "0":
			trainer.setMainPokemon(0);
			break;
		case "1":
			trainer.setMainPokemon(1);
			break;
		case "2":
			trainer.setMainPokemon(2);
			break;
		case "3":
			trainer.setMainPokemon(3);
			break;
		case "4":
			trainer.setMainPokemon(4);
			break;
		case "5":
			trainer.setMainPokemon(5);
			break;
		default:
			System.out.println("cambio non avvenuto");
			return;
		}	
		System.out.println("\nRientra " + p.getNome() + ", vai " + trainer.getMainPokemon().getNome() +"!\n");
		
		this.log += "\n" + trainer.getNickname() + " sostituisce " + p.getNome() + " con " + trainer.getMainPokemon().getNome();
	}
	
	private void esausto(Allenatore trainer, AtomicInteger count) {
		System.out.println("\n" + trainer.getMainPokemon().getNome() + " e' esausto");
		count.set(count.get()-1);
		if(count.get() <= 0) {return;}
		this.log += "\n" + trainer.getMainPokemon().getNome() + " di " + trainer.getNickname() + " e' esausto!";
		this.cambia(trainer);
	}
	
	public String getLog() { return this.log;}

	public Allenatore getAllenatore() { return allenatore; }
	public void setAllenatore(Allenatore allenatore) { this.allenatore = allenatore; }

	public Allenatore getSfidante() { return sfidante; }
	public void setSfidante(Allenatore sfidante) { this.sfidante = sfidante; }

	public Mossa getM1() { return m1; }
	public void setM1(Mossa m1) { this.m1 = m1; }

	public Mossa getM2() { return m2; }
	public void setM2(Mossa m2) { this.m2 = m2; }

	public AtomicInteger getCountAllenatore() { return countAllenatore; }
	public void setCountAllenatore(AtomicInteger countAllenatore) { 	this.countAllenatore = countAllenatore; }

	public AtomicInteger getCountSfidante() { return countSfidante; }
	public void setCountSfidante(AtomicInteger countSfidante) { this.countSfidante = countSfidante; }
}
