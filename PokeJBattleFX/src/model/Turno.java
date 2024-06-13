package model;

import model.costanti.Mossa;

public class Turno {
	private Mossa mossa;
	private boolean cambioPoke;
	private boolean surrend;
	
	public Turno(Mossa mossa, boolean cambioPoke, boolean surrend) {
		this.mossa = mossa;
		this.cambioPoke = cambioPoke;
		this.surrend = surrend;
	}
	
	
	public Mossa getMossa() { return mossa; }
	public void setMossa(Mossa mossa) { this.mossa = mossa; }
	
	public boolean isCambioPoke() { return cambioPoke; }
	public void setCambioPoke(boolean cambioPoke) { this.cambioPoke = cambioPoke; }
	
	public boolean isSurrend() { return surrend; }
	public void setSurrend(boolean surrend) { this.surrend = surrend; }
}
