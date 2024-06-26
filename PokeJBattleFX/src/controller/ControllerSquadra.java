package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Allenatore;
import model.Pokemon;

/**
 * Classe controller della scelta pokemon in squadra che ha il compito di gestire
 * tutta l'interfaccia della scelta pokemon in squadra.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerSquadra {
	/**
	 * Anchor pane principale dell interfaccia.
	 */
	@FXML
	AnchorPane anchorSquadra;
	
	/**
	 * controller del interfaccia padre.
	 */
	ControllerBattleInterface owner;
	
	/**
	 * allenatore che deve scegliere il pokemon.
	 */
	Allenatore trainer;


	/**
     * questo metodo viene lanciato una volta fatta la load della schermata,
     * e inizializza i campi utili alla visualizzazione di tutti i pokemon
     * in squadra dell'allenatore
     *
     * @return void.
     */
	@FXML
	public void initialize() {
		
		Platform.runLater(()->{
			Pokemon[] poke = trainer.getSquadra();
			
			for (int counter = 0; counter<6; counter++) {
				Pokemon pokemon = poke[counter];
				Pane pane = (Pane) anchorSquadra.lookup("#pkmn"+ String.valueOf(counter));
				if(pokemon != null) {
					
					Label index = new Label(String.valueOf(counter + 1));
					index.setLayoutX(14);
					index.setLayoutY(14);
					index.setId("index");
					
					ImageView imagePokemon = new ImageView("./view/img/"+pokemon.getNome().toLowerCase() + "Front.png");
					imagePokemon.setFitHeight(90);
					imagePokemon.setFitWidth(90);
					imagePokemon.setLayoutY(10);
					
					Label namePokemon = new Label(pokemon.getNome());
					namePokemon.setLayoutX(110);
					namePokemon.setLayoutY(20);
					
					Label lvl = new Label("LVL:");
					lvl.setLayoutX(110);
					lvl.setLayoutY(45);
					
					Label pokeLvl = new Label(String.valueOf(pokemon.getLvl()));
					pokeLvl.setLayoutX(160);
					pokeLvl.setLayoutY(45);
					pokeLvl.setId("lvl");
					
					Label ps = new Label("PS:");
					ps.setLayoutX(110);
					ps.setLayoutY(65);
					
					Label psBattle = new Label(String.valueOf(pokemon.getBattlePs()));
					psBattle.setLayoutX(145);
					psBattle.setLayoutY(65);
					
					Label barra = new Label("/");
					barra.setLayoutX(180);
					barra.setLayoutY(65);
					
					Label psMax = new Label(String.valueOf(pokemon.getMaxPs()));
					psMax.setLayoutX(195);
					psMax.setLayoutY(65);
					
					pane.getChildren().addAll(imagePokemon,namePokemon, lvl, pokeLvl, ps, psMax, psBattle, barra, index);
					pane.setOnMouseClicked(this::sceltaPokemon);
				}else {
					pane.setOnMouseClicked(null);
				}
			}
		});
		
	}
		
	/**
	 * Questo metodo serve a capire che pokemon il player ha selezionato
	 * e va i dovuti controlli per capire se quel pokemon puo essere scelto
	 * o no.
	 * 
	 * @param event ActionEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void sceltaPokemon(MouseEvent event) {
		Object source = event.getTarget();
		Pane pane = null;
		if (source instanceof ImageView) {
			pane = (Pane) ((ImageView)source).getParent();
        } else if (source instanceof Pane) {
            pane = (Pane) source; 
        }else if (source instanceof Text){
        	pane = (Pane) ((Text) source).getParent().getParent();
        }else {
        	pane = (Pane) ((Label) source).getParent();
        }
		
		int index = Integer.valueOf(((Label) pane.lookup("#index")).getText()) - 1;
		
		Pokemon scelta = trainer.getPokemonById(index);
		
		if(scelta.getBattlePs() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("Questo pokemon e' KO");
			alert.showAndWait();
			return;
		}else if(trainer.getMainPokemon() == scelta) {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("Questo pokemon e' gia in campo");
			alert.showAndWait();
			return;
		}
		
		if(trainer == owner.getAllenatore()) {
			owner.setIndexCambioAllenatore(index);
		}else if (trainer == owner.getSfidante()) {
			owner.setIndexCambioSfidante(index);
		}
		((Stage)pane.getScene().getWindow()).close();
	}
	
	/**
	 * setta l'allenatore
	 * 
	 * @param all Allenatore
	 * @return void.
	 */
	public void setAllenatore(Allenatore all) {
		this.trainer = all;
	}
	
	/**
	 * setta il controller padre
	 * 
	 * @param controllerBattleInterface ControllerBattleInterface
	 * @return void.
	 */
	public void setControllerOwner(ControllerBattleInterface controllerBattleInterface) {
		this.owner = controllerBattleInterface;
	}

}
