package common;

import java.io.Serializable;

public class inventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NO;
	private String SUPPLIER;
	private String CATALOG_NO;
	private String DESCRIPTION;
	private String UNIT;
	private String QTY;
	private String QUANTITY_IN_BOX;
	private String TOTAL_BOXES_COILS;
	private String BOX_SIZE;
	private String BOX_COIL_NET_WEIGHT;
	private String BOX_COIL_GROSS_WEIGHT;
	private String TOTAL_NET_WEIGHT;
	private String TOTAL_GROSS_WEIGHT;
	private String PALLET_NUMBER;
	private String BOXES_WITHOUT_PALLETS;
	public inventory() {
		// TODO Auto-generated constructor stub
	}
	
	

	public inventory(String nO, String sUPPLIER, String cATALOG_NO, String dESCRIPTION, String uNIT, String qTY,
			String qUANTITY_IN_BOX, String tOTAL_BOXES_COILS, String bOX_SIZE, String bOX_COIL_NET_WEIGHT,
			String bOX_COIL_GROSS_WEIGHT, String tOTAL_NET_WEIGHT, String TOTAL_GROSS_WEIGHT,String pALLET_NUMBER, String bOXES_WITHOUT_PALLETS) {
		super();
		NO = nO;
		SUPPLIER = sUPPLIER;
		CATALOG_NO = cATALOG_NO;
		DESCRIPTION = dESCRIPTION;
		UNIT = uNIT;
		QTY = qTY;
		QUANTITY_IN_BOX = qUANTITY_IN_BOX;
		TOTAL_BOXES_COILS = tOTAL_BOXES_COILS;
		BOX_SIZE = bOX_SIZE;
		BOX_COIL_NET_WEIGHT = bOX_COIL_NET_WEIGHT;
		BOX_COIL_GROSS_WEIGHT = bOX_COIL_GROSS_WEIGHT;
		TOTAL_NET_WEIGHT = tOTAL_NET_WEIGHT;
		PALLET_NUMBER = pALLET_NUMBER;
		BOXES_WITHOUT_PALLETS = bOXES_WITHOUT_PALLETS;
		this.TOTAL_GROSS_WEIGHT=TOTAL_GROSS_WEIGHT;
	}
	
	



	public String getTOTAL_GROSS_WEIGHT() {
		return TOTAL_GROSS_WEIGHT;
	}



	public void setTOTAL_GROSS_WEIGHT(String tOTAL_GROSS_WEIGHT) {
		TOTAL_GROSS_WEIGHT = tOTAL_GROSS_WEIGHT;
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


	public void setSUPPLIER(String sUPPLIER) {
		SUPPLIER = sUPPLIER;
	}


	public String getCATALOG_NO() {
		return CATALOG_NO;
	}


	public void setCATALOG_NO(String cATALOG_NO) {
		CATALOG_NO = cATALOG_NO;
	}


	public String getDESCRIPTION() {
		return DESCRIPTION;
	}


	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
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


	public String getQUANTITY_IN_BOX() {
		return QUANTITY_IN_BOX;
	}


	public void setQUANTITY_IN_BOX(String qUANTITY_IN_BOX) {
		QUANTITY_IN_BOX = qUANTITY_IN_BOX;
	}


	public String getTOTAL_BOXES_COILS() {
		return TOTAL_BOXES_COILS;
	}


	public void setTOTAL_BOXES_COILS(String tOTAL_BOXES_COILS) {
		TOTAL_BOXES_COILS = tOTAL_BOXES_COILS;
	}


	public String getBOX_SIZE() {
		return BOX_SIZE;
	}


	public void setBOX_SIZE(String bOX_SIZE) {
		BOX_SIZE = bOX_SIZE;
	}


	public String getBOX_COIL_NET_WEIGHT() {
		return BOX_COIL_NET_WEIGHT;
	}


	public void setBOX_COIL_NET_WEIGHT(String bOX_COIL_NET_WEIGHT) {
		BOX_COIL_NET_WEIGHT = bOX_COIL_NET_WEIGHT;
	}


	public String getBOX_COIL_GROSS_WEIGHT() {
		return BOX_COIL_GROSS_WEIGHT;
	}


	public void setBOX_COIL_GROSS_WEIGHT(String bOX_COIL_GROSS_WEIGHT) {
		BOX_COIL_GROSS_WEIGHT = bOX_COIL_GROSS_WEIGHT;
	}


	public String getTOTAL_NET_WEIGHT() {
		return TOTAL_NET_WEIGHT;
	}


	public void setTOTAL_NET_WEIGHT(String tOTAL_NET_WEIGHT) {
		TOTAL_NET_WEIGHT = tOTAL_NET_WEIGHT;
	}


	public String getPALLET_NUMBER() {
		return PALLET_NUMBER;
	}


	public void setPALLET_NUMBER(String pALLET_NUMBER) {
		PALLET_NUMBER = pALLET_NUMBER;
	}


	public String getBOXES_WITHOUT_PALLETS() {
		return BOXES_WITHOUT_PALLETS;
	}


	public void setBOXES_WITHOUT_PALLETS(String bOXES_WITHOUT_PALLETS) {
		BOXES_WITHOUT_PALLETS = bOXES_WITHOUT_PALLETS;
	}


	

}
