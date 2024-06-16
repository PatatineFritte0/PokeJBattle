package controller;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FactoryPkmn;
import model.Pokemon;

public class ControllerListPkmn {
	
	private MouseEvent priviusEvent;
	
	private ControllerNewSave controllerOwner;
	
	public void sceltaPokemon(MouseEvent event) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Object source = event.getTarget();
		Pane pane = null;
		if (source instanceof ImageView) {
			pane = (Pane) ((ImageView)source).getParent();
        } else if (source instanceof Pane) {
            pane = (Pane) source; 
        }else {
        	pane = (Pane) ((Text) source).getParent().getParent();
        }
		
		String nomePokemon = findLabelInPane(pane).getText();
		
		FactoryPkmn factory = new FactoryPkmn();
		Pokemon pokemon = factory.crea(nomePokemon.toLowerCase(), 5);
		
		Pane privPane = (Pane) priviusEvent.getTarget();
		
		String idPane = privPane.getId();
		
		controllerOwner.squadra[Integer.valueOf(idPane.substring(idPane.length()- 1)) - 1] = pokemon;
		
		Label namePokemonLabel = new Label(pokemon.getNome());
		namePokemonLabel.setLayoutX(100.0);
		namePokemonLabel.setLayoutY(14.0);
		
		Label lvlPokemonLabel = new Label("LVL: "+String.valueOf(pokemon.getLvl()));
		lvlPokemonLabel.setLayoutX(118.0);
		lvlPokemonLabel.setLayoutY(50);
		
		Image pokeImg = new Image("./view/img/"+pokemon.getNome().toLowerCase()+"Front.png");
		ImageView viewPokeImg = new ImageView(pokeImg);
		viewPokeImg.setLayoutX(10.0);
		viewPokeImg.setLayoutY(9.0);
		
		privPane.getChildren().clear();
		privPane.getChildren().addAll(namePokemonLabel, lvlPokemonLabel, viewPokeImg);
		
		stage.close();
	}
	
	private Label findLabelInPane(Pane pane) {
        for (Node node : pane.getChildren()) {
            if (node instanceof Label) {
                return (Label) node;
            }
        }
        return null;
    }
	
	public void setPriviusEvent(MouseEvent event) {
		this.priviusEvent = event;
	}
	
	public void setControllerOwner(ControllerNewSave controller) {
		this.controllerOwner = controller;
	}
}
