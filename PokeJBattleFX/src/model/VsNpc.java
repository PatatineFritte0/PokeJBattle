package model;

public class VsNpc extends BestOfThree{
	
	public VsNpc(Allenatore allenatore) {
		super(allenatore, new Franco(allenatore));
	}

	public void run()
	{
		Allenatore winner;
		
		System.out.println("Squadra di franco:" + this.sfidante.squadraToString() + " " + this.sfidante.getMainPokemon().getLvl());
		
		winner = match(this.allenatore, this.sfidante);
		assegnaPunti(winner);

			
		if(winAllenatore > winSfidante) {
			this.allenatore.setVittorie(this.allenatore.getVittorie() + 1);
			this.sfidante.setSconfitte(this.sfidante.getSconfitte() + 1);
		}
		
		SaveManager.save(allenatore);	
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
		}
		
		return winner;
	}
	
}
