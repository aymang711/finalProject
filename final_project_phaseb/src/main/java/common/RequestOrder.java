package common;

import java.io.Serializable;

public class RequestOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String requestId;
	private String clientId;
	private String CatalogNum;
	private String Qunatity;
	private String description;
	

	public RequestOrder() {
		// TODO Auto-generated constructor stub
	}


	public RequestOrder(String requestId, String clientId, String catalogNum, String qunatity, String description) {
		super();
		this.requestId = requestId;
		this.clientId = clientId;
		CatalogNum = catalogNum;
		Qunatity = qunatity;
		this.description = description;
	}
	


	public RequestOrder(String catalogNum, String qunatity, String description) {
		super();
		CatalogNum = catalogNum;
		Qunatity = qunatity;
		this.description = description;
	}


	public String getRequestId() {
		return requestId;
	}


	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getCatalogNum() {
		return CatalogNum;
	}


	public void setCatalogNum(String catalogNum) {
		CatalogNum = catalogNum;
	}


	public String getQunatity() {
		return Qunatity;
	}


	public void setQunatity(String qunatity) {
		Qunatity = qunatity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

}
