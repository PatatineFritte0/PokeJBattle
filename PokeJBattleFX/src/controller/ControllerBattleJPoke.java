package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe controller della schermata principale che ha il compito di gestire
 * tutta l'interfaccia della schermata principale.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerBattleJPoke {
	
	
	/**
	 * Questo metodo serve a cambiare schermata
	 *
	 * @param event ActionEvent ci sono informazioni utili correlate all evento.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void sceneNewProfile(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/newSave.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Questo metodo serve a cambiare schermata
	 *
	 * @param event ActionEvent ci sono informazioni utili correlate all evento.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void sceneChoose(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ChoosePlayers.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Questo metodo serve a cambiare schermata
	 *
	 * @param event ActionEvent ci sono informazioni utili correlate all evento.
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void sceneChooseFranco(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ChoosePlayerFranco.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}