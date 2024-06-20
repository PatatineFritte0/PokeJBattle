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
import javafx.scene.image.ImageView;
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
	
	@FXML
    private ComboBox<Pokemon> chooseP1;

    @FXML
    private ComboBox<Pokemon> chooseP2;

    private ObservableList<Pokemon> allPokemon;
	
    @FXML
    public void initialize() {
        chooseAnchor.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                FactoryPkmn factory = new FactoryPkmn();

                allPokemon = FXCollections.observableArrayList(
                        factory.crea("bulbasaur", 5),
                        factory.crea("charmander", 5),
                        factory.crea("squirtle", 5)
                );

                chooseP1.setItems(FXCollections.observableArrayList(allPokemon));
                chooseP2.setItems(FXCollections.observableArrayList(allPokemon));

                setupComboBox(chooseP1);
                setupComboBox(chooseP2);

                chooseP1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                    updateComboBoxItems();
                });

                chooseP2.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                    updateComboBoxItems();
                });
            }
        });
    }

    private void setupComboBox(ComboBox<Pokemon> comboBox) {
        comboBox.setCellFactory(new Callback<ListView<Pokemon>, ListCell<Pokemon>>() {
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

        comboBox.setButtonCell(new ListCell<Pokemon>() {
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
    
    
    private Pokemon oldCP1;
    private Pokemon oldCP2;
    
    private void updateComboBoxItems(){
        Pokemon selectedP1 = chooseP1.getSelectionModel().getSelectedItem();
        Pokemon selectedP2 = chooseP2.getSelectionModel().getSelectedItem();

        System.out.println(selectedP1 == null);
        System.out.println(selectedP2 == null);
    
        if (selectedP1 != null) {
        	if(oldCP1 != null) chooseP2.getItems().add(oldCP1);
        	
        	chooseP2.getItems().remove(selectedP1);
        	oldCP1 = selectedP1;
        	
        	ImageView imp1 = (ImageView) chooseAnchor.getScene().lookup("#imp1");
        	if(imp1.getOpacity() == 0.5) {
        		imp1.setOpacity(1);
            	imp1.setOnMouseClicked(arg0 -> {
    				try {
    					openReorganize(arg0);
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			});
        	}
        }

        if (selectedP2 != null) {
        	if(oldCP2 != null) chooseP1.getItems().add(oldCP2);
        	
        	chooseP1.getItems().remove(selectedP2);
        	oldCP2 = selectedP2;
        	
        	ImageView imp2 = (ImageView) chooseAnchor.getScene().lookup("#imp2");
        	if(imp2.getOpacity() == 0.5) {
        		imp2.setOpacity(1);
            	imp2.setOnMouseClicked(arg0 -> {
    				try {
    					openReorganize(arg0);
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			});
        	}
        }
    }
	
	public void openReorganize(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/reorganizePkmn.fxml"));
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root.load());
		
		ControllerReorganizePkmn controller = root.getController();
		controller.setIdChoose(((ImageView) event.getTarget()).getId());
		
		controller.setControllerOwner(this);
		
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
		
		
		
		
