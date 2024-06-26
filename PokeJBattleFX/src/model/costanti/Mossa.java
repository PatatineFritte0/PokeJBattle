package model.costanti;

/**
 * Enum delle mosse che possono avere i pokemon.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public enum Mossa {
	
	/**
     * E' una mossa che indica la resa dell allenatore
     */
	RESA("RESA", 0, Tipo.NORMALE, Categoria.FISICO, 0, 0, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * E' una mossa che indica che l'allenatore sta cambiando
     */
	CAMBIA("CAMBIA", 0, Tipo.NORMALE, Categoria.FISICO, 0, 0, /*Dati per mosse di stato ->*/null, 0, false),
	
	/**
     * Il pokemon puo usare coleomorso
     */
	COLEOMORSO("Coleomorso", 60, Tipo.COLEOTTERO, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare millebrave
     */
	MILLEBAVE("Millebave", 0, Tipo.COLEOTTERO, Categoria.STATO, 95, 40, /*Dati per mosse di stato ->*/Statistica.VELOCITA, -1, false),
	/**
     * Il pokemon puo usare raffica
     */
	RAFFICA("Raffica", 40, Tipo.VOLANTE, Categoria.SPECIALE, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare rafforzatore
     */
	RAFFORZATORE("Rafforzatore", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, 1, true),
	/**
     * Il pokemon puo usare confusione
     */
	CONFUSIONE("Confusione", 50, Tipo.PSICO, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare botta
     */
	BOTTA("Botta", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare colpokarate
     */
	COLPOKARATE("Colpokarate", 50, Tipo.LOTTA, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare cometapugno
     */
	COMETAPUGNO("Cometapugno", 18, Tipo.NORMALE, Categoria.FISICO, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare doppiasberla
     */
	DOPPIASBERLA("Doppiasberla", 30, Tipo.NORMALE, Categoria.FISICO, 85, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare megapugno
     */
	MEGAPUGNO("Megapugno", 80, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare giornopaga
     */
	GIORNOPAGA("Giornopaga", 40, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fuocopugno
     */
	FUOCOPUGNO("Fuocopugno", 75, Tipo.FUOCO, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare gelopugno
     */
	GELOPUGNO("Gelopugno", 75, Tipo.GHIACCIO, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare tuonopugno
     */
	TUONOPUGNO("Tuonopugno", 75, Tipo.ELETTRO, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ghigliottina
     */
	GHIGLIOTTINA("Ghigliottina", 1000, Tipo.NORMALE, Categoria.FISICO, 10, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ventagliente
     */
	VENTAGLIENTE("Ventagliente", 80, Tipo.VOLANTE, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare danzaspada
     */
	DANZASPADA("Danzaspada", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.ATTACCO, 2, true),
	/**
     * Il pokemon puo usare taglio
     */
	TAGLIO("Taglio", 50, Tipo.NORMALE, Categoria.FISICO, 95, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare attaccodala
     */
	ATTACCODALA("Attacco d'ala", 60, Tipo.VOLANTE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare volo
     */
	VOLO("Volo", 90, Tipo.VOLANTE, Categoria.FISICO, 90, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare pestone
     */
	PESTONE("Pestone", 65, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare doppiocalcio
     */
	DOPPIOCALCIO("Doppiocalcio", 60, Tipo.LOTTA, Categoria.FISICO, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare megacalcio
     */
	MEGACALCIO("Megacalcio", 120, Tipo.LOTTA, Categoria.FISICO, 75, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare calciosalto
     */
	CALCIOSALTO("Calciosalto", 100, Tipo.LOTTA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare calciorullo
     */
	CALCIORULLO("Calciorullo", 60, Tipo.LOTTA, Categoria.FISICO, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare turbosabbia
     */
	TURBOSABBIA("Turbosabbia", 0, Tipo.TERRA, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	/**
     * Il pokemon puo usare bottaintesta
     */
	BOTTAINTESTA("Bottintesta", 70, Tipo.NORMALE, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare incornata
     */
	INCORNATA("Incornata", 65, Tipo.NORMALE, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare perfocorno
     */
	PERFORCORNO("Perforcorno", 1000, Tipo.NORMALE, Categoria.FISICO, 10, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare corposcontro
     */
	CORPOSCONTRO("Corposcontro", 85, Tipo.NORMALE, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare velenospina
     */
	VELENOSPINA("Velenospina", 40, Tipo.VELENO, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare doppioago
     */
	DOPPIOAGO("Doppio Ago", 50, Tipo.COLEOTTERO, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fulminsguardo
     */
	FULMISGUARDO("Fulmisguardo", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, -1, false),
	/**
     * Il pokemon puo usare acido
     */
	ACIDO("Acido", 40, Tipo.VELENO, Categoria.SPECIALE, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare geloraggio
     */
	GELORAGGIO("Geloraggio", 90, Tipo.GHIACCIO, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare bora
     */
	BORA("Bora", 110, Tipo.GHIACCIO, Categoria.SPECIALE, 80, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare psicoraggio
     */
	PSICORAGGIO("Psicoraggio", 65, Tipo.PSICO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare bollaraggio
     */
	BOLLARAGGIO("Bollaraggio", 65, Tipo.ACQUA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare raggioaurora
     */
	RAGGIOAURORA("Raggioaurora", 65, Tipo.GHIACCIO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare iperraggio
     */
	IPERRAGGIO("Iper Raggio", 150, Tipo.NORMALE, Categoria.SPECIALE, 75, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare gigaimpatto
     */
	GIGAIMPATTO("Gigaimpatto", 150, Tipo.NORMALE, Categoria.FISICO, 75, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare beccata
     */
	BECCATA("Beccata", 35, Tipo.VOLANTE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare perforbecco
     */
	PERFORBECCO("Perforbecco", 35, Tipo.VOLANTE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare sottomissione
     */
	SOTTOMISSIONE("Sottomissione", 80, Tipo.LOTTA, Categoria.FISICO, 80, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare forza
     */
	FORZA("Forza", 80, Tipo.NORMALE, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare iradidrago
     */
	IRADIDRAGO("Ira di Drago", 50, Tipo.DRAGO, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare turbofuoco
     */
	TURBOFUOCO("Turbofuoco", 35, Tipo.FUOCO, Categoria.SPECIALE, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare tuonoshock
     */
	TUONOSHOCK("Tuonoshock", 40, Tipo.ELETTRO, Categoria.SPECIALE, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fulmine
     */
	FULMINE("Fulmine", 90, Tipo.ELETTRO, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare tuono
     */
	TUONO("Tuono", 110, Tipo.ELETTRO, Categoria.SPECIALE, 70, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare sassata
     */
	SASSATA("Sassata", 50, Tipo.ROCCIA, Categoria.FISICO, 90, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare terremoto
     */
	TERREMOTO("Terremoto", 100, Tipo.TERRA, Categoria.FISICO, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare abisso
     */
	ABISSO("Abisso", 1000, Tipo.TERRA, Categoria.FISICO, 10, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fossa
     */
	FOSSA("Fossa", 80, Tipo.TERRA, Categoria.FISICO, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare psichico
     */
	PSICHICO("Psichico", 90, Tipo.PSICO, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare meditazione
     */
	MEDITAZIONE("Meditazione", 0, Tipo.PSICO, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ATTACCO, 1, true),
	/**
     * Il pokemon puo usare agilita
     */
	AGILITA("Agilità", 0, Tipo.PSICO, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.VELOCITA, 2, true),
	/**
     * Il pokemon puo usare stridio
     */
	STRIDIO("Stridio", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.DIFESA, -2, false),
	/**
     * Il pokemon puo usare doppioteam
     */
	DOPPIOTEAM("Doppioeam", 0, Tipo.NORMALE, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.ELUSIONE, 1, true),
	/**
     * Il pokemon puo usare mimizzato
     */
	MIMIZZATO("Minimizzato", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ELUSIONE, 2, true),
	/**
     * Il pokemon puo usare leccata
     */
	LECCATA("Leccata", 30, Tipo.SPETTRO, Categoria.FISICO, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare smog
     */
	SMOG("Smog", 30, Tipo.VELENO, Categoria.SPECIALE, 70, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fango
     */
	FANGO("Fango", 65, Tipo.VELENO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ossoClava
     */
	OSSOCLAVA("Ossoclava", 65, Tipo.TERRA, Categoria.FISICO, 85, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fuovobomba
     */
	FUOCOBOMBA("Fuocobomba", 110, Tipo.FUOCO, Categoria.SPECIALE, 85, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare cascata
     */
	CASCATA("Cascata", 80, Tipo.ACQUA, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare tenaglia
     */
	TENAGLIA("Tenaglia", 35, Tipo.ACQUA, Categoria.FISICO, 85, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare comete
     */
	COMETE("Comete", 60, Tipo.NORMALE, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare amnesia
     */
	AMNESIA("Amnesia", 0, Tipo.PSICO, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.DIFESA_SPECIALE, 2, true),
	/**
     * Il pokemon puo usare cinesi
     */
	CINESI("Cinési", 0, Tipo.PSICO, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	/**
     * Il pokemon puo usare sanguisuga
     */
	SANGUISUGA("Sanguisuga", 80, Tipo.COLEOTTERO, Categoria.FISICO, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare aereoattacco
     */
	AEREOATTACCO("Aereoattacco", 140, Tipo.VOLANTE, Categoria.FISICO, 90, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare bolla
     */
	BOLLA("Bolla", 40, Tipo.ACQUA, Categoria.SPECIALE, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare flash
     */
	FLASH("Flash", 0, Tipo.NORMALE, Categoria.STATO, 100, 2, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, true),
	/**
     * Il pokemon puo usare splash
     */
	SPLASH("Splash", 0, Tipo.ACQUA, Categoria.SPECIALE, 100, 40, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare scudoacido
     */
	SCUDOACIDO("Scudo Acido", 0, Tipo.VELENO, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.DIFESA, 2, true),
	/**
     * Il pokemon puo usare martellata
     */
	MARTELLATA("Martellata", 100, Tipo.ACQUA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ossomerang
     */
	OSSOMERANG("Ossomerang", 100, Tipo.TERRA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare frana
     */
	FRANA("Frana", 75, Tipo.ROCCIA, Categoria.FISICO, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare iperzanna
     */
	IPERZANNA("Iperzanna", 80, Tipo.NORMALE, Categoria.FISICO, 90, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare affilatore
     */
	AFFILATORE("Affilatore", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.ATTACCO, 1, true),
	/**
     * Il pokemon puo usare attaccorapido
     */
	ATTACCORAPIDO("Attacco Rapido", 40, Tipo.NORMALE, Categoria.FISICO, 100, 30, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare frustata
     */
	FRUSTATA("Frustata", 45, Tipo.ERBA, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ruggito
     */
	RUGGITO("Ruggito", 0, Tipo.NORMALE, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.ATTACCO, -1, false),
	/**
     * Il pokemon puo usare crescita
     */
	CRESCITA("Crescita", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.ATTACCO_SPECIALE, 1, true),
	/**
     * Il pokemon puo usare semebomba
     */
	SEMEBOMBA("Semebomba", 80, Tipo.ERBA, Categoria.FISICO, 100, 15,/*Dati per mosse di stato ->*/ null, 0, false),
	/**
     * Il pokemon puo usare riduttore
     */
	RIDUTTORE("Riduttore", 90, Tipo.NORMALE, Categoria.FISICO, 85, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare vigorcolpo
     */
	VIGORCOLPO("Vigorcolpo", 120, Tipo.ERBA, Categoria.FISICO, 85, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare foglielama
     */
	FOGLIELAMA("Foglielama", 55, Tipo.ERBA, Categoria.FISICO, 95, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fogliamagica
     */
	FOGLIAMAGICA("Fogliamagica", 60, Tipo.ERBA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare laccioerboso
     */
	LACCIOERBOSO("Laccioerboso", 70, Tipo.ERBA, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare solaraggio
     */
	SOLARAGGIO("Solarraggio", 120, Tipo.ERBA, Categoria.SPECIALE, 100, 8, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare verdebufera
     */
	VERDEBUFERA("Verdebufera", 130, Tipo.ERBA, Categoria.SPECIALE, 90, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare fiortempesta
     */
	FIORTEMPESTA("Fiortempesta", 90, Tipo.ERBA, Categoria.FISICO, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare azione
     */
	AZIONE("Azione", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare colpocoda
     */
	COLPOCODA("Colpocoda", 0, Tipo.NORMALE, Categoria.STATO, 100, 30, /*Dati per mosse di stato ->*/Statistica.DIFESA, -1, false),
	/**
     * Il pokemon puo usare pistolacqua
     */
	PISTOLACQUA("Pistolacqua", 40, Tipo.ACQUA, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ritirata
     */
	RITIRATA("Ritirata", 0, Tipo.ACQUA, Categoria.STATO, 100, 40, /*Dati per mosse di stato ->*/Statistica.DIFESA, 1, true),
	/**
     * Il pokemon puo usare morso
     */
	MORSO("Morso", 60, Tipo.BUIO, Categoria.FISICO, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare idropompa
     */
	IDROPOMPA("Idropompa", 110, Tipo.ACQUA, Categoria.SPECIALE, 80, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare Idropulsar
     */
	IDROPULSAR("Idropulsar", 60, Tipo.ACQUA, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ferroscudo
     */
	FERROSCUDO("Ferroscudo", 0, Tipo.ACCIAIO, Categoria.STATO, 100, 15, /*Dati per mosse di stato ->*/Statistica.DIFESA, 2, true),
	/**
     * Il pokemon puo usare idrondata
     */
	IDRONDATA("Idrondata", 90, Tipo.ACQUA, Categoria.SPECIALE, 90, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ondaschianto
     */
	ONDASCHIANTO("Ondaschianto", 75, Tipo.ACQUA, Categoria.SPECIALE, 100, 10, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare surf
     */
	SURF("Surf", 90, Tipo.ACQUA, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare idropompa
     */
	IDROPOPMA("Idropompa", 110, Tipo.ACQUA, Categoria.SPECIALE, 80, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare graffio
     */
	GRAFFIO("Graffio", 40, Tipo.NORMALE, Categoria.FISICO, 100, 35, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare murodifumo
     */
	MURODIFUMO("Muro di fumo", 0, Tipo.NORMALE, Categoria.STATO, 100, 20, /*Dati per mosse di stato ->*/Statistica.PRECISIONE, -1, false),
	/**
     * Il pokemon puo usare dragospiro
     */
	DRAGOSPIRO("Dragospiro", 60, Tipo.DRAGO, Categoria.SPECIALE, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare rogodenti
     */
	ROGODENTI("Rogodenti", 65, Tipo.FUOCO, Categoria.FISICO, 95, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare lacerazione
     */
	LACERAZIONE("Lacerazione", 70, Tipo.NORMALE, Categoria.FISICO, 100, 20, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare lanciafiamme
     */
	LANCIAFIAMME("Lanciafiamme", 90, Tipo.FUOCO, Categoria.SPECIALE, 100, 15, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare visotruce
     */
	VISOTRUCE("Visotruce", 0, Tipo.NORMALE, Categoria.STATO, 100, 10, /*Dati per mosse di stato ->*/Statistica.VELOCITA, -2, false),
	/**
     * Il pokemon puo usare marchiatura
     */
	MARCHIATURA("Marchiatura", 100, Tipo.FUOCO, Categoria.SPECIALE, 50, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare bracere
     */
	BRACIERE("Braciere", 40, Tipo.FUOCO, Categoria.SPECIALE, 100, 25, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare inferno
     */
	INFERNO("Inferno", 100, Tipo.FUOCO, Categoria.SPECIALE, 50, 5, /*Dati per mosse di stato ->*/null, 0, false),
	/**
     * Il pokemon puo usare ruotafuoco
     */
	RUOTAFUOCO("Ruotafuoco", 35, Tipo.FUOCO, Categoria.SPECIALE, 85, 15, /*Dati per mosse di stato ->*/null, 0, false);
	
	/**
     * 
     */
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
