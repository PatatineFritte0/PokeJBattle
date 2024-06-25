package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.SaveManager;
import model.Allenatore;
import model.Franco;

public class ControllerChoosePlayerFranco {
	@FXML
	private AnchorPane chooseAnchor;
	
	@FXML
    private ComboBox<Allenatore> chooseP1;

    private ObservableList<Allenatore> allAllenatori;
	
    @FXML
    public void initialize() {
        chooseAnchor.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {

                allAllenatori = FXCollections.observableArrayList(SaveManager.getSaves());

                chooseP1.setItems(FXCollections.observableArrayList(allAllenatori));

                setupComboBox(chooseP1);

                chooseP1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                    updateComboBoxItems();
                });
            }
        });
    }

    private void setupComboBox(ComboBox<Allenatore> chooseP12) {
        chooseP12.setCellFactory(new Callback<ListView<Allenatore>, ListCell<Allenatore>>() {
            @Override
            public ListCell<Allenatore> call(ListView<Allenatore> param) {
                return new ListCell<Allenatore>() {
                    protected void updateItem(Allenatore allenatore, boolean empty) {
                        super.updateItem(allenatore, empty);
                        if (empty || allenatore == null) {
                            setText(null);
                            setGraphic(null);
                            setStyle("");
                        } else {
                            setText(allenatore.getNickname());
                        }
                    }
                };
            }
        });

        chooseP12.setButtonCell(new ListCell<Allenatore>() {
            @Override
            protected void updateItem(Allenatore allenatore, boolean empty) {
                super.updateItem(allenatore, empty);
                if (empty || allenatore == null) {
                    setText(null);
                    setGraphic(null);
                    setStyle("");
                } else {
                    setText(allenatore.getNickname());
                }
            }
        });
    }
    
    
    
    private void updateComboBoxItems(){
    	Allenatore selectedP1 = chooseP1.getSelectionModel().getSelectedItem();
    
        if (selectedP1 != null) {
        	((Label)chooseAnchor.getScene().lookup("#VP1")).setText(String.valueOf(selectedP1.getVittorie()));
        	((Label)chooseAnchor.getScene().lookup("#SP1")).setText(String.valueOf(selectedP1.getSconfitte()));
        	
        	
        	String.valueOf(selectedP1.getVittorie());
        	
        	ImageView imp1 = (ImageView) chooseAnchor.getScene().lookup("#imp1");
        	if(imp1.getOpacity() == 0.5) {
        		imp1.setOpacity(1);
            	imp1.setOnMouseClicked(arg0 -> {
    				try {
						openReorganize(arg0);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			});
        	}
        }
    }
	
	public void openReorganize(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/reorganizePkmn.fxml"));
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene;
		scene = new Scene(root.load());
	
		ControllerReorganizePkmn controller = root.getController();
		
		String idImg = ((ImageView) event.getTarget()).getId();
		
		controller.setIdChoose("chooseP1");
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
	
	public void back(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
		Scene scene = new Scene(root.load());
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		owner.setScene(scene);
		owner.show();
	}
	
	public void fight(ActionEvent event) throws IOException{
		Allenatore allenatoreP1 = ((ComboBox<Allenatore>)this.getAnchor().getScene().lookup("#chooseP1")).getSelectionModel().getSelectedItem();
		//Allenatore sfidanteP2 = ((ComboBox<Allenatore>)this.getAnchor().getScene().lookup("#chooseP2")).getSelectionModel().getSelectedItem();
		
		if(allenatoreP1 == null) {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("Scegliere i combattenti prima di andare in battaglia");
			alert.showAndWait();
			return;
		}
		
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/battleInterface.fxml"));
		
		root.setController(new ControllerBattleInterfaceFranco());
		
		Scene scene = new Scene(root.load());
		
		ControllerBattleInterface controller = root.getController();
		
		controller.setAllenatore(allenatoreP1);
		controller.setSfidante(new Franco(allenatoreP1));
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		owner.setScene(scene);
		owner.show();
	}
	
	public AnchorPane getAnchor(){ return this.chooseAnchor;}
}
		
		
		
		
