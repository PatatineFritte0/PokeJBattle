package model;

import java.util.*;
import java.util.HashMap;
import java.util.Random;

import model.costanti.Categoria;
import model.costanti.Mossa;
import model.costanti.Statistica;
import model.costanti.Tipo;

public class Pokemon implements Crescita {
	
	// ↓ Mossa utilizzabile ↓ ------------------------------------------------------------
	private class UsableMove {
		private Mossa mossa;
		private static int ppMax;
		private int pp;
		
		public UsableMove(Mossa m) {
			this.mossa = m;
			this.ppMax = m.getPP();
			this.pp = this.ppMax;
		}
		
		@Override
		public String toString() {
			return "[" + mossa + ", pp=" + pp + "]";
		}

		public Mossa getMossa() { return mossa; }
		public void setMossa(Mossa mossa) { this.mossa = mossa; }
		public static int getPpMax() { return ppMax; }
		public static void setPpMax(int ppMax) { UsableMove.ppMax = ppMax; }
		public int getPp() { return pp; }
		public void setPp(int pp) { this.pp = pp; }
		
		public boolean isMe(Mossa m) {
			return (m == this.mossa);
		}

		public void useMove() {
			this.pp -= 1;
		}
	}
	// ↑ Mossa utilizzabile ↑ --------------------------------------------------------------------------------------
	
	
	// ↓ Statistiche di base ↓--------------------------------------------------------------------------------------
	private class BaseStat{
		private Statistica stat;
		private int mainVal;
		private int battleValue;
		
		private int modifyLvl;
		
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

		public Statistica getStat() { return stat; }
		public int getMainValue() { return mainVal; }
		public int getBattleValue() { return battleValue; }
		public int modifyLvl() { return modifyLvl; }

		public void setStat(Statistica stat) { this.stat = stat; }
		public void setMainValue(int valore) { this.mainVal = valore; }
		public void setBattleValue(int battleValue) { this.battleValue = battleValue; }
		public void setModifyLvl(int modifyLvl) { this.modifyLvl = modifyLvl; this.battleValue += modifyLvl * (this.mainVal * 11 / 100);}
		
		public void modify(int val) {
			if(modifyLvl <= -6 || modifyLvl >= 6) { return; }
			
			this.battleValue += val * (this.mainVal * 11 / 100);
			this.modifyLvl += val;
		}
		
		public void resetStat() { setBattleValue(this.mainVal); }
	}
	// ↑ Statistiche di base ↑ --------------------------------------------------------------------------------------	
	
	
	
	// ↓ Attributi POKEMON ↓ ------------------------------------------------------------------------------------------
	private String nome;
	private Tipo[] tipi = new Tipo[2];
	private UsableMove[] mosse = new UsableMove[4];
	private HashMap<Integer, Mossa> parcoMosse = new HashMap<Integer, Mossa>();
	
	private int lvl;
	private int currentExp;
	private int nextLvlExp;
	private int evoLvl;
	private Pokemon evo;
	private int evoStage;
	
	private int battlePs;
	private int maxPs;
	private BaseStat velocita;
	private BaseStat attacco;
	private BaseStat attaccoSP;
	private BaseStat difesa;
	private BaseStat difesaSP;
	private BaseStat precisione;
	private BaseStat elusione;
	// ↑ Attributi POKEMON ↑ ------------------------------------------------------------------------------------------
	
	
	
	// ↓ Costruttore ↓ ------------------------------------------------------------------------------------------
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
	public void incassa(int danno) {
		Random r = new Random();
		if (this.elusione.getBattleValue() > r.nextInt(100, 180)) {
			System.out.println("MISS");
			return; 
		}
		this.setBattlePs(this.getBattlePs() - danno);
	}
	
	
	public int attacca(Pokemon enemy, Mossa mossa) {
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
				default:
					return -1;
			}		
			baseOnAction.modify(mossa.getLvlBoostNerf());
			
		}
		
		if(mossa.getCategoria() == Categoria.SPECIALE){
			return hit(mossa, enemy, this.getAttaccoSP(), enemy.getDifesaSP());
		}else if(mossa.getCategoria() == Categoria.FISICO) {
			return hit(mossa, enemy, this.getAttacco(), enemy.getDifesa());
		}
		return 0;
	}
	
	private int hit(Mossa mossa, Pokemon enemy, BaseStat myAtk, BaseStat hisDef) {		
		Random r = new Random();
		
		int accuracy = mossa.getPrecisione() * this.precisione.getBattleValue()/100;

		if (r.nextInt(1, 100) > accuracy) { 
			System.out.println("MISS");
			return 0 ;
		}
		
		int crit = r.nextInt(1, 100);
		crit = (crit<=8) ? 2 : 1;
																														
		double random = r.nextDouble(217, 255) / 255;
		double stab = (mossa.getTipo() == this.tipi[0] || mossa.getTipo() == this.tipi[1]) ? 1.5 : 1;
		
		Tipo tipo1 = enemy.getTipi()[0];
		Tipo tipo2 = enemy.getTipi()[1];
		
		return (int) (((((((2 * this.lvl * crit )/ 5) + 2) * mossa.getBasePower() * myAtk.getBattleValue()/hisDef.getBattleValue()))/30 + 2) * stab * random * mossa.getTipo().calcolaRelazioneTipi(tipo1) * mossa.getTipo().calcolaRelazioneTipi(tipo2));
	}
	// ↑ Danni ↑ ------------------------------------------------------------------------------------
	
	
	// ↓ lvl-up ↓ ---------------------------------------------------------------------------
	@Override
	public void levelUp() {
		if (this.lvl >= 100) {return;}
		
		this.setLvl(this.getLvl() + 1);
		
		this.setNextLvlExp( (int) (4 * Math.pow(this.getLvl(), 3)/ 5));
		
		int oldMaxPs = this.getMaxPs();
		this.setMaxPs(this.getMaxPs() + calcStat(this.getMaxPs(), 110));
		
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
		
		this.learnMove();
	}
	
	private int calcStat(int stat, int percentuale) { return ((stat + this.lvl)/percentuale) + 1; }
	
	public void goToLvl(int lvl) {
		for(int i = 0; i<lvl; i++) {
			this.levelUp(); 
		}
	}
	
	@Override
	public void learnMove() {
		Mossa m = null;
		if(this.parcoMosse == null) {return;}

		for (int key : this.parcoMosse.keySet()) {
			if(key == this.lvl) {
				m = this.parcoMosse.get(key);
				if(Arrays.asList(this.getMoveSet()).contains(null) && !Arrays.asList(this.getMoveSet()).contains(m)) {
					mosse[Arrays.asList(this.getMoveSet()).indexOf(null)] = new UsableMove(m);
				} else {
					System.out.println(this.nome + " vorrebbe imparare " + m.getNome() + ". Inserire il numero della mossa da sostituire...");
					Scanner s = new Scanner(System.in);
					String scelta = s.nextLine();
					switch(scelta) {
						case "1":
							this.mosse[0] = new UsableMove(m);
							break;
						case "2":
							this.mosse[1] = new UsableMove(m);
							break;
						case "3":
							this.mosse[2] = new UsableMove(m);
							break;
						case "4":
							this.mosse[3] = new UsableMove(m);
							break;
						default:
							System.out.println("Mossa non imparata");
							continue;
					}
				}
			}
		}
	}
	
	@Override
	public void evolve() {
		if(!(this.getLvl() >= this.getEvoLvl() && this.evo != null)) { return; }
		
		System.out.println(this.nome + " vorrebbe evolversi! Confermare l'evoluzione? s/n");
		Scanner s = new Scanner(System.in);
		String scelta = s.next();
		if(!scelta.equals("s")) {
			System.out.println("Evoluzione annullata");
			return; 
		}
		
		this.nome = evo.nome;
		this.tipi = evo.tipi;
		this.parcoMosse = evo.parcoMosse;
		this.evoLvl = evo.evoLvl;
		this.evo = evo.evo;
		
		this.setMaxPs(this.getMaxPs() + calcStat(this.getMaxPs(), 10));
		this.attacco.setMainValue(this.attacco.getMainValue() + calcStat( this.attacco.getMainValue(), 10));
		this.attaccoSP.setMainValue(this.attaccoSP.getMainValue() +calcStat( this.attaccoSP.getMainValue(), 10));	
		this.difesa.setMainValue(this.difesa.getMainValue() + calcStat( this.difesa.getMainValue(), 10));
		this.difesaSP.setMainValue(this.difesaSP.getMainValue() +calcStat( this.difesaSP.getMainValue(), 10));
		this.velocita.setMainValue(this.velocita.getMainValue() +calcStat( this.velocita.getMainValue(), 10));
		
		this.resetStats();
	}
	
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
	
public String battleData() {
		
		return "Pokemon [nome=" + nome + ", tipi=" + Arrays.toString(tipi) + ", mosse=" + Arrays.toString(mosse) + ",\n" 
				+ "lvl=" + lvl + ", currentExp=" + currentExp + ", nextLvlExp=" + nextLvlExp
				+ "\nbattlePs=" + battlePs + ", maxPs=" + maxPs + ",\n" + "velocita=" + velocita + ", attacco=" + attacco + ", attaccoSP=" + attaccoSP + ", difesa=" + difesa + ", difesaSP=" + difesaSP + "]" 
				+  ",\n" + "precisione=" + precisione + ", elusione=" + elusione;
	}
	
	
	// ↓ Setters and Getters ↓ ------------------------------------------------------------------------------
	public Tipo[] getTipi() { return tipi; }
	public String getNome() { return nome; }
	public UsableMove[] getMosse() { return mosse; }
	public HashMap<Integer, Mossa> getParcoMosse() { return parcoMosse; }
	public int getLvl() { return lvl; }
	public int getCurrentExp() { return currentExp; }
	public int getNextLvlExp() { return nextLvlExp; }
	public int getEvoLvl() { return evoLvl; }
	public Pokemon getEvo() { return evo; }
	public int getBattlePs() { return battlePs; }
	public int getMaxPs() { return maxPs; }
	public BaseStat getVelocita() { return velocita; }
	public BaseStat getAttacco() { return attacco; }
	public BaseStat getAttaccoSP() { return attaccoSP; }
	public BaseStat getDifesa() { return difesa; }
	public BaseStat getDifesaSP() { return difesaSP; }
	public BaseStat getPrecisione() { return precisione; }
	public BaseStat getElusione() { return elusione; }
	
	public Mossa[] getMoveSet() {
		Mossa[] ms = new Mossa[4];
		for(int i = 0; i < this.mosse.length; i++) {
			ms[i] = (mosse[i] == null) ? null : mosse[i].getMossa();
		}
		return ms;
	}
	
	public String moveSetToString() {
		String ms = "[";
		for(int i = 0; i < this.mosse.length; i++) {
			ms += (mosse[i] == null) ? "" : mosse[i].getMossa().getNome() + "[" + (i+1) +"], ";
		}
		ms += "]";
		return ms;
	}
	
	public void setTipi(Tipo[] tipi) { this.tipi = tipi; }
	public void setNome(String nome) { this.nome = nome; }
	public void setMosse(UsableMove[] mosse) { this.mosse = mosse; }
	public void setParcoMosse(HashMap<Integer, Mossa> parcoMosse) { this.parcoMosse = parcoMosse; }
	public void setLvl(int lvl) { this.lvl = lvl; }
	public void setCurrentExp(int currentExp) { this.currentExp = currentExp; }
	public void setNextLvlExp(int nextLvlExp) { this.nextLvlExp = nextLvlExp; }
	public void setEvoLvl(int evoLvl) { this.evoLvl = evoLvl; }
	public void setEvo(Pokemon evo) { this.evo = evo; }
	public void setBattlePs(int battlePs) { this.battlePs = battlePs; }
	public void setMaxPs(int maxPs) { this.maxPs = maxPs; }
	public void setVelocita(BaseStat velocita) { this.velocita = velocita; }
	public void setAttacco(BaseStat attacco) { this.attacco = attacco; }
	public void setAttaccoSP(BaseStat attaccoSP) { this.attaccoSP = attaccoSP; }
	public void setDifesa(BaseStat difesa) { this.difesa = difesa; }
	public void setDifesaSP(BaseStat difesaSP) { this.difesaSP = difesaSP; }
	public void setPrecisione(BaseStat precisione) { this.precisione = precisione; }
	public void setElusione(BaseStat elusione) { this.elusione = elusione; }
	
	public void resetStats() {
		this.battlePs = this.maxPs;
		this.attacco.resetStat();
		this.attaccoSP.resetStat();
		this.difesa.resetStat();
		this.difesaSP.resetStat();
		this.velocita.resetStat();
		this.precisione.resetStat();
		this.elusione.resetStat();
	}
	
	// Setter e Getter utili per debug
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
	
	public int getVelocitaBattaglia() { return velocita.getBattleValue(); }
	public int getAttaccoBattaglia() { return attacco.getBattleValue(); }
	public int getAttaccoSPBattaglia() { return attaccoSP.getBattleValue(); }
	public int getDifesaBattaglia() { return difesa.getBattleValue(); }
	public int getDifesaSPBattaglia() { return difesaSP.getBattleValue(); }
	public int getPrecisioneBattaglia() { return precisione.getBattleValue(); }
	public int getElusioneBattaglia() { return elusione.getBattleValue(); }
	public void setVelocitaBattaglia(int velocita) { this.velocita.setBattleValue(velocita); }
	public void setAttaccoBattaglia(int attacco) { this.attacco.setBattleValue(attacco); }
	public void setAttaccoSPBattaglia(int attaccoSP) { this.attaccoSP.setBattleValue(attaccoSP); }
	public void setDifesaBattaglia(int difesa) { this.difesa.setBattleValue(difesa); }
	public void setDifesaSPBattaglia(int difesaSP) { this.difesaSP.setBattleValue(difesaSP); }
	public void setPrecisioneBattaglia(int precisione) { this.precisione.setBattleValue(precisione); }
	public void setElusioneBattaglia(int elusione) { this.elusione.setBattleValue(elusione); }
}
