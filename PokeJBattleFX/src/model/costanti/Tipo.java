package model.costanti;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum degli elementi che mosse e pokemon possono possedere.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public enum Tipo {
	/**
     * L'oggetto e' di tipo normale
     */
	NORMALE,
	/**
     * L'oggetto e' di tipo lotta
     */
    LOTTA,
    /**
     * L'oggetto e' di tipo volante
     */
    VOLANTE,
    /**
     * L'oggetto e' di tipo veleno
     */
    VELENO,
    /**
     * L'oggetto e' di tipo terra
     */
    TERRA,
    /**
     * L'oggetto e' di tipo coleottero
     */
    COLEOTTERO,
    /**
     * L'oggetto e' di tipo spettro
     */
    SPETTRO,
    /**
     * L'oggetto e' di tipo acciaio
     */
    ACCIAIO, 
    /**
     * L'oggetto e' di tipo fuoco
     */
    FUOCO,
    /**
     * L'oggetto e' di tipo acqua
     */
    ACQUA,
    /**
     * L'oggetto e' di tipo roccia
     */
    ROCCIA,
    /**
     * L'oggetto e' di tipo erba
     */
    ERBA,
    /**
     * L'oggetto e' di tipo elettro
     */
    ELETTRO,
    /**
     * L'oggetto e' di tipo psico
     */
    PSICO,
    /**
     * L'oggetto e' di tipo ghiaccio
     */
    GHIACCIO,
    /**
     * L'oggetto e' di tipo drago
     */
    DRAGO,
    /**
     * L'oggetto e' di tipo buio
     */
    BUIO,    
    /**
     * L'oggetto e' di tipo folletto
     */
    FOLLETTO;
	
	/**
     * Costruttore dell'Enum Tipo.
     */
	Tipo() {
		this.forteContro = new ArrayList<>();
		this.resistitoDa = new ArrayList<>();
		this.immuneDa = new ArrayList<>();
	}
	
	/**
     * Indica su quali tipi e' forte il tipo
     */
    private List<Tipo> forteContro;
    /**
     * Indica su quali tipi e' resistente il tipo.
     */
    private List<Tipo> resistitoDa;
    /**
     * Indica su quali tipi e' immune il tipo.
     */
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
    
    /**
     * Metodo che restituisce il valore del campo forteContro.
     * 
     * @return List<Tipo>.
     */
    public List<Tipo> getForze(){return this.forteContro;}
    
    /**
     * Metodo che restituisce il valore del campo resistitoDa.
     * 
     * @return List<Tipo>.
     */
    public List<Tipo> getResistenti(){return this.resistitoDa;}
    
    /**
     * Metodo che restituisce il valore del campo immuneDa.
     * 
     * @return List<Tipo>.
     */
    public List<Tipo> getImmuni() { return this.immuneDa; }
	
    
    /**
     * Metodo che controlla se il tipo e' superefficace
     * contro un altro tipo.
     * 
     * @param tipo Tipo
     * @return boolean.
     */
    public boolean checkSuperefficacia(Tipo tipo) {
		return getForze().contains(tipo);
	}
	
    /**
     * Metodo che controlla se il tipo e' resistente
     * contro un altro tipo.
     * 
     * @param tipo Tipo
     * @return boolean.
     */
    public boolean checkResistenza(Tipo tipo) {
		return getResistenti().contains(tipo);
	}
	
    /**
     * Metodo che controlla se il tipo e' immune
     * contro un altro tipo.
     * 
     * @param tipo Tipo
     * @return boolean.
     */
    public boolean checkImmunita(Tipo tipo) {
		return getImmuni().contains(tipo);
	}
    
    /**
     * Metodo che relazione ha un tipo rispetto ad un altro
     * ritornando dei valori 0, 0.5, 2
     * 
     * @param tipo Tipo
     * @return double.
     */
	public double calcolaRelazioneTipi(Tipo tipo)
	{
		if (checkSuperefficacia(tipo)) return 2;
		if (checkResistenza(tipo)) return 0.5;
		if (checkImmunita(tipo)) return 0;
		return 1;
	}
		
}

