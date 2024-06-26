package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Allenatore;
import model.Pokemon;
import model.UsableMove;
import model.SaveManager;
import model.costanti.Categoria;
import model.costanti.Mossa;
import model.costanti.Tipo;

/**
 * Classe controller della battaglia che ha il compito di gestire
 * tutta l'interfaccia della battaglia.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerBattleInterface {
	
	/**
	 * Anchor pane principale dell interfaccia
	 */
	@FXML
	protected AnchorPane battleAnchor;
	
	/**
	 * Allenatore P1
	 */
	protected Allenatore allenatore;
	/**
	 * scelta della mossa P1
	 */
	protected Mossa m1;
	/**
	 * index di cambio pokemon di P1
	 */
	protected int indexCambioAllenatore;
	/**
	 * counter dei pokemon ancora in vita
	 */
	protected AtomicInteger countAllenatore;
	
	
	/**
	 * Allenatore P2
	 */
	protected Allenatore sfidante;
	/**
	 * scelta della mossa P2
	 */
	protected Mossa m2;
	/**
	 * index di cambio pokemon di P2
	 */
	protected int indexCambioSfidante;
	/**
	 * counter dei pokemon ancora in vita di P2
	 */
	protected AtomicInteger countSfidante;
	
	/**
	 * log del turno
	 */
	protected String log = "";
	

	/**
	 * Inizializzo il campo di battaglia con gli sfidanti
	 * 
	 * @return void.
	 */
	@FXML
	public void initialize() {
		Platform.runLater(()->{
			this.allenatore.setMainPokemon(0);
			this.countAllenatore = new AtomicInteger(contaPkmn(allenatore));
			
			this.sfidante.setMainPokemon(0);
			this.countSfidante = new AtomicInteger(contaPkmn(sfidante));
			
			caricaAllenatore(allenatore, "P1");
			caricaAllenatore(sfidante, "P2");
			
			aggiornaTurno(allenatore.getMainPokemon(), "P1");
		});
	}
	
	
	/**
	 * Inizializzo la barra del nickname del giocatore
	 *
	 * @param allenatore Allenatore contiene le informazioni da inserire nei campi.
	 * @param player String contiene l'id del giocatore selezionato.
	 * @return void.
	 */
	protected void caricaAllenatore(Allenatore allenatore, String player){
		Pane p = (Pane) battleAnchor.lookup("#"+player);
		((Label)p.lookup("#nicknamePlayer")).setText(allenatore.getNickname());
		
		aggiornaStatPokemon(allenatore, player);
	}
	
	/**
	 * Aggiorna le statistiche del pokemon selezionato
	 *
	 * @param allenatore Allenatore contiene il pokemon da aggiornare.
	 * @param player String contiene l'id del giocatore selezionato.
	 * @return void.
	 */
	protected void aggiornaStatPokemon(Allenatore allenatore, String player) {
		String verso;
		if(player.equals("P1")) {
			verso = "Back";
		}else if(player.equals("P2")) {
			verso = "Front";
		}else {
			System.out.println("ERR");
			return;
		}
		
		Pokemon main = allenatore.getMainPokemon();
		
		Pane p = (Pane) battleAnchor.lookup("#"+player);
		
		for(int i = 0; i<6; i++) {
			if(allenatore.getPokemonById(i) != null) {
				if(allenatore.getPokemonById(i).getBattlePs() <= 0) {
					p.lookup("#poke"+i).setStyle("-fx-background-image: url(./view/img/esausto.png);");
				}else {
					p.lookup("#poke"+i).setStyle("-fx-background-image: url(./view/img/pokeball.png);");
				}
			}
		}
		
		
		p.lookup("#imgPokemon").setStyle("-fx-background-image: url(./view/img/"+main.getNome().toLowerCase()+verso+".png);");
		
		((Label)p.lookup("#nomePokemon")).setText(main.getNome());
		((Label)p.lookup("#lvlPokemon")).setText(String.valueOf(main.getLvl()));
		((Label)p.lookup("#currentHP")).setText(String.valueOf(main.getBattlePs()));
		((Label)p.lookup("#maxHP")).setText(String.valueOf(main.getMaxPs()));
		
		ProgressBar barHp = ((ProgressBar)p.lookup("#progresHPPokemon"));
		double progressHp = Double.valueOf(main.getBattlePs())/Double.valueOf(main.getMaxPs());
		double currentHp = barHp.getProgress();
		
		animateProgressBar(barHp, currentHp, progressHp, 1);
		
		String color = "green";
		if(progressHp > 0.5) color = "green";
		if(progressHp <= 0.5 && progressHp >= 0.2 ) color = "orange";
		if(progressHp < 0.2) color = "red";
		barHp.setStyle("-fx-accent: "+color);
		
		ProgressBar barExp = ((ProgressBar)p.lookup("#progresExpPokemon"));
		double progressExp = Double.valueOf(main.getCurrentExp())/Double.valueOf(main.getNextLvlExp());
		double currentExp = barExp.getProgress();
		
		animateProgressBar(barExp, currentExp, progressExp, 0.5);
	}
	
	
	/**
	 * Un metodo utile per l'animazione della progressbar per evitare l'effetto istantaneo
	 *
	 * @param progressBar ProgressBar contiene l'oggetto ProgressBar da aggiornare.
	 * @param fromValue double contiene il valore iniziale della PB.
	 * @param toValue double contiene il valore finale della PB.
	 * @param durationInSeconds double sarebbe in quanto tempo l'animazione va al suo termine.
	 * @return void.
	 */
	protected void animateProgressBar(ProgressBar progressBar, double fromValue, double toValue, double durationInSeconds) {
        progressBar.setProgress(fromValue);
        KeyValue keyValue = new KeyValue(progressBar.progressProperty(), toValue);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(durationInSeconds), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }
	
	protected void aggiornaTurno(Pokemon poke, String player){
		
		Pane activePlayerPane = (Pane)battleAnchor.lookup(".active");
		if(activePlayerPane != null) {
			activePlayerPane.getStyleClass().remove("active");
			Pane statAllenActive = (Pane) activePlayerPane.lookup("#statAllen");
			statAllenActive.getStyleClass().remove("statPartitaActive");
			statAllenActive.getStyleClass().add("statPartita");
		}
		
		Pane playerPane = (Pane) battleAnchor.lookup("#inf"+player);
		Pane statAllen = (Pane) playerPane.lookup("#statAllen");
		statAllen.getStyleClass().remove("statPartita");
		statAllen.getStyleClass().add("statPartitaActive");
		playerPane.getStyleClass().add("active");
		
		Pane paneInf = (Pane)battleAnchor.lookup("#inf");
		for(int i = 0; i<4; i++) {
			Pane paneMossa = (Pane) paneInf.lookup("#mossa"+String.valueOf(i));
			UsableMove usableMossa = poke.getMosse()[i];
			if(usableMossa != null) {
				Mossa mossa = usableMossa.getMossa();
				
				String tipo =  mossa.getTipo().name().toLowerCase();
				
				paneMossa.setStyle("-fx-background-image: url(\"./view/img/"+tipo+".png\");");
				
				if(player.equals("P1"))
					paneMossa.setOnMouseClicked(this::sceltaP1);
				else
					paneMossa.setOnMouseClicked(arg0 -> {
						sceltaP2(arg0);
					});
				
				((Label)paneMossa.lookup("#nameMossa")).setText(mossa.getNome());
				((Label)paneMossa.lookup("#mosseDisponibili")).setText(String.valueOf(usableMossa.getPp()));
				((Label)paneMossa.lookup("#mosseMax")).setText(String.valueOf(usableMossa.getPpMax()));
			}else {
				
				paneMossa.setStyle("-fx-background-image: url(\"./view/img/"+"noType"+".png\");");
				paneMossa.setOnMouseClicked(null);
				
				((Label)paneMossa.lookup("#nameMossa")).setText("");
				((Label)paneMossa.lookup("#mosseDisponibili")).setText("");
				((Label)paneMossa.lookup("#mosseMax")).setText("");
			}
		}
	}
	
	/**
	 * Quando fa la scelta il P1, viene chiamato questo metodo
	 * passa le informazioni utili alla classe e cede il turno al prossimo player
	 *
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void
	 */
	protected void sceltaP1(MouseEvent event) {
		Object source = event.getTarget();
		Pane pane = null;
		if (source instanceof Pane) {
			pane = (Pane) source;
        }else if (source instanceof Text){
        	pane = (Pane) ((Text) source).getParent().getParent();
        }else {
        	pane = (Pane) ((Label) source).getParent();
        }
		
		UsableMove mossa = allenatore.getMainPokemon().getMosse()[Integer.valueOf(String.valueOf( pane.getId().charAt(pane.getId().length() - 1)))];
		if(mossa.getPp() == 0) return;
		this.m1 = mossa.getMossa();
		
		
		aggiornaTurno(sfidante.getMainPokemon(), "P2");
	}
	
	/**
	 * Quando fa la scelta il P2, viene chiamato questo metodo
	 * passa le informazioni utili alla classe e viene fatto il calcolo del turno
	 *
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void
	 */
	protected void sceltaP2(MouseEvent event){
		Object source = event.getTarget();
		Pane pane = null;
		if (source instanceof Pane) {
			pane = (Pane) source;
        }else if (source instanceof Text){
        	pane = (Pane) ((Text) source).getParent().getParent();
        }else {
        	pane = (Pane) ((Label) source).getParent();
        }
		
		UsableMove mossa = sfidante.getMainPokemon().getMosse()[Integer.valueOf(String.valueOf( pane.getId().charAt(pane.getId().length() - 1)))];
		if(mossa.getPp() == 0) return;
		this.m2 = mossa.getMossa();
		
		try {
			turno();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
		aggiornaTurno(allenatore.getMainPokemon(), "P1");
	}
	
	/**
	 * Quando il player vuole cambiare pokemon in campo viene chiamato questo metodo
	 * che una volta scelto il pokemon da cambiare fa finire il turno.
	 *
	 * @param event MouseEvent ci sono informazioni utili correlate all evento.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void mossaCambia(MouseEvent event) throws IOException {
		Pane activePlayerPane = (Pane)battleAnchor.lookup(".active");
		
		String player = activePlayerPane.getParent().getId();
		
		if(player.equals("P1")) {
			m1 = Mossa.CAMBIA;
			sostituisciPkmn(allenatore, false);
			if(indexCambioAllenatore != allenatore.getPokemonId(allenatore.getMainPokemon())) {
				aggiornaTurno(sfidante.getMainPokemon(), "P2");
			}
		}else if(player.equals("P2")) {
			m2 = Mossa.CAMBIA;
			sostituisciPkmn(sfidante, false);
			
			if(indexCambioSfidante != sfidante.getPokemonId(sfidante.getMainPokemon())) {
				aggiornaTurno(allenatore.getMainPokemon(), "P1");
				try {
					turno();
				} catch (InterruptedException | IOException e) {e.printStackTrace();}
			}
		}
		
	}
	
	/**
	 * questo metodo controlla se il main pokemon dell allenatore deve imparare qualche mossa o no,
	 * quando deve imparare qualcosa appare una schermata di scelta delle mosse
	 *
	 * @param trainer Allenatore contiene il pokemon in campo.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void learnMove(Allenatore trainer) {
		Pokemon poke = trainer.getMainPokemon();
		Mossa m = null;
		if(poke.getParcoMosse() == null) {return;}

		ArrayList<Integer> salvaChiavi = new ArrayList();
		
		for (int key : poke.getParcoMosse().keySet()) {
			
			if(Arrays.asList(poke.getMoveSet()).contains(poke.getParcoMosse().get(key))) {
				salvaChiavi.add(key);
				continue;
			}
			
			if(key <= poke.getLvl()) {
				m = poke.getParcoMosse().get(key);
				
				if(Arrays.asList(poke.getMoveSet()).contains(null) && !Arrays.asList(poke.getMoveSet()).contains(m)) {
					poke.getMosse()[Arrays.asList(poke.getMoveSet()).indexOf(null)] = new UsableMove(m);
					this.log += "\n il pokemon "+poke.getNome()+" di "+trainer.getNickname()+" ha imparato "+m.name()+"\n";
					salvaChiavi.add(key);
				} else {
					
					AtomicInteger index = new AtomicInteger();
					index.set(5);
					try {
						sceltaMosse(trainer, index, m);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.print(index.get());
					
					if(index.get() >= 0 && index.get() <=3) {
						this.log += "\n il pokemon "+poke.getNome()+" di "+trainer.getNickname()+" ha imparato "+m.name()+" al posto di "+poke.getMosse()[index.get()].getMossa().name()+"\n";
						poke.getMosse()[index.get()] = new UsableMove(m);
					}
					salvaChiavi.add(key);
				}
			}
		}
		
		for(int key: salvaChiavi) {
			poke.getParcoMosse().remove(key);
		}
	}
	
	/**
	 * questo metodo apre la schermata della scelta delle mosse
	 *
	 * @param trainer Allenatore contiene il pokemon in campo.
	 * @param index AtomicInteger e' l'indice della mossa da dimenticare.
	 * @param mossa Mossa contine la mossa che deve imparare.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void sceltaMosse(Allenatore trainer, AtomicInteger index, Mossa m) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/apprendimentoMosse.fxml"));
		
		Stage owner = (Stage)(battleAnchor.getScene().getWindow());
		
		Scene scene;
		scene = new Scene(root.load());
	
		ControllerApprendimentoMosse controller = root.getController();
		
		controller.setControllerOwner(this);
		controller.setPokemon(trainer.getMainPokemon());
		controller.setIndex(index);
		controller.setMossa(m);
		
		Stage pkmn = new Stage();
		pkmn.setScene(scene);
		
		Image icon = new Image("./view/img/pokeIcon2.PNG");
		pkmn.getIcons().add(icon);
		pkmn.setTitle("il "+ trainer.getMainPokemon().getNome() +" di "+ trainer.getNickname() +" Vuole imparare una nuova mossa");
		
		pkmn.setResizable(false);
		pkmn.initModality(Modality.APPLICATION_MODAL);
		pkmn.setOnCloseRequest(event ->{
			 // Intercetta l'evento di chiusura
            event.consume();

            // Mostra un messaggio all'utente
            Alert alert = new Alert(AlertType.INFORMATION);
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
            alert.setTitle("Attenzione");
            alert.setHeaderText("Chiusura disabilitata");
            alert.setContentText("La chiusura della finestra è disabilitata. Scegli prima una mossa");
            alert.showAndWait();
		});
		
		pkmn.initOwner(owner);
		
		pkmn.showAndWait();
	}
	
	/**
	 * questo metodo controlla se i pokemon della squadra dell allenatore si devono evolvere o meno
	 *
	 * @param trainer Allenatore contiene il pokemon in campo.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void controlloEvoluzioni(Allenatore trainer) throws IOException {
		for(Pokemon poke: trainer.getSquadra()) {
			if(poke != null) {
				if(poke.isTryToEvolv()) {
					poke.setTryToEvolv(false);
					richiestaEvo(trainer, poke);
				}
			}
		}
	}
	
	/**
	 * questo metodo apre la schermata della richiesta delle evoluzioni
	 *
	 * @param trainer Allenatore contiene delle informazioni utili.
	 * @param poke Pokemon contiene il pokemon da evolvere
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void richiestaEvo(Allenatore trainer, Pokemon poke) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/evoluzione.fxml"));
		
		Stage owner = (Stage)(battleAnchor.getScene().getWindow());
		
		Scene scene;
		scene = new Scene(root.load());
	
		ControllerEvoluzione controller = root.getController();
		
		controller.setPokemon(poke);
		
		Stage pkmn = new Stage();
		pkmn.setScene(scene);
		
		Image icon = new Image("./view/img/pokeIcon2.PNG");
		pkmn.getIcons().add(icon);
		pkmn.setTitle("il "+ trainer.getMainPokemon().getNome() +" di "+ trainer.getNickname() +" si sta evolvendo!");
		
		pkmn.setResizable(false);
		pkmn.initModality(Modality.APPLICATION_MODAL);
		pkmn.setOnCloseRequest(event ->{
			 // Intercetta l'evento di chiusura
            event.consume();

            // Mostra un messaggio all'utente
            Alert alert = new Alert(AlertType.INFORMATION);
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
            alert.setTitle("Attenzione");
            alert.setHeaderText("Chiusura disabilitata");
            alert.setContentText("La chiusura della finestra è disabilitata. Scegli prima un opzione");
            alert.showAndWait();
		});
		
		pkmn.initOwner(owner);
		
		pkmn.showAndWait();
	}
	
	
	/**
	 * Questo metodo viene chiamato da interfaccia e capisce chi si arrende e 
	 * aggiorna i campi utili a capire chi ha fatto la resa nel calcolo del turno.
	 *
	 * @return void.
	 */
	public void resa() {
		Pane activePlayerPane = (Pane)battleAnchor.lookup(".active");
		
		String player = activePlayerPane.getParent().getId();
		
		if(player.equals("P1")) {
			m1 = Mossa.RESA;
			aggiornaTurno(sfidante.getMainPokemon(), "P2");
		}else if(player.equals("P2")) {
			m2 = Mossa.RESA;
			aggiornaTurno(allenatore.getMainPokemon(), "P1");
			try {
				turno();
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * questo metodo esegue il turno
	 * 
	 * Fa scontrare i pokemon, controlla se hanno imparato nuove mosse per possibili
	 * lvlup, aggiorna le stats dei pokemon, controlla se qualcuno e' il vincitore della partita,
	 * salva i progressi ogni fine partita, resetta lo stato delle squadre ogni fine partita,
	 * controlla le evoluzioni e fa tornare alla schermata principale se la best of three e' finita.
	 * 
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 * @throws InterruptedException da errore nel caso in cui lo sleep non funzioni correttamente.
	 */
	public void turno() throws InterruptedException, IOException {
		iniziaTurno();
		
		learnMove(allenatore);
		learnMove(sfidante);
		
		((TextArea)battleAnchor.lookup("#log")).setText(this.log);
		this.log = "";
		
		aggiornaStatPokemon(allenatore, "P1");
		aggiornaStatPokemon(sfidante, "P2");
		
		Allenatore vincitore = checkVincitore();
		if(vincitore != null) {
			Thread.sleep(1000);
			Pane winnerPane;
			Allenatore allePerdente;
			if(vincitore == allenatore) {
				winnerPane = (Pane)(battleAnchor.lookup("#P1"));
				allePerdente = sfidante;
			}else {
				winnerPane = (Pane)(battleAnchor.lookup("#P2"));
				allePerdente = allenatore;
			}
			
			Label nVittorie = (Label)winnerPane.lookup("#nVittorie");
			nVittorie.setText(String.valueOf(Integer.valueOf(nVittorie.getText()) + 1));
			
			for(int i = 0; i<6; i++) {
				Pokemon pkmn = allenatore.getPokemonById(i);
				if(pkmn != null) {
					pkmn.resetStats();				
				}
				pkmn = sfidante.getPokemonById(i);
				if(pkmn != null) {
					pkmn.resetStats();
					//pkmn.evolve();				
				}
			}
			
			controlloEvoluzioni(allenatore);
			controlloEvoluzioni(sfidante);
			
			allenatore.setMainPokemon(0);
			sfidante.setMainPokemon(0);
			
			if(Integer.valueOf(nVittorie.getText()) == 2) {
				vincitore.setVittorie(vincitore.getVittorie() + 1);
				allePerdente.setSconfitte(allePerdente.getSconfitte() + 1);
				
				Alert alert = new Alert(AlertType.INFORMATION);
				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
	            alert.setTitle("Vittoria");
	            alert.setHeaderText("Vittoria per "+ vincitore.getNickname());
	            alert.setContentText("Procedo a caricare la schermata di titolo");
	            
	            alert.setOnCloseRequest(menuPrincipale());
	            
	            alert.showAndWait();
			}
			
			SaveManager.save(allenatore);
			SaveManager.save(sfidante);
			
		}else {
			if(allenatore.getMainPokemon().getBattlePs() == 0) {
				sostituisciPkmn(allenatore, true);
			}
			if(sfidante.getMainPokemon().getBattlePs() == 0) {
				sostituisciPkmn(sfidante, true);
			}
		}
		
		aggiornaStatPokemon(allenatore, "P1");
		aggiornaStatPokemon(sfidante, "P2");
		
		aggiornaTurno(allenatore.getMainPokemon(), "P1");
	}
	
	
	/**
	 * fa tornare al menu principale
	 * 
	 * @return EventHandler<DialogEvent>
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public EventHandler<DialogEvent> menuPrincipale() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
		
		Stage stage = (Stage)battleAnchor.getScene().getWindow();
		
		Scene scene = new Scene(root,1000,800);
		stage.setScene(scene);
		stage.show();
		return null;
	}
	
	
	/**
	 * Questo metodo apre la schermata di sostituzione dei pokemon
	 *
	 * @param trainer Allenatore contiene delle informazioni utili per l'interfaccia.
	 * @param disableClose boolean contiene una booleana che indica se bisogna disabilitare la chiusura della finestra o meno
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void sostituisciPkmn(Allenatore trainer, boolean disableClose) throws IOException{
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/squadra.fxml"));
		
		Stage owner = (Stage)(battleAnchor.getScene().getWindow());
		
		Scene scene;
		scene = new Scene(root.load());
	
		ControllerSquadra controller = root.getController();
		
		
		controller.setControllerOwner(this);
		controller.setAllenatore(trainer);
		
		Stage pkmn = new Stage();
		pkmn.setScene(scene);
		
		Image icon = new Image("./view/img/pokeIcon2.PNG");
		pkmn.getIcons().add(icon);
		pkmn.setTitle("Sostituisci Pokemon");
		
		pkmn.setResizable(false);
		pkmn.initModality(Modality.APPLICATION_MODAL);
		if (disableClose) {
			pkmn.setOnCloseRequest(event ->{
				 // Intercetta l'evento di chiusura
	            event.consume();
	
	            // Mostra un messaggio all'utente
	            Alert alert = new Alert(AlertType.INFORMATION);
	            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
	            alert.setTitle("Attenzione");
	            alert.setHeaderText("Chiusura disabilitata");
	            alert.setContentText("La chiusura della finestra è disabilitata. Scegli prima un pokemon");
	            alert.showAndWait();
			});
		}
		
		pkmn.initOwner(owner);
		
		pkmn.showAndWait();
	}
	
	// turno -----------------------------------------------------------------------------
	
	
	/**
	 * In questo metodo considera tutte le possibili scelte che hanno fatto i giocatori
	 * a seconda di queste agira di conseguenza, qui vengono anche scritti i log.
	 *
	 * @return void.
	 */
	public void iniziaTurno() {
		this.log += "\n-----\nInizio turno: [" + this.allenatore.getNickname() + ":" + this.countAllenatore + ", " + this.sfidante.getNickname() + ":" + this.countSfidante + "]\n";

		int danno = 0;
		
		if(this.m1 == Mossa.RESA) {
			this.countAllenatore.set(0);
			this.log += "\nRESA di " + this.allenatore.getNickname();
			return;
		}
		if(this.m2 == Mossa.RESA) {
			this.countSfidante.set(0);
			this.log += "\nRESA di " + this.sfidante.getNickname();
			return;
		}
		
		if(this.m1 == Mossa.CAMBIA && this.m2 != Mossa.CAMBIA) {
			Pokemon p = this.allenatore.getMainPokemon();
			this.allenatore.setMainPokemon(indexCambioAllenatore);
			this.log += "\n"+ allenatore.getNickname() + " sostituisce " + p.getNome() + " con " + allenatore.getMainPokemon().getNome()+"\n";
			
			scontro(this.sfidante, this.allenatore, m2);
			
			if(this.allenatore.getMainPokemon().getBattlePs() < 0) {
				this.allenatore.getMainPokemon().setBattlePs(0);
				
				this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
				esausto(this.allenatore, this.countAllenatore);
			}
			
		} else if(this.m1 != Mossa.CAMBIA && this.m2 == Mossa.CAMBIA) {
			Pokemon p = this.sfidante.getMainPokemon();
			this.sfidante.setMainPokemon(indexCambioSfidante);
			this.log += "\n"+ sfidante.getNickname() + " sostituisce " + p.getNome() + " con " + sfidante.getMainPokemon().getNome()+"\n";
			
			scontro(this.allenatore, this.sfidante, this.m1);
			
			if(this.sfidante.getMainPokemon().getBattlePs() < 0) {
				this.sfidante.getMainPokemon().setBattlePs(0);
				
				this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
				esausto(this.sfidante, this.countSfidante);
			}
		}else if(this.m1 == Mossa.CAMBIA && this.m2 == Mossa.CAMBIA) {
			Pokemon p = this.allenatore.getMainPokemon();
			this.allenatore.setMainPokemon(indexCambioAllenatore);
			this.log += "\n"+ allenatore.getNickname() + " sostituisce " + p.getNome() + " con " + allenatore.getMainPokemon().getNome()+"\n";
			
			p = this.sfidante.getMainPokemon();
			this.sfidante.setMainPokemon(indexCambioSfidante);
			this.log += "\n"+ sfidante.getNickname() + " sostituisce " + p.getNome() + " con " + sfidante.getMainPokemon().getNome()+"\n";
			
		}else {
			if(this.allenatore.getMainPokemon().getVelocitaBattaglia() >= this.sfidante.getMainPokemon().getVelocitaBattaglia()) {
				scontro(this.allenatore, this.sfidante, this.m1);
				
				if(this.sfidante.getMainPokemon().getBattlePs() > 0) {
					scontro(this.sfidante, this.allenatore, this.m2);
					
					if(this.allenatore.getMainPokemon().getBattlePs() <= 0) {
						this.allenatore.getMainPokemon().setBattlePs(0);
						
						this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
						esausto(this.allenatore, this.countAllenatore);
					}
				} else {
					this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
					
					this.sfidante.getMainPokemon().setBattlePs(0);
					esausto(this.sfidante, this.countSfidante);
				}
				
			} else {
				scontro(this.sfidante, this.allenatore, this.m2);
				
				if(this.allenatore.getMainPokemon().getBattlePs() > 0) {
					scontro(this.allenatore, this.sfidante, this.m1);
					
					if(this.sfidante.getMainPokemon().getBattlePs() <= 0) {
						this.sfidante.getMainPokemon().setBattlePs(0);
						
						this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
						esausto(this.sfidante, this.countSfidante);
					}
				} else {
					this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
					
					this.allenatore.getMainPokemon().setBattlePs(0);
					esausto(this.allenatore, this.countAllenatore);
				}
			}
		}
		//System.out.println(this.allenatore.getMainPokemon().battleData() + "\n\n" + this.sfidante.getMainPokemon().battleData());
		
		this.log += "\nFine turno: [" + this.allenatore.getNickname() + ":" + this.countAllenatore + ", " + this.sfidante.getNickname() + ":" + this.countSfidante + "]\n-----\n\n";
		return;
	}
	
	
	/**
	 * questo metodo c'e' la logica di scontro tra due pokemon
	 *
	 * @param attaccante Allenatore allenatore che attacca.
	 * @param ricevente Allenatore allenatore che riceve il colpo.
	 * @param attacco Mossa e' la mossa con cui l'attaccante attacca il ricevente.
	 * @return void.
	 */
	protected void scontro(Allenatore attaccante, Allenatore ricevente, Mossa attacco) {
		
		AtomicBoolean isCrit = new AtomicBoolean();
		isCrit.set(false);
		AtomicBoolean isMiss = new AtomicBoolean();
		isMiss.set(false);
		
		int danno = attaccante.getMainPokemon().attacca(ricevente.getMainPokemon(), attacco, isCrit, isMiss);
		if(isMiss.get()) {
			//System.out.println("/n L'attacco non e' andato a segno!");
			this.log += "\n L'attacco di "+ attaccante.getMainPokemon().getNome() +" non e' andato a segno! \n";
			return;
		}
		
		
		ricevente.getMainPokemon().incassa(danno);
		if(attacco.getCategoria() == Categoria.STATO) {
			if(attacco.getOnSelf()) {
				if(attacco.getLvlBoostNerf() > 0) {
					//System.out.println("\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + attaccante.getMainPokemon().getNome() + " aumenta!\n");
					this.log += "\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + attaccante.getMainPokemon().getNome() + " aumenta!\n";
				} else {
					//System.out.println("\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + attaccante.getMainPokemon().getNome() + " diminuisce!\n");
					this.log += "\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + attaccante.getMainPokemon().getNome() + " diminuisce!\n";
				}
			} else {
				if(attacco.getLvlBoostNerf() > 0) {
					//System.out.println("\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + ricevente.getMainPokemon().getNome() + " aumenta!\n");
					this.log += "\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + ricevente.getMainPokemon().getNome() + " aumenta!\n";
				} else {
					//System.out.println("\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + ricevente.getMainPokemon().getNome() + " diminuisce!\n");
					this.log += "\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + attacco.getStatBoostNerf().name() + " di " + ricevente.getMainPokemon().getNome() + " diminuisce!\n";
				}
			}
		} else {			
			//System.out.println("\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + ricevente.getMainPokemon().getNome() + " subisce " + danno + " danni!\n");
			this.log += "\n" + attaccante.getMainPokemon().getNome() + " usa " + attacco + "! " + ricevente.getMainPokemon().getNome() + " subisce " + danno + " danni!\n";
			
			Tipo tipo1 = ricevente.getMainPokemon().getTipi()[0];
			Tipo tipo2 = ricevente.getMainPokemon().getTipi()[1];
			
			double s1 = attacco.getTipo().calcolaRelazioneTipi(tipo1);
			double s2 = attacco.getTipo().calcolaRelazioneTipi(tipo2);
			double superefficacia = s1 * s2;
			
			if(superefficacia == 0.0) {
				//System.out.println("\n" + ricevente.getMainPokemon().getNome() + " e' immune! \n");
				this.log += "" + ricevente.getMainPokemon().getNome() + " e' immune! \n";
			}
			else if(superefficacia == 0.25) {
				//System.out.println("\n Non e' per niente efficace! \n");
				this.log += "Non e' per niente efficace! \n";
			}
			else if(superefficacia == 0.5) {
				//System.out.println("\n E' poco efficace! \n");
				this.log += "E' poco efficace! \n";
			}
			else if(superefficacia == 2) {
				//System.out.println("\n E' superefficace! \n");
				this.log += "E' superefficace! \n";
			}	
			
			if(isCrit.get()) {
				//System.out.println("\n E' un colpo critico! ");
				this.log += "E' un colpo critico! \n";
			}
		}
	}
	
	/**
	 * Questo metodo ha il compito di gestire un pokemon esausto facendolo cambiare poi
	 * all'allenatore
	 *
	 * @param trainer Allenatore contiene l'allenatore a cui il pokemon e' esausto
	 * @param count AtomicInteger indica il counter dei pokemon rimanenti all'allenatore.
	 * @return void.
	 */
	protected void esausto(Allenatore trainer, AtomicInteger count) {
		//System.out.println("\n" + trainer.getMainPokemon().getNome() + " e' esausto");
		count.set(count.get()-1);
		if(count.get() <= 0) {return;}
		this.log += "\n" + trainer.getMainPokemon().getNome() + " di " + trainer.getNickname() + " e' esausto!\n";
		String player = null;
		if(trainer == allenatore) { player = "P1"; }
		else if(trainer == sfidante){ player = "P2"; }
		
		aggiornaStatPokemon(trainer, player);
		
		try {
			sostituisciPkmn(trainer, true);
		} catch (IOException e) {e.printStackTrace();}
		
		Pokemon p = trainer.getMainPokemon();
		
		int index = 6;
		if(trainer == allenatore) { index = indexCambioAllenatore; }
		else if(trainer == sfidante){ index = indexCambioSfidante; }
		
		trainer.setMainPokemon(index);
		this.log += "\n"+ trainer.getNickname() + " sostituisce " + p.getNome() + " con " + trainer.getMainPokemon().getNome()+"\n";
	}
	// turno-------------------------------------------------------
	
	// partita-------------------------------------------------------
	
	/**
	 * Questo metodo ha il compito di contare i pokemon dell'allenatore
	 *
	 * @param trainer Allenatore contiene la squadra
	 * @return void.
	 */
	protected int contaPkmn(Allenatore t) {
		int pkmn = 0;
		
		Pokemon[] squadraAll = t.getSquadra();
		for(Pokemon poke: squadraAll) {
			pkmn += (poke != null) ? 1 : 0;
		}
		return pkmn;
	}
	
	
	/**
	 * Questo metodo ha il compito di capire se c'e' un vincitore
	 *
	 * @return Allenatore chi ha vinto.
	 */
	public Allenatore checkVincitore() {
		if(this.countAllenatore.get() <= 0) {
			this.countAllenatore.set(contaPkmn(allenatore));
			return this.sfidante;
		}
		if(this.countSfidante.get()  <= 0) {
			this.countSfidante.set(contaPkmn(sfidante));
			return this.allenatore;
		}
		return null;
	}
	
	/**
	 * Questo metodo ritorna l'allenatore
	 *
	 * @return Allenatore.
	 */
	public Allenatore getAllenatore() {return allenatore;}
	
	/**
	 * Questo metodo setta il valore di allenatore
	 *
	 * @param allenatore Allenatore contiene il nuovo valore di allenatore
	 * @return void.
	 */
	public void setAllenatore(Allenatore allenatore) {this.allenatore = allenatore;}
	
	/**
	 * Questo metodo ritorna l'index di cambio dell'allenatore
	 *
	 * @return int.
	 */
	public int getIndexCambioAllenatore() {return indexCambioAllenatore;}
	
	/**
	 * Questo metodo setta il valore di indexCambioAllenatore
	 *
	 * @param indexCambioAllenatore int contiene il nuovo valore dell indexCambioAllenatore
	 * @return void.
	 */
	public void setIndexCambioAllenatore(int indexCambioAllenatore) {this.indexCambioAllenatore = indexCambioAllenatore;}
	
	/**
	 * Questo metodo ritorna lo sfidante
	 * 
	 * @return Allenatore.
	 */
	public Allenatore getSfidante() {return sfidante;}
	
	/**
	 * Questo metodo setta il valore di sfidante
	 *
	 * @param sfidante Allenatore contiene il nuovo valore dello sfidante.
	 * @return void.
	 */
	public void setSfidante(Allenatore sfidante) {this.sfidante = sfidante;}
	
	/**
	 * Questo metodo ritorna l'index di cambio dell'sfidante.
	 *
	 * @return int.
	 */
	public int getIndexCambioSfidante() {return indexCambioSfidante;}
	
	/**
	 * Questo metodo setta il valore di indexCambioSfidante
	 *
	 * @param indexCambioAllenatore int contiene il nuovo valore dell indexCambioSfidante
	 * @return void.
	 */
	public void setIndexCambioSfidante(int indexCambioSfidante) {this.indexCambioSfidante = indexCambioSfidante;}
}
