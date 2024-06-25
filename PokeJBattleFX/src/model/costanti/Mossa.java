package model.costanti;

public enum Mossa {
	
	// roba di controllo
	RESA("RESA", 0, Tipo.NORMALE, Categoria.FISICO, 0, 0, /*Dati per mosse di stato ->*/null, 0, false),
	CAMBIA("CAMBIA", 0, Tipo.NORMALE, Categoria.FISICO, 0, 0, /*Dati per mosse di stato ->*/null, 0, false),
	
	// generic stuff
	COLEOMORSO("Coleomorso", 60, Tipo.COLEOTTERO, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	MILLEBAVE("Millebave", 0, Tipo.COLEOTTERO, Categoria.STATO, 95, 40, /*Dati per mosse di stato ->*/Statistica.VELOCITA, -1, false),
	RAFFICA("Raffica", 40, Tipo.VOLANTE, Categoria.SPECIALE, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	RAFFORZATORE("Rafforzatore", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, 1, true),
	CONFUSIONE("Confusione", 50, Tipo.PSICO, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	BOTTA("Botta", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	COLPOKARATE("Colpokarate", 50, Tipo.LOTTA, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	COMETAPUGNO("Cometapugno", 18, Tipo.NORMALE, Categoria.FISICO, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	DOPPIASBERLA("Doppiasberla", 30, Tipo.NORMALE, Categoria.FISICO, 85, 10, /*Dati per mosse di stato ->*/null, 0, false),
	MEGAPUGNO("Megapugno", 80, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	GIORNOPAGA("Giornopaga", 40, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FUOCOPUGNO("Fuocopugno", 75, Tipo.FUOCO, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	GELOPUGNO("Gelopugno", 75, Tipo.GHIACCIO, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	TUONOPUGNO("Tuonopugno", 75, Tipo.ELETTRO, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	GHIGLIOTTINA("Ghigliottina", 1000, Tipo.NORMALE, Categoria.FISICO, 10, 5, /*Dati per mosse di stato ->*/null, 0, false),
	VENTAGLIENTE("Ventagliente", 80, Tipo.VOLANTE, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	DANZASPADA("Danzaspada", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.ATTACCO, 2, true),
	TAGLIO("Taglio", 50, Tipo.NORMALE, Categoria.FISICO, 95, 30, /*Dati per mosse di stato ->*/null, 0, false),
	ATTACCODALA("Attacco d'ala", 60, Tipo.VOLANTE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	VOLO("Volo", 90, Tipo.VOLANTE, Categoria.FISICO, 90, 15, /*Dati per mosse di stato ->*/null, 0, false),
	PESTONE("Pestone", 65, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	DOPPIOCALCIO("Doppiocalcio", 60, Tipo.LOTTA, Categoria.FISICO, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	MEGACALCIO("Megacalcio", 120, Tipo.LOTTA, Categoria.FISICO, 75, 5, /*Dati per mosse di stato ->*/null, 0, false),
	CALCIOSALTO("Calciosalto", 100, Tipo.LOTTA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	CALCIORULLO("Calciorullo", 60, Tipo.LOTTA, Categoria.FISICO, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	TURBOSABBIA("Turbosabbia", 0, Tipo.TERRA, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	BOTTAINTESTA("Bottintesta", 70, Tipo.NORMALE, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	INCORNATA("Incornata", 65, Tipo.NORMALE, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	PERFORCORNO("Perforcorno", 1000, Tipo.NORMALE, Categoria.FISICO, 10, 5, /*Dati per mosse di stato ->*/null, 0, false),
	CORPOSCONTRO("Corposcontro", 85, Tipo.NORMALE, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	VELENOSPINA("Velenospina", 40, Tipo.VELENO, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	DOPPIOAGO("Doppio Ago", 50, Tipo.COLEOTTERO, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FULMISGUARDO("Fulmisguardo", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, -1, false),
	ACIDO("Acido", 40, Tipo.VELENO, Categoria.SPECIALE, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	GELORAGGIO("Geloraggio", 90, Tipo.GHIACCIO, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	BORA("Bora", 110, Tipo.GHIACCIO, Categoria.SPECIALE, 80, 10, /*Dati per mosse di stato ->*/null, 0, false),
	PSICORAGGIO("Psicoraggio", 65, Tipo.PSICO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	BOLLARAGGIO("Bollaraggio", 65, Tipo.ACQUA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	RAGGIOAURORA("Raggioaurora", 65, Tipo.GHIACCIO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	IPERRAGGIO("Iper Raggio", 150, Tipo.NORMALE, Categoria.SPECIALE, 75, 5, /*Dati per mosse di stato ->*/null, 0, false),
	GIGAIMPATTO("Gigaimpatto", 150, Tipo.NORMALE, Categoria.FISICO, 75, 5, /*Dati per mosse di stato ->*/null, 0, false),
	BECCATA("Beccata", 35, Tipo.VOLANTE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	PERFORBECCO("Perforbecco", 35, Tipo.VOLANTE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	SOTTOMISSIONE("Sottomissione", 80, Tipo.LOTTA, Categoria.FISICO, 80, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FORZA("Forza", 80, Tipo.NORMALE, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	IRADIDRAGO("Ira di Drago", 50, Tipo.DRAGO, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	TURBOFUOCO("Turbofuoco", 35, Tipo.FUOCO, Categoria.SPECIALE, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	TUONOSHOCK("Tuonoshock", 40, Tipo.ELETTRO, Categoria.SPECIALE, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	FULMINE("Fulmine", 90, Tipo.ELETTRO, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	TUONO("Tuono", 110, Tipo.ELETTRO, Categoria.SPECIALE, 70, 15, /*Dati per mosse di stato ->*/null, 0, false),
	SASSATA("Sassata", 50, Tipo.ROCCIA, Categoria.FISICO, 90, 15, /*Dati per mosse di stato ->*/null, 0, false),
	TERREMOTO("Terremoto", 100, Tipo.TERRA, Categoria.FISICO, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	ABISSO("Abisso", 1000, Tipo.TERRA, Categoria.FISICO, 10, 5, /*Dati per mosse di stato ->*/null, 0, false),
	FOSSA("Fossa", 80, Tipo.TERRA, Categoria.FISICO, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	PSICHICO("Psichico", 90, Tipo.PSICO, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	MEDITAZIONE("Meditazione", 0, Tipo.PSICO, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ATTACCO, 1, true),
	AGILITA("Agilità", 0, Tipo.PSICO, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.VELOCITA, 2, true),
	STRIDIO("Stridio", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.DIFESA, -2, false),
	DOPPIOTEAM("Doppioeam", 0, Tipo.NORMALE, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.ELUSIONE, 1, true),
	MIMIZZATO("Minimizzato", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ELUSIONE, 2, true),
	LECCATA("Leccata", 30, Tipo.SPETTRO, Categoria.FISICO, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	SMOG("Smog", 30, Tipo.VELENO, Categoria.SPECIALE, 70, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FANGO("Fango", 65, Tipo.VELENO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	OSSOCLAVA("Ossoclava", 65, Tipo.TERRA, Categoria.FISICO, 85, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FUOCOBOMBA("Fuocobomba", 110, Tipo.FUOCO, Categoria.SPECIALE, 85, 5, /*Dati per mosse di stato ->*/null, 0, false),
	CASCATA("Cascata", 80, Tipo.ACQUA, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	TENAGLIA("Tenaglia", 35, Tipo.ACQUA, Categoria.FISICO, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	COMETE("Comete", 60, Tipo.NORMALE, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	AMNESIA("Amnesia", 0, Tipo.PSICO, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.DIFESA_SPECIALE, 2, true),
	CINESI("Cinési", 0, Tipo.PSICO, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	SANGUISUGA("Sanguisuga", 80, Tipo.COLEOTTERO, Categoria.FISICO, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	AEREOATTACCO("Aereoattacco", 140, Tipo.VOLANTE, Categoria.FISICO, 90, 5, /*Dati per mosse di stato ->*/null, 0, false),
	BOLLA("Bolla", 40, Tipo.ACQUA, Categoria.SPECIALE, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	FLASH("Flash", 0, Tipo.NORMALE, Categoria.STATO, 100, 2, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, true),
	SPLASH("Splash", 0, Tipo.ACQUA, Categoria.SPECIALE, 100, 40, /*Dati per mosse di stato ->*/null, 0, false),
	SCUDOACIDO("Scudo Acido", 0, Tipo.VELENO, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.DIFESA, 2, true),
	MARTELLATA("Martellata", 100, Tipo.ACQUA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	OSSOMERANG("Ossomerang", 100, Tipo.TERRA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	FRANA("Frana", 75, Tipo.ROCCIA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	IPERZANNA("Iperzanna", 80, Tipo.NORMALE, Categoria.FISICO, 90, 15, /*Dati per mosse di stato ->*/null, 0, false),
	AFFILATORE("Affilatore", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.ATTACCO, 1, true),
	ATTACCORAPIDO("Attacco Rapido", 40, Tipo.NORMALE, Categoria.FISICO, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	
	// Bulbasaur stuff
	FRUSTATA("Frustata", 45, Tipo.ERBA, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	RUGGITO("Ruggito", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ATTACCO, -1, false),
	CRESCITA("Crescita", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.ATTACCO_SPECIALE, 1, true),
	SEMEBOMBA("Semebomba", 80, Tipo.ERBA, Categoria.FISICO, 100, 15,/*Dati per mosse di stato ->*/ null, 0, false),
	RIDUTTORE("Riduttore", 90, Tipo.NORMALE, Categoria.FISICO, 85, 20, /*Dati per mosse di stato ->*/null, 0, false),
	VIGORCOLPO("Vigorcolpo", 120, Tipo.ERBA, Categoria.FISICO, 85, 10, /*Dati per mosse di stato ->*/null, 0, false),
	FOGLIELAMA("Foglielama", 55, Tipo.ERBA, Categoria.FISICO, 95, 25, /*Dati per mosse di stato ->*/null, 0, false),
	FOGLIAMAGICA("Fogliamagica", 60, Tipo.ERBA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	LACCIOERBOSO("Laccioerboso", 70, Tipo.ERBA, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	SOLARAGGIO("Solarraggio", 120, Tipo.ERBA, Categoria.SPECIALE, 100, 8, /*Dati per mosse di stato ->*/null, 0, false),
	VERDEBUFERA("Verdebufera", 130, Tipo.ERBA, Categoria.SPECIALE, 90, 5, /*Dati per mosse di stato ->*/null, 0, false),
	FIORTEMPESTA("Fiortempesta", 90, Tipo.ERBA, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	
	// Squirtle stuff
	AZIONE("Azione", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	COLPOCODA("Colpocoda", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, -1, false),
	PISTOLACQUA("Pistolacqua", 40, Tipo.ACQUA, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	RITIRATA("Ritirata", 0, Tipo.ACQUA, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.DIFESA, 1, true),
	MORSO("Morso", 60, Tipo.BUIO, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	IDROPOMPA("Idropompa", 110, Tipo.ACQUA, Categoria.SPECIALE, 80, 5, /*Dati per mosse di stato ->*/null, 0, false),
	IDROPULSAR("Idropulsar", 60, Tipo.ACQUA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	FERROSCUDO("Ferroscudo", 0, Tipo.ACCIAIO, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.DIFESA, 2, true),
	IDRONDATA("Idrondata", 90, Tipo.ACQUA, Categoria.SPECIALE, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	ONDASCHIANTO("Ondaschianto", 75, Tipo.ACQUA, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	SURF("Surf", 90, Tipo.ACQUA, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	IDROPOPMA("Idropompa", 110, Tipo.ACQUA, Categoria.SPECIALE, 80, 5, /*Dati per mosse di stato ->*/null, 0, false),
	
	// Charmander stuff
	GRAFFIO("Graffio", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	MURODIFUMO("Muro di fumo", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	DRAGOSPIRO("Dragospiro", 60, Tipo.DRAGO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	ROGODENTI("Rogodenti", 65, Tipo.FUOCO, Categoria.FISICO, 95, 15, /*Dati per mosse di stato ->*/null, 0, false),
	LACERAZIONE("Lacerazione", 70, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	LANCIAFIAMME("Lanciafiamme", 90, Tipo.FUOCO, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	VISOTRUCE("Visotruce", 0, Tipo.NORMALE, Categoria.STATO, 100, 10, /*Dati per mosse di stato ->*/Statistica.VELOCITA, -2, false),
	MARCHIATURA("Marchiatura", 100, Tipo.FUOCO, Categoria.SPECIALE, 50, 5, /*Dati per mosse di stato ->*/null, 0, false),
	BRACIERE("Braciere", 40, Tipo.FUOCO, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	INFERNO("Inferno", 100, Tipo.FUOCO, Categoria.SPECIALE, 50, 5, /*Dati per mosse di stato ->*/null, 0, false),
	RUOTAFUOCO("Ruotafuoco", 35, Tipo.FUOCO, Categoria.SPECIALE, 85, 15, /*Dati per mosse di stato ->*/null, 0, false);
	
	
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
