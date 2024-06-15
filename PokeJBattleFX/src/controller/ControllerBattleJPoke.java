package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerBattleJPoke {
	
	public void sceneNewProfile(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/newSave.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root,1000,800);
		stage.setScene(scene);
		stage.show();
	}
	
	public void sceneChoose(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ChoosePlayers.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root,1000,800);
		stage.setScene(scene);
		stage.show();
	}
}
