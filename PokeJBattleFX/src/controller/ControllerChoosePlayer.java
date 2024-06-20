package controller;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Pokemon;
import model.Allenatore;
import model.FactoryPkmn;

public class ControllerChoosePlayer {
	@FXML
	private AnchorPane chooseAnchor;
	
	Allenatore P1;
	
	Allenatore P2;
	
	@FXML
	public void initialize(){
		chooseAnchor.sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldScene, Scene newScene) {
				if(newScene != null) {
					
					ComboBox<Pokemon> comboBox1 = (ComboBox<Pokemon>) newScene.lookup("#chooseP1");
					
					
					FactoryPkmn factory = new FactoryPkmn();
					
					ObservableList<Pokemon> pokemon = FXCollections.observableArrayList(
							factory.crea("bulbasaur", 5),
							factory.crea("bulbasaur", 5),
							factory.crea("bulbasaur", 5));
					comboBox1.setItems(pokemon);
					
					
					comboBox1.setItems(pokemon);
					
					comboBox1.setCellFactory(new Callback<ListView<Pokemon>, ListCell<Pokemon>>(){
	
						@Override
						public ListCell<Pokemon> call(ListView<Pokemon> param) {
							return new ListCell<Pokemon>() {
							
								protected void updateItem(Pokemon pokemon, boolean empty) {
				                    super.updateItem(pokemon, empty);
				                    if (empty || pokemon == null) {
				                        setText(null);
				                        setGraphic(null);
				                        setStyle("");
				                    } else {
				                        setText(pokemon.getNome());   
				                    }
								}
							};
						}
					});
					
					comboBox1.setButtonCell(new ListCell<Pokemon>() {
			            @Override
			            protected void updateItem(Pokemon pokemon, boolean empty) {
			                super.updateItem(pokemon, empty);
			                if (empty || pokemon == null) {
			                    setText(null);
			                    setGraphic(null);
			                    setStyle("");
			                } else {
			                    setText(pokemon.getNome());
			                }
			            }
			        });
				}
			}
		});
	}
	
	public void openReorganize(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/reorganizePkmn.fxml"));
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root.load());
		
		ControllerReorganizePkmn controller = root.getController();
		controller.setPriviusEvent(event);
		
		Stage pkmn = new Stage();
		pkmn.setScene(scene);
		
		Image icon = new Image("./view/img/pokeIcon2.PNG");
		pkmn.getIcons().add(icon);
		pkmn.setTitle("Riorganizza Pokemon");
		
		pkmn.setResizable(false);
		pkmn.initModality(Modality.APPLICATION_MODAL);
		
		pkmn.initOwner(owner);
		
		pkmn.showAndWait();
	}
}
		
		
		
		
