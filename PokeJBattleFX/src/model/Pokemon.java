package model;

import java.util.*;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import model.costanti.Categoria;
import model.costanti.Mossa;
import model.costanti.Statistica;
import model.costanti.Tipo;


/**
 * Questa classe definisce i pokemon e verra utilizzata
 * per tutta l'applicazione
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class Pokemon implements Crescita {	
	
	// ↓ Statistiche di base ↓--------------------------------------------------------------------------------------
	/**
	 * Questa classe innestata serve a creare una statistica alterabile
	 * durante una battaglia fra pokemon
	 * 
	 * @author Simone Comignani, Simone Descontus
	 * @version 1.0
	 */
	private class BaseStat{
		/**
		 * Questo campo serve a specificare la statistica
		 */
		private Statistica stat;
		/**
		 * Questo campo e' il valore originario
		 */
		private int mainVal;
		/**
		 * Questo campo serve a tener conto del valore
		 * corrente durante la battaglia
		 */
		private int battleValue;
		
		/**
		 * Questo campo indica il livello di modifica
		 * che la statistica puo ottenere
		 */
		private int modifyLvl;
		
		/**
		 * Costruttore della classe
		 * 
		 * @param stat Statistica
		 * @param valore int
		 */
		public BaseStat(Statistica stat, int valore) {
			this.stat = stat;
			this.mainVal = valore;
			this.battleValue = this.mainVal;
			
			this.modifyLvl = 0;
		}

		@Override
		public String toString() {
			return "[baseStat=" + mainVal + ", battleValue=" + battleValue + "]";
		}

		
		/**
		 * Questo metodo restituisce il campo stat
		 * 
		 * @return Statistica
		 */
		public Statistica getStat() { return stat; }
		
		/**
		 * Questo metodo restituisce il campo mainVal
		 * 
		 * @return int
		 */
		public int getMainValue() { return mainVal; }
		
		/**
		 * Questo metodo restituisce il campo battleValue
		 * 
		 * @return int
		 */
		public int getBattleValue() { return battleValue; }
		
		/**
		 * Questo metodo restituisce il campo modifyLvl
		 * 
		 * @return int
		 */
		public int getModifyLvl() { return modifyLvl; }

		/**
		 * Questo metodo serve a settare il parametro stat
		 * 
		 * @param stat Statistica
		 * @return void
		 */
		public void setStat(Statistica stat) { this.stat = stat; }
		
		/**
		 * Questo metodo serve a settare il parametro valore
		 * 
		 * @param valore int
		 * @return void
		 */
		public void setMainValue(int valore) { this.mainVal = valore; }
		
		/**
		 * Questo metodo serve a settare il parametro battleValue
		 * 
		 * @param battleValue int
		 * @return void
		 */
		public void setBattleValue(int battleValue) { this.battleValue = battleValue; }
		
		/**
		 * Questo metodo serve a settare il parametro modifyLvl
		 * 
		 * @param modifyLvl int
		 * @return void
		 */
		public void setModifyLvl(int modifyLvl) { this.modifyLvl = modifyLvl; this.battleValue += modifyLvl * (this.mainVal * 11 / 100);}
		
		/**
		 * Questo metodo serve a modificare una statistica in modo
		 * proporzionato
		 * 
		 * @param val int
		 * @return void
		 */
		public void modify(int val) {
			if(modifyLvl <= -6 || modifyLvl >= 6) { return; }
			
			this.battleValue += val * (this.mainVal * 11 / 100);
			this.modifyLvl += val;
		}
		
		/**
		 * Questo metodo resetta la statistica a quella originaria
		 * 
		 * @return void
		 */
		public void resetStat() { setBattleValue(this.mainVal); }
	}
	// ↑ Statistiche di base ↑ --------------------------------------------------------------------------------------	
	
	
	
	// ↓ Attributi POKEMON ↓ ------------------------------------------------------------------------------------------
	
	/**
	 * Questo campo indica il nome del pokemon
	 */
	private String nome;
	/**
	 * Questo campo indica i tipi del pokemon
	 */
	private Tipo[] tipi = new Tipo[2];
	/**
	 * Questo campo indica le mosse utilizzabili dal pokemon
	 */
	private UsableMove[] mosse = new UsableMove[4];
	/**
	 * Questo campo indica tutte le mosse che puo imparare il pokemon
	 */
	private HashMap<Integer, Mossa> parcoMosse = new HashMap<Integer, Mossa>();
	
	/**
	 * Questo campo indica il livello del pokemon
	 */
	private int lvl;
	/**
	 * Questo campo indica quanti punti esperienza ha il pokemon
	 */
	private int currentExp;
	/**
	 * Questo campo indica quanti punti esperienza servono
	 * al pokemon per andare al prossimo livello
	 */
	private int nextLvlExp;
	/**
	 * Questo campo indica quanti livelli servono
	 * al pokemon per evolversi
	 */
	private int evoLvl;
	/**
	 * Questo campo indica in cosa si evolvera il pokemon
	 */
	private Pokemon evo;
	/**
	 * Questo campo indica in che punto della linea evolutiva
	 * del pokemon e'
	 */
	private int evoStage;
	/**
	 * Questo campo indica se il pokemon deve provare ad evolversi o meno
	 */
	private boolean tryToEvolv = false;
	
	/**
	 * Questo campo indica i punti salute del pokemon in battaglia
	 */
	private int battlePs;
	/**
	 * Questo campo indica i punti salute massimi che si possono avere
	 */
	private int maxPs;
	/**
	 * Questo campo indica la Statistica velocita
	 */
	private BaseStat velocita;
	/**
	 * Questo campo indica la Statistica attacco fisico
	 */
	private BaseStat attacco;
	/**
	 * Questo campo indica la Statistica attacco speciale
	 */
	private BaseStat attaccoSP;
	/**
	 * Questo campo indica la Statistica difesa fisica
	 */
	private BaseStat difesa;
	/**
	 * Questo campo indica la Statistica difesa speciale
	 */
	private BaseStat difesaSP;
	/**
	 * Questo campo indica la Statistica precisione
	 */
	private BaseStat precisione;
	/**
	 * Questo campo indica la Statistica elusione
	 */
	private BaseStat elusione;
	// ↑ Attributi POKEMON ↑ ------------------------------------------------------------------------------------------
	
	
	
	// ↓ Costruttore ↓ ------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * Costruttore della classe
	 * 
	 * @param nome String
	 * @param t1 Tipo
	 * @param t2 Tipo
	 * @param mosse Mossa[]
	 * @param parcoMosse HashMap<Integer, Mossa>
	 * @param lvl int
	 * @param evoLvl int
	 * @param evo Pokemon
	 * @param maxPs int
	 * @param velocita int
	 * @param attacco int
	 * @param attaccoSP int
	 * @param difesa int
	 * @param difesaSP int
	 */
	public Pokemon(String nome, Tipo t1, Tipo t2, Mossa[] mosse, HashMap<Integer, Mossa> parcoMosse,
			int lvl, int evoLvl, Pokemon evo, int maxPs, int velocita,
			int attacco, int attaccoSP, int difesa, int difesaSP) {
		
		this.nome = nome;
		
		this.tipi[0] = t1;
		this.tipi[1] = t2;
		
		// potrebbe da errore se spera de no
		for(int i = 0; i<this.mosse.length; i++) {
			if (mosse[i] == null ) continue;
			this.mosse[i] = new UsableMove(mosse[i]);
		}
		this.parcoMosse = parcoMosse;
		
		this.lvl = 0;
		this.currentExp = 0;
		this.nextLvlExp = (int) (4 * Math.pow(this.lvl, 3) / 5);
		
		this.evoLvl = evoLvl;
		this.evoStage = 1;
		this.evo = evo;
		
		this.maxPs = maxPs/3;
		this.battlePs = this.maxPs;
		this.velocita = new BaseStat(Statistica.VELOCITA, velocita/3);
		this.attacco = new BaseStat(Statistica.ATTACCO, attacco/3);
		this.attaccoSP = new BaseStat(Statistica.ATTACCO_SPECIALE, attaccoSP/3);
		this.difesa = new BaseStat(Statistica.DIFESA, difesa/3);
		this.difesaSP = new BaseStat(Statistica.DIFESA_SPECIALE, difesaSP/3);
		
		this.precisione = new BaseStat(Statistica.PRECISIONE, 100);
		this.elusione = new BaseStat(Statistica.ELUSIONE, 100);
		
		this.goToLvl(lvl);
	}
	// ↑ Costruttore ↑ -------------------------------------------------------------------------------------------------------------
	
	
	// ↓ Danni ↓ ------------------------------------------------------------------------------------------
	
	/**
	 * Questo metodo fa subire un danno al pokemon
	 * 
	 * @param danno int
	 * @return void
	 */
	public void incassa(int danno, AtomicBoolean isMiss) {
		Random r = new Random();
		if (this.elusione.getBattleValue() > r.nextInt(100, 180)) {
			isMiss.set(true);
			System.out.println("MISS");
			return; 
		}
		this.setBattlePs(this.getBattlePs() - danno);
	}
	
	/**
	 * Questo metodo serve a gestire l'attacco di un pokemon
	 * 
	 * @param enemy Pokemon
	 * @param mossa Mossa
	 * @param isCrit AtomicBoolean
	 * @param isMiss AtomicBoolean
	 * @return (int) quanto dann fa il colpo
	 */
	public int attacca(Pokemon enemy, Mossa mossa, AtomicBoolean isCrit, AtomicBoolean isMiss) {
		ricerca:
		for(int i = 0; i<this.mosse.length; i++) {
			if(mosse[i] != null && mosse[i].getMossa() == mossa) {
				mosse[i].useMove();
				break ricerca;
			}
			if(i == 3) {
				System.out.println("ERR");
				return 0;
			}
		}
		
		if(mossa.getLvlBoostNerf() != 0) {  //modificato da if(mossa.getCategoria() == Categoria.STATO), di possono essere mosse che infliggono danno E alterano le statistiche
			BaseStat baseOnAction;
			switch (mossa.getStatBoostNerf()) {
				case Statistica.ATTACCO:
					baseOnAction = (mossa.getOnSelf()) ? this.getAttacco() : enemy.getAttacco();
					break;
				case Statistica.ATTACCO_SPECIALE:
					baseOnAction = (mossa.getOnSelf()) ? this.getAttaccoSP() : enemy.getAttaccoSP();
					break;
				case Statistica.DIFESA:
					baseOnAction = (mossa.getOnSelf()) ? this.getDifesa() : enemy.getDifesa();
					break;
				case Statistica.DIFESA_SPECIALE:
					baseOnAction = (mossa.getOnSelf()) ? this.getDifesaSP() : enemy.getDifesaSP();
					break;
				case Statistica.VELOCITA:
					baseOnAction = (mossa.getOnSelf()) ? this.getVelocita() : enemy.getVelocita();
					break;
				case Statistica.PRECISIONE:
					baseOnAction = (mossa.getOnSelf()) ? this.getPrecisione() : enemy.getPrecisione();
					break;
				case Statistica.ELUSIONE:
					baseOnAction = (mossa.getOnSelf()) ? this.getElusione() : enemy.getElusione();
					break;
				default:
					return -1;
			}		
			baseOnAction.modify(mossa.getLvlBoostNerf());
			
		}
		
		if(mossa.getCategoria() == Categoria.SPECIALE){
			return hit(mossa, enemy, this.getAttaccoSP(), enemy.getDifesaSP(), isCrit, isMiss);
		}else if(mossa.getCategoria() == Categoria.FISICO) {
			return hit(mossa, enemy, this.getAttacco(), enemy.getDifesa(), isCrit, isMiss);
		}
		return 0;
	}
	
	
	/**
	 * Questo metodo serve per fare l'algoritmo del danno
	 * 
	 * @param mossa Mossa
	 * @param enemy Pokemon
	 * @param myAtk BaseStat
	 * @param hisDef BaseStat
	 * @param isCrit AtomicBoolean
	 * @param isMiss AtomicBoolean
	 * @return (hit) quanto danno ha fatto il pokemon
	 */
	private int hit(Mossa mossa, Pokemon enemy, BaseStat myAtk, BaseStat hisDef, AtomicBoolean isCrit, AtomicBoolean isMiss) {		
		Random r = new Random();
		
		int accuracy = mossa.getPrecisione() * this.precisione.getBattleValue()/100;

		if (r.nextInt(1, 100) > accuracy) { 
			isMiss.set(true);
			return 0 ;
		}
		
		int crit = r.nextInt(1, 100);
		crit = (crit<=8) ? 2 : 1;
		if(crit == 2) {isCrit.set(true);}
																														
		double random = r.nextDouble(217, 255) / 255;
		double stab = (mossa.getTipo() == this.tipi[0] || mossa.getTipo() == this.tipi[1]) ? 1.5 : 1;	
		
		Tipo tipo1 = enemy.getTipi()[0];
		Tipo tipo2 = enemy.getTipi()[1];
		
		double s1 = mossa.getTipo().calcolaRelazioneTipi(tipo1);
		double s2 = mossa.getTipo().calcolaRelazioneTipi(tipo2);
		double superefficacia = s1 * s2;
		
		return (int) (((((((2 * this.lvl * crit )/ 5) + 2) * mossa.getBasePower() * myAtk.getBattleValue()/hisDef.getBattleValue()))/30 + 2) * stab * random * superefficacia);
	}
	// ↑ Danni ↑ ------------------------------------------------------------------------------------
	
	
	// ↓ lvl-up ↓ ---------------------------------------------------------------------------
	/**
	 * Questo metodo serve a gestire il lvlUp
	 * 
	 * @return void
	 */
	@Override
	public void levelUp() {
		if (this.lvl >= 100) {return;}
		
		this.setLvl(this.getLvl() + 1);
		
		this.setNextLvlExp( (int) (4 * Math.pow(this.getLvl(), 3)/ 5));
		
		int oldMaxPs = this.getMaxPs();
		this.setMaxPs(this.getMaxPs() + calcPs(this.getMaxPs(), 150));
		
		int possibleNewHp = this.getBattlePs() + (this.getMaxPs()*5)/100;
		
		if(possibleNewHp >= this.getMaxPs() || oldMaxPs == this.getBattlePs()) {
			this.setBattlePs(this.getMaxPs());								
		} else {
			this.setBattlePs(possibleNewHp);
		}
		
		
		this.attacco.setMainValue(this.attacco.getMainValue() + calcStat( this.attacco.getMainValue(), 110));
		this.attacco.setBattleValue(this.attacco.getBattleValue() + calcStat( this.attacco.getBattleValue(), 110));	
		
		this.attaccoSP.setMainValue(this.attaccoSP.getMainValue() +calcStat( this.attaccoSP.getMainValue(), 110));
		this.attaccoSP.setBattleValue(this.attaccoSP.getBattleValue() + calcStat( this.attaccoSP.getBattleValue(), 110));	
		
		this.difesa.setMainValue(this.difesa.getMainValue() + calcStat( this.difesa.getMainValue(), 110));
		this.difesa.setBattleValue(this.difesa.getBattleValue() + calcStat( this.difesa.getBattleValue(), 110));	
		
		this.difesaSP.setMainValue(this.difesaSP.getMainValue() +calcStat( this.difesaSP.getMainValue(), 110));
		this.difesaSP.setBattleValue(this.difesaSP.getBattleValue() + calcStat( this.difesaSP.getBattleValue(), 110));
		
		this.velocita.setMainValue(this.velocita.getMainValue() +calcStat( this.velocita.getMainValue(), 110));
		this.velocita.setBattleValue(this.velocita.getBattleValue() + calcStat( this.velocita.getBattleValue(), 110));
		
		if(this.getLvl() >= this.getEvoLvl() && this.evo != null) { tryToEvolv = true;};
	}
	
	/**
	 * Questo metodo serve per calcolare quanto e' aumentata
	 * una statistica quando si aumenta di livello
	 * 
	 * @param stat int
	 * @param percentuale int
	 * @return (int) quanto e' aumentata la statistica
	 */
	private int calcStat(int stat, int percentuale) { return ((stat + this.lvl)/percentuale) + 1; }
	
	/**
	 * Questo metodo serve per calcolare quanto sono aumentati
	 * i punti salute quando si aumenta di livello
	 * 
	 * @param stat int
	 * @param percentuale int
	 * @return (int) quanto sono aumentati i punti salute
	 */
	private int calcPs(int stat, int percentuale) { return ((stat + this.lvl)/percentuale) + 4; }
	
	/**
	 * Questo metodo serve ad andare direttamente da un livello ad un altro
	 * 
	 * @param lvl int
	 * @return void
	 */
	public void goToLvl(int lvl) {
		for(int i = 0; i<lvl; i++) {
			this.levelUp(); 
		}
	}
	
	
	/**
	 * Questo metodo serve per gestire le evoluzioni
	 * 
	 * @return void
	 */
	@Override
	public void evolve() {
		this.nome = evo.nome;
		this.tipi = evo.tipi;
		
		HashMap<Integer, Mossa> nuovoParcoMosse = new HashMap<Integer, Mossa>();
		for(int key: evo.parcoMosse.keySet()) {
			if(key>this.lvl) {
				nuovoParcoMosse.put(key, evo.parcoMosse.get(key));
			}
		}
		this.parcoMosse = nuovoParcoMosse;
		this.evoLvl = evo.evoLvl;
		this.evo = evo.evo;
		
		this.setMaxPs(this.getMaxPs() + calcStat(this.getMaxPs(), 10));
		this.attacco.setMainValue(this.attacco.getMainValue() + calcStat( this.attacco.getMainValue(), 10));
		this.attaccoSP.setMainValue(this.attaccoSP.getMainValue() +calcStat( this.attaccoSP.getMainValue(), 10));	
		this.difesa.setMainValue(this.difesa.getMainValue() + calcStat( this.difesa.getMainValue(), 10));
		this.difesaSP.setMainValue(this.difesaSP.getMainValue() +calcStat( this.difesaSP.getMainValue(), 10));
		this.velocita.setMainValue(this.velocita.getMainValue() +calcStat( this.velocita.getMainValue(), 10));
		
		this.evoStage++;
		
		this.resetStats();
	}
	
	/**
	 * Questo metodo serve per gestire il gainExp
	 * 
	 * @return void
	 */
	@Override
	public void gainExp(Pokemon enemy) {
		this.currentExp += (this.evoStage*64)*enemy.getLvl()/7;
		
		if(this.currentExp >= this.nextLvlExp) {
			this.currentExp -= this.nextLvlExp;
			this.levelUp();
		}
	}	
	// ↑ lvl-up ↑ ------------------------------------------------------------------------------------	
	
	@Override
	public String toString() {
		
		String eName = (this.evo == null)? null:evo.nome;
		
		return "Pokemon [nome=" + nome + ", tipi=" + Arrays.toString(tipi) + ", mosse=" + Arrays.toString(mosse) + ",\n" 
				+ "parcoMosse(Mossa=Lvl):" + parcoMosse + ",\n" 
				+ "lvl=" + lvl + ", currentExp=" + currentExp + ", nextLvlExp=" + nextLvlExp + ", evoLvl=" + evoLvl + ", evo=" + eName + ",\n" 
				+ "battlePs=" + battlePs + ", maxPs=" + maxPs + ",\n" + "velocita=" + velocita + ", attacco=" + attacco + ", attaccoSP=" + attaccoSP + ", difesa=" + difesa + ", difesaSP=" + difesaSP + "]" 
				+  ",\n" + "precisione=" + precisione + ", elusione=" + elusione;
	}
	
	/**
	 * Questo metodo restituisce una stringa contenente tutte le informazioni del pokemon in battaglia
	 * 
	 * @return String
	 */
	public String battleData() {
		
		return "Pokemon [nome=" + nome + ", tipi=" + Arrays.toString(tipi) + ", mosse=" + Arrays.toString(mosse) + ",\n" 
				+ "lvl=" + lvl + ", currentExp=" + currentExp + ", nextLvlExp=" + nextLvlExp
				+ "\nbattlePs=" + battlePs + ", maxPs=" + maxPs + ",\n" + "velocita=" + velocita + ", attacco=" + attacco + ", attaccoSP=" + attaccoSP + ", difesa=" + difesa + ", difesaSP=" + difesaSP + "]" 
				+  ",\n" + "precisione=" + precisione + ", elusione=" + elusione;
	}
	
	
	// ↓ Setters and Getters ↓ ------------------------------------------------------------------------------
	
	/**
	 * Questo metodo restituisce il campo tipi
	 * 
	 * @return Tipo[]
	 */
	public Tipo[] getTipi() { return tipi; }
	/**
	 * Questo metodo restituisce il campo nome
	 * 
	 * @return String
	 */
	public String getNome() { return nome; }
	/**
	 * Questo metodo restituisce il campo mosse
	 * 
	 * @return UsableMove[]
	 */
	public UsableMove[] getMosse() { return mosse; }
	/**
	 * Questo metodo restituisce il campo parcoMosse
	 * 
	 * @return HashMap<Integer, Mossa>
	 */
	public HashMap<Integer, Mossa> getParcoMosse() { return parcoMosse; }
	/**
	 * Questo metodo restituisce il campo lvl
	 * 
	 * @return int
	 */
	public int getLvl() { return lvl; }
	/**
	 * Questo metodo restituisce il campo currentExp
	 * 
	 * @return int
	 */
	public int getCurrentExp() { return currentExp; }
	/**
	 * Questo metodo restituisce il campo nextLvlExp
	 * 
	 * @return int
	 */
	public int getNextLvlExp() { return nextLvlExp; }
	/**
	 * Questo metodo restituisce il campo evoLvl
	 * 
	 * @return int
	 */
	public int getEvoLvl() { return evoLvl; }
	/**
	 * Questo metodo restituisce il campo evo
	 * 
	 * @return Pokemon
	 */
	public Pokemon getEvo() { return evo; }
	/**
	 * Questo metodo restituisce il campo tryToEvolv
	 * 
	 * @return boolean
	 */
	public boolean isTryToEvolv() {return tryToEvolv;}
	/**
	 * Questo metodo restituisce il campo battlePs
	 * 
	 * @return int
	 */
	public int getBattlePs() { return battlePs; }
	/**
	 * Questo metodo restituisce il campo maxPs
	 * 
	 * @return int
	 */
	public int getMaxPs() { return maxPs; }
	/**
	 * Questo metodo restituisce il campo velocita
	 * 
	 * @return BaseStat
	 */
	public BaseStat getVelocita() { return velocita; }
	/**
	 * Questo metodo restituisce il campo attacco
	 * 
	 * @return BaseStat
	 */
	public BaseStat getAttacco() { return attacco; }
	/**
	 * Questo metodo restituisce il campo attaccoSP
	 * 
	 * @return BaseStat
	 */
	public BaseStat getAttaccoSP() { return attaccoSP; }
	/**
	 * Questo metodo restituisce il campo difesa
	 * 
	 * @return BaseStat
	 */
	public BaseStat getDifesa() { return difesa; }
	/**
	 * Questo metodo restituisce il campo difesaSP
	 * 
	 * @return BaseStat
	 */
	public BaseStat getDifesaSP() { return difesaSP; }
	/**
	 * Questo metodo restituisce il campo precisione
	 * 
	 * @return BaseStat
	 */
	public BaseStat getPrecisione() { return precisione; }
	/**
	 * Questo metodo restituisce il campo elusione
	 * 
	 * @return BaseStat
	 */
	public BaseStat getElusione() { return elusione; }
	
	/**
	 * Questo metodo restituisce il move set del pokemon
	 * 
	 * @return Mossa[]
	 */
	public Mossa[] getMoveSet() {
		Mossa[] ms = new Mossa[4];
		for(int i = 0; i < this.mosse.length; i++) {
			ms[i] = (mosse[i] == null) ? null : mosse[i].getMossa();
		}
		return ms;
	}
	
	/**
	 * Questo metodo restituisce una stringa con tutte le mosse
	 * 
	 * @return String
	 */
	public String moveSetToString() {
		String ms = "[";
		for(int i = 0; i < this.mosse.length; i++) {
			ms += (mosse[i] == null) ? "" : mosse[i].getMossa().getNome() + "[" + (i+1) +"], ";
		}
		ms += "]";
		return ms;
	}
	
	
	/**
	 * Questo metodo setta il campo mosse con un array di mosse
	 * 
	 * @param mosse Mossa[]
	 * @return void
	 */
	public void setMoveSet(Mossa[] mosse) {
		this.setMosse(new UsableMove[] {new UsableMove(mosse[0]), new UsableMove(mosse[1]), new UsableMove(mosse[2]), new UsableMove(mosse[3])});
	}
	
	/**
	 * Questo metodo setta il campo tipi
	 * 
	 * @param tipi Tipo[]
	 * @return void
	 */
	public void setTipi(Tipo[] tipi) { this.tipi = tipi; }
	/**
	 * Questo metodo setta il campo nome
	 * 
	 * @param nome String
	 * @return void
	 */
	public void setNome(String nome) { this.nome = nome; }
	/**
	 * Questo metodo setta il campo mosse
	 * 
	 * @param mosse UsableMove[]
	 * @return void
	 */
	public void setMosse(UsableMove[] mosse) { this.mosse = mosse; }
	/**
	 * Questo metodo setta il campo parcoMosse
	 * 
	 * @param parcoMosse HashMap<Integer, Mossa>
	 * @return void
	 */
	public void setParcoMosse(HashMap<Integer, Mossa> parcoMosse) { this.parcoMosse = parcoMosse; }
	/**
	 * Questo metodo setta il campo lvl
	 * 
	 * @param lvl int
	 * @return void
	 */
	public void setLvl(int lvl) { this.lvl = lvl; }
	/**
	 * Questo metodo setta il campo currentExp
	 * 
	 * @param currentExp int
	 * @return void
	 */
	public void setCurrentExp(int currentExp) { this.currentExp = currentExp; }
	/**
	 * Questo metodo setta il campo nextLvlExp
	 * 
	 * @param nextLvlExp int
	 * @return void
	 */
	public void setNextLvlExp(int nextLvlExp) { this.nextLvlExp = nextLvlExp; }
	/**
	 * Questo metodo setta il campo evoLvl
	 * 
	 * @param evoLvl int
	 * @return void
	 */
	public void setEvoLvl(int evoLvl) { this.evoLvl = evoLvl; }
	/**
	 * Questo metodo setta il campo evo
	 * 
	 * @param evo Pokemon
	 * @return void
	 */
	public void setEvo(Pokemon evo) { this.evo = evo; }
	/**
	 * Questo metodo setta il campo tryToEvolv
	 * 
	 * @param tryToEvolv boolean
	 * @return void
	 */
	public void setTryToEvolv(boolean tryToEvolv) {this.tryToEvolv = tryToEvolv;}
	/**
	 * Questo metodo setta il campo battlePs
	 * 
	 * @param battlePs int
	 * @return void
	 */
	public void setBattlePs(int battlePs) { this.battlePs = battlePs; }
	/**
	 * Questo metodo setta il campo maxPs
	 * 
	 * @param maxPs int
	 * @return void
	 */
	public void setMaxPs(int maxPs) { this.maxPs = maxPs; }
	/**
	 * Questo metodo setta il campo velocita
	 * 
	 * @param velocita BaseStat
	 * @return void
	 */
	public void setVelocita(BaseStat velocita) { this.velocita = velocita; }
	/**
	 * Questo metodo setta il campo attacco
	 * 
	 * @param attacco BaseStat
	 * @return void
	 */
	public void setAttacco(BaseStat attacco) { this.attacco = attacco; }
	/**
	 * Questo metodo setta il campo attaccoSP
	 * 
	 * @param attaccoSP BaseStat
	 * @return void
	 */
	public void setAttaccoSP(BaseStat attaccoSP) { this.attaccoSP = attaccoSP; }
	/**
	 * Questo metodo setta il campo difesa
	 * 
	 * @param difesa BaseStat
	 * @return void
	 */
	public void setDifesa(BaseStat difesa) { this.difesa = difesa; }
	/**
	 * Questo metodo setta il campo difesaSP
	 * 
	 * @param difesaSP BaseStat
	 * @return void
	 */
	public void setDifesaSP(BaseStat difesaSP) { this.difesaSP = difesaSP; }
	/**
	 * Questo metodo setta il campo precisione
	 * 
	 * @param precisione BaseStat
	 * @return void
	 */
	public void setPrecisione(BaseStat precisione) { this.precisione = precisione; }
	/**
	 * Questo metodo setta il campo elusione
	 * 
	 * @param elusione BaseStat
	 * @return void
	 */
	public void setElusione(BaseStat elusione) { this.elusione = elusione; }
	
	
	/**
	 * Questo metodo resetta tutte le statistiche a quelle base
	 * 
	 * @return void
	 */
	public void resetStats() {
		this.battlePs = this.maxPs;
		this.attacco.resetStat();
		this.attaccoSP.resetStat();
		this.difesa.resetStat();
		this.difesaSP.resetStat();
		this.velocita.resetStat();
		this.precisione.resetStat();
		this.elusione.resetStat();
		
		for(UsableMove m:this.getMosse()) {
			if(m != null) m.setPp(m.getPpMax());
		}
	}
	
	// Setter e Getter utili per debug
	
	/**
	 * Questo metodo applica del boost o nerf
	 * alle statistiche in mariera artificiale
	 * 
	 * @param modifyLvl int
	 * @param b Statistica
	 * @return void
	 */
	public void setStatModifier(int modifyLvl, Statistica b) {
		switch(b) {
		case Statistica.ATTACCO:
			this.attacco.setModifyLvl(modifyLvl);
			break;
		case Statistica.ATTACCO_SPECIALE:
			this.attaccoSP.setModifyLvl(modifyLvl);
			break;
		case Statistica.DIFESA:
			this.difesa.setModifyLvl(modifyLvl);
			break;
		case Statistica.DIFESA_SPECIALE:
			this.difesaSP.setModifyLvl(modifyLvl);
			break;
		case Statistica.VELOCITA:
			this.velocita.setModifyLvl(modifyLvl);
			break;
		case Statistica.PRECISIONE:
			this.precisione.setModifyLvl(modifyLvl);
			break;
		case Statistica.ELUSIONE:
			this.elusione.setModifyLvl(modifyLvl);
			break;
		default:
			System.out.println("ERR");
		}
		
	}
	
	/**
	 * Questo metodo restituisce il valore della statistica
	 * specificata in battaglia
	 * 
	 * @param s Statistica
	 * @return int
	 */
	public int getModifyLvlFromStat(Statistica s) {
		int out = -1;
		switch(s) {
		case Statistica.ATTACCO:
			out = this.getAttacco().getModifyLvl();
			break;
		case Statistica.ATTACCO_SPECIALE:
			out = this.getAttaccoSP().getModifyLvl();
			break;
		case Statistica.DIFESA:
			out = this.getDifesa().getModifyLvl();
			break;
		case Statistica.DIFESA_SPECIALE:
			out = this.getDifesaSP().getModifyLvl();
			break;
		case Statistica.VELOCITA:
			out = this.getVelocita().getModifyLvl();
			break;
		case Statistica.PRECISIONE:
			out = this.getPrecisione().getModifyLvl();
			break;
		case Statistica.ELUSIONE:
			out = this.getElusione().getModifyLvl();
			break;
		default:
			System.out.println("ERR");
		}
		return out;
	}
	
	/**
	 * Questo metodo restituisce il campo velocita
	 * 
	 * @return int
	 */
	public int getVelocitaBattaglia() { return velocita.getBattleValue(); }
	/**
	 * Questo metodo restituisce il campo attacco
	 * 
	 * @return int
	 */
	public int getAttaccoBattaglia() { return attacco.getBattleValue(); }
	/**
	 * Questo metodo restituisce il campo attaccoSP
	 * 
	 * @return int
	 */
	public int getAttaccoSPBattaglia() { return attaccoSP.getBattleValue(); }
	/**
	 * Questo metodo restituisce il campo difesa
	 * 
	 * @return int
	 */
	public int getDifesaBattaglia() { return difesa.getBattleValue(); }
	/**
	 * Questo metodo restituisce il campo difesaSP
	 * 
	 * @return int
	 */
	public int getDifesaSPBattaglia() { return difesaSP.getBattleValue(); }
	/**
	 * Questo metodo restituisce il campo precisione
	 * 
	 * @return int
	 */
	public int getPrecisioneBattaglia() { return precisione.getBattleValue(); }
	/**
	 * Questo metodo restituisce il campo elusione
	 * 
	 * @return int
	 */
	public int getElusioneBattaglia() { return elusione.getBattleValue(); }
	
	
	/**
	 * Questo metodo setta il campo velocita
	 * 
	 * @param velocita int
	 * @return void
	 */
	public void setVelocitaBattaglia(int velocita) { this.velocita.setBattleValue(velocita); }
	/**
	 * Questo metodo setta il campo attacco
	 * 
	 * @param attacco int
	 * @return void
	 */
	public void setAttaccoBattaglia(int attacco) { this.attacco.setBattleValue(attacco); }
	/**
	 * Questo metodo setta il campo attaccoSP
	 * 
	 * @param attaccoSP int
	 * @return void
	 */
	public void setAttaccoSPBattaglia(int attaccoSP) { this.attaccoSP.setBattleValue(attaccoSP); }
	/**
	 * Questo metodo setta il campo difesa
	 * 
	 * @param difesa int
	 * @return void
	 */
	public void setDifesaBattaglia(int difesa) { this.difesa.setBattleValue(difesa); }
	/**
	 * Questo metodo setta il campo difesaSP
	 * 
	 * @param difesaSP int
	 * @return void
	 */
	public void setDifesaSPBattaglia(int difesaSP) { this.difesaSP.setBattleValue(difesaSP); }
	/**
	 * Questo metodo setta il campo precisione
	 * 
	 * @param precisione int
	 * @return void
	 */
	public void setPrecisioneBattaglia(int precisione) { this.precisione.setBattleValue(precisione); }
	/**
	 * Questo metodo setta il campo elusione
	 * 
	 * @param elusione int
	 * @return void
	 */
	public void setElusioneBattaglia(int elusione) { this.elusione.setBattleValue(elusione); }
}
