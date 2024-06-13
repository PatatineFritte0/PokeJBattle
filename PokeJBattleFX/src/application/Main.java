package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.MainTest;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/BattleJPoke.fxml"));
			Scene scene = new Scene(root,1000,800);
			scene.getStylesheets().add(getClass().getResource("../view/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			
			Image icon = new Image("./view/img/pokeIcon2.PNG");
			primaryStage.getIcons().add(icon);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
		MainTest.test(args);
		System.exit(0);

	}
}
