package GUI;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import common.ClientOffer;
import common.Contact;
import common.Messages;
import common.MessagesClass;
import common.RequestOrder;
import common.answerSupplier;
import common.inventory;
import getway.ClientController;
import getway.ClientHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import main.HelloFX;
import Logic.calculatePricesHandler;
import Logic.ExcelApi;

import java.util.stream.Stream;


public class HomePage  {
	
	
	@FXML
	private MenuItem orderMenu;
	@FXML
	private TableColumn<Contact,String> numberContact;
	@FXML 
	private TableColumn<Contact,String> nameContact;
	@FXML 
	private TableColumn<Contact,String> idContact;
	@FXML
	private TableView<Contact> ContactsTBL;
	
	ObservableList<Contact> data;
	
	
	public void start(Stage stage)   {
		
		
		System.out.println(getClass().getResource("HomePage.fxml"));
	
		Parent root;
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("HomePage.fxml").openStream());
			Scene scene = new Scene(root);
			 //scene.getStylesheets().add(getClass().getResource("/gui/AcademicFrame.css").toExternalForm());
			stage.setTitle("Final Project");
			stage.setScene(scene);

			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	

	}
	public void initialize() {
		HelloFX.chat.accept(new MessagesClass(Messages.getContacts, null));
		
		if(ClientHandler.contacts!=null)
		{
			data=FXCollections.observableArrayList(ClientHandler.contacts);
			initz();
			ContactsTBL.setItems(data);
		}
		HelloFX.chat.accept(new MessagesClass(Messages.getPackingList,null));
		if(ClientHandler.packingList!=null)
		{
			arrayListToSearch=ClientHandler.packingList;
			initzPacking();
			dataForPackingList=  FXCollections.observableArrayList(ClientHandler.packingList);
			packingTBL.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			packingTBL.setItems(dataForPackingList);
		}
	}
	
	
	public void ordersClick() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Test Connection");
		alert.setHeaderText("Results:");
		alert.setContentText("Connect to the database successfully!");

		alert.showAndWait();
		System.out.println("lasdas");
		//HelloFX.chat.accept(new MessagesClass(Messages.addContact, new Contact("","asdas","3213123")));
		HelloFX.chat.accept(new MessagesClass(Messages.getContacts, null));
	}
	
	
	private void initz() {
		idContact.setCellValueFactory(new PropertyValueFactory<Contact, String>("id"));
		nameContact.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
		numberContact.setCellValueFactory(new PropertyValueFactory<Contact, String>("phoneNumber"));
	
		
	}
	
	
	public void newFunc1() {
		System.out.println("i am on tab 1 ");
	}
	public void newFunc2() {
		System.out.println("i am on tab 2 ");
	}
	/////////////////////////////////////////////////////////////////////// Packing List ////////////////////////////////////////////
	
	
	@FXML
	private TableColumn<inventory,String> NO;
	@FXML 
	private TableColumn<inventory,String> SUPPLIER;
	@FXML 
	private TableColumn<inventory,String> CATALOG_NO;
	@FXML
	private TableColumn<inventory,String> DESCRIPTION;
	@FXML 
	private TableColumn<inventory,String> UNIT;
	@FXML 
	private TableColumn<inventory,String> QTY;
	@FXML
	private TableColumn<inventory,String> QUANTITY_IN_BOX;
	@FXML 
	private TableColumn<inventory,String> TOTAL_BOXES_COILS;
	@FXML 
	private TableColumn<inventory,String> BOX_SIZE;
	@FXML
	private TableColumn<inventory,String> BOX_COIL_NET_WEIGHT;
	@FXML 
	private TableColumn<inventory,String> BOX_COIL_GROSS_WEIGHT;
	@FXML 
	private TableColumn<inventory,String> TOTAL_NET_WEIGHT;
	@FXML
	private TableColumn<inventory,String> TOTAL_GROSS_WEIGHT;
	@FXML 
	private TableColumn<inventory,String> PALLET_NUMBER;
	@FXML 
	private TableColumn<inventory,String> BOXES_WITHOUT_PALLETS;
	
	@FXML
	private TextField serachTextHistory;

	
	
	@FXML
	private TableView<inventory> packingTBL;
	
	ObservableList<inventory> dataForPackingList;
	ArrayList<inventory> arrayListToSearch;
	
	private void initzPacking() {
		NO.setCellValueFactory(new PropertyValueFactory<inventory, String>("NO"));
		SUPPLIER.setCellValueFactory(new PropertyValueFactory<inventory, String>("SUPPLIER"));
		CATALOG_NO.setCellValueFactory(new PropertyValueFactory<inventory, String>("CATALOG_NO"));
		DESCRIPTION.setCellValueFactory(new PropertyValueFactory<inventory, String>("DESCRIPTION"));
		UNIT.setCellValueFactory(new PropertyValueFactory<inventory, String>("UNIT"));
		QTY.setCellValueFactory(new PropertyValueFactory<inventory, String>("QTY"));
		QUANTITY_IN_BOX.setCellValueFactory(new PropertyValueFactory<inventory, String>("QUANTITY_IN_BOX"));
		TOTAL_BOXES_COILS.setCellValueFactory(new PropertyValueFactory<inventory, String>("TOTAL_BOXES_COILS"));
		BOX_SIZE.setCellValueFactory(new PropertyValueFactory<inventory, String>("BOX_SIZE"));
		BOX_COIL_NET_WEIGHT.setCellValueFactory(new PropertyValueFactory<inventory, String>("BOX_COIL_NET_WEIGHT"));
		BOX_COIL_GROSS_WEIGHT.setCellValueFactory(new PropertyValueFactory<inventory, String>("BOX_COIL_GROSS_WEIGHT"));
		TOTAL_NET_WEIGHT.setCellValueFactory(new PropertyValueFactory<inventory, String>("TOTAL_NET_WEIGHT"));
		TOTAL_GROSS_WEIGHT.setCellValueFactory(new PropertyValueFactory<inventory, String>("TOTAL_GROSS_WEIGHT"));
		PALLET_NUMBER.setCellValueFactory(new PropertyValueFactory<inventory, String>("PALLET_NUMBER"));
		BOXES_WITHOUT_PALLETS.setCellValueFactory(new PropertyValueFactory<inventory, String>("BOXES_WITHOUT_PALLETS"));
		
	}
	
	
	public void SearchHistory() {
		
		System.out.println("clicked and the text is : "+ serachTextHistory.getText().toString());
//		System.out.println(SerachTxt.getText().toString());
//		if (savedCollectionNames.contains(SerachTxt.getText().toString())) {
//			thread.stop();
//			studentsModelsObserv = FXCollections.observableArrayList();
//			for (int i = 0; i < myCollection.size(); i++)
//				if (myCollection.get(i).getCollectionName().equals(SerachTxt.getText().toString())) {
//					studentsModelsObserv.add(myCollection.get(i).getCollect(SerachTxt.getText().toString()));
//
//					tbData.setItems(studentsModelsObserv);
//					break;
//				}
//		}
		String catalogNum=serachTextHistory.getText().toString();
		boolean flag=false;
			if(!serachTextHistory.getText().isEmpty())
			{
				for(inventory inv:arrayListToSearch) {
					System.out.println(inv.getCATALOG_NO());
					if(inv.getCATALOG_NO().contains(catalogNum))
					{
						flag=true;
						System.out.println("entered");
					}
				}
			}
			
			if(flag) {
				
				dataForPackingList= FXCollections.observableArrayList();
				for(inventory inv:arrayListToSearch) {
					if(inv.getCATALOG_NO().contains(catalogNum))
					{
						dataForPackingList.add(inv);
					}
				}
				packingTBL.setItems(dataForPackingList);
			}

	}
	
	
	//////////////////////////////////////////Make A client Request//////////////////////////////
	
	@FXML
	private TextField newRequestId;
	@FXML 
	private TextField catalogNumRequest;
	@FXML 
	private TextField DiscriptionRequest;
	@FXML 
	private TextField QuantityRequest;
	@FXML
	private Text generatedId;
	/// Columns
	@FXML 
	private TableColumn<RequestOrder,String> CatalogNumNewReq;
	@FXML 
	private TableColumn<RequestOrder,String> DescriptionNewReq;
	@FXML 
	private TableColumn<RequestOrder,String> QunatityNewReq;
	///end Columns
	@FXML
	private TableView<RequestOrder> newRequestTBL;
	ObservableList<RequestOrder> observNewRequest;
	private ArrayList<RequestOrder> requestsOrder;
	
	public void startRequest() {
		requestsOrder = new ArrayList<RequestOrder>();
		
		
		
		LocalDate date = LocalDate.now();
		String generatedid=newRequestId.getText().toString()+date;
		System.out.println("Getting here  and the client id is " + newRequestId.getText().toString()+date);
		generatedId.setText(generatedid);
		observNewRequest=  FXCollections.observableArrayList(requestsOrder);
		newRequestTBL.setItems(observNewRequest);
		
		initRequestTable();
	}
	
	public void addToNewRquest() {
		RequestOrder request= new RequestOrder();
		
		request.setRequestId(generatedId.getText().toString());
		request.setClientId(newRequestId.getText().toString());
		request.setCatalogNum(catalogNumRequest.getText().toString());
		request.setDescription(DiscriptionRequest.getText().toString());
		request.setQunatity(QuantityRequest.getText().toString());
		
		requestsOrder.add(request);
		
		catalogNumRequest.setText("");
		DiscriptionRequest.setText("");
		QuantityRequest.setText("");
		/// add to observable list
		observNewRequest= FXCollections.observableArrayList(requestsOrder);
		
		newRequestTBL.setItems(observNewRequest);
	}
	ExcelApi excelExport= ExcelApi.getInstance();
	public void saveNewRequest() {
		
		
	
		if(requestsOrder!=null&&requestsOrder.size()>0)
		{
			
			HelloFX.chat.accept(new MessagesClass(Messages.SaveTheNewRequest, requestsOrder));
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Save Dialog");
			alert.setHeaderText("Saved");
			alert.setContentText("Good, The request is saved in the Data Base and exported as excel File");
			alert.showAndWait();
			excelExport.exportToExcel(requestsOrder.get(0).getRequestId(),requestsOrder);
			requestsOrder = new ArrayList<RequestOrder>();
			observNewRequest= FXCollections.observableArrayList(requestsOrder);
			newRequestTBL.refresh();
			newRequestTBL.setItems(observNewRequest);
			
		}
				
	}

	public void initRequestTable() {
		QunatityNewReq.setCellValueFactory(new PropertyValueFactory<RequestOrder, String>("Qunatity"));
		CatalogNumNewReq.setCellValueFactory(new PropertyValueFactory<RequestOrder, String>("CatalogNum"));
		DescriptionNewReq.setCellValueFactory(new PropertyValueFactory<RequestOrder, String>("description"));
		
	
	}
    //////////////////////////////////////////End Make A client Request//////////////////////////
	
	/////////////////////////////////////////Create A Answer From Supplier//////////////////////
	

	@FXML
	private TextField SuppNameAns;
	@FXML
	private TextField requestIdAns;
//	@FXML
//	private TextField cataNumAns;
	@FXML
	private TextField priceUnitAns;
	@FXML
	private TextField unitAns;
//	@FXML
//	private TextField QAns;
//	@FXML 
//	private TextArea descAns;
	///// table definetion
	@FXML 
	private TableColumn<answerSupplier,String> SupplierNameAns;
	@FXML 
	private TableColumn<answerSupplier,String> catalogNumAns;
	@FXML 
	private TableColumn<answerSupplier,String> priceUnitAnswer;
	@FXML 
	private TableColumn<answerSupplier,String> unitAnswer;
	
	@FXML 
	private TableColumn<answerSupplier,String> QuantityAns;
	@FXML 
	private TableColumn<answerSupplier,String> descriptionAns;
	@FXML
	private TableView<answerSupplier> newAnswerTBL;
	private ArrayList<answerSupplier> answers;
	ObservableList<answerSupplier> observNewAnswer;
	
	
	public void startNewAns() {
		newAnswerTBL.setEditable(true);
		answers= new ArrayList<answerSupplier>();
		initAnswerTable();
		System.out.println("new answer it is");
		observNewAnswer= FXCollections.observableArrayList(answers);
		newAnswerTBL.setItems(observNewAnswer);
	}
	/// Update spicif Line 
	public void addToNewStart() {
	/*	System.out.println(SuppNameAns.getText().toString()+"\n"+
				cataNumAns.getText().toString()+"\n"+
				priceUnitAns.getText().toString()+"\n"+
				unitAns.getText().toString()+"\n"+
				QAns.getText().toString()+"\n"+
				descAns.getText().toString());
		
		
		answerSupplier answer = new answerSupplier();
		answer.setSupplierName(SuppNameAns.getText().toString());
		answer.setCatalogNum(cataNumAns.getText().toString());
		answer.setDescription(descAns.getText().toString());
		answer.setQunatity(QAns.getText().toString());
		answer.setUnit(unitAns.getText().toString());
		answer.setPriceUnit(priceUnitAns.getText().toString());
		
		System.out.println(answer);
		answers.add(answer);
		*/
		// get selected 
		ObservableList<answerSupplier> SingleOffer;
		SingleOffer = newAnswerTBL.getSelectionModel().getSelectedItems();
		if (SingleOffer.size() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, You must choose an item!");
			alert.showAndWait();
		}
		else {
			answerSupplier ans=SingleOffer.get(0);
			System.out.println("the supplier name is :"+ans.getCatalogNum());
			//get price and unit 
			String supName=SuppNameAns.getText().toString();
			String price=priceUnitAns.getText().toString();
			String unit = unitAns.getText().toString();
			//update it add it back to the arraylist
			ans.setPriceUnit(price);
			ans.setSupplierName(supName);
			ans.setUnit(unit);
			
			// it will update automaticly but we have to do refresh 
				observNewAnswer= FXCollections.observableArrayList(answers);
				newAnswerTBL.refresh();
				newAnswerTBL.setItems(observNewAnswer);
			
		}

		unitAns.setText("");
		priceUnitAns.setText("");
	}
	
	public void getRequestForAnswer() {
		String requestid= requestIdAns.getText().toString();
		HelloFX.chat.accept(new MessagesClass(Messages.getRequestForAnswer, requestid));
		if(ClientHandler.requestForAnswer!=null)
		{
			answers=mapAndTakeOnlyThatWihOutAnOfferBefore(ClientHandler.requestForAnswer);
			// the request maybe is null now because we removed some 
			if(answers!=null&&answers.size()<1)
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Sorry Dialog");
				alert.setHeaderText("Already");
				alert.setContentText("Hi, The answers is already added ");
				alert.showAndWait();
				
			}
			initAnswerTable();
			System.out.println("new answer it is");
			observNewAnswer= FXCollections.observableArrayList(answers);
			newAnswerTBL.setItems(observNewAnswer);
		}
		
		System.out.println(requestid);
	}
	
	private ArrayList<answerSupplier> mapAndTakeOnlyThatWihOutAnOfferBefore(
			ArrayList<answerSupplier> requestForAnswer) {
		// TODO Auto-generated method stub
		// need to make a request for the Offers , and then check which of them not there and add it to the list 
		String requestId= requestForAnswer.get(0).getRequestId();
		ArrayList<answerSupplier> answersWithOutOffer= new ArrayList<answerSupplier>();
		
		HelloFX.chat.accept(new MessagesClass(Messages.getAnswersAndRequest,requestId ));
		if(ClientHandler.clientOffer!=null)
		{
			ArrayList<ClientOffer> offerToCheckWith=ClientHandler.clientOffer;
			for(ClientOffer offer : offerToCheckWith)
			{
				for(answerSupplier ans:requestForAnswer)
				{
					if(offer.getCatalogNum().equals(ans.getCatalogNum()))
						//remove it and break
					{
						requestForAnswer.remove(ans);
						break;
					}
				}
			}
			
		}
		answersWithOutOffer=requestForAnswer;
		ClientHandler.clientOffer=null;// to not effect another proccess (create Offer flow)
		return answersWithOutOffer;
		
		
	}
	public void SaveAnswer() {
		
		ArrayList<answerSupplier> answerToSave ;
		
		answerToSave= getOnlyWhatToSave(answers);
		if(answerToSave.size()>0)
		{
	     	HelloFX.chat.accept(new MessagesClass(Messages.SaveTheNewAnswer, answerToSave));
		answers= new ArrayList<answerSupplier>();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Save Dialog");
		alert.setHeaderText("Saved");
		alert.setContentText("Good, The answers is saved in the Data Base ");
		alert.showAndWait();
		
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No Answer updated");
			alert.setHeaderText("Answer");
			alert.setContentText("Information, No of the Answers was updated ");
			alert.showAndWait();
		}
		observNewAnswer= FXCollections.observableArrayList(answers);
		newAnswerTBL.setItems(observNewAnswer);
		
		SuppNameAns.setText("");
		unitAns.setText("");
		priceUnitAns.setText("");
		requestIdAns.setText("");
	}
	
	private ArrayList<answerSupplier> getOnlyWhatToSave(ArrayList<answerSupplier> answers2) {
		// TODO Auto-generated method stub
		ArrayList<answerSupplier> answerToSave =new ArrayList<answerSupplier>();
		
		for(answerSupplier ans:answers2)
		{
			if(ans.getSupplierName()!=null&&!ans.getSupplierName().isEmpty())
				answerToSave.add(ans);
				
		}
		return answerToSave;
	}
	public void cleanAnswer() {
		SuppNameAns.setText("");
		unitAns.setText("");
		priceUnitAns.setText("");
	}
	public void initAnswerTable() {
		SupplierNameAns.setCellValueFactory(new PropertyValueFactory<answerSupplier, String>("SupplierName"));
		catalogNumAns.setCellValueFactory(new PropertyValueFactory<answerSupplier, String>("CatalogNum"));
		priceUnitAnswer.setCellValueFactory(new PropertyValueFactory<answerSupplier, String>("PriceUnit"));
		unitAnswer.setCellValueFactory(new PropertyValueFactory<answerSupplier, String>("Unit"));
		unitAnswer.setCellFactory(TextFieldTableCell.<answerSupplier>forTableColumn());
		QuantityAns.setCellValueFactory(new PropertyValueFactory<answerSupplier, String>("Qunatity"));
		descriptionAns.setCellValueFactory(new PropertyValueFactory<answerSupplier, String>("Description"));
	}
	
	////////////////////////////////////////End Create A answer From Supplier//////////////////
	
	///////////////////////////////////////Create The Offer///////////////////////
	
	
	@FXML
	private TextField requestIdOffer;
	/////Table define 
	@FXML 
	private TableColumn<ClientOffer,String> SupplierOff;
	@FXML 
	private TableColumn<ClientOffer,String> catalogNumOff;
	@FXML 
	private TableColumn<ClientOffer,String> DescriptionOff;
	@FXML 
	private TableColumn<ClientOffer,String> UnitOff;
	@FXML 
	private TableColumn<ClientOffer,String> QOff;
	@FXML 
	private TableColumn<ClientOffer,String> UnitPriceOff;
	@FXML 
	private TableColumn<ClientOffer,String> POOff;
	@FXML 
	private TableColumn<ClientOffer,String> FactorOff;
	@FXML 
	private TableColumn<ClientOffer,String> UnitCostOff;
	@FXML
	private TableView<ClientOffer> offerTBL;
	ObservableList<ClientOffer> observclientOffer;
	
	private ArrayList<ClientOffer> clientOffer;
	
	public void getTheOffer() {
		
		clientOffer=new  ArrayList<ClientOffer>();
		observclientOffer=FXCollections.observableArrayList(clientOffer);
		offerTBL.setItems(observclientOffer);
		
	
	String requestId=requestIdOffer.getText().toString();
	if(requestId!=null&&!requestId.isEmpty()){
		HelloFX.chat.accept(new MessagesClass(Messages.getAnswersAndRequest,requestId ));
		if(ClientHandler.clientOffer!=null)
		{
			clientOffer=calculatePricesHandler.calcaultePriceDependOnFactor(ClientHandler.clientOffer);
			initOfferTableColumns();
			observclientOffer=FXCollections.observableArrayList(clientOffer);
			offerTBL.setItems(observclientOffer);
		}
		
	   }
	}
	
	public void initOfferTableColumns() {
		SupplierOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("SupplierId"));
		catalogNumOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("CatalogNum"));
		DescriptionOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("description"));
		UnitOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unit"));
		QOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("Qunatity"));
		UnitPriceOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unitPrice"));
		POOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("PO"));
		FactorOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("FACTOR"));
		UnitCostOff.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unitCost"));
	
	}
	
	public void setFactor() {
		ObservableList<ClientOffer> SingleOffer;
		SingleOffer = offerTBL.getSelectionModel().getSelectedItems();
		if (SingleOffer.size() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, You must choose an item!");
			alert.showAndWait();
		}
		else {
		ClientOffer offer=SingleOffer.get(0);
		System.out.println("the supplier name is :"+offer.getSupplierId());
		 // create a text input dialog
        TextInputDialog td = new TextInputDialog(offer.getFACTOR());
        // setHeaderText
        td.setTitle("Factor");
        td.setHeaderText("enter the factor");
        td.showAndWait();
        //get the new factor to set it
        String newFactor=td.getEditor().getText().toString();
        //get the index in the list to update it
        int index=calculatePricesHandler.getIndexOfGoods(offer.getCatalogNum(), clientOffer);
       
        //update
        if(index!=-1) {
        	
        	
        	System.out.println("it should be updated");
        	clientOffer.get(index).setFACTOR(newFactor);
        	clientOffer=calculatePricesHandler.calcaultePriceDependOnFactor(clientOffer);
        }
        	
    	observclientOffer=FXCollections.observableArrayList(clientOffer);
		offerTBL.refresh();
		offerTBL.setItems(observclientOffer);
		initOfferTableColumns();
       
		}
	}
	
	public void generateOffer() {
		HelloFX.chat.accept(new MessagesClass(Messages.saveOffer,clientOffer ));
	
		if(ClientHandler.isSucces!=null&&ClientHandler.isSucces==false)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, This Offer Already Gernerated");
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm Dialog");
			alert.setHeaderText("Generate");
			alert.setContentText("Good, The Offer is generated ");
			alert.showAndWait();
			clientOffer= new ArrayList<ClientOffer>();
			observclientOffer= FXCollections.observableArrayList(clientOffer);
			offerTBL.setItems(observclientOffer);
		}
		ClientHandler.isSucces=null;
	}
	
	//////////////////////////////////////End The Create The offer///////////////
	
	/////////////////////////////////////Confirm The Offer////////////////////
	@FXML
	private TextField requestIdConfirm;
	
/////Table define 
	@FXML 
	private TableColumn<ClientOffer,String> SupplierOff2;
	@FXML 
	private TableColumn<ClientOffer,String> catalogNumOff2;
	@FXML 
	private TableColumn<ClientOffer,String> DescriptionOff2;
	@FXML 
	private TableColumn<ClientOffer,String> UnitOff2;
	@FXML 
	private TableColumn<ClientOffer,String> QOff2;
	@FXML 
	private TableColumn<ClientOffer,String> UnitPriceOff2;
	@FXML 
	private TableColumn<ClientOffer,String> POOff2;
	@FXML 
	private TableColumn<ClientOffer,String> FactorOff2;
	@FXML 
	private TableColumn<ClientOffer,String> UnitCostOff2;
	@FXML
	private TableView<ClientOffer> confirmOfferTBL;
	ObservableList<ClientOffer> observclientOfferConfirm;
	
	private ArrayList<ClientOffer> clientOfferConfirm;
	
	public void getOfferConfirm(){
		System.out.println("Confiremd"+requestIdConfirm.getText().toString());
		String requestId=requestIdConfirm.getText().toString();
		if(!requestId.isEmpty())
		{
			HelloFX.chat.accept(new MessagesClass(Messages.getTheOffer,requestId ));
			if(ClientHandler.offerToConfirm!=null)
			{
				ArrayList<ClientOffer> offer = ClientHandler.offerToConfirm;
				System.out.println(offer.get(0).getFACTOR());
				initConfirmTable();
				
				clientOfferConfirm=offer;
				observclientOfferConfirm = FXCollections.observableArrayList(clientOfferConfirm);
				confirmOfferTBL.setItems(observclientOfferConfirm);
				
			
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Error");
				alert.setContentText("Ooops, There is no request with this request id");
				alert.showAndWait();
				
				initConfirmTable();				
				clientOfferConfirm=new ArrayList<ClientOffer>();
				observclientOfferConfirm = FXCollections.observableArrayList(clientOfferConfirm);
				confirmOfferTBL.setItems(observclientOfferConfirm);
			}
		}
	}
	
	public void confirmOrderShowAll() {
		if(clientOfferConfirm!=null&&clientOfferConfirm.size()>0)
		{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm Dialog");
		alert.setHeaderText("Confirm");
		alert.setContentText("Good, The order confirmed and saved. \n We will send it by mail to another Department");
		alert.showAndWait();
		
		initConfirmTable();				
		clientOfferConfirm=new ArrayList<ClientOffer>();
		observclientOfferConfirm = FXCollections.observableArrayList(clientOfferConfirm);
		confirmOfferTBL.setItems(observclientOfferConfirm);
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, There is no List");
			alert.showAndWait();
		}
		
	}
	
	public void initConfirmTable() {
		SupplierOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("SupplierId"));
		catalogNumOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("CatalogNum"));
		DescriptionOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("description"));
		UnitOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unit"));
		QOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("Qunatity"));
		UnitPriceOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unitPrice"));
		POOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("PO"));
		FactorOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("FACTOR"));
		UnitCostOff2.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unitCost"));
		
	}
	
	/////////////////////////////////////End Confirm The Offer////////////////
	
	////////////////////////////////////Create The Order////////////////////
	@FXML
	private TextField requestIdToCreateOrder;
/////Table define 
	@FXML 
	private TableColumn<ClientOffer,String> SupplierOff3;
	@FXML 
	private TableColumn<ClientOffer,String> catalogNumOff3;
	@FXML 
	private TableColumn<ClientOffer,String> DescriptionOff3;
	@FXML 
	private TableColumn<ClientOffer,String> UnitOff3;
	@FXML 
	private TableColumn<ClientOffer,String> QOff3;
	@FXML 
	private TableColumn<ClientOffer,String> UnitPriceOff3;
	@FXML 
	private TableColumn<ClientOffer,String> POOff3;
	@FXML 
	private TableColumn<ClientOffer,String> FactorOff3;
	@FXML 
	private TableColumn<ClientOffer,String> UnitCostOff3;
	@FXML
	private TableView<ClientOffer> createOrderTBL;
    ObservableList<ClientOffer> observCreateOrder;
	
	private ArrayList<ClientOffer> orderCreateList;
	
	public void getTheOfferToCreate() {
		System.out.println("clicked and the id is"+requestIdToCreateOrder.getText().toString());
		String requestId=requestIdToCreateOrder.getText().toString();
		if(!requestId.isEmpty())
		{
			HelloFX.chat.accept(new MessagesClass(Messages.getOfferToCreate,requestId ));
			if(ClientHandler.offerToCreate!=null)
			{
				
				ArrayList<ClientOffer> offer = ClientHandler.offerToCreate;
				System.out.println(offer.get(0).getFACTOR());
				initCreateOrderTable();
				
				orderCreateList=offer;
				observCreateOrder = FXCollections.observableArrayList(orderCreateList);
				createOrderTBL.setItems(observCreateOrder);
				
			}
			else {
				CleanTheLists();
			}
			
		}
		else {
			CleanTheLists();
		}
		
	}
	
	public void CleanTheLists() {
		orderCreateList=new ArrayList<ClientOffer>();
		observCreateOrder = FXCollections.observableArrayList(orderCreateList);
		createOrderTBL.setItems(observCreateOrder);
	}
	
	
	public void editQuantity() {
		System.out.println("getting to edit");
		// get Selected 
		ObservableList<ClientOffer> SingleOffer;
		SingleOffer = createOrderTBL.getSelectionModel().getSelectedItems();
		if (SingleOffer.size() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, You must choose an item!");
			alert.showAndWait();
		}
		else {
			ClientOffer ans=SingleOffer.get(0);
			System.out.println(ans.getCatalogNum());
			// open alert withTextField
			 // create a text input dialog
	        TextInputDialog td = new TextInputDialog(ans.getQunatity());
	        // setHeaderText
	        td.setTitle("Quantity");
	        td.setHeaderText("enter the new Quantity");
	        td.showAndWait();
	        //get the new factor to set it   // take the value
	        String newQu=td.getEditor().getText().toString();
	        System.out.println("the new Q is "+newQu);
	      //update the item value
	        ans.setQunatity(newQu);
	       // update PO's
	        orderCreateList= calculatePricesHandler.calcaultePriceDependOnFactor(orderCreateList);// because we need to calculate the PO -> total price
	    	
			observCreateOrder = FXCollections.observableArrayList(orderCreateList);
			createOrderTBL.refresh();
			createOrderTBL.setItems(observCreateOrder);
		}
		
	}
	
	public void removeItem() {
		System.out.println("getting to remove item");
		//get selected 
		ObservableList<ClientOffer> SingleOffer;
		SingleOffer = createOrderTBL.getSelectionModel().getSelectedItems();
		if (SingleOffer.size() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, You must choose an item!");
			alert.showAndWait();
		}
		else {
			ClientOffer ans=SingleOffer.get(0);
		     //remove it 
		
					boolean removed = orderCreateList.remove(ans);
					observCreateOrder = FXCollections.observableArrayList(orderCreateList);
					createOrderTBL.refresh();
					createOrderTBL.setItems(observCreateOrder);
					if(removed==true) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Succes Dialog");
						alert.setHeaderText("Succes");
						alert.setContentText("Good, The item with! catalog num: "+ans.getCatalogNum()+" is Removed");
						alert.showAndWait();
						
					}
					
		}
		
	}
	public void CreateAndOrderLISTS() {
		// create  a new scene 
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		Pane root1;
		try {
			ReportController.inputData=orderCreateList;
			root1 = loader.load(getClass().getResource("/GUI/reports.fxml").openStream());
			Scene scene1 = new Scene(root1);
			primaryStage.setTitle("Packing Reports Page");
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// send the list to the new scene
		
	}
	public void initCreateOrderTable() {
		
		SupplierOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("SupplierId"));
		catalogNumOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("CatalogNum"));
		DescriptionOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("description"));
		UnitOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unit"));
		QOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("Qunatity"));
		UnitPriceOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unitPrice"));
		POOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("PO"));
		FactorOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("FACTOR"));
		UnitCostOff3.setCellValueFactory(new PropertyValueFactory<ClientOffer, String>("unitCost"));
	}
	//////////////////////////////////End Create The Order///////////////////
	

	
}
