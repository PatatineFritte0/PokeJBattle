package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.Pokemon;

public class ControllerChoosePlayer {
	@FXML
	private AnchorPane ChooseAnchor;
	
	@FXML
	public void initialize(){
		Scene scena = ChooseAnchor.getScene();
		
		ComboBox<Pokemon> comboBox1 = (ComboBox<Pokemon>) scena.lookup("#chooseP1");
		
		ObservableList<Pokemon> pokemon = FXCollections.observableArrayList();
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
	                        setStyle("-fx-background-image: url(' ../view/img/pokemonLogo '); " +
	                                 "-fx-background-size: cover; " +
	                                 "-fx-background-position: center center;");
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
                    setStyle("-fx-background-image: url(' ../view/img/pokemonLogo '); " +
                             "-fx-background-size: cover; " +
                             "-fx-background-position: center center;");
                }
            }
        });
	}
}
		
		
		
		
