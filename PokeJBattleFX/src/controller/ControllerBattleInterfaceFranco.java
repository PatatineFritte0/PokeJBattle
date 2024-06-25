package controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Allenatore;
import model.Franco;
import model.Pokemon;
import model.SaveManager;
import model.UsableMove;
import model.costanti.Mossa;

public class ControllerBattleInterfaceFranco extends ControllerBattleInterface{
	
	@Override
	protected void aggiornaStatPokemon(Allenatore allenatore, String player) {
		String verso;
		Pane p;
		Pokemon main = allenatore.getMainPokemon();
		if(player.equals("P1")) {
			verso = "Back";
			
			p = (Pane) battleAnchor.lookup("#"+player);
			
			ProgressBar barExp = ((ProgressBar)p.lookup("#progresExpPokemon"));
			double progressExp = Double.valueOf(main.getCurrentExp())/Double.valueOf(main.getNextLvlExp());
			double currentExp = barExp.getProgress();
			
			animateProgressBar(barExp, currentExp, progressExp, 0.5);
		}else if(player.equals("P2")) {
			verso = "Front";
			
			
			p = (Pane) battleAnchor.lookup("#"+player);
			
			ProgressBar barExp = ((ProgressBar)p.lookup("#progresExpPokemon"));
			double progressExp = Double.valueOf(0);
			double currentExp = barExp.getProgress();
			
			animateProgressBar(barExp, currentExp, progressExp, 0.5);
		}else {
			System.out.println("ERR");
			return;
		}
		
		for(int i = 0; i<6; i++) {
			if(allenatore.getPokemonById(i) != null) {
				if(allenatore.getPokemonById(i).getBattlePs() <= 0) {
					p.lookup("#poke"+i).setStyle("-fx-background-image: url(./view/img/esausto.png);");
				}else {
					p.lookup("#poke"+i).setStyle("-fx-background-image: url(./view/img/pokeball.png);");
				}
			}
		}
		
		p.lookup("#imgPokemon").setStyle("-fx-background-image: url(./view/img/"+main.getNome().toLowerCase()+verso+".png);");
		
		((Label)p.lookup("#nomePokemon")).setText(main.getNome());
		((Label)p.lookup("#lvlPokemon")).setText(String.valueOf(main.getLvl()));
		((Label)p.lookup("#currentHP")).setText(String.valueOf(main.getBattlePs()));
		((Label)p.lookup("#maxHP")).setText(String.valueOf(main.getMaxPs()));
		
		ProgressBar barHp = ((ProgressBar)p.lookup("#progresHPPokemon"));
		double progressHp = Double.valueOf(main.getBattlePs())/Double.valueOf(main.getMaxPs());
		double currentHp = barHp.getProgress();
		
		animateProgressBar(barHp, currentHp, progressHp, 1);
		
		String color = "green";
		if(progressHp > 0.5) color = "green";
		if(progressHp <= 0.5 && progressHp >= 0.2 ) color = "orange";
		if(progressHp < 0.2) color = "red";
		barHp.setStyle("-fx-accent: "+color);
	}
	
	@Override
	protected void sceltaP1(MouseEvent event) {
		Object source = event.getTarget();
		Pane pane = null;
		if (source instanceof Pane) {
			pane = (Pane) source;
        }else if (source instanceof Text){
        	pane = (Pane) ((Text) source).getParent().getParent();
        }else {
        	pane = (Pane) ((Label) source).getParent();
        }
		
		UsableMove mossa = allenatore.getMainPokemon().getMosse()[Integer.valueOf(String.valueOf( pane.getId().charAt(pane.getId().length() - 1)))];
		if(mossa.getPp() == 0) return;
		this.m1 = mossa.getMossa();
		
		//aggiornaTurno(sfidante.getMainPokemon(), "P2");
		
		this.m2 = ((Franco)sfidante).agisci();
		if(this.m2 == Mossa.CAMBIA) {
			indexCambioSfidante = ((Franco)sfidante).cambia();
		}
		
		try {
			turno();
		} catch (InterruptedException | IOException e) {e.printStackTrace();}	
	}
	
	@Override
	public void mossaCambia(MouseEvent event) throws IOException {
		Pane activePlayerPane = (Pane)battleAnchor.lookup(".active");
		
		String player = activePlayerPane.getParent().getId();
		
		if(player.equals("P1")) {
			m1 = Mossa.CAMBIA;
			System.out.println("Ciao");
			sostituisciPkmn(allenatore, false);
			if(indexCambioAllenatore != allenatore.getPokemonId(allenatore.getMainPokemon())) {
				//aggiornaTurno(sfidante.getMainPokemon(), "P2");
				this.m2 = ((Franco)sfidante).agisci();
				if(this.m2 == Mossa.CAMBIA) {
					indexCambioSfidante = ((Franco)sfidante).cambia();
				}
				try {
					turno();
				} catch (InterruptedException | IOException e) {e.printStackTrace();}
			}
		}
		
	}
	
	@Override
	public void sostituisciPkmn(Allenatore trainer, boolean disableClose) throws IOException{
		if(trainer instanceof Franco) {return;}
		FXMLLoader root = new FXMLLoader(getClass().getResource("../view/fxml/squadra.fxml"));
		
		Stage owner = (Stage)(battleAnchor.getScene().getWindow());
		
		Scene scene;
		scene = new Scene(root.load());
	
		ControllerSquadra controller = root.getController();
		
		
		controller.setControllerOwner(this);
		controller.setAllenatore(trainer);
		
		Stage pkmn = new Stage();
		pkmn.setScene(scene);
		
		Image icon = new Image("./view/img/pokeIcon2.PNG");
		pkmn.getIcons().add(icon);
		pkmn.setTitle("Sostituisci Pokemon");
		
		pkmn.setResizable(false);
		pkmn.initModality(Modality.APPLICATION_MODAL);
		if (disableClose) {
			pkmn.setOnCloseRequest(event ->{
				 // Intercetta l'evento di chiusura
	            event.consume();
	
	            // Mostra un messaggio all'utente
	            Alert alert = new Alert(AlertType.INFORMATION);
	            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
	            alert.setTitle("Attenzione");
	            alert.setHeaderText("Chiusura disabilitata");
	            alert.setContentText("La chiusura della finestra è disabilitata. Scegli prima un pokemon");
	            alert.showAndWait();
			});
		}
		
		pkmn.initOwner(owner);
		
		pkmn.showAndWait();
	}
	
	
	@Override
	public void resa() {
		Pane activePlayerPane = (Pane)battleAnchor.lookup(".active");
		
		String player = activePlayerPane.getParent().getId();
		
		if(player.equals("P1")) {
			m1 = Mossa.RESA;
			//aggiornaTurno(sfidante.getMainPokemon(), "P2");
			this.m2 = ((Franco)sfidante).agisci();
			if(this.m2 == Mossa.CAMBIA) {
				indexCambioSfidante = ((Franco)sfidante).cambia();
			}
			try {
				turno();
			} catch (InterruptedException | IOException e) {e.printStackTrace();}
		}
	}
	
	
	@Override
	public void turno() throws InterruptedException, IOException {
		iniziaTurno();
		
		learnMove(allenatore);
		//learnMove(sfidante);
		
		((TextArea)battleAnchor.lookup("#log")).setText(this.log);
		this.log = "";
		
		aggiornaStatPokemon(allenatore, "P1");
		aggiornaStatPokemon(sfidante, "P2");
		
		Allenatore vincitore = checkVincitore();
		if(vincitore != null) {
			Thread.sleep(1000);
			Pane winnerPane;
			Allenatore allePerdente;
			if(vincitore == allenatore) {
				winnerPane = (Pane)(battleAnchor.lookup("#P1"));
				allePerdente = sfidante;
			}else {
				winnerPane = (Pane)(battleAnchor.lookup("#P2"));
				allePerdente = allenatore;
			}
			
			Label nVittorie = (Label)winnerPane.lookup("#nVittorie");
			nVittorie.setText(String.valueOf(Integer.valueOf(nVittorie.getText()) + 1));
			
			for(int i = 0; i<6; i++) {
				Pokemon pkmn = allenatore.getPokemonById(i);
				if(pkmn != null) {
					pkmn.resetStats();				
				}
				pkmn = sfidante.getPokemonById(i);
				if(pkmn != null) {
					pkmn.resetStats();
					//pkmn.evolve();				
				}
			}
			
			controlloEvoluzioni(allenatore);
			//controlloEvoluzioni(sfidante);
			
			allenatore.setMainPokemon(0);
			sfidante.setMainPokemon(0);
			
			if(Integer.valueOf(nVittorie.getText()) == 1) {
				vincitore.setVittorie(vincitore.getVittorie() + 1);
				allePerdente.setSconfitte(allePerdente.getSconfitte() + 1);
				
				Alert alert = new Alert(AlertType.INFORMATION);
				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("./view/img/pokeIcon2.PNG"));
	            alert.setTitle("Vittoria");
	            alert.setHeaderText("Vittoria per "+ vincitore.getNickname());
	            alert.setContentText("Procedo a caricare la schermata di titolo");
	            
	            alert.setOnCloseRequest(menuPrincipale());
	            
	            alert.showAndWait();
			}
			
			SaveManager.save(allenatore);
			SaveManager.save(sfidante);
			
		}else {
			if(allenatore.getMainPokemon().getBattlePs() == 0) {
				sostituisciPkmn(allenatore, true);
			}
			if(sfidante.getMainPokemon().getBattlePs() == 0) {
				sostituisciPkmn(sfidante, true);
			}
		}
		
		aggiornaStatPokemon(allenatore, "P1");
		aggiornaStatPokemon(sfidante, "P2");
		
		aggiornaTurno(allenatore.getMainPokemon(), "P1");
	}
	
	@Override
	public void iniziaTurno() {
		this.log += "\n-----\nInizio turno: [" + this.allenatore.getNickname() + ":" + this.countAllenatore + ", " + this.sfidante.getNickname() + ":" + this.countSfidante + "]\n";

		int danno = 0;
		
		if(this.m1 == Mossa.RESA) {
			this.countAllenatore.set(0);
			this.log += "\nRESA di " + this.allenatore.getNickname();
			return;
		}
		if(this.m2 == Mossa.RESA) {
			this.countSfidante.set(0);
			this.log += "\nRESA di " + this.sfidante.getNickname();
			return;
		}
		
		if(this.m1 == Mossa.CAMBIA && this.m2 != Mossa.CAMBIA) {
			Pokemon p = this.allenatore.getMainPokemon();
			this.allenatore.setMainPokemon(indexCambioAllenatore);
			this.log += "\n"+ allenatore.getNickname() + " sostituisce " + p.getNome() + " con " + allenatore.getMainPokemon().getNome()+"\n";
			
			scontro(this.sfidante, this.allenatore, m2);
			
			if(this.allenatore.getMainPokemon().getBattlePs() < 0) {
				this.allenatore.getMainPokemon().setBattlePs(0);
				
				this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
				esausto(this.allenatore, this.countAllenatore);
			}
			
		} else if(this.m1 != Mossa.CAMBIA && this.m2 == Mossa.CAMBIA) {
			Pokemon p = this.sfidante.getMainPokemon();
			this.sfidante.setMainPokemon(indexCambioSfidante);
			this.log += "\n"+ sfidante.getNickname() + " sostituisce " + p.getNome() + " con " + sfidante.getMainPokemon().getNome()+"\n";
			
			scontro(this.allenatore, this.sfidante, this.m1);
			
			if(this.sfidante.getMainPokemon().getBattlePs() < 0) {
				this.sfidante.getMainPokemon().setBattlePs(0);
				
				this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
				esausto(this.sfidante, this.countSfidante);
			}
		}else if(this.m1 == Mossa.CAMBIA && this.m2 == Mossa.CAMBIA) {
			Pokemon p = this.allenatore.getMainPokemon();
			this.allenatore.setMainPokemon(indexCambioAllenatore);
			this.log += "\n"+ allenatore.getNickname() + " sostituisce " + p.getNome() + " con " + allenatore.getMainPokemon().getNome()+"\n";
			
			p = this.sfidante.getMainPokemon();
			this.sfidante.setMainPokemon(indexCambioSfidante);
			this.log += "\n"+ sfidante.getNickname() + " sostituisce " + p.getNome() + " con " + sfidante.getMainPokemon().getNome()+"\n";
			
		}else {
			if(this.allenatore.getMainPokemon().getVelocitaBattaglia() >= this.sfidante.getMainPokemon().getVelocitaBattaglia()) {
				scontro(this.allenatore, this.sfidante, this.m1);
				
				if(this.sfidante.getMainPokemon().getBattlePs() > 0) {
					scontro(this.sfidante, this.allenatore, this.m2);
					
					if(this.allenatore.getMainPokemon().getBattlePs() <= 0) {
						this.allenatore.getMainPokemon().setBattlePs(0);
						
						this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
						esausto(this.allenatore, this.countAllenatore);
					}
				} else {
					this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
					
					this.sfidante.getMainPokemon().setBattlePs(0);
					esausto(this.sfidante, this.countSfidante);
				}
				
			} else {
				scontro(this.sfidante, this.allenatore, this.m2);
				
				if(this.allenatore.getMainPokemon().getBattlePs() > 0) {
					scontro(this.allenatore, this.sfidante, this.m1);
					
					if(this.sfidante.getMainPokemon().getBattlePs() <= 0) {
						this.sfidante.getMainPokemon().setBattlePs(0);
						
						this.allenatore.getMainPokemon().gainExp(this.sfidante.getMainPokemon());
						esausto(this.sfidante, this.countSfidante);
					}
				} else {
					this.sfidante.getMainPokemon().gainExp(this.allenatore.getMainPokemon());
					
					this.allenatore.getMainPokemon().setBattlePs(0);
					esausto(this.allenatore, this.countAllenatore);
				}
			}
		}
		//System.out.println(this.allenatore.getMainPokemon().battleData() + "\n\n" + this.sfidante.getMainPokemon().battleData());
		
		this.log += "\nFine turno: [" + this.allenatore.getNickname() + ":" + this.countAllenatore + ", " + this.sfidante.getNickname() + ":" + this.countSfidante + "]\n-----\n\n";
		return;
	}
	
	
	@Override
	protected void esausto(Allenatore trainer, AtomicInteger count) {
		System.out.println("\n" + trainer.getMainPokemon().getNome() + " e' esausto");
		count.set(count.get()-1);
		if(count.get() <= 0) {return;}
		this.log += "\n" + trainer.getMainPokemon().getNome() + " di " + trainer.getNickname() + " e' esausto!\n";
		String player = (trainer == allenatore) ? "P1" : "P2";
		
		aggiornaStatPokemon(trainer, player);
		
		if(player.equals("P1")){
			try {
				sostituisciPkmn(trainer, true);
			} catch (IOException e) {e.printStackTrace();}
		}else {
			indexCambioSfidante = ((Franco)trainer).cambia();
		}
		
		Pokemon p = trainer.getMainPokemon();
		
		int index = 6;
		if(trainer == allenatore) { index = indexCambioAllenatore; }
		else if(trainer == sfidante){ index = indexCambioSfidante; }
		
		trainer.setMainPokemon(index);
		this.log += "\n"+ trainer.getNickname() + " sostituisce " + p.getNome() + " con " + trainer.getMainPokemon().getNome()+"\n";

	}
	
}
	
