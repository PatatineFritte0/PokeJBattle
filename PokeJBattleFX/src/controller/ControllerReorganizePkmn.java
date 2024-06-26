package controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Allenatore;
import model.Pokemon;
import model.SaveManager;

/**
 * Classe controller della riorganizzazione pokemon che ha il compito di gestire
 * tutta l'interfaccia della riorganizzazione pokemon.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerReorganizePkmn {
	/**
	 * id di che squadra allenatore deve riorganizzare
	 */
	private String idChoose;
	
	/**
	 * controller schermata padre
	 */
	public ControllerChoosePlayer controllerOwner;
	
	/**
	 * Label del nickname
	 */
	@FXML
	private Label nicknameLabel;
	
	/**
	 * pane contenenti tutti i pokemon riorganizzati
	 */
	@FXML
	private Pane riorganizedPane;
	
	/**
	 * pane contenenti tutti i pokemon non riorganizzati
	 */
	@FXML
	private Pane squadPane;
	
	/**
	 * allenatore che deve riorganizzare la squadra
	 */
	public Allenatore allenatore;
	
	/**
	 * controller schermata padre (franco)
	 */
	private ControllerChoosePlayerFranco controllerOwnerFranco;
	
	
	/**
     * questo metodo viene lanciato una volta fatta la load della schermata,
     * e inizializza i campi utili alla visualizzazione di tutti i pokemon
     * in squadra dell allenatore dando ad ogniuno di loro un metodo di spostamento.
     *
     * @return void.
     */
	@FXML
	public void initialize(){
		//inserisci il nickname nel label nickname
		Platform.runLater(()->{
			Stage stage = (Stage)squadPane.getScene().getWindow();
			ComboBox<Allenatore> comboBox;
			
			if (controllerOwner == null){
				comboBox = (ComboBox<Allenatore>)controllerOwnerFranco.getAnchor().getScene().lookup("#"+idChoose);
			}else {
				comboBox = (ComboBox<Allenatore>)controllerOwner.getAnchor().getScene().lookup("#"+idChoose);
			}
			
			this.allenatore = comboBox.getSelectionModel().getSelectedItem();
			
			nicknameLabel.setText(allenatore.getNickname());
			
			for(int i=0; i<6; i++) {
				Pokemon poke;
				if((poke = allenatore.getPokemonById(i)) == null) continue;
				
				Pane pane = getFreePane(squadPane);
				pane.setOnMouseClicked(this::toRiorganize);
				
				ImageView image = new ImageView("./view/img/"+poke.getNome().toLowerCase()+"Front.png");
				image.setFitHeight(100);
				image.setFitWidth(100);
				
				Label namePokemon = new Label(poke.getNome());
				namePokemon.setLayoutX(100);
				namePokemon.setLayoutY(29);
				namePokemon.setPrefHeight(13);
				namePokemon.setPrefWidth(114);
				
				Label lvl = new Label("LVL:");
				lvl.setLayoutX(140);
				lvl.setLayoutY(60);
				
				Label valueLvl = new Label(String.valueOf((poke.getLvl())));
				valueLvl.setLayoutX(190);
				valueLvl.setLayoutY(60);
				
				Label indexPoke = new Label(String.valueOf(i + 1));
				indexPoke.setLayoutX(8);
				indexPoke.setLayoutY(8);
				indexPoke.setId("index");
				
				pane.getStyleClass().add("paneCell");
				
				pane.setOnMouseEntered(event -> {
		            pane.setCursor(Cursor.HAND);
		        });
				
				pane.setOnMouseExited(event -> {
		            pane.setCursor(Cursor.DEFAULT);
		        });
				
				pane.getChildren().addAll(image, namePokemon, lvl, valueLvl, indexPoke);
			}
			
		});
	}
	
	/**
	 * Questo metodo serve a controllare se tutti i pokemon sono
	 * stati riorganizzati, nel caso sia cosi, salva la squadra dell allenatore
	 * e chiude l'interfaccia
	 * 
	 * @param event ActionEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void reorganizeSquad(ActionEvent event) {
		if(isEmptyPane(squadPane)){
			Pokemon[] nuovaSquadra = new Pokemon[6];
			
			for(int i = 0; i<6; i++) {
				Pane pane;
				if((pane = getFullPane(riorganizedPane)) == null) break;
				int index = Integer.valueOf(((Label) pane.lookup("#index")).getText()) - 1;
				pane.getChildren().clear();
				nuovaSquadra[i] = allenatore.getPokemonById(index);
			}
			
			this.allenatore.setSquadra(nuovaSquadra);
			
			SaveManager.save(this.allenatore);
			
			((Stage)((Node)event.getTarget()).getScene().getWindow()).close();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("NON HAI RIORGANIZZATO TUTTA LA SQUADRA");
			alert.showAndWait();
		}
	}
	
	/**
	 * Questo metodo serve a spostare un pane dalla parte della squadra non riorganizzata
	 * alla squadra riorganizzata
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void toRiorganize(MouseEvent event) {
		Pane free = getFreePane(riorganizedPane);
		if(free != null) {
			Object source = event.getTarget();
			Pane pane = null;
			if (source instanceof ImageView) {
				pane = (Pane) ((ImageView)source).getParent();
	        } else if (source instanceof Pane) {
	            pane = (Pane) source; 
	        }else if ( source instanceof Text){
	        	pane = (Pane) ((Text) source).getParent().getParent();
	        }else {
	        	pane = (Pane) ((Label) source).getParent();
	        }
			
			free.getChildren().addAll(pane.getChildren());
			free.setOnMouseClicked(this::toSquad);
			free.getStyleClass().add("paneCell");
			free.setOnMouseEntered(evento -> {
	            free.setCursor(Cursor.HAND);
	        });
			
			free.setOnMouseExited(evento -> {
	            free.setCursor(Cursor.DEFAULT);
	        });
			
			pane.setCursor(Cursor.DEFAULT);
			pane.setOnMouseEntered(null);
			pane.setOnMouseExited(null);
			
			pane.getChildren().clear();
			
			pane.setOnMouseClicked((useless)->{});
			pane.getStyleClass().remove("paneCell");
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("ESISTONO TROPPI POKEMON CONTEMPORANEAMENTE");
			alert.showAndWait();
		}
	}
	
	/**
	 * Questo metodo serve a spostare un pane dalla parte della squadra riorganizzata
	 * alla squadra non riorganizzata
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void toSquad(MouseEvent event) {
		Pane free = getFreePane(squadPane);
		if(free != null) {
			Object source = event.getTarget();
			Pane pane = null;
			if (source instanceof ImageView) {
				pane = (Pane) ((ImageView)source).getParent();
	        } else if (source instanceof Pane) {
	            pane = (Pane) source; 
	        }else if ( source instanceof Text){
	        	pane = (Pane) ((Text) source).getParent().getParent();
	        }else {
	        	pane = (Pane) ((Label) source).getParent();
	        }
			
			free.getChildren().addAll(pane.getChildren());
			free.setOnMouseClicked(this::toRiorganize);
			free.getStyleClass().add("paneCell");
			free.setOnMouseEntered(evento -> {
	            free.setCursor(Cursor.HAND);
	        });
			free.setOnMouseExited(evento -> {
	            free.setCursor(Cursor.DEFAULT);
	        });
			
			
			pane.setCursor(Cursor.DEFAULT);
			pane.setOnMouseEntered(null);
			pane.setOnMouseExited(null);
			
			pane.getChildren().clear();
			pane.setOnMouseClicked((useless)->{});
			pane.getStyleClass().remove("paneCell");
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
			alert.setTitle("Errore");
			alert.setContentText("ESISTONO TROPPI POKEMON CONTEMPORANEAMENTE");
			alert.showAndWait();
		}
	}
	
	
	/**
	 * setta l'idChoose
	 * 
	 * @param id String
	 * @return void.
	 */
	public void setIdChoose(String id) {
		this.idChoose = id;
	}
	
	/**
	 * setta il controller padre
	 * 
	 * @param controller ControllerChoosePlayer
	 * @return void.
	 */
	public void setControllerOwner(ControllerChoosePlayer controller) {
		this.controllerOwner = controller;
	}
	
	/**
	 * setta il controller padre
	 * 
	 * @param controller ControllerChoosePlayerFranco
	 * @return void.
	 */
	public void setControllerOwner(ControllerChoosePlayerFranco controller) {
		this.controllerOwnerFranco = controller;
	}
	
	
	/**
	 * restituisce un pane libero nei figli pane del mainPane
	 * 
	 * @param mainPane Pane
	 * @return Pane.
	 */
	private Pane getFreePane(Pane mainPane){
		ObservableList<Node> childrens =  mainPane.getChildren();
		
		for(Node children: childrens) {
			Pane pane = (Pane)children;
			if(pane.getChildren().isEmpty()) return pane;
		}
		
		return null;
	}
	
	/**
	 * restituisce un pane pieno nei figli pane del mainPane
	 * 
	 * @param mainPane Pane
	 * @return Pane.
	 */
	private Pane getFullPane(Pane mainPane) {
		ObservableList<Node> childrens =  mainPane.getChildren();
		
		for(Node children: childrens) {
			Pane pane = (Pane)children;
			if(!pane.getChildren().isEmpty()) return pane;
		}
		
		return null;
	}
	
	/**
	 * restituisce se un pane figlio mainPane e' vuoto o no
	 * 
	 * @param mainPane Pane
	 * @return boolean.
	 */
	private boolean isEmptyPane(Pane mainPane){
		ObservableList<Node> childrens =  mainPane.getChildren();
		
		for(Node children: childrens) {
			Pane pane = (Pane)children;
			if(!pane.getChildren().isEmpty()) return false;
		}
		
		return true;
	}
	
}
