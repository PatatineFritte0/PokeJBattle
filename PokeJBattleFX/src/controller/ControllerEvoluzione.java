package controller;

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

public class ControllerEvoluzione {
	
	@FXML
	AnchorPane evoluzioneAnchor;
	private Pokemon poke;

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
	
	public void evolvi(ActionEvent event) {
		poke.evolve();
		((Stage)evoluzioneAnchor.getScene().getWindow()).close();
	}
	
	public void close(ActionEvent event) {
		((Stage)evoluzioneAnchor.getScene().getWindow()).close();
	}
	
	public void setPokemon(Pokemon poke) {
		this.poke = poke;
	}

}
