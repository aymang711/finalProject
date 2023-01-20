package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Contact;
import common.RequestOrder;
import common.answerSupplier;

public class newAnswerHandler extends DBO{
	
	public static void addNewAnswer(ArrayList<answerSupplier> answers) {
		Statement stm;
		int i=0;
		try {
			stm = conn.createStatement();
			String sql= "INSERT INTO answers_order (catalognum,supplierName,description,priceunit,quantity,unit,requestid)values ";
			for(answerSupplier answer:answers)
			{
				if(i!=0)
					sql+=',';
			i++;
			 sql+= " ('"+answer.getCatalogNum()+"','"+answer.getSupplierName()+"','"+answer.getDescription()+"','"+answer.getPriceUnit()+"','"+answer.getQunatity()+"','"+answer.getUnit()+"','"+answer.getRequestId()+"')";
			 
			
			}
			System.out.println(sql);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static ArrayList<answerSupplier> getAllAnswers() {
		ArrayList<answerSupplier> answers = new ArrayList<answerSupplier>();
		Statement stm;
		
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM answers_order";
			ResultSet rst;
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				answers.add(new answerSupplier(rst.getString(2),rst.getString(1),rst.getString(3),rst.getString(4),rst.getString(6),rst.getString(5),rst.getString(7)));
				// if i need to add the requestId i can do it here .. 
				//String s= getString(7) and then put it in a loop for all the answers
			}
			
			return answers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<answerSupplier> mapRequestToAnswer(ArrayList<RequestOrder> request) {
		 ArrayList<answerSupplier> answer = new  ArrayList<answerSupplier>();
		 
		 for(RequestOrder req: request)
		 {
			 answerSupplier newAnswer = new answerSupplier();
			 newAnswer.setCatalogNum(req.getCatalogNum());
			 newAnswer.setDescription(req.getDescription());
			 newAnswer.setQunatity(req.getQunatity());
			 newAnswer.setRequestId(req.getRequestId());
			 answer.add(newAnswer);
		 }
		 
		return answer;
	}
	
	

}
