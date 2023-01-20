package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Contact;
import common.inventory;

public class inventoryHandler extends DBO {

	public inventoryHandler() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<inventory> getPackingList(){
		ArrayList<inventory> packingList = new ArrayList<>();
		Statement stm;

		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM inventory ";
			ResultSet rst;
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				packingList.add(new inventory(rst.getInt(1)+"",rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6)+"",rst.getInt(7)+"",rst.getInt(8)+"",rst.getString(9),rst.getInt(10)+"",rst.getInt(11)+"",rst.getInt(12)+"",rst.getInt(13)+"",rst.getInt(14)+"",rst.getInt(15)+""));
			}
			return packingList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}

}
