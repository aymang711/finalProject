package database;

import java.util.ArrayList;

import common.ClientOffer;
import common.RequestOrder;
import common.answerSupplier;

public class getAnswerAndRequestHandler extends DBO{
	
   public static ArrayList<ClientOffer> getOffer(String requestId){
	   
	   ArrayList<ClientOffer> offer= new ArrayList<ClientOffer> ();
	   ArrayList<RequestOrder> request= newRequestHandler.getRequest(requestId);
	   ArrayList<answerSupplier> answers= newAnswerHandler.getAllAnswers();
	  
	   for(RequestOrder goodsRow: request)
	   {String requestid=goodsRow.getRequestId();
		  String catalogNum =  goodsRow.getCatalogNum();
		 
		  for(answerSupplier answer:answers)
		  {
			  
			  if(answer.getCatalogNum().equals(catalogNum)&&answer.getRequestId().equals(requestid)) {
				  System.out.println("getting  "+catalogNum);
				  offer.add(new ClientOffer(goodsRow.getClientId(),goodsRow.getRequestId(),catalogNum,answer.getDescription(),answer.getUnit(),answer.getQunatity(),"","","0.2",answer.getPriceUnit(),answer.getSupplierName())) ;
			  }
		  }
	   }
	   System.out.println("Done!!");
	   
	   return offer;
   }

}
