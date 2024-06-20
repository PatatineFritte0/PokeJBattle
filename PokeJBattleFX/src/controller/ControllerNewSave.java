package controller;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Allenatore;
import model.Pokemon;
import model.SaveManager;

public class ControllerNewSave {
	@FXML
	AnchorPane newSaveAnchor;
	
	public Pokemon[] squadra = new Pokemon[6];
	
	private boolean nicknameRight = false;
	
	public void openListPkmn(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/listPkmn.fxml"));
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root.load());
		
		ControllerListPkmn controller = root.getController();
		controller.setPriviusEvent(event);
		controller.setControllerOwner(this);
		
		Stage pkmn = new Stage();
		pkmn.setScene(scene);
		
		Image icon = new Image("./view/img/pokeIcon2.PNG");
		pkmn.getIcons().add(icon);
		pkmn.setTitle("Scelta Pokemon");
		
		pkmn.setResizable(false);
		pkmn.initModality(Modality.APPLICATION_MODAL);
		
		pkmn.initOwner(owner);
		
		pkmn.showAndWait();
	}
	
	public void controlNickname(KeyEvent event){
		TextField textField = (TextField) event.getTarget();
		String text = textField.getText();
		
		Scene myScene = ((Node)event.getSource()).getScene();
		Label errLabel = (Label) myScene.lookup("#errNickname");
		
		if(text.equals("")) {
			errLabel.setText("Il nickname non puo'\nessere vuoto, avrai\npur un nome te no?");
			return;
		}else if(controlEqualNickname(text)){
			errLabel.setText("Nickname gia esistente");
		}else {
			errLabel.setText("");
		}
		
		this.nicknameRight = true;
	}
	
	public boolean controlEqualNickname(String nickname){
		List<Allenatore> allenatori = SaveManager.getSaves();
		for(Allenatore al: allenatori) {
			if(nickname.toLowerCase().equals(al.getNickname().toLowerCase())) return true;
		}
		
		return false;
	}
	
	public void controlDone(ActionEvent event) throws IOException{
		Scene myScene = ((Node)event.getSource()).getScene();
		
		Label errLabel = (Label) myScene.lookup("#errCrea");
		String errText = "";
		boolean error = false;
		if(isArrayFullOfNulls(this.squadra)) {
			errText += "Inserisci in squadra almeno un pokemon";
			error = true;
		}
		if(!this.nicknameRight) {
			if(!errText.equals("")) {
				errText+='\n';
			}
			errText += "Nickname non valido";
			error = true;
		}
		
		errLabel.setText(errText);
		
		if(error) return;
		
		String nickname = ((TextField) myScene.lookup("#nicknameField")).getText();
		
		Allenatore nuovoAllenatore = new Allenatore(nickname, this.squadra);
		

		SaveManager.newSave(nuovoAllenatore);

		Stage stage = (Stage) myScene.getWindow();
		
		FXMLLoader choose = new FXMLLoader(getClass().getResource("../view/fxml/ChoosePlayers.fxml"));
		stage.setScene(new Scene(choose.load()));

		
	}
	
	private boolean isArrayFullOfNulls(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return false;
            }
        }
        return true;
	}
	
	public void back(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
		Scene scene = new Scene(root.load());
		
		Stage owner = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		owner.setScene(scene);
		owner.show();
	}
}
