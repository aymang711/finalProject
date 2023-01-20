// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package getway;

import ocsf.client.*;
import java.util.stream.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import common.ChatIF;
import common.ClientOffer;
import common.Contact;
import common.Messages;
import common.MessagesClass;
import common.answerSupplier;
import common.inventory;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ClientHandler extends AbstractClient {

	// Instance variables **********************************************
	public static ArrayList<Contact> contacts;
	public static ArrayList<inventory> packingList;
	public static ArrayList<ClientOffer> clientOffer;
	public static Boolean isSucces;
	public static ArrayList<ClientOffer> offerToConfirm;
	public static ArrayList<ClientOffer> offerToCreate;
	public static ArrayList<answerSupplier> requestForAnswer;
	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;
	// public static ArrayList<Exam> exams;
	public static boolean awaitResponse = false;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host     The server to connect to.
	 * @param port     The port number to connect on.
	 * @param clientUI The interface type variable.
	 */

	public ClientHandler(String host, int port, ChatIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		openConnection();

	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg The message from the server.
	 */
	@SuppressWarnings("unchecked")
	public void handleMessageFromServer(Object msg) {
		awaitResponse = false;

		System.out.println("--> handleMessageFromServer");

		MessagesClass message = (MessagesClass) msg;
		
		switch(message.getMsgType())
		{
		case getContacts:
			ArrayList<Contact> contacts = new ArrayList<Contact>();
			contacts=(ArrayList<Contact>)message.getMsgData();
			ClientHandler.contacts=(ArrayList<Contact>)message.getMsgData();
			
			for(Contact c :contacts) {
				System.out.println(c);
			}
			break;
		case postPackingList: 
			packingList = (ArrayList<inventory>)message.getMsgData();
			break ;
		case getAnswersAndRequest: 
			ArrayList<ClientOffer> offer = (ArrayList<ClientOffer>)message.getMsgData();
			if(offer.size()>0)
				clientOffer = offer;
			else 
				clientOffer = null;
		 break;
		case saveOffer:
			
			isSucces= (Boolean) message.getMsgData();
			break;
		case getTheOffer:
			offer=(ArrayList<ClientOffer>)message.getMsgData();;
			 offerToConfirm=(ArrayList<ClientOffer>)message.getMsgData();
			 if(offer.size()>0)
				 offerToConfirm = offer;
				else 
					offerToConfirm = null;
			break;
		case getOfferToCreate:
			offer=(ArrayList<ClientOffer>)message.getMsgData();
			 if(offer.size()>0)
				 offerToCreate = offer;
				else 
					offerToCreate = null;
			break;
		case getRequestForAnswer:
			ArrayList<answerSupplier> requestForAnswerTemp=(ArrayList<answerSupplier>) message.getMsgData();
			if(requestForAnswerTemp!=null&&requestForAnswerTemp.size()>0)
			   requestForAnswer = requestForAnswerTemp;
			else 
				requestForAnswer=null;
		  break;
			default : break;
			
		}
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message The message from the UI.
	 */

	public void handleMessageFromClientUI(Object message) {
		// openConnection(); //in order to send more than one message

		awaitResponse = true;
		try {
			sendToServer(message);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// wait for response
		while (awaitResponse) {
			try {

				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			sendToServer(new MessagesClass(Messages.Disconnected, null));

			closeConnection();

		} catch (IOException e) {

		}

		// System.exit(0);
	}
}
//End of ChatClient class
