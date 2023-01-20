package common;

import java.io.Serializable;

public class priceItem implements Serializable{
	private String NO;
	private String SUPPLIER;
	private String CatalogNum;
	private String DESCRIPTION;
	private String UNIT;
	private String unitPrice;
	
	public priceItem() {};
	public priceItem(String nO, String sUPPLIER, String catalogNum, String dESCRIPTION, String uNIT, String unitPrice) {
		super();
		NO = nO;
		SUPPLIER = sUPPLIER;
		CatalogNum = catalogNum;
		DESCRIPTION = dESCRIPTION;
		UNIT = uNIT;
		this.unitPrice = unitPrice;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		NO = nO;
	}
	public String getSUPPLIER() {
		return SUPPLIER;
	}
	public void setSUPPLIER(String SUPPLIER) {
		this.SUPPLIER = SUPPLIER;
	}
	public String getCatalogNum() {
		return CatalogNum;
	}
	public void setCatalogNum(String catalogNum) {
		CatalogNum = catalogNum;
	}
	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}
	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}
	public String getUNIT() {
		return UNIT;
	}
	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	

}
