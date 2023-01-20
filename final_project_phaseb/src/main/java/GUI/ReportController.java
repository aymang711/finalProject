package GUI;

import java.util.ArrayList;

import Logic.calculatePricesHandler;
import common.BL;
import common.ClientOffer;
import common.Messages;
import common.MessagesClass;
import common.inventory;
import common.invoiceItem;
import common.priceItem;
import getway.ClientHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.HelloFX;

public class ReportController {
	
	//////////////////////////packing list/////////////////
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
	private TableView<inventory> packingTBL;
	ObservableList<inventory> dataForPackingList;
	ArrayList<inventory> arrayListOfPacking;

	@FXML
	private TextField boxSizeField;
	@FXML
	private TextField QinBoxField;
	@FXML
	private TextField boxNetWegField;
	@FXML
	private TextField boxGrossWegField;
	@FXML
	private TextField PalletNumField;

	public static ArrayList<ClientOffer> inputData;
	
	
	public void initialize() {
		if(inputData!=null)
		{
	System.out.println("Hello i am in initailze");
	for(ClientOffer input:inputData)
		{
			System.out.println(input);
		}
	
	arrayListOfPacking = mapClientOfferToInventory(inputData);
	// get the data from the database
	// take care it do not conflict with the histroy in the first window
	HelloFX.chat.accept(new MessagesClass(Messages.getPackingList,null));
	
	if(ClientHandler.packingList!=null)
	{
		
		getMissingData(ClientHandler.packingList);
	}
	initzPacking();
	dataForPackingList=  FXCollections.observableArrayList(arrayListOfPacking);
	packingTBL.setItems(dataForPackingList);
	
		}
	}
	
	private void getMissingData(ArrayList<inventory> packingList) {
		
		for(inventory inv:arrayListOfPacking)//Getting the missed data only for who has it in the database  
		{
			for(inventory invHistroy:packingList)
			{
				if(inv.getCATALOG_NO().equals(invHistroy.getCATALOG_NO()))
				{
					inv.setBOX_COIL_GROSS_WEIGHT(invHistroy.getBOX_COIL_GROSS_WEIGHT());
					inv.setBOX_COIL_NET_WEIGHT(invHistroy.getBOX_COIL_NET_WEIGHT());
					inv.setBOX_SIZE(invHistroy.getBOX_SIZE());
					inv.setQUANTITY_IN_BOX(invHistroy.getQUANTITY_IN_BOX());
					inv.setTOTAL_NET_WEIGHT(invHistroy.getTOTAL_NET_WEIGHT());
					inv.setTOTAL_GROSS_WEIGHT(invHistroy.getTOTAL_GROSS_WEIGHT());
					
					calcualteTotalBoxes(inv, invHistroy.getQUANTITY_IN_BOX());
					
					//after updating the total boxes then 
					inv.setBOXES_WITHOUT_PALLETS(inv.getTOTAL_BOXES_COILS());
					inv.setPALLET_NUMBER("0");
					
					calculateTotalWegs(inv);
				
				}
			}
		}
	}

	public void updateItem() {
		
		// SELECT item 
		System.out.println("getting to edit");
		// get Selected 
		ObservableList<inventory> SingleOffer;
		SingleOffer = packingTBL.getSelectionModel().getSelectedItems();
		if (SingleOffer.size() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("Ooops, You must choose an item!");
			alert.showAndWait();
		}
		else {
			inventory inv=SingleOffer.get(0);
			System.out.println(inv.getCATALOG_NO());
			String  QinBoxValue = QinBoxField.getText().toString();
			String BoxSizeValue = boxSizeField.getText().toString();
			String NetWegValue = boxNetWegField.getText().toString();
			String grossWegValue=boxGrossWegField.getText().toString();
			String PalletNumberValue = PalletNumField.getText().toString();
			
			//update the selected one with this parameters
			// update it * but only if it should be updated - > it mean if the value we are insrted empty then dont uppdated this value 
			if(QinBoxValue!=null&&!QinBoxValue.isEmpty())
			   inv.setQUANTITY_IN_BOX(QinBoxValue);
			if(BoxSizeValue!=null&&!BoxSizeValue.isEmpty())
				inv.setBOX_SIZE(BoxSizeValue);
			if(NetWegValue!=null&&!NetWegValue.isEmpty())
				inv.setBOX_COIL_NET_WEIGHT(NetWegValue);
			if(grossWegValue!=null&&!grossWegValue.isEmpty())
				inv.setBOX_COIL_GROSS_WEIGHT(grossWegValue);
			if(PalletNumberValue!=null&&!PalletNumberValue.isEmpty())
				inv.setPALLET_NUMBER(PalletNumberValue);
			if(QinBoxValue!=null&&!QinBoxValue.isEmpty())
			     calcualteTotalBoxes(inv, QinBoxValue);
			if(NetWegValue!=null&&!NetWegValue.isEmpty()&&grossWegValue!=null&&!grossWegValue.isEmpty())
			calculateTotalWegs(inv);
			
			if(PalletNumberValue.equals("0"))
				inv.setBOXES_WITHOUT_PALLETS(inv.getTOTAL_BOXES_COILS());
			else {
				inv.setPALLET_NUMBER(PalletNumberValue);
				inv.setBOXES_WITHOUT_PALLETS("0");
			}
			
			dataForPackingList=  FXCollections.observableArrayList(arrayListOfPacking);
			packingTBL.refresh();
			packingTBL.setItems(dataForPackingList);
		}
		
		
	}
//	inventory(String nO, String sUPPLIER, String cATALOG_NO, String dESCRIPTION, String uNIT, String qTY,
//			String qUANTITY_IN_BOX, String tOTAL_BOXES_COILS, String bOX_SIZE, String bOX_COIL_NET_WEIGHT,
//			String bOX_COIL_GROSS_WEIGHT, String tOTAL_NET_WEIGHT, String TOTAL_GROSS_WEIGHT,String pALLET_NUMBER, String bOXES_WITHOUT_PALLETS)
//	

	private void calcualteTotalBoxes(inventory inv, String QinBoxValue) {
		System.out.println("Q int box is : "+inv.getQTY());
		
		Integer numberInBox=Integer.parseInt(QinBoxValue);
		Integer Q=Integer.parseInt(inv.getQTY());
		
		System.out.println("Q int box is : "+Q + " / " + numberInBox);
		
		Integer totalBoxes=(Q/numberInBox);
		
		inv.setTOTAL_BOXES_COILS(totalBoxes.toString());
		
		if(totalBoxes==0)
			inv.setTOTAL_BOXES_COILS(1+"");
	}
	
	public void calculateTotalWegs(inventory inv)
	{
		Double netWeg=Double.parseDouble(inv.getBOX_COIL_NET_WEIGHT());
		Double grossWeg= Double.parseDouble(inv.getBOX_COIL_GROSS_WEIGHT());
		Double Q= Double.parseDouble(inv.getTOTAL_BOXES_COILS());
		Double TotalNet = netWeg*Q;
		Double TotalGross = grossWeg*Q;
		inv.setTOTAL_NET_WEIGHT(TotalNet+"");
		inv.setTOTAL_GROSS_WEIGHT(TotalGross+"");
		
	}
	
	private ArrayList<inventory> mapClientOfferToInventory(ArrayList<ClientOffer> inputData2) {
		 ArrayList<inventory> maping=new ArrayList<inventory>();
		 // index to give a number for each line 
		 int index=0;
		for(ClientOffer offer: inputData2)
			maping.add(new inventory(""+index++,offer.getSupplierId(),offer.getCatalogNum(),offer.getDescription(),offer.getUnit(),offer.getQunatity(),"","","","","","","","","") );
		return maping;
	}
	
	public void generateLists() {
		
		System.out.println("gerenrating...");
		// calacualte only price List
		pricesForPriceList=calculatePricesHandler.calaucaltePriceForPriceList(inputData);
		initzPriceList();
		dataForPriceList = FXCollections.observableArrayList(pricesForPriceList);
		priceListTBL.setItems(dataForPriceList);
		
		// now calaculate invoice
		 initzInvoiceCells() ;
		invoiceList=calculatePricesHandler.calaucalteInvoice(inputData);
		dataForInvoiceist=FXCollections.observableArrayList(invoiceList);
		invoiceTBL.setItems(dataForInvoiceist);
		
		TotalPriceInvoiceS=calculatePricesHandler.calculateTotal(invoiceList);
		totalPriceOFtotal.setText(TotalPriceInvoiceS);
		
		////////// now calcualte BL
		
		BL bl = calculatePricesHandler.calacualteBL(arrayListOfPacking);
		updateBL(bl);
		
	}

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
	
////////////////////////// End packing list/////////////////
	
	
    ///////////////////////////PRICE LIST///////////////////////
	
	@FXML
	private TableColumn<priceItem,String> priceListNo;
	@FXML
	private TableColumn<priceItem,String> supplierPriceList;
	@FXML
	private TableColumn<priceItem,String> catalogNumPriceList;
	@FXML
	private TableColumn<priceItem,String> DesPriceList;
	@FXML
	private TableColumn<priceItem,String> UnitPriceList;
	@FXML
	private TableColumn<priceItem,String> PricePriceList;
	@FXML
	private TableView<priceItem> priceListTBL;
	private ArrayList<priceItem> pricesForPriceList;

	ObservableList<priceItem> dataForPriceList;

	
	
	
	private void initzPriceList() {
		priceListNo.setCellValueFactory(new PropertyValueFactory<priceItem, String>("NO"));
		supplierPriceList.setCellValueFactory(new PropertyValueFactory<priceItem, String>("SUPPLIER"));
		catalogNumPriceList.setCellValueFactory(new PropertyValueFactory<priceItem, String>("CatalogNum"));
		DesPriceList.setCellValueFactory(new PropertyValueFactory<priceItem, String>("DESCRIPTION"));
		UnitPriceList.setCellValueFactory(new PropertyValueFactory<priceItem, String>("UNIT"));
		PricePriceList.setCellValueFactory(new PropertyValueFactory<priceItem, String>("unitPrice"));
		
		
	}
	
	///////////////////////End price list///////////////////////
	
	////////////////////////////////// invoice///////////////////
	
	@FXML
	private TableColumn<invoiceItem,String> numInvoice;
	@FXML
	private TableColumn<invoiceItem,String> supplierInvoice;
	@FXML
	private TableColumn<invoiceItem,String> catalogInvoice;
	@FXML
	private TableColumn<invoiceItem,String> desInvoice;
	@FXML
	private TableColumn<invoiceItem,String> UnitInvoice;
	@FXML
	private TableColumn<invoiceItem,String> QTYinvoice;
	@FXML
	private TableColumn<invoiceItem,String> priceFieldInvoice;
	@FXML
	private TableColumn<invoiceItem,String> totalPriceInvoice;
	@FXML
	private TableView<invoiceItem> invoiceTBL;
	
	ArrayList<invoiceItem> invoiceList;
	
	ObservableList<invoiceItem> dataForInvoiceist;
	
	@FXML
	private Text totalPriceOFtotal;
	String TotalPriceInvoiceS="0";
	
	

	private void initzInvoiceCells() {
		numInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("NO"));
		supplierInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("Supplier"));
		catalogInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("CatalogNum"));
		desInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("Descritpon"));
		UnitInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("UNIT"));
		QTYinvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("QTY"));
		priceFieldInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("UNITPRICE"));
		totalPriceInvoice.setCellValueFactory(new PropertyValueFactory<invoiceItem, String>("TotalPrice"));
		
	}
	////////////////////////////////end invoice//////////////////
	
	
	/////////////////////////// START BL//////////////////////
	@FXML
	private Text gridGrossWegWithPallet;
	@FXML
	private Text gridGrossWeg;
	@FXML
	private Text gridNetWeg;
	@FXML
	private Text gridNumOfBoxes;
	@FXML
	private Text gridNumOfPallet;
	@FXML
	private Text gridTotalPackages;
	
	public void updateBL(BL bl) {
		gridGrossWegWithPallet.setText(bl.getGrossWeightWithPallets());
		gridGrossWeg.setText(bl.getGrossWeight());
		gridNetWeg.setText(bl.getNetGrossWeight());
		gridNumOfBoxes.setText(bl.getNumberOfBoxesWithOutPallets());
		gridNumOfPallet.setText(bl.getNumberOfPallets());
		gridTotalPackages.setText(bl.getTotalPackges());
	}
	
	////////////////////////// end BL////////////////////////
	
	
	
	

}
