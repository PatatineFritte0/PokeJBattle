package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.fxml.FXMLLoader;

/**
 * Classe main dove viene fatta partire la prima interfaccia.
 * 
 * @author Simone Comignani, Simone Descontus
 * @version 1.0
 */
public class JPokeBattle extends Application {
	/**
	 * Fa partire la l'interfaccia grafica di javaFX.
	 *
	 * @param primaryStage Stage da dover far vedere.
	 * @return void.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Font.loadFont(getClass().getResourceAsStream("../view/fonts/PressStart2P.ttf"), 12);
			
			Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			
			primaryStage.setTitle("JPokeBattle");
			
			Image icon = new Image("./view/img/pokeIcon2.PNG");
			primaryStage.getIcons().add(icon);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		System.exit(0);

	}
}
