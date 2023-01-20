package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Contact;


public class ContactHandler extends DBO {

	

	
	public static ArrayList<Contact> getContact() {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Statement stm;
		
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM contacts ";
			ResultSet rst;
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				contacts.add(new Contact(rst.getString(1),rst.getString(2),rst.getString(3)));
			}
			return contacts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean addContact(Contact contact) {
		Statement stm;
		try {
			stm = conn.createStatement();
			String sql= "INSERT INTO contacts (name,number)values ('"+contact.getName()+"','"+contact.getPhoneNumber()+"')";
			stm.executeUpdate(sql);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
