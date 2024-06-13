package model.costanti;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
	NORMALE(new ArrayList<Tipo>() {{
		
		}}, 
		new ArrayList<Tipo>() {{
	        add(Tipo.ROCCIA);
	        add(Tipo.ACCIAIO);
	    }}, 
		new ArrayList<Tipo>() {{
			add(Tipo.SPETTRO);
		}}),
	
    LOTTA(new ArrayList<Tipo>() {{
    			add(Tipo.NORMALE);
    			add(Tipo.ROCCIA);
    			add(Tipo.ACCIAIO);
    			add(Tipo.GHIACCIO);
    			add(Tipo.BUIO);
    		}}, 
    		new ArrayList<Tipo>() {{
    	        add(Tipo.VOLANTE);
    	        add(Tipo.VELENO);
    	        add(Tipo.COLEOTTERO);
    	        add(Tipo.PSICO);
    	        add(Tipo.FOLLETTO);
    	    }}, 
    		new ArrayList<Tipo>() {{
    			add(Tipo.SPETTRO);
    		}}),
    
    VOLANTE(new ArrayList<Tipo>() {{
			add(Tipo.LOTTA);
			add(Tipo.COLEOTTERO);
			add(Tipo.ERBA);
		}}, 
		new ArrayList<Tipo>() {{
	        add(Tipo.ROCCIA);
	        add(Tipo.ACCIAIO);
	        add(Tipo.ELETTRO);
	    }}, 
		new ArrayList<Tipo>() {{
		}}),
    
    VELENO(new ArrayList<Tipo>() {{
		add(Tipo.ERBA);
		add(Tipo.FOLLETTO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.VELENO);
        add(Tipo.ROCCIA);
        add(Tipo.TERRA);
        add(Tipo.SPETTRO);
    }}, 
	new ArrayList<Tipo>() {{
		add(Tipo.ACCIAIO);
	}}),
    
    TERRA(new ArrayList<Tipo>() {{
		add(Tipo.VELENO);
		add(Tipo.ROCCIA);
		add(Tipo.ACCIAIO);
		add(Tipo.FUOCO);
		add(Tipo.ELETTRO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.COLEOTTERO);
        add(Tipo.ERBA);
    }}, 
	new ArrayList<Tipo>() {{
		add(Tipo.VOLANTE);
	}}),
    
    COLEOTTERO(new ArrayList<Tipo>() {{
		add(Tipo.ERBA);
		add(Tipo.PSICO);
		add(Tipo.BUIO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.LOTTA);
        add(Tipo.VOLANTE);
        add(Tipo.VELENO);
        add(Tipo.SPETTRO);
        add(Tipo.ACCIAIO);
        add(Tipo.FUOCO);
        add(Tipo.FOLLETTO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    SPETTRO(new ArrayList<Tipo>() {{
		add(Tipo.SPETTRO);
		add(Tipo.PSICO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.BUIO);
    }}, 
	new ArrayList<Tipo>() {{
		add(Tipo.NORMALE);
	}}),
    
    ACCIAIO(new ArrayList<Tipo>() {{
		add(Tipo.ROCCIA);
		add(Tipo.GHIACCIO);
		add(Tipo.FOLLETTO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ACCIAIO);
        add(Tipo.FUOCO);
        add(Tipo.ACQUA);
        add(Tipo.ELETTRO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    FUOCO(new ArrayList<Tipo>() {{
		add(Tipo.COLEOTTERO);
		add(Tipo.ACCIAIO);
		add(Tipo.ERBA);
		add(Tipo.GHIACCIO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ACQUA);
        add(Tipo.ROCCIA);
        add(Tipo.FUOCO);
        add(Tipo.DRAGO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    ACQUA(new ArrayList<Tipo>() {{
		add(Tipo.TERRA);
		add(Tipo.ROCCIA);
		add(Tipo.FUOCO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ACQUA);
        add(Tipo.ERBA);
        add(Tipo.DRAGO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    ROCCIA(new ArrayList<Tipo>() {{
		add(Tipo.VOLANTE);
		add(Tipo.COLEOTTERO);
		add(Tipo.FUOCO);
		add(Tipo.GHIACCIO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.LOTTA);
        add(Tipo.TERRA);
        add(Tipo.ACCIAIO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    ERBA(new ArrayList<Tipo>() {{
		add(Tipo.ROCCIA);
		add(Tipo.ACQUA);
		add(Tipo.TERRA);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.VOLANTE);
        add(Tipo.ERBA);
        add(Tipo.COLEOTTERO);
        add(Tipo.ACCIAIO);
        add(Tipo.FUOCO);
        add(Tipo.ERBA);
        add(Tipo.DRAGO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    ELETTRO(new ArrayList<Tipo>() {{
		add(Tipo.VOLANTE);
		add(Tipo.ACQUA);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ERBA);
        add(Tipo.ELETTRO);
        add(Tipo.DRAGO);
    }}, 
	new ArrayList<Tipo>() {{
		add(Tipo.TERRA);
	}}),
    
    PSICO(new ArrayList<Tipo>() {{
		add(Tipo.LOTTA);
		add(Tipo.VELENO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ACCIAIO);
        add(Tipo.PSICO);
    }}, 
	new ArrayList<Tipo>() {{
		add(Tipo.BUIO);
	}}),
    
    GHIACCIO(new ArrayList<Tipo>() {{
		add(Tipo.VOLANTE);
		add(Tipo.TERRA);
		add(Tipo.ERBA);
		add(Tipo.DRAGO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ACCIAIO);
        add(Tipo.FUOCO);
        add(Tipo.ACQUA);
        add(Tipo.GHIACCIO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    DRAGO(new ArrayList<Tipo>() {{
		add(Tipo.DRAGO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.ACCIAIO);
    }}, 
	new ArrayList<Tipo>() {{
		add(Tipo.FOLLETTO);
	}}),
    
    BUIO(new ArrayList<Tipo>() {{
		add(Tipo.SPETTRO);
		add(Tipo.PSICO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.LOTTA);
        add(Tipo.BUIO);
        add(Tipo.FOLLETTO);
    }}, 
	new ArrayList<Tipo>() {{
	}}),
    
    FOLLETTO(new ArrayList<Tipo>() {{
		add(Tipo.LOTTA);
		add(Tipo.DRAGO);
		add(Tipo.BUIO);
	}}, 
	new ArrayList<Tipo>() {{
        add(Tipo.FUOCO);
        add(Tipo.ACCIAIO);
        add(Tipo.VELENO);
    }}, 
	new ArrayList<Tipo>() {{
	}});

    private List<Tipo> forteContro;
    private List<Tipo> resistitoDa;
    private List<Tipo> immuneDa;

    Tipo(List<Tipo> forte, List<Tipo> resistito, List<Tipo> immune) {
        forteContro = forte;
        resistitoDa = resistito;
        immuneDa = immune;
    }
    
    private List<Tipo> getForze(){return this.forteContro;}
    private List<Tipo> getResistenti(){return this.resistitoDa;}
    private List<Tipo> getImmuni() { return this.immuneDa; }
	
	private boolean checkSuperefficacia(Tipo tipo) {
		return (getForze().contains(tipo));
	}
	
	private boolean checkResistenza(Tipo tipo) {
		return getResistenti().contains(tipo);
	}
	
	private boolean checkImmunita(Tipo tipo) {
		return (getImmuni().contains(tipo));
	}
	
	public double calcolaRelazioneTipi(Tipo tipo)
	{
		if (checkSuperefficacia(tipo)) return 2;
		if (checkResistenza(tipo)) return 0.5;
		if (checkImmunita(tipo)) return 0;
		return 1;
	}
		
}

