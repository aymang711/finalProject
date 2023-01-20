package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.RequestOrder;
import common.answerSupplier;

public class newRequestHandler extends DBO{

	public newRequestHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public static void addNewRequest(ArrayList<RequestOrder> requests) {
		Statement stm;
		int i=0;
		try {
			stm = conn.createStatement();
			String sql= "INSERT INTO request_order (request_id,clientid,catalogNum,qunatity,description)values ";
			for(RequestOrder request:requests)
			{
				if(i!=0)
					sql+=',';
			i++;
			 sql+= " ('"+request.getRequestId()+"','"+request.getClientId()+"','"+request.getCatalogNum()+"','"+request.getQunatity()+"','"+request.getDescription()+"')";
			 
			
			}
			System.out.println(sql);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static ArrayList<RequestOrder> getRequest(String requestid) {
		ArrayList<RequestOrder> requests = new ArrayList<RequestOrder>();
		Statement stm;
		
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM request_order where  request_id='"+requestid+"'";
			ResultSet rst;
			rst = stm.executeQuery(sql);
			while (rst.next()) {// id / client id / catalog num / qunatity /desc  
				requests.add(new RequestOrder(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
