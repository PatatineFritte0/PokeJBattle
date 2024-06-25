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
import model.FactoryPkmn;
import model.Pokemon;
import model.SaveManager;

public class ControllerReorganizePkmn {
	private String idChoose;
	
	public ControllerChoosePlayer controllerOwner;
	
	@FXML
	private Label nicknameLabel;
	
	@FXML
	private Pane riorganizedPane;
	
	@FXML
	private Pane squadPane;
	
	public Allenatore allenatore;

	private ControllerChoosePlayerFranco controllerOwnerFranco;
	
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
	
	
	public void setIdChoose(String id) {
		this.idChoose = id;
	}
	
	public void setControllerOwner(ControllerChoosePlayer controller) {
		this.controllerOwner = controller;
	}
	
	public void setControllerOwner(ControllerChoosePlayerFranco controller) {
		this.controllerOwnerFranco = controller;
	}
	
	
	private Pane getFreePane(Pane mainPane){
		ObservableList<Node> childrens =  mainPane.getChildren();
		
		for(Node children: childrens) {
			Pane pane = (Pane)children;
			if(pane.getChildren().isEmpty()) return pane;
		}
		
		return null;
	}
	
	private Pane getFullPane(Pane mainPane) {
		ObservableList<Node> childrens =  mainPane.getChildren();
		
		for(Node children: childrens) {
			Pane pane = (Pane)children;
			if(!pane.getChildren().isEmpty()) return pane;
		}
		
		return null;
	}
	
	
	private boolean isEmptyPane(Pane mainPane){
		ObservableList<Node> childrens =  mainPane.getChildren();
		
		for(Node children: childrens) {
			Pane pane = (Pane)children;
			if(!pane.getChildren().isEmpty()) return false;
		}
		
		return true;
	}
	
}
