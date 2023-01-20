package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ClientOffer;
import common.RequestOrder;

public class OfferHandler extends DBO {
	
	public static Boolean addNewOffer(ArrayList<ClientOffer> offer) {
		Statement stm;
		int i=0;
		try {
			stm = conn.createStatement();
			String sql= "INSERT INTO offers (requestid,catalogNum,supplier,description,unit,qunaitty,unitprice,PO,factor,unitcost)values ";
			for(ClientOffer row:offer)
			{
				if(i!=0)
					sql+=',';
			i++;
			 sql+= " ('"+row.getRequestId()+"','"+row.getCatalogNum()+"','"+row.getSupplierId()+"','"+row.getDescription()+"','"+row.getUnit()+"','"+row.getQunatity()+"','"+row.getUnitPrice()+"','"+
			 row.getPO()+"','"+row.getFACTOR()+"','"+row.getUnitCost()+"')";
			 
			
			}
			System.out.println(sql);
			stm.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	public static ArrayList<ClientOffer> getOffer(String requestid) {
		ArrayList<ClientOffer> offer = new ArrayList<ClientOffer>();
		Statement stm;
		
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM offers where  requestid='"+requestid+"'"; 
			ResultSet rst; 
			rst = stm.executeQuery(sql);
			while (rst.next()) {// String clientId, String requestId, String catalogNum, String description, String unit,
				//String qunatity, String unitPrice, String pO, String fACTOR, String unitCost,String supplierId
				offer.add(new ClientOffer(rst.getString(3),rst.getString(1),rst.getString(2),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(4)));
			}
			
			return offer;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
