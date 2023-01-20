package common;

import java.io.Serializable;

public class answerSupplier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SupplierName;
	private String CatalogNum;
	private String Description;
	private String PriceUnit;
	private String Unit;
	private String Qunatity;
	private String requestId;
	
	
	public answerSupplier() {
		// TODO Auto-generated constructor stub
	}
	


	public answerSupplier(String supplierName, String catalogNum, String description, String priceUnit, String unit,
			String qunatity,String requestId) {
		super();
		SupplierName = supplierName;
		CatalogNum = catalogNum;
		Description = description;
		PriceUnit = priceUnit;
		Unit = unit;
		Qunatity = qunatity;
		this.requestId=requestId;
	}	
	
	
		



	public answerSupplier(String supplierName, String catalogNum, String priceUnit) {
		super();
		SupplierName = supplierName;
		CatalogNum = catalogNum;
		PriceUnit = priceUnit;
	}



	public String getSupplierName() {
		return SupplierName;
	}



	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}



	public String getCatalogNum() {
		return CatalogNum;
	}



	public void setCatalogNum(String catalogNum) {
		CatalogNum = catalogNum;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public String getPriceUnit() {
		return PriceUnit;
	}



	public void setPriceUnit(String priceUnit) {
		PriceUnit = priceUnit;
	}



	public String getUnit() {
		return Unit;
	}



	public void setUnit(String unit) {
		Unit = unit;
	}



	public String getQunatity() {
		return Qunatity;
	}



	public void setQunatity(String qunatity) {
		Qunatity = qunatity;
	}
	
	


	@Override
	public String toString() {
		return "answerSupplier [SupplierName=" + SupplierName + ", CatalogNum=" + CatalogNum + ", Description="
				+ Description + ", PriceUnit=" + PriceUnit + ", Unit=" + Unit + ", Qunatity=" + Qunatity + "]";
	}



	public String getRequestId() {
		return requestId;
	}



	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	
	
	

}
