package controller;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Pokemon;
import model.UsableMove;
import model.costanti.Mossa;


/**
 * Classe controller dell apprendimento mosse che ha il compito di gestire
 * tutta l'interfaccia apprendimento mosse.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerApprendimentoMosse {
	/**
	 * Il pokemon alla quale bisogna far dimenticare la mossa
	 */
	private Pokemon poke;
	
	/**
	 * La mossa che deve imparare
	 */
	private Mossa newMossa;
	
	/**
	 * index della mossa che deve scordare
	 */
	private AtomicInteger index;
	
	/**
	 * controller del padre
	 */
	private ControllerBattleInterface owner;
	
	/**
	 * Anchor pane principale dell interfaccia
	 */
	@FXML
	AnchorPane apprendimentoAnchor;
	
	/**
	 * Prima di far vedere l'interfaccia andra' ad eseguire questo metodo
	 * 
	 * in questo metodo vado a caricare tutte le mosse che il pokemon puo dimenticare
	 * facendo vedere anche quale mossa dovra' imparare
	 *
	 * @return void.
	 */
	@FXML
	public void initialize() {
		Platform.runLater(()->{
			UsableMove[] mosse = poke.getMosse();
			for(int i = 0; i<4; i++) {
				Pane pane = (Pane) apprendimentoAnchor.lookup("#mossa"+String.valueOf(i));
				UsableMove mossa = mosse[i];
				if(mossa != null) {
					pane.setStyle("-fx-background-image: url(\"./view/img/"+mossa.getMossa().getTipo().name().toLowerCase()+".png\");");
					
					((Label) pane.lookup("#nameMossa")).setText(mossa.getMossa().getNome());
					((Label) pane.lookup("#ppBattle")).setText(String.valueOf(mossa.getPp()));
					((Label) pane.lookup("#ppMax")).setText(String.valueOf(mossa.getPpMax()));
					
					pane.setOnMouseClicked(this::sceltaMossa);
				}else {
					pane.setStyle("-fx-background-image: url(\"./view/img/noType.png\");");
				}
			}
			
			UsableMove newMossa = new UsableMove(this.newMossa);

			Pane pane = (Pane) apprendimentoAnchor.lookup("#newMossa");

			pane.setStyle("-fx-background-image: url(\"./view/img/"+newMossa.getMossa().getTipo().name().toLowerCase()+".png\");");
			
			((Label) pane.lookup("#nameMossa")).setText(newMossa.getMossa().getNome());
			((Label) pane.lookup("#ppBattle")).setText(String.valueOf(newMossa.getPp()));
			((Label) pane.lookup("#ppMax")).setText(String.valueOf(newMossa.getPpMax()));
		});
	}
	
	
	/**
	 * A seconda di quale mossa ha scelto il player andra ad aggiornare l'index di scelta.
	 *
	 * @param event MouseEvent contiene le informazioni utili per l'evento generato.
	 * @return void.
	 */
	public void sceltaMossa(MouseEvent event) {
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
		
		int i = Integer.valueOf(String.valueOf(pane.getId().charAt(pane.getId().length() - 1)));
		System.out.println(i);
		
		index.set(i);
		((Stage)pane.getScene().getWindow()).close();
	}
	
	
	/**
	 * Chiude la finestra.
	 * 
	 * @return void.
	 */
	public void close(MouseEvent event) {
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
		
		((Stage)pane.getScene().getWindow()).close();
	}
	
	
	/**
	 * Setta il pokemon a cui verra richiesta la scelta delle mosse da dimenticare
	 *
	 * @param pokemon Pokemon.
	 * @return void.
	 */
	public void setPokemon(Pokemon pokemon) {
		this.poke = pokemon;
	}
	
	/**
	 * Setta l'index della mossa dimenticata
	 *
	 * @param index AtomicInteger.
	 * @return void.
	 */
	public void setIndex(AtomicInteger index) {
		this.index = index;
	}
	
	/**
	 * Setta il controller della finestra padre
	 *
	 * @param controllerBattleInterface ControllerBattleInterface.
	 * @return void.
	 */
	public void setControllerOwner(ControllerBattleInterface controllerBattleInterface) {
		this.owner = controllerBattleInterface;
	}
	
	/**
	 * Setta la mossa da imparare
	 *
	 * @param mossa Mossa.
	 * @return void.
	 */
	public void setMossa(Mossa m) {
		this.newMossa = m;
	}
}
