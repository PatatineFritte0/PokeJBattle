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

public class ControllerSquadra {
	
	@FXML
	AnchorPane anchorSquadra;
	
	ControllerBattleInterface owner;
	
	Allenatore trainer;

	@FXML
	public void initialize() {
		
		Platform.runLater(()->{
			Pokemon[] poke = trainer.getSquadra();
			
			for (int counter = 0; counter<6; counter++) {
				Pokemon pokemon = poke[counter];
				Pane pane = (Pane) anchorSquadra.lookup("#pkmn"+ String.valueOf(counter));
				if(pokemon != null) {
					
					Label index = new Label(String.valueOf(counter));
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
					lvl.setLayoutY(50);
					
					Label pokeLvl = new Label(String.valueOf(pokemon.getLvl()));
					pokeLvl.setLayoutX(160);
					pokeLvl.setLayoutY(50);
					pokeLvl.setId("lvl");
					
					Label ps = new Label("ps:");
					ps.setLayoutX(110);
					ps.setLayoutY(70);
					
					Label psBattle = new Label(String.valueOf(pokemon.getBattlePs()));
					psBattle.setLayoutX(160);
					psBattle.setLayoutY(70);
					
					Label barra = new Label("/");
					psBattle.setLayoutX(190);
					psBattle.setLayoutY(70);
					
					Label psMax = new Label(String.valueOf(pokemon.getMaxPs()));
					psMax.setLayoutX(220);
					psMax.setLayoutY(70);
					
					pane.getChildren().addAll(imagePokemon,namePokemon, lvl, pokeLvl, ps, psMax, psBattle, barra, index);
					pane.setOnMouseClicked(this::sceltaPokemon);
				}else {
					pane.setOnMouseClicked(null);
				}
			}
		});
		
	}
		
	
		
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
		
		int index = Integer.valueOf(((Label) pane.lookup("#index")).getText());
		
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
		
		//Pokemon p = trainer.getMainPokemon();
		//trainer.setMainPokemon(index);
		
		//System.out.println("\nRientra " + p.getNome() + ", vai " + trainer.getMainPokemon().getNome() +"!\n");
		
		//owner.log += "\n" + trainer.getNickname() + " sostituisce " + p.getNome() + " con " + trainer.getMainPokemon().getNome();
		if(trainer == owner.allenatore) {
			owner.indexCambioAllenatore = index;
		}else if (trainer == owner.sfidante) {
			owner.indexCambioSfidante = index;
		}
		((Stage)pane.getScene().getWindow()).close();
	}
	
	
	public void setAllenatore(Allenatore all) {
		this.trainer = all;
	}
	
	public void setControllerOwner(ControllerBattleInterface controllerBattleInterface) {
		this.owner = controllerBattleInterface;
	}

}
