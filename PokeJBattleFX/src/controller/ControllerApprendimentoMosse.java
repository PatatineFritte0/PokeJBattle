package controller;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Pokemon;
import model.UsableMove;
import model.costanti.Mossa;

public class ControllerApprendimentoMosse {
	private Pokemon poke;
	private Mossa newMossa;
	private AtomicInteger index;
	private ControllerBattleInterface owner;
	
	@FXML
	AnchorPane apprendimentoAnchor;
	
	
	@FXML
	public void initialize() {
		Platform.runLater(()->{
			UsableMove[] mosse = poke.getMosse();
			for(int i = 0; i<4; i++) {
				Pane pane = (Pane) apprendimentoAnchor.lookup("#mossa"+String.valueOf(i));
				UsableMove mossa = mosse[i];
				if(mossa != null) {
					pane.setStyle("-fx-background-image: url(\"../img/"+mossa.getMossa().getTipo().name().toLowerCase()+".png\");");
					
					((Label) pane.lookup("#nameMossa")).setText(mossa.getMossa().getNome());
					((Label) pane.lookup("#ppBattle")).setText(String.valueOf(mossa.getPp()));
					((Label) pane.lookup("#nameMossa")).setText(String.valueOf(mossa.getPpMax()));
				}else {
					pane.setStyle("-fx-background-image: url(\"../img/noType.png\");");
				}
			}
			
			UsableMove newMossa = new UsableMove(this.newMossa);

			Pane pane = (Pane) apprendimentoAnchor.lookup("#newMossa");

			pane.setStyle("-fx-background-image: url(\"../img/"+newMossa.getMossa().getTipo().name().toLowerCase()+".png\");");
			
			((Label) pane.lookup("#nameMossa")).setText(newMossa.getMossa().getNome());
			((Label) pane.lookup("#ppBattle")).setText(String.valueOf(newMossa.getPp()));
			((Label) pane.lookup("#nameMossa")).setText(String.valueOf(newMossa.getPpMax()));
		});
	}
	
	public void setPokemon(Pokemon pokemon) {
		this.poke = pokemon;
	}
	
	public void setIndex(AtomicInteger index) {
		this.index = index;
	}
	
	public void setControllerOwner(ControllerBattleInterface controllerBattleInterface) {
		this.owner = controllerBattleInterface;
	}

	public void setMossa(Mossa m) {
		this.newMossa = m;
	}
}
