package controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pokemon;


/**
 * Classe controller della scelta evolutiva che ha il compito di gestire
 * tutta l'interfaccia della scelta evolutiva.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerEvoluzione {
	/**
	 * Anchor pane principale dell interfaccia
	 */
	@FXML
	AnchorPane evoluzioneAnchor;
	
	/**
	 * Pokemon che si deve evolvere
	 */
	private Pokemon poke;

	/**
     * questo metodo viene lanciato una volta fatta la load della schermata,
     * e inizializza i campi utili alla visualizzazione delle evoluzioni.
     *
     * @return void.
     */
	@FXML
	public void initialize() {
		Platform.runLater(()->{
			Pokemon evo = poke.getEvo();
			((Label)evoluzioneAnchor.lookup("#labelPoke")).setText(poke.getNome());
			((Label)evoluzioneAnchor.lookup("#labelPokeEvo")).setText(evo.getNome());
			
			((ImageView) evoluzioneAnchor.lookup("#imgPoke")).setImage(new Image("./view/img/"+poke.getNome().toLowerCase()+"Front.png"));
			((ImageView) evoluzioneAnchor.lookup("#imgPokeEvo")).setImage(new Image("./view/img/"+evo.getNome().toLowerCase()+"Front.png"));
		});
	}
	
	/**
	 * questo metodo evolve il pokemon e chiude la schermata
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void evolvi(ActionEvent event) {
		poke.evolve();
		((Stage)evoluzioneAnchor.getScene().getWindow()).close();
	}
	
	/**
	 * questo metodo chiude la schermata
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void close(ActionEvent event) {
		((Stage)evoluzioneAnchor.getScene().getWindow()).close();
	}
	
	
	/**
	 * Questo metodo setta il valore di poke.
	 * 
	 * @param poke Pokemon.
	 * @return void.
	 */
	public void setPokemon(Pokemon poke) {
		this.poke = poke;
	}

}
