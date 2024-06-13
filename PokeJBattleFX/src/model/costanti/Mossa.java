package model.costanti;

public enum Mossa {
	// Bulbasaur stuff
	FRUSTATA("Frustata", 45, Tipo.ERBA, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	RUGGITO("Ruggito", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ATTACCO, -1, false),
	CRESCITA("Crescita", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.ATTACCO_SPECIALE, 1, true),
	SEMEBOMBA("Semebomba", 80, Tipo.ERBA, Categoria.FISICO, 100, 15,/*Dati per mosse di stato ->*/ null, 0, false),
	RIDUTTORE("Riduttore", 90, Tipo.NORMALE, Categoria.FISICO, 85, 20, /*Dati per mosse di stato ->*/null, 0, false),
	VIGORCOLPO("Vigorcolpo", 120, Tipo.ERBA, Categoria.FISICO, 85, 10, /*Dati per mosse di stato ->*/null, 0, false),
	FOGLIELAMA("Foglielama", 55, Tipo.ERBA, Categoria.FISICO, 95, 25, /*Dati per mosse di stato ->*/null, 0, false),
	
	// Squirtle stuff
	AZIONE("Azione", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	COLPOCODA("Colpocoda", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, -1, false),
	PISTOLACQUA("Pistolacqua", 40, Tipo.ACQUA, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	RITIRATA("Ritirata", 0, Tipo.ACQUA, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.DIFESA, 1, true),
	MORSO("Morso", 60, Tipo.BUIO, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	IDROPOMPA("Idropompa", 110, Tipo.ACQUA, Categoria.SPECIALE, 80, 5, /*Dati per mosse di stato ->*/null, 0, false),
	IDROPURSAL("Idropulsar", 60, Tipo.ACQUA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FERROSCUDO("Ferroscudo", 0, Tipo.ACCIAIO, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.DIFESA, 2, true),
	
	// Charmander stuff
	GRAFFIO("Graffio", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	MURODIFUMO("Muro di fumo", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	DRAGOSPIRO("Dragospiro", 60, Tipo.DRAGO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	ROGODENTI("Rogodenti", 65, Tipo.FUOCO, Categoria.FISICO, 95, 15, /*Dati per mosse di stato ->*/null, 0, false),
	LACERAZIONE("Lacerazione", 70, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	LANCIAFIAMME("Lanciafiamme", 90, Tipo.FUOCO, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	VISOTRUCE("Visotruce", 0, Tipo.NORMALE, Categoria.STATO, 100, 10, /*Dati per mosse di stato ->*/Statistica.VELOCITA, -2, false),
	MARCHIATURA("Marchiatura", 100, Tipo.FUOCO, Categoria.SPECIALE, 50, 5, /*Dati per mosse di stato ->*/null, 0, false),
	BRACIERE("Braciere", 40, Tipo.FUOCO, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false);
	
	
	private String nome;
	private int basePower;
	private Tipo tipo;
	private Categoria categoria;
	private int precisione;
	private int PP;
	
	private int lvlBoostNerf;
	private Statistica statBoostNerf;
	private boolean onSelf;
	
	private Mossa(String nome, int basePower, Tipo tipo, Categoria categoria, int precisione, int pP, Statistica statBoostNerf, int lvlBoostNerf, boolean onSelf) {
		this.nome = nome;
		this.basePower = basePower;
		this.tipo = tipo;
		this.categoria = categoria;
		this.precisione = precisione;
		this.PP = pP;
		
		this.lvlBoostNerf = lvlBoostNerf;
		this.statBoostNerf = statBoostNerf;
		this.onSelf = onSelf;
	}
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public int getBasePower() { return basePower; }
	public void setBasePower(int basePower) { this.basePower = basePower; }
	
	public Tipo getTipo() { return tipo; }
	public void setTipo(Tipo tipo) { this.tipo = tipo; }
	
	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) { this.categoria = categoria; }
	
	public int getPrecisione() { return precisione; }
	public void setPrecisione(int precisione) { this.precisione = precisione; }
	
	public int getPP() { return PP; }
	public void setPP(int pP) { PP = pP; }
	
	
	public int getLvlBoostNerf() { return lvlBoostNerf; }
	public void setLvlBoostNerf(int lvlBoostNerf) { this.lvlBoostNerf = lvlBoostNerf; }
	
	public Statistica getStatBoostNerf() { return this.statBoostNerf; }
	public void setStatBoostNerf(Statistica statBoostNerf) { this.statBoostNerf = statBoostNerf; }
	
	public boolean getOnSelf() { return this.onSelf; }
	public void setOnSelf(boolean onSelf) { this.onSelf = onSelf; }
	
	}
