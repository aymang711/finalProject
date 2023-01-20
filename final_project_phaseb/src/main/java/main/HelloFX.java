package main;
import GUI.HomePage;
import getway.ClientController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
	public static ClientController chat;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		chat = new ClientController("localhost", 5555);
		HomePage first = new HomePage();
		first.start(stage);
		
	}
	@Override
	public void stop() throws Exception {
		System.exit(0);
	}

}