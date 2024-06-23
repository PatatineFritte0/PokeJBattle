package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FactoryPkmn;
import model.Pokemon;

public class ControllerListPkmn {
	
	private MouseEvent priviusEvent;
	
	private ControllerNewSave controllerOwner;
	
	@FXML
	private AnchorPane pokeContainer;
	
	
	@FXML
	public void initialize() {
		List<Pokemon> poke = new ArrayList<>();
		poke.addAll(FactoryPkmn.allPokemon());
		//for(Pokemon pokkkeee : poke) System.out.println(pokkkeee.getNome());
		
		int lenAnchor = poke.size() * 100;
		pokeContainer.setPrefHeight(lenAnchor);
		
		int counter = 0;
		for (Pokemon pokemon: poke) {
			Pane pane = new Pane();
			pane.setLayoutY(counter * 100);
			pane.setPrefHeight(100);
			pane.setPrefWidth(235);
			pane.getStyleClass().add("pane");
			pane.setOnMouseClicked(this::sceltaPokemon);
			
			ImageView imagePokemon = new ImageView("./view/img/"+pokemon.getNome().toLowerCase() + "Front.png");
			imagePokemon.setFitHeight(90);
			imagePokemon.setFitWidth(90);
			imagePokemon.setLayoutY(10);
			
			Label namePokemon = new Label(pokemon.getNome());
			namePokemon.setLayoutX(110);
			namePokemon.setLayoutY(20);
			namePokemon.setId("name");
			
			Label lvl = new Label("LVL:");
			lvl.setLayoutX(110);
			lvl.setLayoutY(50);
			
			Label pokeLvl = new Label(String.valueOf(pokemon.getLvl()));
			pokeLvl.setLayoutX(160);
			pokeLvl.setLayoutY(50);
			pokeLvl.setId("lvl");
			
			pane.getChildren().addAll(imagePokemon,namePokemon, lvl, pokeLvl);
			
			pokeContainer.getChildren().add(pane);
			
			counter++;
		}
	}
	
	
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
		
		String nomePokemon = findLabelInPaneWithId(pane, "name").getText();
		int lvlPoke = Integer.valueOf(findLabelInPaneWithId(pane, "lvl").getText());
		
		Pokemon pokemon = FactoryPkmn.crea(nomePokemon.toLowerCase(), lvlPoke);
		
		Pane privPane = null;
		if(priviusEvent.getTarget() instanceof Pane) {
			privPane = (Pane) priviusEvent.getTarget();
		}else if(priviusEvent.getTarget() instanceof ImageView) {
			privPane = (Pane)((ImageView)priviusEvent.getTarget()).getParent();
		}else{
			privPane = (Pane)((Text)priviusEvent.getTarget()).getParent().getParent();
		}

		String idPane = privPane.getId();
		
		controllerOwner.squadra[Integer.valueOf(idPane.substring(idPane.length()- 1)) - 1] = pokemon;
		
		Label namePokemonLabel = new Label(pokemon.getNome());
		namePokemonLabel.setLayoutX(100.0);
		namePokemonLabel.setLayoutY(20.0);
		
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
	
	private Label findLabelInPaneWithId(Pane pane, String id) {
        return (Label)pane.lookup("#"+id);
    }
	
	public void setPriviusEvent(MouseEvent event) {
		this.priviusEvent = event;
	}
	
	public void setControllerOwner(ControllerNewSave controller) {
		this.controllerOwner = controller;
	}
}
