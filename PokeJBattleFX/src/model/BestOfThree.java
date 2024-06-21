package model;

public class BestOfThree implements Runnable {
	protected Allenatore allenatore;
	protected Allenatore sfidante;
	protected int winAllenatore;
	protected int winSfidante;
	
	public BestOfThree(Allenatore allenatore, Allenatore sfidante) {
		this.allenatore = allenatore;
		this.sfidante = sfidante;
		this.winAllenatore = 0;
		this.winSfidante = 0;
	}
	
	public void run()
	{
		Allenatore winner;
		
		bo3:
		for(int i = 0; i < 3; i++) {
			winner = match(this.allenatore, this.sfidante);
			assegnaPunti(winner);
			
			System.out.println("\nPUNTEGGI -> " + this.allenatore.getNickname() + ":" + this.winAllenatore + "; " + this.sfidante.getNickname() + ":" + this.winSfidante + "\n");
			if(winAllenatore > 1 || winSfidante > 1) {break bo3;}
		}
			
		if(winAllenatore > winSfidante) {
			this.allenatore.setVittorie(this.allenatore.getVittorie() + 1);
			this.sfidante.setSconfitte(this.sfidante.getSconfitte() + 1);
		} else {
			this.sfidante.setVittorie(this.sfidante.getVittorie() + 1);
			this.allenatore.setSconfitte(this.allenatore.getSconfitte() + 1);
		}
		
		SaveManager.save(allenatore);
		SaveManager.save(sfidante);
		
	}
	
	protected Allenatore match(Allenatore a1, Allenatore a2) {
		Partita p = new Partita(a1,a2);
		
		boolean fin = true;
		Allenatore winner;
		
		do {
			p.run();
			winner = p.checkVincitore();
			fin = (winner != null)? false : true;
			//System.out.println(p.getLog());
		} while (fin);
		
		System.out.println("\nIl vincitore è " + winner.getNickname() + "\n");
		
		for(int i = 0; i<6; i++) {
			Pokemon pkmn = a1.getPokemonById(i);
			if(pkmn != null) {
				pkmn.resetStats();
				pkmn.evolve();				
			}
			pkmn = a2.getPokemonById(i);
			if(pkmn != null) {
				pkmn.resetStats();
				pkmn.evolve();				
			}
		}
		
		return winner;
	}
	
	protected void assegnaPunti(Allenatore w) {
		if(w.getNickname() == this.allenatore.getNickname()) {
			this.winAllenatore += 1;
		}
		else if(w.getNickname() == this.sfidante.getNickname()) {
			this.winSfidante += 1;
		}
	}
}
