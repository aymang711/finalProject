package common;

import java.io.Serializable;

public class ClientOffer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clientId;
	private String SupplierId;
	private String requestId;
	private String CatalogNum;
	private String description;
	private String unit;
	private String Qunatity;
	private String unitPrice;
	private String PO;
	private String FACTOR;
	private String unitCost;
	
	public ClientOffer(String clientId, String requestId, String catalogNum, String description, String unit,
			String qunatity, String unitPrice, String pO, String fACTOR, String unitCost,String supplierId) {
		super();
		this.clientId = clientId;
		this.requestId = requestId;
		CatalogNum = catalogNum;
		this.description = description;
		this.unit = unit;
		Qunatity = qunatity;
		this.unitPrice = unitPrice;
		PO = pO;
		FACTOR = fACTOR;
		this.unitCost = unitCost;
		this.SupplierId=supplierId;
		setFACTOR(fACTOR);
		
		setUnitCost(unitCost);
		
	}

	public ClientOffer(String clientId, String requestId, String catalogNum, String description, String unit,
			String qunatity, String unitCost,String supplierId) {
		super();
		this.clientId = clientId;
		this.requestId = requestId;
		CatalogNum = catalogNum;
		this.description = description;
		this.unit = unit;
		Qunatity = qunatity;
		this.unitCost = unitCost;
		this.SupplierId=supplierId;
	}

	public String getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(String supplierId) {
		SupplierId = supplierId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCatalogNum() {
		return CatalogNum;
	}

	public void setCatalogNum(String catalogNum) {
		CatalogNum = catalogNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQunatity() {
		return Qunatity;
	}

	public void setQunatity(String qunatity) {
		Qunatity = qunatity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPO() {
		return PO;
	}

	public void setPO(String pO) {
		PO = pO;
	}

	public String getFACTOR() {
		return FACTOR;
	}

	public void setFACTOR(String fACTOR) {
		if(fACTOR.equals("")||fACTOR.isEmpty())
			FACTOR="0";
		else 
		FACTOR = fACTOR;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
