package model.costanti;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
	NORMALE,	
    LOTTA,   
    VOLANTE,
    VELENO,
    TERRA,
    COLEOTTERO,
    SPETTRO,
    ACCIAIO, 
    FUOCO,
    ACQUA,
    ROCCIA,
    ERBA,
    ELETTRO,
    PSICO,
    GHIACCIO,
    DRAGO,    
    BUIO,    
    FOLLETTO;

	Tipo() {
		this.forteContro = new ArrayList<>();
		this.resistitoDa = new ArrayList<>();
		this.immuneDa = new ArrayList<>();
	}
	
    private List<Tipo> forteContro;
    private List<Tipo> resistitoDa;
    private List<Tipo> immuneDa;

    static {
    	NORMALE.forteContro.addAll(new ArrayList<Tipo>() {});
    	NORMALE.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ROCCIA);  add(Tipo.ACCIAIO); }});
    	NORMALE.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.SPETTRO); }});
    	
    	LOTTA.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.NORMALE); add(Tipo.ROCCIA); add(Tipo.ACCIAIO); add(Tipo.GHIACCIO); add(Tipo.BUIO); }});
    	LOTTA.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.VOLANTE);   add(Tipo.VELENO);  add(Tipo.COLEOTTERO);   add(Tipo.PSICO);  add(Tipo.FOLLETTO); }});
    	LOTTA.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.SPETTRO); }});
    	
    	VOLANTE.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.LOTTA); add(Tipo.COLEOTTERO); add(Tipo.ERBA); }});
    	VOLANTE.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ROCCIA); add(Tipo.ACCIAIO);  add(Tipo.ELETTRO); }});
    	VOLANTE.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	VELENO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.ERBA); add(Tipo.FOLLETTO); }});
    	VELENO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.VELENO);  add(Tipo.ROCCIA);  add(Tipo.TERRA); add(Tipo.SPETTRO);  }});
    	VELENO.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACCIAIO); }});
    	
    	TERRA.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.VELENO); add(Tipo.ROCCIA); add(Tipo.ACCIAIO); add(Tipo.FUOCO); add(Tipo.ELETTRO); }});
    	TERRA.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.COLEOTTERO);  add(Tipo.ERBA); }});
    	TERRA.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.VOLANTE); }});
    	
    	COLEOTTERO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.ERBA); add(Tipo.PSICO); add(Tipo.BUIO); }});
    	COLEOTTERO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.LOTTA);  add(Tipo.VOLANTE); add(Tipo.VELENO); add(Tipo.SPETTRO);  add(Tipo.ACCIAIO);  add(Tipo.FUOCO); add(Tipo.FOLLETTO); }});
    	COLEOTTERO.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	SPETTRO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.SPETTRO); add(Tipo.PSICO); }});
    	SPETTRO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.BUIO); }});
    	SPETTRO.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.NORMALE); }});
    	
    	ACCIAIO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.ROCCIA); add(Tipo.GHIACCIO); add(Tipo.FOLLETTO); }});
    	ACCIAIO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACCIAIO);  add(Tipo.FUOCO); add(Tipo.ACQUA); add(Tipo.ELETTRO); }});
    	ACCIAIO.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	FUOCO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.COLEOTTERO); add(Tipo.ACCIAIO); add(Tipo.ERBA); add(Tipo.GHIACCIO); }});
    	FUOCO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACQUA); add(Tipo.ROCCIA);  add(Tipo.FUOCO); add(Tipo.DRAGO); }});
    	FUOCO.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	ACQUA.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.TERRA); add(Tipo.ROCCIA); add(Tipo.FUOCO); }});
    	ACQUA.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACQUA); add(Tipo.ERBA); add(Tipo.DRAGO); }});
    	ACQUA.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	ROCCIA.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.VOLANTE); add(Tipo.COLEOTTERO); add(Tipo.FUOCO); add(Tipo.GHIACCIO); }});
    	ROCCIA.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.LOTTA);   add(Tipo.TERRA); add(Tipo.ACCIAIO); }});
    	ROCCIA.immuneDa.addAll(new ArrayList<Tipo>() {{ }});

    	ERBA.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.ROCCIA); add(Tipo.ACQUA); add(Tipo.TERRA); }});
    	ERBA.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.VOLANTE); add(Tipo.ERBA); add(Tipo.COLEOTTERO); add(Tipo.ACCIAIO); add(Tipo.FUOCO);  add(Tipo.ERBA); add(Tipo.DRAGO); }});
    	ERBA.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	ELETTRO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.VOLANTE); add(Tipo.ACQUA); }});
    	ELETTRO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ERBA); add(Tipo.ELETTRO); add(Tipo.DRAGO); }});
    	ELETTRO.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.TERRA); }});
    	
    	PSICO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.LOTTA); add(Tipo.VELENO); }});
    	PSICO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACCIAIO); add(Tipo.PSICO); }});
    	PSICO.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.BUIO); }});
    	
    	GHIACCIO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.VOLANTE); add(Tipo.TERRA); add(Tipo.ERBA); add(Tipo.DRAGO); }});
    	GHIACCIO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACCIAIO); add(Tipo.FUOCO); add(Tipo.ACQUA); add(Tipo.GHIACCIO); }});
    	GHIACCIO.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	DRAGO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.DRAGO); }});
    	DRAGO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.ACCIAIO); }});
    	DRAGO.immuneDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.FOLLETTO); }});
    	
    	BUIO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.SPETTRO); add(Tipo.PSICO); }});
    	BUIO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.LOTTA); add(Tipo.BUIO); add(Tipo.FOLLETTO); }});
    	BUIO.immuneDa.addAll(new ArrayList<Tipo>() {{ }});
    	
    	FOLLETTO.forteContro.addAll(new ArrayList<Tipo>() {{ add(Tipo.LOTTA); add(Tipo.DRAGO); add(Tipo.BUIO); }});
    	FOLLETTO.resistitoDa.addAll(new ArrayList<Tipo>() {{ add(Tipo.FUOCO); add(Tipo.ACCIAIO); add(Tipo.VELENO); }});
    	FOLLETTO.immuneDa.addAll(new ArrayList<Tipo>() {{ }});  	
    }
    
    public List<Tipo> getForze(){return this.forteContro;}
    public List<Tipo> getResistenti(){return this.resistitoDa;}
    public List<Tipo> getImmuni() { return this.immuneDa; }
	
	private boolean checkSuperefficacia(Tipo tipo) {
		return getForze().contains(tipo);
	}
	
	private boolean checkResistenza(Tipo tipo) {
		return getResistenti().contains(tipo);
	}
	
	private boolean checkImmunita(Tipo tipo) {
		return getImmuni().contains(tipo);
	}
	
	public double calcolaRelazioneTipi(Tipo tipo)
	{
		if (checkSuperefficacia(tipo)) return 2;
		if (checkResistenza(tipo)) return 0.5;
		if (checkImmunita(tipo)) return 0;
		return 1;
	}
		
}

