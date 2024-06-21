package model;

import model.costanti.Mossa;

public class UsableMove {
	private Mossa mossa;
	private int ppMax;
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
	public int getPpMax() { return this.ppMax; }
	public void setPpMax(int ppMax) { this.ppMax = ppMax; }
	public int getPp() { return pp; }
	public void setPp(int pp) { this.pp = pp; }
	
	public boolean isMe(Mossa m) {
		return (m == this.mossa);
	}

	public void useMove() {
		this.pp -= 1;
	}
}