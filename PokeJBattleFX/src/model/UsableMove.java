package model;

import model.costanti.Mossa;

/**
 * Questa classe e' utilizzata per far utilizzare la mossa non piu
 * dei suoi ppMax
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class UsableMove {
	/**
	 * Questo campo indica la mossa utilizzabile
	 */
	private Mossa mossa;
	/**
	 * Questo campo indica quante volte puo essere usata la mossa
	 */
	private int ppMax;
	/**
	 * Questo campo indica quante volte ancora puo' utilizzare la mossa
	 */
	private int pp;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param m Mossa
	 */
	public UsableMove(Mossa m) {
		this.mossa = m;
		this.ppMax = m.getPP();
		this.pp = this.ppMax;
	}
	
	@Override
	public String toString() {
		return "[" + mossa + ", pp=" + pp + "]";
	}
	
	/**
	 * Questo metodo restituisce il campo mossa
	 * 
	 * @return Mossa
	 */
	public Mossa getMossa() { return mossa; }
	/**
	 * Questo metodo setta il campo mossa
	 * 
	 * @param mossa Mossa
	 * @return void
	 */
	public void setMossa(Mossa mossa) { this.mossa = mossa; }
	
	/**
	 * Questo metodo restituisce il campo ppMax
	 * 
	 * @return int
	 */
	public int getPpMax() { return this.ppMax; }
	/**
	 * Questo metodo setta il campo ppMax
	 * 
	 * @param ppMax int
	 * @return void
	 */
	public void setPpMax(int ppMax) { this.ppMax = ppMax; }
	
	/**
	 * Questo metodo restituisce il campo pp
	 * 
	 * @return int
	 */
	public int getPp() { return pp; }
	/**
	 * Questo metodo setta il campo pp
	 * 
	 * @param pp int
	 */
	public void setPp(int pp) { this.pp = pp; }
	
	/**
	 * Questo metodo controlla se m e' uguale
	 * al campo mossa
	 * 
	 * @param m Mossa
	 * @return boolean
	 */
	public boolean isMe(Mossa m) {
		return (m == this.mossa);
	}
	
	/**
	 * Questo metodo decrementa il campo pp
	 * @return void
	 */
	public void useMove() {
		if(pp==0) return;
		this.pp -= 1;
	}
}