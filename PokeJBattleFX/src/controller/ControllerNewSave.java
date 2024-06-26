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


/**
 * Classe controller del nuovo salvataggio che ha il compito di gestire
 * tutta l'interfaccia del nuovo salvataggio.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class ControllerNewSave {
	/**
	 * Anchor pane principale dell interfaccia
	 */
	@FXML
	AnchorPane newSaveAnchor;
	
	/**
	 * Possibile squadra per un nuovo allenatore
	 */
	public Pokemon[] squadra = new Pokemon[6];
	
	/**
	 * booleana per il controllo del nickname
	 */
	private boolean nicknameRight = false;
	
	
	/**
	 * Questo metodo apre l'interfaccia della lista pokemon disponibili
	 * inizializzando il suo controller con dei dati utili.
	 * 
	 * 
	 * @param event MouseEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
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
	
	
	/**
	 * Questo metodo serve a controllare se il nickname dell utente abbia senso
	 * o sia disponibile, questo viene rifatto ogni volta che digita un carattere
	 * nella text field
	 * 
	 * 
	 * @param event KeyEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 */
	public void controlNickname(KeyEvent event){
		TextField textField = (TextField) event.getTarget();
		String text = textField.getText();
		
		Scene myScene = ((Node)event.getSource()).getScene();
		Label errLabel = (Label) myScene.lookup("#errNickname");
		
		if(text.equals("")) {
			errLabel.setText("Il nickname non puo'\nessere vuoto, avrai\npur un nome te no?");
			this.nicknameRight = false;
			return;
		}else if(controlEqualNickname(text)){
			errLabel.setText("Nickname gia esistente");
			this.nicknameRight = false;
			return;
		}else {
			errLabel.setText("");
		}
		
		this.nicknameRight = true;
	}
	
	/**
	 * Questo metodo serve a controllare se nella lista di salvataggi c'e' un nome
	 * simile a quello nel parametro.
	 * 
	 * 
	 * @param nickname String contiene il nickname che si vuole provare a creare
	 * @return void.
	 */
	public boolean controlEqualNickname(String nickname){
		List<Allenatore> allenatori = SaveManager.getSaves();
		for(Allenatore al: allenatori) {
			if(nickname.toLowerCase().equals(al.getNickname().toLowerCase())) return true;
		}
		
		return false;
	}
	
	
	/**
	 * Questo metodo serve a controllare se tutti i campi sono stati compilati
	 * correttamente, nel caso sia cosi, crea un nuovo salvataggio riportando alla
	 * schermata principale.
	 * 
	 * 
	 * @param event ActionEvent ci sono informazioni utili correlate all evento
	 * @return void.
	 * @throws IOException puo essere lanciata se il file fxml e' errato o inesistente.
	 */
	public void controlDone(ActionEvent event) throws IOException{
		Scene myScene = ((Node)event.getSource()).getScene();
		
		Label errLabel = (Label) myScene.lookup("#errCrea");
		String errText = "";
		boolean error = false;
		if(isArrayFullOfNulls(this.squadra)) {
			errText += "Inserisci in squadra\nalmeno un pokemon.";
			error = true;
		}
		if(!this.nicknameRight) {
			if(!errText.equals("")) {
				errText+='\n';
			}
			errText += "Nickname non valido.";
			error = true;
		}
		
		errLabel.setText(errText);
		
		if(error) return;
		
		String nickname = ((TextField) myScene.lookup("#nicknameField")).getText();
		
		Allenatore nuovoAllenatore = new Allenatore(nickname, this.squadra);
		

		SaveManager.newSave(nuovoAllenatore);

		Stage stage = (Stage) myScene.getWindow();
		
		FXMLLoader choose = new FXMLLoader(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
		stage.setScene(new Scene(choose.load()));

		
	}
	
	
	/**
	 * Questo metodo serve a controllare se l'array e' pieno di null o meno
	 * 
	 * 
	 * @param array Object[]
	 * @return boolean.
	 */
	private boolean isArrayFullOfNulls(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return false;
            }
        }
        return true;
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
}
