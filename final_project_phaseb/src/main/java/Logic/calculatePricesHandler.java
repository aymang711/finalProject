package Logic;

import java.util.ArrayList;

import common.BL;
import common.ClientOffer;
import common.inventory;
import common.invoiceItem;
import common.priceItem;

public class calculatePricesHandler {
	
	public static ArrayList<ClientOffer> calcaultePriceDependOnFactor(ArrayList<ClientOffer> offer){
		Double PO ;
		Double Cost;
		Double Price;
		Double Factor;
		Integer Q;
		for(ClientOffer row : offer) {
			
			Cost=Double.parseDouble(row.getUnitCost());
			Factor=Double.parseDouble(row.getFACTOR());
			Price= (Cost+(Factor*Cost));
			Q= Integer.parseInt(row.getQunatity());
			PO=Price*Q;
			row.setUnitPrice(Price.toString());
			row.setPO(PO.toString());
			
		}
		
		return offer;
	}
	
	public static int getIndexOfGoods(String catlognum,ArrayList<ClientOffer> offers) {
		int i=0;
		
		for(ClientOffer offer:offers)
		{
			if(offer.getCatalogNum().equals(catlognum))
			{
				System.out.println("got it");
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public static ArrayList<priceItem> calaucaltePriceForPriceList(ArrayList<ClientOffer> inputData){
		ArrayList<priceItem> prices = new ArrayList<priceItem>();
		int index=1;
		for(ClientOffer offer:inputData)
		{
			prices.add(new priceItem(index+"",offer.getSupplierId(),offer.getCatalogNum(),offer.getDescription(),offer.getUnit(),offer.getUnitPrice()));
			index++;
		}
		  return prices;
	}
	
	public static ArrayList<invoiceItem> calaucalteInvoice(ArrayList<ClientOffer> inputData){
		ArrayList<invoiceItem> prices = new ArrayList<invoiceItem>();
		int index=1;
		for(ClientOffer offer:inputData)
		{
			Double Q=Double.parseDouble(offer.getQunatity());
			Double price=Double.parseDouble(offer.getUnitPrice());
			Double totalPrice= Q*price;
			prices.add(new invoiceItem(index+"",offer.getSupplierId(),offer.getCatalogNum(),offer.getDescription(),offer.getUnit(),offer.getQunatity(),offer.getUnitPrice(),totalPrice+""));
			index++;
		}
		// ADD THE TRANSPORT cost
		prices.add(new invoiceItem(index+"","TtransCompany","111","Transporation","UN","1","1000","1000"));
		  return prices;
	}
	
	public static String calculateTotal(ArrayList<invoiceItem>  invoice) {
		Double total = 0.0 ; 
		for(invoiceItem item:invoice)
		{
			Double price= Double.parseDouble(item.getTotalPrice());
			total +=price;
		}
		
		return total+"";
	}
	
	public static BL calacualteBL(ArrayList<inventory> packingList) {
		BL bl= new BL();
		Double totalGross=0.0;
		Double totalNet=0.0;
		Integer palletNumTotal=0;
		Integer boxesWithOutTotal=0;
		Integer Packages=0;
		
		for(inventory inv : packingList)
		{
			totalGross+=Double.parseDouble(inv.getTOTAL_GROSS_WEIGHT());
			totalNet+=Double.parseDouble(inv.getTOTAL_NET_WEIGHT());
			palletNumTotal+= Integer.parseInt(inv.getPALLET_NUMBER());
			boxesWithOutTotal+=Integer.parseInt(inv.getBOXES_WITHOUT_PALLETS());
			
		}
		Packages+=(palletNumTotal+boxesWithOutTotal);
		bl.setGrossWeight(totalGross+"");
		bl.setGrossWeightWithPallets(totalGross+"");
		bl.setNetGrossWeight(totalNet+"");
		bl.setNumberOfBoxesWithOutPallets(boxesWithOutTotal+"");
		bl.setNumberOfPallets(palletNumTotal+"");
		bl.setTotalPackges(Packages+"");
		
		
		return bl;
	}
	

}
