package Logic;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.RequestOrder;
  
public class ExcelApi {
	 private static ExcelApi instance;
	private ExcelApi() {
		
	}
	//singleton
	  public  static ExcelApi getInstance() {
	    	 if(instance==null) {
	    		 instance=new ExcelApi();
	    		 
	    	 }
	    	 return instance;
	     }
    // any exceptions need to be caught
    public  void exportToExcel(String filename,ArrayList<RequestOrder> list)
    {

    	//workbook object
    	
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet spreadsheet
            = workbook.createSheet(" Request ");
        
//        XSSFSheet spreadsheet2
//        = workbook.createSheet(" Student Not Data ");
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        Map<String, Object[]> requestData
            = new TreeMap<String, Object[]>();
  System.out.println("getting here to send excel file");
  requestData.put(
            "1",
            new Object[] { "requestId", "catalogNumber", "Qunatity","Description" });
     int    i=1;
        for(RequestOrder rowModel:list) {
        	i++;
        	requestData.put(String.valueOf(i), new Object[] { rowModel.getRequestId(), rowModel.getCatalogNum(),
            		rowModel.getQunatity() ,rowModel.getDescription().toString()});
        }
 
  
        Set<String> keyid = requestData.keySet();
  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = requestData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
//        XSSFRow row2= spreadsheet2.createRow(rowid);
//        Cell cell = row2.createCell(15);
//        cell.setCellValue("Total");
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        try {
        FileOutputStream out = new FileOutputStream(
            new File(filename+".xlsx"));
  
        workbook.write(out);
        out.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
