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


/**
 * Classe controller della scelta dei player che ha il compito di gestire
 * tutta l'interfaccia della scelta dei player.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerChoosePlayer {
	/**
	 * Anchor pane principale dell interfaccia
	 */
	@FXML
	private AnchorPane chooseAnchor;
	
	/**
	 * Combo box della scelta di P1
	 */
	@FXML
    private ComboBox<Allenatore> chooseP1;
	
	/**
	 * Combo box della scelta di P2
	 */
    @FXML
    private ComboBox<Allenatore> chooseP2;
    
    /**
	 * Lista di tutti gli allenatori esistenti nei salvataggi
	 */
    private ObservableList<Allenatore> allAllenatori;
	
    /**
     * questo metodo viene lanciato una volta fatta la load della schermata,
     * e inizializza le chooseBox dei player.
     *
     * @return void.
     */
    @FXML
    public void initialize() {
        chooseAnchor.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {

                allAllenatori = FXCollections.observableArrayList(SaveManager.getSaves());

                chooseP1.setItems(FXCollections.observableArrayList(allAllenatori));
                chooseP2.setItems(FXCollections.observableArrayList(allAllenatori));

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
    
	/**
	 * setta i vari valori e funzioni che la combobox deve avere.
	 *
	 * @param chooseP12 ComboBox<Allenatore> contiene la comboBox da fare il setup.
	 * @return void.
	 */
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
    
    /**
	 * tiene conto della vecchi ascelta di P1
	 */
    private Allenatore oldCP1;
    /**
	 * tiene conto della vecchia scelta di P2
	 */
    private Allenatore oldCP2;
    
    
    /**
	 * questo metodo serve a gestire ogni volta che un player sceglie un valore nella combobox.
	 *
	 * @return void.
	 */
    private void updateComboBoxItems(){
    	Allenatore selectedP1 = chooseP1.getSelectionModel().getSelectedItem();
    	Allenatore selectedP2 = chooseP2.getSelectionModel().getSelectedItem();
    
        if (selectedP1 != null) {
        	((Label)chooseAnchor.getScene().lookup("#VP1")).setText(String.valueOf(selectedP1.getVittorie()));
        	((Label)chooseAnchor.getScene().lookup("#SP1")).setText(String.valueOf(selectedP1.getSconfitte()));
        	
        	
        	String.valueOf(selectedP1.getVittorie());
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			});
        	}
        }

        if (selectedP2 != null) {
        	((Label)chooseAnchor.getScene().lookup("#VP2")).setText(String.valueOf(selectedP2.getVittorie()));
        	((Label)chooseAnchor.getScene().lookup("#SP2")).setText(String.valueOf(selectedP2.getSconfitte()));
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			});
        	}
        }
    }
	
    
    /**
	 * apre la schermata di riorganizzazione pokemon e inizializza i valori utili nel suo controller
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void openReorganize(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/reorganizePkmn.fxml"));
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene;
		scene = new Scene(root.load());
	
		ControllerReorganizePkmn controller = root.getController();
		
		String idImg = ((ImageView) event.getTarget()).getId();
		
		controller.setIdChoose("chooseP"+ idImg.charAt(idImg.length()-1));
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
	
	
	/**
	 * un metodo che fa ritornare al menu principale
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void back(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
		Scene scene = new Scene(root.load());
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		owner.setScene(scene);
		owner.show();
	}
	
	/**
	 * un metodo che fa iniziare la battaglia cambiando schermata, questo solo se i campi dei
	 * combobox sono tutti e due settati ad un valore.
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void fight(ActionEvent event) throws IOException{
		Allenatore allenatoreP1 = ((ComboBox<Allenatore>)this.getAnchor().getScene().lookup("#chooseP1")).getSelectionModel().getSelectedItem();
		Allenatore sfidanteP2 = ((ComboBox<Allenatore>)this.getAnchor().getScene().lookup("#chooseP2")).getSelectionModel().getSelectedItem();
		
		if(allenatoreP1 == null || sfidanteP2 == null ) {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("Scegliere i combattenti prima di andare in battaglia");
			alert.showAndWait();
			return;
		}
		
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/battleInterface.fxml"));
		
		root.setController(new ControllerBattleInterface());
		
		Scene scene = new Scene(root.load());
		
		ControllerBattleInterface controller = root.getController();
		
		controller.setAllenatore(allenatoreP1);
		controller.setSfidante(sfidanteP2);
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		owner.setScene(scene);
		owner.show();
	}
	
	
	/**
	 * ottieni l'anchorPane della schermata
	 * 
	 * @return AnchorPane.
	 */
	public AnchorPane getAnchor(){ return this.chooseAnchor;}
}
		
		
		
		
