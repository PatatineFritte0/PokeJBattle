package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import model.Allenatore;
import model.BestOfThree;
import model.FactoryPkmn;
import model.Pokemon;
import model.Pokemon.UsableMove;
import model.SaveManager;
import model.costanti.Mossa;

public class ControllerBattleInterface {
	
	@FXML
	AnchorPane battleAnchor;
	
	Allenatore P1;
	
	Allenatore P2;
	
	BestOfThree game;
	
	@FXML
	public void initialize() {
		
		
		this.P1 = SaveManager.loadSave("Comi");
		this.P2 = SaveManager.loadSave("Desk");
		
		game = new BestOfThree(P1, P2);
		
		game.run();
		
		caricaAllenatore(P1, "P1");
		caricaAllenatore(P2, "P2");
		
		aggiornaMosse(P1.getMainPokemon());
	}
	
	private void caricaAllenatore(Allenatore allenatore, String player){
		Pane p = (Pane) battleAnchor.lookup("#"+player);
		((Label)p.lookup("#nicknamePlayer")).setText(allenatore.getNickname());
		
		aggiornaStatPokemon(allenatore.getMainPokemon(), player);
	}
	
	private void aggiornaStatPokemon(Pokemon main, String player) {
		String verso;
		if(player.equals("P1")) {
			verso = "Back";
		}else if(player.equals("P2")) {
			verso = "Front";
		}else {
			System.out.println("ERR");
			return;
		}
		
		Pane p = (Pane) battleAnchor.lookup("#"+player);
		
		p.lookup("#imgPokemon").setStyle("-fx-background-image: url(./view/img/"+main.getNome().toLowerCase()+verso+".png);");
		
		((Label)p.lookup("#nomePokemon")).setText(main.getNome());
		((Label)p.lookup("#lvlPokemon")).setText(String.valueOf(main.getLvl()));
		((Label)p.lookup("#currentHP")).setText(String.valueOf(main.getBattlePs()));
		((Label)p.lookup("#maxHP")).setText(String.valueOf(main.getMaxPs()));
		
		((ProgressBar)p.lookup("#progresHPPokemon")).setProgress(main.getBattlePs()/main.getMaxPs());
	}
	
	private void aggiornaMosse(Pokemon poke){
		Pane pane = (Pane)battleAnchor.lookup("#inf");
		for(int i = 0; i<4; i++) {
			Pane paneMossa = (Pane) pane.lookup("#mossa"+String.valueOf(i));
			UsableMove usableMossa = poke.getMosse()[i];
			if(usableMossa != null) {
				Mossa mossa = usableMossa.getMossa();
				
				String tipo =  mossa.getTipo().name().toLowerCase();
				
				paneMossa.setStyle("-fx-background-image: url(\"./view/img/"+tipo+".png\");");
				
				((Label)paneMossa.lookup("#nameMossa")).setText(mossa.getNome());
				((Label)paneMossa.lookup("#mosseDisponibili")).setText(String.valueOf(usableMossa.getPp()));
				((Label)paneMossa.lookup("#mosseMax")).setText(String.valueOf(usableMossa.getPpMax()));
			}else {
				
				paneMossa.setStyle("-fx-background-image: url(\"./view/img/"+"noType"+".png\");");
				
				((Label)paneMossa.lookup("#nameMossa")).setText("");
				((Label)paneMossa.lookup("#mosseDisponibili")).setText("");
				((Label)paneMossa.lookup("#mosseMax")).setText("");
			}
		}
	}
}
