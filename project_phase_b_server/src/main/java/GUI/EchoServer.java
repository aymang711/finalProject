// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package GUI;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import common.ClientOffer;
import common.Contact;
import common.Messages;
import common.MessagesClass;
import common.RequestOrder;
import common.answerSupplier;
import common.inventory;
import database.ContactHandler;
import database.OfferHandler;
import database.getAnswerAndRequestHandler;
import database.inventoryHandler;
import database.newAnswerHandler;
import database.newRequestHandler;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer {

	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	// final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 * 
	 */

	public EchoServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 * @param
	 */
	@SuppressWarnings("unchecked")
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		System.out.println("getting the request in the server ...");
		// System.out.println("message:"+(String)msg);
		if (msg instanceof MessagesClass) {
			MessagesClass  ms = (MessagesClass) msg;
			try {
				
				switch (((MessagesClass) msg).getMsgType()) {
				case getContacts:
					ArrayList<Contact> contacts = ContactHandler.getContact();

					MessagesClass response = new MessagesClass(Messages.getContacts, contacts);

					client.sendToClient(response);
					
					break;
					////////////////////////
				case addContact: 
					ContactHandler.addContact((Contact)(((MessagesClass) msg).getMsgData()));
					client.sendToClient(msg);
					break;
					
				case getPackingList:
					ArrayList<inventory> packingList = inventoryHandler.getPackingList();
					MessagesClass responsePackingList = new MessagesClass(Messages.postPackingList, packingList);
					client.sendToClient(responsePackingList);
					
					break;
				case SaveTheNewRequest:
					ArrayList<RequestOrder> requests= (ArrayList<RequestOrder> ) ms.getMsgData();
					newRequestHandler.addNewRequest(requests);
					client.sendToClient(msg);
					break;
				case SaveTheNewAnswer:
					ArrayList<answerSupplier> answers= (ArrayList<answerSupplier> ) ms.getMsgData();
					newAnswerHandler.addNewAnswer(answers);
					client.sendToClient(msg);
					break;
				case getAnswersAndRequest:
					String requestid= (String)ms.getMsgData();
					
					ArrayList<ClientOffer> offer=getAnswerAndRequestHandler.getOffer(requestid);
					System.out.println("from the echo server : "+offer);
					client.sendToClient(new MessagesClass(Messages.getAnswersAndRequest, offer));
				break;
				case saveOffer:
					Boolean isSucess = OfferHandler.addNewOffer((ArrayList<ClientOffer>)ms.getMsgData());
					MessagesClass succescMessage= new MessagesClass(Messages.saveOffer, isSucess);
					client.sendToClient(succescMessage);
					break;
				case getTheOffer:
					requestid=(String)ms.getMsgData();
					
					ArrayList<ClientOffer> responseOffer = OfferHandler.getOffer(requestid);
					client.sendToClient(new MessagesClass(Messages.getTheOffer,responseOffer));
					break;
				case getOfferToCreate:
					requestid=(String)ms.getMsgData();				
					ArrayList<ClientOffer> responseOffertoCreate = OfferHandler.getOffer(requestid);
					client.sendToClient(new MessagesClass(Messages.getOfferToCreate,responseOffertoCreate));
					break;
				case getRequestForAnswer:
					
					requestid=(String)ms.getMsgData();	
					ArrayList<RequestOrder> responseRequestTo = newRequestHandler.getRequest(requestid);
					ArrayList<answerSupplier>  realResposne = newAnswerHandler.mapRequestToAnswer(responseRequestTo);
					client.sendToClient(new MessagesClass(Messages.getRequestForAnswer,realResposne));

					break;
				default:
					client.sendToClient(new MessagesClass(Messages.error,null));
					break;

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					client.sendToClient(new MessagesClass(Messages.error,null));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			catch (Exception e)
			{
				try {
					client.sendToClient(new MessagesClass(Messages.error,null));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

	}

//////end of switch loop /////////////////////////////////////////////////////////////////////////////

	public void clientConnected(ConnectionToClient client) {
		try {
			System.out.println(client.getInetAddress().getLocalHost()+ client.getInetAddress().getHostName() + "Connected");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clientDisconnected(ConnectionToClient client) {
		System.out.println("->Client DisConnected");
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());

	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}
}
//End of EchoServer class
