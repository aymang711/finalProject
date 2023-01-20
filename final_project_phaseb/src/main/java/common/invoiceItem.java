package common;

import java.io.Serializable;

public class invoiceItem implements Serializable{
	private String NO;
	private String Supplier;
	private String CatalogNum;
	private String Descritpon;
	private String UNIT;
	private String QTY;
	private String UNITPRICE;
	private String TotalPrice;
	
	public invoiceItem() {
		
	}
	

	public invoiceItem(String nO, String supplier, String catalogNum, String descritpon, String uNIT, String qTY,
			String uNITPRICE, String totalPrice) {
		super();
		NO = nO;
		Supplier = supplier;
		CatalogNum = catalogNum;
		Descritpon = descritpon;
		UNIT = uNIT;
		QTY = qTY;
		UNITPRICE = uNITPRICE;
		TotalPrice = totalPrice;
	}


	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public String getSupplier() {
		return Supplier;
	}

	public void setSupplier(String supplier) {
		Supplier = supplier;
	}

	public String getCatalogNum() {
		return CatalogNum;
	}

	public void setCatalogNum(String catalogNum) {
		CatalogNum = catalogNum;
	}

	public String getDescritpon() {
		return Descritpon;
	}

	public void setDescritpon(String descritpon) {
		Descritpon = descritpon;
	}

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}

	public String getQTY() {
		return QTY;
	}

	public void setQTY(String qTY) {
		QTY = qTY;
	}

	public String getUNITPRICE() {
		return UNITPRICE;
	}

	public void setUNITPRICE(String uNITPRICE) {
		UNITPRICE = uNITPRICE;
	}

	public String getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	
	
	
}
