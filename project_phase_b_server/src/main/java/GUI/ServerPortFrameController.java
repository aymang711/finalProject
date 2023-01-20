package GUI;

import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import common.Contact;
import database.ContactHandler;
import database.DBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//import logic.Exam;


public class ServerPortFrameController  implements Initializable {
	// private Pane root = new Pane();
	private Label Host = new Label();
	private Label IP = new Label();
	private Label Status = new Label();
	private Label Hosttxt = new Label();
	private Label IPtxt = new Label();
	private Label Statustxt = new Label();
	public static boolean firstTime = false;
	@FXML
	TableView<clientDetails> tableServer;
	@FXML
	private  TableColumn<clientDetails, String> colHostName;
	@FXML
	private  TableColumn<clientDetails, String> colIP;
	@FXML
	private  TableColumn<clientDetails, String> colStatus;
	private static ObservableList<clientDetails> clients=FXCollections.observableArrayList();
	private static ArrayList<clientDetails> clientArrayList = new ArrayList<clientDetails>();

	public void start(Stage primaryStage) throws Exception {
		IP.setText("IP: ");
		Host.setText("Host: ");
		Status.setText("Status: ");
		Hosttxt.setText(" ");
		IPtxt.setText(" ");
		Statustxt.setText(" ");

		/*
		 * root.getChildren().add(Host); Host.setLayoutX(14); Host.setLayoutY(40);
		 * root.getChildren().add(IP); IP.setLayoutX(14); IP.setLayoutY(89);
		 * root.getChildren().add(Status); Status.setLayoutX(14);
		 * Status.setLayoutY(132); root.getChildren().add(Hosttxt);
		 * Hosttxt.setLayoutX(84); Hosttxt.setLayoutY(40);
		 * root.getChildren().add(IPtxt); IPtxt.setLayoutX(84); IPtxt.setLayoutY(89);
		 * root.getChildren().add(Statustxt); Statustxt.setLayoutX(82);
		 * Statustxt.setLayoutY(132);
		 */
		FXMLLoader loader = new FXMLLoader();

		Pane root = loader.load(getClass().getResource("/GUI/serverFxml.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		ServerUI.runServer(ServerUI.DEFAULT_PORT);
		DBO.connecttodb();
		//ServerUI.runServer(ServerUI.DEFAULT_PORT);

//		primaryStage.setTitle("Server");
//		primaryStage.setScene(new Scene(root,360,260));
//		primaryStage.show();
//		ServerUI.runServer(ServerUI.DEFAULT_PORT);
	}

	

	
	public void startServerBtn(ActionEvent event) throws Exception {
		ServerUI.runServer(ServerUI.DEFAULT_PORT);
		DBO.connecttodb();
		
		
	}
	public void getExitBtn(ActionEvent event) throws Exception {
	    System.out.println("exit Exams Tool");
		System.exit(0);
	
	}




	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}



	


		


	
	
}